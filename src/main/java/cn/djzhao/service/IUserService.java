package cn.djzhao.service;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.User2;
import com.github.pagehelper.PageInfo;
import cn.djzhao.model.entity.User;

import java.util.List;

/**
 * Create by kwk on 2019-04-17
 *
 * @author kwk
 */
public interface IUserService {
    ServerResponse<String> add(String username, String password, String role);

    ServerResponse<User> login(String username, String password, String role);

    ServerResponse<String> del(Integer id);

    ServerResponse<PageInfo<User2>> findAll(String role, Integer pageNum, Integer pageSize);

    ServerResponse<User> findById(Integer id);

    ServerResponse<String> update(Integer id, String username, String password,String role);

    ServerResponse<String> batchImport(List<User2> user2s);

    ServerResponse<String> deleteAll();
}
