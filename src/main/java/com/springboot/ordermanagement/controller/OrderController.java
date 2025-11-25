package com.springboot.ordermanagement.controller;

import com.springboot.ordermanagement.dto.OrderDto;
import com.springboot.ordermanagement.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class OrderController {

    private OrderService orderService;

    public OrderController (OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/getAllOrders")
    public List<OrderDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/addOrder")
    public OrderDto addOrder(@RequestBody OrderDto orderDto){
        return orderService.addOrder(orderDto);
    }

    @PutMapping("/updateOrder/{orderId}")
    public OrderDto updateOrder(@PathVariable Integer orderId, @RequestBody OrderDto orderDto){
        return orderService.updateOrder(orderId, orderDto);
    }

    @DeleteMapping("deleteOrder/{orderId}")
    public String deleteOrder(@PathVariable Integer orderId){
        return orderService.deleteOrder(orderId);
    }
}
