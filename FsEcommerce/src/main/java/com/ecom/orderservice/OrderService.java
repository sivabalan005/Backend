package com.ecom.orderservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.orderentity.OrderEntity;
import com.ecom.orderrepository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public OrderEntity saveOrder(OrderEntity order) {
		return orderRepository.save(order);
	}
	
	
	public List<OrderEntity> getAllOrders() {
	    return orderRepository.findAll();
	}

}
