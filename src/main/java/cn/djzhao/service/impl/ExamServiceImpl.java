package cn.djzhao.service.impl;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.Exam;
import cn.djzhao.model.entity.ExamQuery;
import cn.djzhao.model.mapper.ExamMapper;
import cn.djzhao.service.IExamService;
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
public class ExamServiceImpl implements IExamService {
    @Autowired
    private ExamMapper ExamMapper;

    @Override
    public ServerResponse<String> add(String className, String classNum, String mark, String subject) {
        ExamQuery query = new ExamQuery();
        query.createCriteria().andClassNameEqualTo(className);
        Exam Exam = ExamMapper.selectOneByExample(query);
        if (Exam != null) {
            return ServerResponse.createByErrorMessage("考试已经存在");
        }
        Exam c = new Exam();
        c.setClassName(className);
        c.setClassNumber(classNum);
        c.setMark(mark);
        c.setStatu(subject);
        int count = ExamMapper.insertSelective(c);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("新建成功");
        }
        return ServerResponse.createByErrorMessage("新建失败");
    }

    @Override
    public ServerResponse<String> del(Integer id) {
        int count = ExamMapper.deleteByPrimaryKey(id);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse<String> update(Integer id, String className, String classNum,String mark,String subject) {
        Exam Exam = ExamMapper.selectByPrimaryKey(id);
        Exam.setClassName(className);
        Exam.setClassNumber(classNum);
        Exam.setMark(mark);
        Exam.setStatu(subject);
        int count = ExamMapper.updateByPrimaryKeySelective(Exam);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @Override
    public ServerResponse<Exam> find(Integer id) {
         return ServerResponse.createBySuccess(ExamMapper.selectByPrimaryKey(id));
    }

    @Override
    public ServerResponse<PageInfo<Exam>> findAll(Integer pageNum, Integer pageSize) {
        ExamQuery query = new ExamQuery();
        PageHelper.startPage(pageNum, pageSize);
        List<Exam> list = ExamMapper.selectByExampleWithRowbounds(query,new RowBounds((pageNum-1)*10,pageSize));
        PageInfo<Exam> pageInfo = new PageInfo<>(list);
        pageInfo.setTotal(ExamMapper.countByExample(query));
        return ServerResponse.createBySuccess(pageInfo);
    }
}
