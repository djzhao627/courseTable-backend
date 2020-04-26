package cn.djzhao.controller;

import cn.djzhao.model.entity.User2;
import cn.djzhao.util.ToLayerUtil;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cn.djzhao.constant.LayerResponse;
import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.User;
import cn.djzhao.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Create by kwk on 2019-04-17
 *
 * @author kwk
 */
@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 添加用户
     *
     * @param username
     * @param password
     * @param age
     * @return
     */
    @RequestMapping("add")
    public ServerResponse<String> add(String username, String password, String age, String no) {
        return iUserService.add(username, password, age, no);

    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @param role
     * @param session
     * @return
     */
    @RequestMapping("login")
    public ServerResponse<User> login(String username, String password, String role, HttpSession session) {

        ServerResponse<User> login = iUserService.login(username, password, role);
        if (login.isSuccess()) {
            session.setAttribute("user", login.getData());
            System.out.println(session.getId());
        }
        return login;
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping("del")
    public ServerResponse<String> del(Integer id) {
        return iUserService.del(id);
    }

    /**
     * 查找全部用户
     *
     * @param session
     * @return
     */
    @RequestMapping("findAll")
    public LayerResponse<List<User2>> findAll(HttpSession session, Integer pageNum, Integer pageSize) {
        User user = (User) session.getAttribute(session.getId());
        ServerResponse<PageInfo<User2>> all = iUserService.findAll("会员", pageNum, pageSize);
        return ToLayerUtil.toLayer(all);
    }

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */
    @RequestMapping("find")
    public ServerResponse<User> find(Integer id) {
        return iUserService.findById(id);
    }

    /**
     * 更新用户信息
     *
     * @param id
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("update")
    public ServerResponse<String> update(Integer id, String username, String password, String age, String no) {
        return iUserService.update(id, username, password, age, no);
    }

    /**
     * 更新用户信息
     *
     * @param students 用户数据
     * @return
     */
    @RequestMapping("batchImport")
    public ServerResponse<String> batchImport(String students, boolean isRemoveAll) {
        students = students.replace("学号", "mark");
        students = students.replace("密码", "password");
        students = students.replace("姓名", "username");
        students = students.replace("年龄", "role");
        Gson gson = new Gson();
        Type type = new TypeToken<List<User2>>() {
        }.getType();
        List<User2> list = gson.fromJson(students, type);
        if (isRemoveAll) {
            iUserService.deleteAll();
        }
        return iUserService.batchImport(list);
    }
}
