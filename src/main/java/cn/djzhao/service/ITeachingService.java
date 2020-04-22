package cn.djzhao.service;

import cn.djzhao.constant.ServerResponse;
import com.github.pagehelper.PageInfo;
import cn.djzhao.model.entity.Teaching;

public interface ITeachingService {
    ServerResponse<String> add(Integer classId, Integer teacherId, Integer semId, String className, String techerName);

    ServerResponse<String> del(Integer id);

    ServerResponse<String> update(Integer id, Integer classId, Integer teacherId, Integer semId, String className, String techerName);

    ServerResponse<Teaching> find(Integer id);

    ServerResponse<PageInfo<Teaching>> findAll(Integer pageNum, Integer pageSize);
}
