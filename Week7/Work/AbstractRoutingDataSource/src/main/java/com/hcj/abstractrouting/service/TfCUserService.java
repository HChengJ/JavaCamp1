package com.hcj.abstractrouting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hcj.abstractrouting.entity.TfCUser;
import com.hcj.abstractrouting.util.CurDataSource;
import com.hcj.abstractrouting.util.DataSourceNames;

import java.util.List;

/**
 * 用户表(TfCUser)表服务接口
 *
 * @author makejava
 * @since 2021-08-10 00:50:42
 */
public interface TfCUserService extends IService<TfCUser> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TfCUser queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TfCUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tfCUser 实例对象
     * @return 实例对象
     */
    TfCUser insert(TfCUser tfCUser);

    /**
     * 修改数据
     *
     * @param tfCUser 实例对象
     * @return 实例对象
     */
    TfCUser update(TfCUser tfCUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    TfCUser findUserByFirstDb(long id) ;

    TfCUser findUserBySecondDb(long id);
}
