package com.hcj.abstractrouting.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcj.abstractrouting.entity.TfCUser;
import com.hcj.abstractrouting.dao.TfCUserDao;
import com.hcj.abstractrouting.service.TfCUserService;
import com.hcj.abstractrouting.util.CurDataSource;
import com.hcj.abstractrouting.util.DataSourceNames;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 用户表(TfCUser)表服务实现类
 *
 * @author makejava
 * @since 2021-08-10 00:50:43
 */
@Service("tfCUserService")
public  class TfCUserServiceImpl  extends ServiceImpl<TfCUserDao, TfCUser> implements TfCUserService{
    @Resource
    private TfCUserDao tfCUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TfCUser queryById(Long id) {
        return this.tfCUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TfCUser> queryAllByLimit(int offset, int limit) {
        return this.tfCUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tfCUser 实例对象
     * @return 实例对象
     */
    @Override
    public TfCUser insert(TfCUser tfCUser) {
        this.tfCUserDao.insert(tfCUser);
        return tfCUser;
    }

    /**
     * 修改数据
     *
     * @param tfCUser 实例对象
     * @return 实例对象
     */
    @Override
    public TfCUser update(TfCUser tfCUser) {
        this.tfCUserDao.update(tfCUser);
        return this.queryById(tfCUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tfCUserDao.deleteById(id) > 0;
    }

    @Override
    public boolean save(TfCUser tfCUser) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<TfCUser> collection) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<TfCUser> collection, int i) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<TfCUser> collection) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<TfCUser> collection, int i) {
        return false;
    }

    @Override
    public boolean removeById(Serializable serializable) {
        return false;
    }

    @Override
    public boolean removeByMap(Map<String, Object> map) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<TfCUser> wrapper) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> collection) {
        return false;
    }

    @Override
    public boolean updateById(TfCUser tfCUser) {
        return false;
    }

    @Override
    public boolean update(TfCUser tfCUser, Wrapper<TfCUser> wrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<TfCUser> collection) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<TfCUser> collection, int i) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(TfCUser tfCUser) {
        return false;
    }

    @Override
    public TfCUser getById(Serializable serializable) {
        return null;
    }

    @Override
    public Collection<TfCUser> listByIds(Collection<? extends Serializable> collection) {
        return null;
    }

    @Override
    public Collection<TfCUser> listByMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public TfCUser getOne(Wrapper<TfCUser> wrapper) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<TfCUser> wrapper) {
        return null;
    }

    @Override
    public Object getObj(Wrapper<TfCUser> wrapper) {
        return null;
    }

    @Override
    public int count(Wrapper<TfCUser> wrapper) {
        return 0;
    }

    @Override
    public List<TfCUser> list(Wrapper<TfCUser> wrapper) {
        return null;
    }

    @Override
    public IPage<TfCUser> page(IPage<TfCUser> iPage, Wrapper<TfCUser> wrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<TfCUser> wrapper) {
        return null;
    }

    @Override
    public List<Object> listObjs(Wrapper<TfCUser> wrapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<TfCUser> iPage, Wrapper<TfCUser> wrapper) {
        return null;
    }

    @Override
    public TfCUser findUserByFirstDb(long id) {
        return this.baseMapper.selectById(id);
    }

    @CurDataSource(name = DataSourceNames.SECOND)
    @Override
    public TfCUser findUserBySecondDb(long id) {
        return this.baseMapper.selectById(id);
    }
}
