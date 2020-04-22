package cn.djzhao.service;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.EngineRoom;
import cn.djzhao.model.entity.EngineRoomFree;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IEngineRoomService {
    ServerResponse<String> add(String roomName, Integer roomSpace, Integer roomLayer);

    ServerResponse<String> del(Integer id);

    ServerResponse<EngineRoom> find(Integer id);

    ServerResponse<PageInfo<EngineRoom>> findAll(Integer pageNum, Integer pageSize);

    ServerResponse<String> update(Integer id, String roomName, Integer roomSpace, Integer roomLaye);

    List<EngineRoomFree> findByWeek(Integer week, String roomName);
}
