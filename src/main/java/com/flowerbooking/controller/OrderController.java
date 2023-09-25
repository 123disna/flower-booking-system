package com.flowerbooking.controller;

import com.flowerbooking.model.Order;
import com.flowerbooking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@Controller
@RequestMapping
public class OrderController {

    @Autowired
    OrderService orderService;

   /* @PostMapping("/order/new")
    public String orderSave(@ModelAttribute("order")Order order, @RequestParam("imageFile")MultipartFile imageFile)throws Exception,Exception{
        orderService.saveOrder(order);
        return "redirect:/flower/cart";
    }*/

}
