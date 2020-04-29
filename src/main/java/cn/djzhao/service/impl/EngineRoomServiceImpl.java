package cn.djzhao.service.impl;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.*;
import cn.djzhao.model.mapper.EngineRoomMapper;
import cn.djzhao.model.mapper.CourseTableMapper;
import cn.djzhao.service.IEngineRoomService;
import cn.djzhao.util.DayUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djzhao
 */
@Service
public class EngineRoomServiceImpl implements IEngineRoomService {

    @Autowired
    private EngineRoomMapper engineRoomMapper;

    @Autowired
    private CourseTableMapper courseTableMapper;

    @Override
    public ServerResponse<String> add(String roomName, Integer roomSpace, Integer roomLayer) {
        EngineRoom c = new EngineRoom();
        c.setRoomName(roomName);
        c.setRoomSpace(roomSpace);
        c.setRoomLayer(roomLayer);
        int count = engineRoomMapper.insertSelective(c);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("新建成功");
        }
        return ServerResponse.createByErrorMessage("新建失败");
    }

    @Override
    public ServerResponse<String> del(Integer id) {
        int count = engineRoomMapper.deleteByPrimaryKey(id);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse<EngineRoom> find(Integer id) {
        return ServerResponse.createBySuccess(engineRoomMapper.selectByPrimaryKey(id));
    }

    @Override
    public ServerResponse<PageInfo<EngineRoom>> findAll(Integer pageNum, Integer pageSize) {
        EngineRoomQuery query = new EngineRoomQuery();
        PageHelper.startPage(pageNum, pageSize);
        List<EngineRoom> list = engineRoomMapper.selectByExampleWithRowbounds(query, new RowBounds((pageNum - 1) * 10, pageSize));
        PageInfo<EngineRoom> pageInfo = new PageInfo<>(list);
        pageInfo.setTotal(engineRoomMapper.countByExample(query));
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse<String> update(Integer id, String roomName, Integer roomSpace, Integer roomLaye) {
        EngineRoom EngineRoom = engineRoomMapper.selectByPrimaryKey(id);
        EngineRoom.setRoomName(roomName);
        EngineRoom.setRoomSpace(roomSpace);
        EngineRoom.setRoomLayer(roomLaye);
        System.out.println(roomLaye);
        int count = engineRoomMapper.updateByPrimaryKeySelective(EngineRoom);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @Override
    public List<EngineRoomFree> findByWeek(Integer week, String roomName) {
        EngineRoomQuery query1 = new EngineRoomQuery();
        EngineRoomQuery.Criteria criteria1 = query1.createCriteria();
        if (roomName != null && !"".equals(roomName)){
            criteria1.andRoomNameLike("%" + roomName + "%");
        }
        List<EngineRoom> EngineRooms = engineRoomMapper.selectByExample(query1);

        List<EngineRoomFree> EngineRoomFrees = new ArrayList<>();

        for (EngineRoom EngineRoom : EngineRooms) {
            int[][] arr = new int[5][4];
            Integer EngineRoomId = EngineRoom.getId();

            CourseTableQuery query = new CourseTableQuery();
            CourseTableQuery.Criteria criteria = query.createCriteria();
            criteria.andStatuEqualTo(week)
                    .andRoomIdEqualTo(EngineRoomId);
            List<CourseTable> courseTables = courseTableMapper.selectByExample(query);

            for (CourseTable courseTable : courseTables) {
                Integer number = courseTable.getTimeId();
                String timeName = courseTable.getTimeName();
                arr[DayUtil.toDayNum(timeName) - 1][number - 1] = 1;
            }

            for (int x = 1; x <= 5; x++) {
                for (int y = 1; y <= 4; y++) {
                    if (arr[x - 1][y - 1] == 0) {
                        EngineRoomFrees.add(toFree(EngineRoom, DayUtil.toDay(x), y,week));
                    }
                }
            }
        }
        return EngineRoomFrees;
    }

    private EngineRoomFree toFree(EngineRoom EngineRoom, String day, Integer number,Integer week) {
        EngineRoomFree EngineRoomFree = new EngineRoomFree();
        EngineRoomFree.setClassroomId(EngineRoom.getId());
        EngineRoomFree.setClassroomName(EngineRoom.getRoomName());
        EngineRoomFree.setDay(day);
        EngineRoomFree.setWeek(week);
        EngineRoomFree.setNumber(number);
        return EngineRoomFree;
    }
}
