package cn.djzhao.controller;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.TermRoom;
import cn.djzhao.model.entity.TermRoomFree;
import cn.djzhao.service.ITermRoomService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author djzhao
 */
@RestController
@RequestMapping("/term/")
public class TermRoomController {

    @Autowired
    private ITermRoomService iTermRoomService;

    @RequestMapping("add")
    public ServerResponse<String> add(String roomName, String mark) {
        return iTermRoomService.add(roomName, mark);
    }

    @RequestMapping("del")
    public ServerResponse<String> del(Integer id) {
        return iTermRoomService.del(id);
    }

    @RequestMapping("update")
    public ServerResponse<String> update(Integer id, String roomName, String mark) {
        return iTermRoomService.update(id, roomName, mark);
    }

    @RequestMapping("find")
    public ServerResponse<TermRoom> find(Integer id) {
        return iTermRoomService.find(id);
    }

    @RequestMapping("findAll")
    public ServerResponse<PageInfo<TermRoom>> findAll(Integer pageNum, Integer pageSize) {
        return iTermRoomService.findAll(pageNum, pageSize);
    }

    @RequestMapping("findByWeek")
    public ServerResponse<PageInfo<TermRoomFree>> findByWeek(Integer pageNum, Integer pageSize, Integer week,String roomName,String day) {
        List<TermRoomFree> byWeek = iTermRoomService.findByWeek(week,roomName);
        List<TermRoomFree> collect;
        if (day!=null&&!"".equals(day)){
             collect= byWeek.stream().filter(s->s.getDay().equals(day)).skip((pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        }else {
            collect= byWeek.stream().skip((pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        }
        PageInfo<TermRoomFree> pageInfo = new PageInfo<>(collect);
        pageInfo.setTotal(byWeek.size());
        return ServerResponse.createBySuccess(pageInfo);
    }

}
