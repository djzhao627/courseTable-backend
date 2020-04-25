package cn.djzhao.service.impl;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.*;
import cn.djzhao.model.mapper.TermRoomMapper;
import cn.djzhao.model.mapper.CourseTableMapper;
import cn.djzhao.service.ITermRoomService;
import cn.djzhao.util.DayUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by kwk on 2019-04-17
 *
 * @author kwk
 */
@Service
public class TermRoomServiceImpl implements ITermRoomService {

    @Autowired
    private TermRoomMapper TermRoomMapper;

    @Autowired
    private CourseTableMapper courseTableMapper;

    @Override
    public ServerResponse<String> add(String roomName, String mark) {
        TermRoomQuery query = new TermRoomQuery();
        query.createCriteria().andRoomNameEqualTo(roomName);
        TermRoom TermRoom = TermRoomMapper.selectOneByExample(query);
        if (TermRoom != null) {
            return ServerResponse.createByErrorMessage("教室已经存在");
        }
        TermRoom c = new TermRoom();
        c.setRoomName(roomName);
        c.setMark(mark);
        int count = TermRoomMapper.insertSelective(c);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("新建成功");
        }
        return ServerResponse.createByErrorMessage("新建失败");
    }

    @Override
    public ServerResponse<String> del(Integer id) {
        int count = TermRoomMapper.deleteByPrimaryKey(id);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse<TermRoom> find(Integer id) {
        return ServerResponse.createBySuccess(TermRoomMapper.selectByPrimaryKey(id));
    }

    @Override
    public ServerResponse<PageInfo<TermRoom>> findAll(Integer pageNum, Integer pageSize) {
        TermRoomQuery query = new TermRoomQuery();
        PageHelper.startPage(pageNum, pageSize);
        List<TermRoom> list = TermRoomMapper.selectByExampleWithRowbounds(query, new RowBounds((pageNum - 1) * 10, pageSize));
        PageInfo<TermRoom> pageInfo = new PageInfo<>(list);
        pageInfo.setTotal(TermRoomMapper.countByExample(query));
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse<String> update(Integer id, String roomName, String mark) {
        TermRoom TermRoom = TermRoomMapper.selectByPrimaryKey(id);
        TermRoom.setRoomName(roomName);
        TermRoom.setMark(mark);
        int count = TermRoomMapper.updateByPrimaryKeySelective(TermRoom);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @Override
    public List<TermRoomFree> findByWeek(Integer week, String roomName) {
        TermRoomQuery query1 = new TermRoomQuery();
        TermRoomQuery.Criteria criteria1 = query1.createCriteria();
        if (roomName != null && !"".equals(roomName)){
            criteria1.andRoomNameLike("%" + roomName + "%");
        }
        List<TermRoom> TermRooms = TermRoomMapper.selectByExample(query1);

        List<TermRoomFree> TermRoomFrees = new ArrayList<>();

        for (TermRoom TermRoom : TermRooms) {
            int[][] arr = new int[5][4];
            Integer TermRoomId = TermRoom.getId();

            CourseTableQuery query = new CourseTableQuery();
            CourseTableQuery.Criteria criteria = query.createCriteria();
            criteria.andStatuEqualTo(week)
                    .andRoomIdEqualTo(TermRoomId);
            List<CourseTable> courseTables = courseTableMapper.selectByExample(query);

            for (CourseTable courseTable : courseTables) {
                Integer number = courseTable.getTimeId();
                String timeName = courseTable.getTimeName();
                arr[DayUtil.toDayNum(timeName) - 1][number - 1] = 1;
            }

            for (int x = 1; x <= 5; x++) {
                for (int y = 1; y <= 4; y++) {
                    if (arr[x - 1][y - 1] == 0) {
                        TermRoomFrees.add(toFree(TermRoom, DayUtil.toDay(x), y,week));
                    }
                }
            }
        }
        return TermRoomFrees;
    }

    private TermRoomFree toFree(TermRoom TermRoom, String day, Integer number,Integer week) {
        TermRoomFree TermRoomFree = new TermRoomFree();
        TermRoomFree.setClassroomId(TermRoom.getId());
        TermRoomFree.setClassroomName(TermRoom.getRoomName());
        TermRoomFree.setDay(day);
        TermRoomFree.setWeek(week);
        TermRoomFree.setNumber(number);
        return TermRoomFree;
    }
}
