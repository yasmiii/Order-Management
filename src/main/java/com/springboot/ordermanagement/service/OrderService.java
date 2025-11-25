package com.springboot.ordermanagement.service;

import com.springboot.ordermanagement.dto.OrderDto;
import com.springboot.ordermanagement.model.Order;
import com.springboot.ordermanagement.repo.OrderRepo;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;


import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderRepo orderRepo;

    public List<OrderDto> getAllOrders(){
        List<Order> orders = orderRepo.findAll();
        return modelMapper.map(orders, new TypeToken<List<OrderDto>>(){}.getType());

    }

    public OrderDto addOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        Order savedOrder = orderRepo.save(order);
        return modelMapper.map(savedOrder, OrderDto.class);
    }

    public OrderDto updateOrder(Integer orderId, OrderDto orderDto){
        Order existingOrder = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        existingOrder.setOrderDate(orderDto.getOrderDate());
        existingOrder.setItemId(orderDto.getItemId());
        existingOrder.setAmount(orderDto.getAmount());
        orderRepo.save(existingOrder);
        return modelMapper.map(existingOrder, OrderDto.class);
    }

    public String deleteOrder(Integer orderId) {
        if (!orderRepo.existsById(orderId)) {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }
        orderRepo.deleteById(orderId);
        return "Order deleted";
    }



}
