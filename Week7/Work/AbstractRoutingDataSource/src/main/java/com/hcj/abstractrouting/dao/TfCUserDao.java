package com.hcj.abstractrouting.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hcj.abstractrouting.entity.TfCUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表(TfCUser)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-10 00:50:42
 */
@Mapper
public interface TfCUserDao extends BaseMapper<TfCUser> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TfCUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TfCUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tfCUser 实例对象
     * @return 对象列表
     */
    List<TfCUser> queryAll(TfCUser tfCUser);

    /**
     * 新增数据
     *
     * @param tfCUser 实例对象
     * @return 影响行数
     */
    int insert(TfCUser tfCUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TfCUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TfCUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TfCUser> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TfCUser> entities);

    /**
     * 修改数据
     *
     * @param tfCUser 实例对象
     * @return 影响行数
     */
    int update(TfCUser tfCUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

