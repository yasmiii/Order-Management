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

    private ModelMapper modelMapper;

    private OrderRepo orderRepo;

    public List<OrderDto> getAllOrders(){
        List<Order> orders = orderRepo.findAll();
        return modelMapper.map(orders, new TypeToken<List<OrderDto>>(){}.getType());

    }


}
