package cn.djzhao.service;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.CourseTable;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Create by kwk on 2019-04-24
 *
 * @author kwk
 */
public interface ICourseTableService {
    ServerResponse<String> add(CourseTable courseTable);

    ServerResponse<String> del(Integer id);

    ServerResponse<String> update(CourseTable courseTable);

    ServerResponse<CourseTable> find(Integer id);

    ServerResponse<PageInfo<CourseTable>> findAll(Integer pageNum, Integer pageSize);

    ServerResponse<String> arr();

    ServerResponse<List<CourseTable>> findBy(String className, String teacherName,Integer week);

    ServerResponse<PageInfo<CourseTable>> findAllBy(Integer pageNum, Integer pageSize, Integer week, String courseName, String className, String teacherName, String roomName);

    ServerResponse<String> adjust(Integer courseTableId, Integer classroomId, Integer week, String day, Integer number, String classroomName);
}
