package cn.djzhao.service;

import cn.djzhao.constant.ServerResponse;
import com.github.pagehelper.PageInfo;
import cn.djzhao.model.entity.Classroom;
import cn.djzhao.model.entity.ClassroomFree;

import java.util.List;

public interface IClassroomService {
    ServerResponse<String> add(String roomName, Integer roomSpace, Integer roomLayer);

    ServerResponse<String> del(Integer id);

    ServerResponse<Classroom> find(Integer id);

    ServerResponse<PageInfo<Classroom>> findAll(Integer pageNum, Integer pageSize);

    ServerResponse<String> update(Integer id, String roomName, Integer roomSpace, Integer roomLaye);

    List<ClassroomFree> findByWeek(Integer week,String roomName);
}
