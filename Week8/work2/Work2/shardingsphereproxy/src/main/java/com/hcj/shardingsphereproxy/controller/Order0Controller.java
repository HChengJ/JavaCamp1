package com.hcj.shardingsphereproxy.controller;

import com.hcj.shardingsphereproxy.entity.Order;
import com.hcj.shardingsphereproxy.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Order0)表控制层
 *
 * @author makejava
 * @since 2021-08-15 22:53:12
 */
@RestController
@RequestMapping("order0")
public class Order0Controller {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Order selectOne(Long id) {
        return this.orderService.queryById(id);
    }

}
