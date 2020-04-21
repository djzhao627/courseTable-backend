package com.hut.kwk.service;

import com.github.pagehelper.PageInfo;
import com.hut.kwk.constant.ServerResponse;
import com.hut.kwk.model.entity.User;
import com.hut.kwk.model.entity.User2;

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
