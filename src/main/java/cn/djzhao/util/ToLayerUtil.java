package cn.djzhao.util;

import cn.djzhao.model.entity.User2;
import com.github.pagehelper.PageInfo;
import cn.djzhao.constant.LayerResponse;
import cn.djzhao.constant.ServerResponse;

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
