package cn.djzhao.controller;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.Exam;
import cn.djzhao.service.IExamService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author djzhao
 */
@RestController
@RequestMapping("/exam/")
public class ExamController {
    @Autowired
    private IExamService iExamService;

    @RequestMapping("add")
    public ServerResponse<String> add(String className, String classNum, String mark, String subject) {
        return iExamService.add(className, classNum, mark, subject);
    }

    @RequestMapping("del")
    public ServerResponse<String> del(Integer id) {
        return iExamService.del(id);
    }

    @RequestMapping("update")
    public ServerResponse<String> update(Integer id, String className, String classNum, String mark, String subject) {
        return iExamService.update(id, className, classNum, mark, subject);
    }

    @RequestMapping("find")
    public ServerResponse<Exam> find(Integer id) {
        return iExamService.find(id);
    }

    @RequestMapping("findAll")
    public ServerResponse<PageInfo<Exam>> findAll(Integer pageNum, Integer pageSize) {
        return iExamService.findAll(pageNum, pageSize);
    }
}
