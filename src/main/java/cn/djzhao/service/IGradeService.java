package cn.djzhao.service;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.Grade;
import com.github.pagehelper.PageInfo;

public interface IGradeService {
    ServerResponse<String> add(String className, String classNum, String mark);

    ServerResponse<String> del(Integer id);

    ServerResponse<String> update(Integer id, String className, String classNum, String mark);

    ServerResponse<Grade> find(Integer id);

    ServerResponse<PageInfo<Grade>> findAll(Integer pageNum, Integer pageSize);
}
