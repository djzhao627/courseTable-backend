package com.hut.kwk.util;

import com.github.pagehelper.PageInfo;
import com.hut.kwk.constant.LayerResponse;
import com.hut.kwk.constant.ServerResponse;
import com.hut.kwk.model.entity.User;
import com.hut.kwk.model.entity.User2;

import java.util.List;

/**
 * Create by kwk on 2019-04-21
 *
 * @author kwk
 */
public class ToLayerUtil {
    public static LayerResponse<List<User2>> toLayer(ServerResponse<PageInfo<User2>> serverResponse){
        return new LayerResponse<>(serverResponse.getStatus(),serverResponse.getMsg(),serverResponse.getData().getTotal(),serverResponse.getData().getList());
    }
}
