package cn.djzhao.controller;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.service.IArrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by kwk on 2019-04-24
 *
 * @author kwk
 */
@RestController
@RequestMapping("/process/")
public class ArrController {

    @Autowired
    private IArrService iArrService;
    @RequestMapping("arr")
    public ServerResponse<String> arr() {
        return iArrService.arr(20);
    }
}
