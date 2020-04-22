package cn.djzhao.service.impl;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.Semester;
import cn.djzhao.model.entity.SemesterQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.djzhao.model.mapper.SemesterMapper;
import cn.djzhao.service.ISemesterService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by kwk on 2019-04-17
 *
 * @author kwk
 */
@Service
public class SemesterServiceImpl implements ISemesterService {
    @Autowired
    private SemesterMapper semesterMapper;

    @Override
    public ServerResponse<String> add(String year, String semester, Integer weekCount) {
        SemesterQuery query = new SemesterQuery();
        query.createCriteria().andYearEqualTo(year).andSemesterEqualTo(semester);
        Semester s = semesterMapper.selectOneByExample(query);
        if (s != null) {
            return ServerResponse.createByErrorMessage("学期已经存在");
        }
        Semester c = new Semester();
        c.setYear(year);
        c.setSemester(semester);
        c.setWeekCount(weekCount);
        int count = semesterMapper.insertSelective(c);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("新建成功");
        }
        return ServerResponse.createByErrorMessage("新建失败");
    }

    @Override
    public ServerResponse<String> del(Integer id) {
        int count = semesterMapper.deleteByPrimaryKey(id);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse<String> update(Integer id, String year, String semester, Integer weekCount) {
        Semester s = semesterMapper.selectByPrimaryKey(id);
        s.setYear(year);
        s.setSemester(semester);
        int count = semesterMapper.updateByPrimaryKeySelective(s);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @Override
    public ServerResponse<PageInfo<Semester>> findAll(Integer pageNum, Integer pageSize) {
        SemesterQuery query = new SemesterQuery();
        PageHelper.startPage(pageNum, pageSize);
        List<Semester> list = semesterMapper.selectByExampleWithRowbounds(query,new RowBounds((pageNum-1)*10,pageSize));
        PageInfo<Semester> pageInfo = new PageInfo<>(list);
        pageInfo.setTotal(semesterMapper.countByExample(query));
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse<Semester> find(Integer id) {
        return ServerResponse.createBySuccess(semesterMapper.selectByPrimaryKey(id));

    }
}
