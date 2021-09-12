package com.hcj.shardingsphereatomikosxa.controller;

import com.hcj.shardingsphereatomikosxa.entity.Order;
import com.hcj.shardingsphereatomikosxa.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Order0)表控制层
 *
 * @author makejava
 * @since 2021-08-19 23:13:57
 */
@RestController
@RequestMapping("order")
public class OrderController {
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
