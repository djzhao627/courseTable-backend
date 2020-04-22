package cn.djzhao.controller;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.EngineRoom;
import cn.djzhao.model.entity.EngineRoomFree;
import cn.djzhao.service.IEngineRoomService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by djzhao on 2020-04-22
 *
 * @author djzhao
 */
@RestController
@RequestMapping("/engineRoom/")
public class EngineRoomController {

    @Autowired
    private IEngineRoomService iEngineRoomService;

    @RequestMapping("add")
    public ServerResponse<String> add(String roomName, Integer roomSpace, Integer roomLayer) {
        return iEngineRoomService.add(roomName, roomSpace, roomLayer);
    }

    @RequestMapping("del")
    public ServerResponse<String> del(Integer id) {
        return iEngineRoomService.del(id);
    }

    @RequestMapping("update")
    public ServerResponse<String> update(Integer id, String roomName, Integer roomSpace, Integer roomLayer) {
        return iEngineRoomService.update(id, roomName, roomSpace, roomLayer);
    }

    @RequestMapping("find")
    public ServerResponse<EngineRoom> find(Integer id) {
        return iEngineRoomService.find(id);
    }

    @RequestMapping("findAll")
    public ServerResponse<PageInfo<EngineRoom>> findAll(Integer pageNum, Integer pageSize) {
        return iEngineRoomService.findAll(pageNum, pageSize);
    }

    @RequestMapping("findByWeek")
    public ServerResponse<PageInfo<EngineRoomFree>> findByWeek(Integer pageNum, Integer pageSize, Integer week,String roomName,String day) {
        List<EngineRoomFree> byWeek = iEngineRoomService.findByWeek(week,roomName);
        List<EngineRoomFree> collect;
        if (day!=null&&!"".equals(day)){
             collect= byWeek.stream().filter(s->s.getDay().equals(day)).skip((pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        }else {
            collect= byWeek.stream().skip((pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        }
        PageInfo<EngineRoomFree> pageInfo = new PageInfo<>(collect);
        pageInfo.setTotal(byWeek.size());
        return ServerResponse.createBySuccess(pageInfo);
    }

}
