package cn.djzhao.service;

import cn.djzhao.constant.ServerResponse;
import com.github.pagehelper.PageInfo;
import cn.djzhao.model.entity.Arrange;

/**
 * Create by kwk on 2019-04-23
 *
 * @author kwk
 */
public interface IArrangeService {
    ServerResponse<String> add(Arrange arrange);

    ServerResponse<String> del(Integer id);

    ServerResponse<String> update(Arrange arrange);

    ServerResponse<Arrange> find(Integer id);

    ServerResponse<PageInfo<Arrange>> findAll(Integer pageNum, Integer pageSize);
}
