package cn.djzhao.controller;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.Grade;
import cn.djzhao.service.IGradeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author djzhao
 */
@RestController
@RequestMapping("/grade/")
public class GradeController {
    @Autowired
    private IGradeService iGradeService;

    @RequestMapping("add")
    public ServerResponse<String> add(String className, String classNum, String mark) {
        return iGradeService.add(className, classNum, mark);
    }

    @RequestMapping("del")
    public ServerResponse<String> del(Integer id) {
        return iGradeService.del(id);
    }

    @RequestMapping("update")
    public ServerResponse<String> update(Integer id, String className, String classNum, String mark) {
        return iGradeService.update(id, className, classNum, mark);
    }

    @RequestMapping("find")
    public ServerResponse<Grade> find(Integer id) {
        return iGradeService.find(id);
    }

    @RequestMapping("findAll")
    public ServerResponse<PageInfo<Grade>> findAll(Integer pageNum, Integer pageSize) {
        return iGradeService.findAll(pageNum, pageSize);
    }
}
