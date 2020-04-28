package cn.djzhao.controller;

import cn.djzhao.model.entity.Course;
import cn.djzhao.model.entity.CoursesTable;
import com.github.pagehelper.PageInfo;
import cn.djzhao.constant.ServerResponse;
import cn.djzhao.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Create by kwk on 2019-04-17
 *
 * @author kwk
 */
@RestController
@RequestMapping("/course/")
public class CourseController {
    @Autowired
    private ICourseService iCourseService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("add")
    public ServerResponse<String> add(String courseName, Integer courseTime,Integer sord) {
        return iCourseService.add(courseName, courseTime,sord);
    }

    @RequestMapping("del")
    public ServerResponse<String> del(Integer id) {
        return iCourseService.del(id);
    }

    @RequestMapping("update")
    public ServerResponse<String> update(Integer id, String courseName, Integer courseTime,Integer sord) {
        return iCourseService.update(id, courseName, courseTime,sord);
    }

    @RequestMapping("find")
    public ServerResponse<Course> find(Integer id) {
        return iCourseService.find(id);
    }

    @RequestMapping("findAll")
    public ServerResponse<PageInfo<Course>> findAll(Integer pageNum, Integer pageSize) {
        return iCourseService.findAll(pageNum, pageSize);
    }
    @RequestMapping("findAllByName")
    public ServerResponse<PageInfo<Course>> findAllByName(Integer pageNum, Integer pageSize,String courseName) {
        return iCourseService.findAllByName(pageNum, pageSize,courseName);
    }

    /**
     * 导入课表
     * @param type
     * @param typeId
     * @return
     */
    @RequestMapping("import")
    public ServerResponse<Integer> importData(String type, String typeId, String courses) {
        courses = courses.replace("周", "dayOfWeek");
        courses = courses.replace("节", "classStart");
        courses = courses.replace("课程名", "name");
        String sql = "delete from courses_table where `type` = ? and type_id = ?";
        String[] params = new String[2];
        params[0] = type;
        params[1] = typeId;
        jdbcTemplate.update(sql, params);
        sql = "insert into courses_table (`type`, type_id, courses) values (?, ?, ?)";
        params = new String[3];
        params[0] = type;
        params[1] = typeId;
        params[2] = courses;
        int number = jdbcTemplate.update(sql, params);
        if (number > 0) {
            return ServerResponse.createBySuccess(number);
        } else {
            return ServerResponse.createByErrorMessage("导入出错");
        }
    }

    /**
     * 查询课表
     * @param type
     * @param typeId
     * @return
     */
    @RequestMapping("query")
    public ServerResponse<String> query(String type, String typeId) {
        String sql = "select id, `type`, type_id, courses from courses_table where `type` = ? and type_id = ?";
        String[] params = new String[2];
        params[0] = type;
        params[1] = typeId;
        Map coursesTable = null;
        try {
            coursesTable = jdbcTemplate.queryForMap(sql, params);
        } catch (DataAccessException e) {
            return ServerResponse.createByErrorMessage("暂无数据");
        }
        // [{"classStart":3,"dayOfWeek":1,"name":"文科物理学"},{"classStart":5,"dayOfWeek":1,"name":"人工智能"},{"classStart":3,"dayOfWeek":2,"name":"计算机网络"},{"classStart":5,"dayOfWeek":2,"name":"编译原理"},{"classStart":7,"dayOfWeek":2,"name":"算法分析与设计"}]
        return ServerResponse.createBySuccess((String) coursesTable.get("courses"));
    }


}
