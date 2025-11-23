package com.springboot.ordermanagement.controller;

import com.springboot.ordermanagement.dto.OrderDto;
import com.springboot.ordermanagement.service.OrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1")
public class OrderController {

    private OrderService orderService;

    @GetMapping("/getAllOrders")
    public List<OrderDto> getAllOrders(){
        return orderService.getAllOrders();
    }
}
