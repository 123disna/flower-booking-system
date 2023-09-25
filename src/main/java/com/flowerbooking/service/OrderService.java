package com.flowerbooking.service;

import com.flowerbooking.model.Order;
import com.flowerbooking.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    public void saveOrder(Order order) {
      orderRepo.save(order);
        System.out.println("saved");
    }
}
