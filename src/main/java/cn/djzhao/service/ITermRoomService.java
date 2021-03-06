package cn.djzhao.service;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.TermRoom;
import cn.djzhao.model.entity.TermRoomFree;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ITermRoomService {
    ServerResponse<String> add(String roomName, String mark);

    ServerResponse<String> del(Integer id);

    ServerResponse<TermRoom> find(Integer id);

    ServerResponse<PageInfo<TermRoom>> findAll(Integer pageNum, Integer pageSize);

    ServerResponse<String> update(Integer id, String roomName, String mark);

    List<TermRoomFree> findByWeek(Integer week, String roomName);
}
