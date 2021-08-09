package com.hcj.abstractrouting.controller;

import com.hcj.abstractrouting.entity.TfCUser;
import com.hcj.abstractrouting.service.TfCUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户表(TfCUser)表控制层
 *
 * @author makejava
 * @since 2021-08-10 00:50:43
 */
@RestController
@RequestMapping("tfCUser")
public class TfCUserController {
    /**
     * 服务对象
     */
    @Resource
    private TfCUserService tfCUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TfCUser selectOne(Long id) {
        return this.tfCUserService.queryById(id);
    }

}
