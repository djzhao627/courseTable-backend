package cn.djzhao.controller;

import com.github.pagehelper.PageInfo;
import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.Classes;
import cn.djzhao.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by kwk on 2019-04-17
 *
 * @author kwk
 */
@RestController
@RequestMapping("/classes/")
public class ClassesController {
    @Autowired
    private IClassesService iClassesService;

    @RequestMapping("add")
    public ServerResponse<String> add(String className, String classNum,Integer limit) {
        return iClassesService.add(className, classNum,limit);
    }

    @RequestMapping("del")
    public ServerResponse<String> del(Integer id) {
        return iClassesService.del(id);
    }

    @RequestMapping("update")
    public ServerResponse<String> update(Integer id, String className, String classNum,Integer limit) {
        return iClassesService.update(id, className, classNum,limit);
    }

    @RequestMapping("find")
    public ServerResponse<Classes> find(Integer id) {
        return iClassesService.find(id);
    }

    @RequestMapping("findAll")
    public ServerResponse<PageInfo<Classes>> findAll(Integer pageNum, Integer pageSize) {
        return iClassesService.findAll(pageNum, pageSize);
    }
}
