package com.example.springbootpart4.order.service;

import com.example.springbootpart4.domain.order.Order;
import com.example.springbootpart4.domain.order.OrderRepository;
import com.example.springbootpart4.order.converter.OrderConverter;
import com.example.springbootpart4.order.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderConverter orderConverter;

    @Transactional
    public String save(OrderDto dto) {
        // 1. dto -> entity 변환 (준영속)
        Order order = orderConverter.convertOrder(dto);

        // 2. orderRepository.save() (영속화)
        Order entity = orderRepository.save(order);

        // 3. 결과 반환
        return entity.getUuid();
    }

    public void findAll() {

    }

    public void findOne() {

    }
}
