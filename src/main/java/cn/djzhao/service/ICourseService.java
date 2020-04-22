package cn.djzhao.service;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.Course;
import com.github.pagehelper.PageInfo;

public interface ICourseService {
    ServerResponse<String> add(String courseName, Integer courseTime, Integer sord);

    ServerResponse<String> del(Integer id);

    ServerResponse<String> update(Integer id, String courseName, Integer courseTime ,Integer sord);

    ServerResponse<Course> find(Integer id);

    ServerResponse<PageInfo<Course>> findAll(Integer pageNum, Integer pageSize);

    ServerResponse<PageInfo<Course>> findAllByName(Integer pageNum, Integer pageSize, String courseName);
}
