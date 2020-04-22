package cn.djzhao.service;

import cn.djzhao.constant.ServerResponse;
import com.github.pagehelper.PageInfo;
import cn.djzhao.model.entity.Teacher;

public interface ITeacherService {
    ServerResponse<String> add(String name, String phone, Integer countLimit);

    ServerResponse<String> del(Integer id);

    ServerResponse<String> update(Integer id, String name, String phone,Integer countLimit);

    ServerResponse<Teacher> find(Integer id);

    ServerResponse<PageInfo<Teacher>> findAll(Integer pageNum, Integer pageSize);
}
