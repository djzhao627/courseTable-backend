package cn.djzhao.controller;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.CoursesTable;
import cn.djzhao.model.entity.Exam;
import cn.djzhao.model.entity.Grade;
import cn.djzhao.model.entity.User;
import cn.djzhao.service.IExamService;
import cn.djzhao.service.IUserService;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给手机端使用的接口类
 *
 * @author djzhao
 * @date 20/04/25 14:16
 * @email djzhao627@gmail.com
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IUserService iUserService;

    @RequestMapping("login")
    public User login(String username, String password) {
        return iUserService.login(username, password);
    }

    @RequestMapping("updateUser")
    public String updateUser(Integer id, String username, String password, String age, String no) {
        return iUserService.update(id, username, password, age, no).getStatus() + "";
    }

    @RequestMapping("getCourses")
    public String getCourses(String type, String typeId) {
        String sql = "select id, `type`, type_id, courses from courses_table where `type` = ? and type_id = ?";
        String[] params = new String[2];
        params[0] = type;
        params[1] = typeId;
        Map coursesTable = null;
        try {
            coursesTable = jdbcTemplate.queryForMap(sql, params);
        } catch (DataAccessException e) {
            return null;
        }
        // [{"classStart":3,"dayOfWeek":1,"name":"文科物理学"},{"classStart":5,"dayOfWeek":1,"name":"人工智能"},{"classStart":3,"dayOfWeek":2,"name":"计算机网络"},{"classStart":5,"dayOfWeek":2,"name":"编译原理"},{"classStart":7,"dayOfWeek":2,"name":"算法分析与设计"}]
        return (String) coursesTable.get("courses");
    }

    @RequestMapping("getBaseInfo")
    public Map<String, Object> getBaseInfo() {
        Map<String, Object> res = new HashMap<>();
        // 班级数据
        String sql = "select id, class_name as name from classes";
        List<Map<String, Object>> classes = null;
        try {
            classes = jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        res.put("classes", classes);

        // 机房数据
        sql = "select id, room_name as name from engine_room";
        List<Map<String, Object>> engineRooms = null;
        try {
            engineRooms = jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        res.put("engineRooms", engineRooms);

        // 教室数据
        sql = "select id, room_name as name from classroom";
        List<Map<String, Object>> classrooms = null;
        try {
            classrooms = jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        res.put("classrooms", classrooms);

        // 学期数据
        sql = "select id, room_name as name from term_room";
        List<Map<String, Object>> termRooms = null;
        try {
            termRooms = jdbcTemplate.queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        res.put("termRooms", termRooms);
        return res;
    }

    @RequestMapping("getExams")
    public List<Map<String, Object>> getExams() {
        String sql = "select * from exam";
        List<Map<String, Object>> exams;
        exams = jdbcTemplate.queryForList(sql);
        return exams;
    }

    @RequestMapping("getGrades")
    public List<Map<String, Object>> getGrades(String no) {
        String sql = "select * from grade where class_name = ?";
        List<Map<String, Object>> grades;
        grades = jdbcTemplate.queryForList(sql, no);
        return grades;
    }
}
