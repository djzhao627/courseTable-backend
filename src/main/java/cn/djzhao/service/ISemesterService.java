package cn.djzhao.service;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.Semester;
import com.github.pagehelper.PageInfo;

public interface ISemesterService {
    ServerResponse<String> add(String year, String semester, Integer weekCount);

    ServerResponse<String> del(Integer id);

    ServerResponse<String> update(Integer id, String year, String semester, Integer weekCount);

    ServerResponse<PageInfo<Semester>> findAll(Integer pageNum, Integer pageSize);

    ServerResponse<Semester> find(Integer id);
}
