package cn.djzhao.service.impl;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.Grade;
import cn.djzhao.model.entity.GradeQuery;
import cn.djzhao.model.mapper.GradeMapper;
import cn.djzhao.service.IGradeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author djzhao
 */
@Service
public class GradeServiceImpl implements IGradeService {
    @Autowired
    private GradeMapper GradeMapper;

    @Override
    public ServerResponse<String> add(String className, String classNum, String mark) {
        Grade c = new Grade();
        c.setClassName(className);
        c.setClassNumber(classNum);
        c.setMark(mark);
        int count = GradeMapper.insertSelective(c);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("新建成功");
        }
        return ServerResponse.createByErrorMessage("新建失败");
    }

    @Override
    public ServerResponse<String> del(Integer id) {
        int count = GradeMapper.deleteByPrimaryKey(id);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse<String> update(Integer id, String className, String classNum,String mark) {
        Grade Grade = GradeMapper.selectByPrimaryKey(id);
        Grade.setClassName(className);
        Grade.setClassNumber(classNum);
        Grade.setMark(mark);
        int count = GradeMapper.updateByPrimaryKeySelective(Grade);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @Override
    public ServerResponse<Grade> find(Integer id) {
         return ServerResponse.createBySuccess(GradeMapper.selectByPrimaryKey(id));
    }

    @Override
    public ServerResponse<PageInfo<Grade>> findAll(Integer pageNum, Integer pageSize) {
        GradeQuery query = new GradeQuery();
        PageHelper.startPage(pageNum, pageSize);
        List<Grade> list = GradeMapper.selectByGradepleWithRowbounds(query,new RowBounds((pageNum-1)*10,pageSize));
        PageInfo<Grade> pageInfo = new PageInfo<>(list);
        pageInfo.setTotal(GradeMapper.countByGradeple(query));
        return ServerResponse.createBySuccess(pageInfo);
    }
}
