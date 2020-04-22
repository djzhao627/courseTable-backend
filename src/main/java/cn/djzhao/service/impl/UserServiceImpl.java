package cn.djzhao.service.impl;

import cn.djzhao.constant.Constant;
import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.User2;
import cn.djzhao.model.entity.User2Query;
import cn.djzhao.model.entity.UserQuery;
import cn.djzhao.model.mapper.User2Mapper;
import cn.djzhao.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.djzhao.model.entity.User;
import cn.djzhao.model.mapper.UserMapper;
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
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private User2Mapper user2Mapper;

    @Override
    public ServerResponse<String> add(String username, String password, String role) {
        UserQuery query = new UserQuery();
        query.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(query);
        if (users.size() > 0) {
            return ServerResponse.createByErrorMessage("用户已经存在");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        int count = userMapper.insertSelective(user);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("用户创建成功");
        }
        return ServerResponse.createByErrorMessage("用户创建失败");
    }

    @Override
    public ServerResponse<User> login(String username, String password, String role) {
        UserQuery query = new UserQuery();
        query.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password).andRoleEqualTo(role);
        User user = userMapper.selectOneByExample(query);
        if (user != null) {
            user.setPassword("");
            return ServerResponse.createBySuccess("登录成功", user);
        }
        return ServerResponse.createByErrorMessage("账号信息错误");
    }

    @Override
    public ServerResponse<String> del(Integer id) {
        int count = userMapper.deleteByPrimaryKey(id);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse<PageInfo<User2>> findAll(String role, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        User2Query query = new User2Query();
        List<User2> users;
        PageInfo<User2> pageInfo;
        if (role.equals(Constant.ADMIN)) {
            users = user2Mapper.selectByExampleWithRowbounds(query, new RowBounds((pageNum - 1) * 10, pageSize));
            pageInfo = new PageInfo<>(users);
            pageInfo.setTotal(user2Mapper.countByExample(query));

        } else {
            query.createCriteria().andRoleEqualTo(Constant.NOT_ADMIN);
            users = user2Mapper.selectByExampleWithRowbounds(query, new RowBounds((pageNum - 1) * 10, pageSize));
            pageInfo = new PageInfo<>(users);
            pageInfo.setTotal(user2Mapper.countByExample(query));
        }
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse<User> findById(Integer id) {
        return ServerResponse.createBySuccess(userMapper.selectByPrimaryKey(id));
    }

    @Override
    public ServerResponse<String> update(Integer id, String username, String password, String role) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        int count = userMapper.updateByPrimaryKeySelective(user);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @Override
    public ServerResponse<String> batchImport(List<User2> user2s) {
        int insert = user2Mapper.batchInsert(user2s);
        if (insert > 0) {
            return ServerResponse.createBySuccessMessage("批量插入成功");
        } else {
            return ServerResponse.createByErrorMessage("批量插入失败");
        }
    }

    @Override
    public ServerResponse<String> deleteAll() {
        user2Mapper.deleteAll();
        return ServerResponse.createBySuccessMessage("删除全部成功");
    }
}
