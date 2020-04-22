package cn.djzhao.service;

import cn.djzhao.constant.ServerResponse;

/**
 * Create by kwk on 2019-04-24
 *
 * @author kwk
 */
public interface IArrService {
    ServerResponse<String> arr(int weeks);
}
