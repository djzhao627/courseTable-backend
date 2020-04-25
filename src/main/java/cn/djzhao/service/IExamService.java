package cn.djzhao.service;

import cn.djzhao.constant.ServerResponse;
import cn.djzhao.model.entity.Exam;
import com.github.pagehelper.PageInfo;

public interface IExamService {
    ServerResponse<String> add(String className, String classNum, String mark, String subject);

    ServerResponse<String> del(Integer id);

    ServerResponse<String> update(Integer id, String className, String classNum, String mark, String subject);

    ServerResponse<Exam> find(Integer id);

    ServerResponse<PageInfo<Exam>> findAll(Integer pageNum, Integer pageSize);
}
