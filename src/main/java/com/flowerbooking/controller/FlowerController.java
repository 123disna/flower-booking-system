package com.flowerbooking.controller;

import com.flowerbooking.model.Flower;
import com.flowerbooking.model.Order;
import com.flowerbooking.model.OrderItem;
import com.flowerbooking.model.User;
import com.flowerbooking.service.FlowerService;
import com.flowerbooking.service.OrderService;
import com.flowerbooking.service.UserService;
import com.flowerbooking.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FlowerController {
    @Autowired
    private FlowerService flowerService;

    @Autowired
    private ImageUtils imageUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/flower/new")
    public String flowerForm(Model model){
        model.addAttribute("flower",new Flower());
        return "flower-form";
    }

    @PostMapping("/flower/new")
    public String saveFlower(@ModelAttribute("flower") Flower flower, @RequestParam("imageFile")MultipartFile imageFie) throws IOException,IOException {
        if(!imageFie.isEmpty()){
            flower.setImage(imageFie.getBytes());
        }
        flowerService.saveFlower(flower);
        return "redirect:/flower/all";
    }

    @GetMapping("/flower/all")
    public String listAllFlower(Model model){
        List<Flower> flower=flowerService.getAllFlowers();
        model.addAttribute("flower",flower);
        model.addAttribute("imageUtils",imageUtils);
        return "flowerDetails";
    }

    @GetMapping("/flower/mainPage")
    public String listAllFlowerMainPage(Model model){
        List<Flower> flower=flowerService.getAllFlowers();
        model.addAttribute("flower",flower);
        model.addAttribute("imageUtils",imageUtils);
        return "flower-page";
    }

    @GetMapping("/flower/cart")
    public String listAllFlowerCart(Model model){
        List<Flower> flower=flowerService.getAllFlowers();
        model.addAttribute("flower",flower);
        model.addAttribute("imageUtils",imageUtils);
        return "flower-cart";
    }

    @GetMapping("/flower/edit/{id}")
    public String editFlowerForm(@PathVariable(value = "id") int id,Model model){
        model.addAttribute("flower",flowerService.getFlowerById(id));
        return "edit_flower";
    }

    @PostMapping("/flower/{id}")
    public String updateFlower(@PathVariable int id,
                                @ModelAttribute("flower")Flower flower,@RequestParam("imageFile") MultipartFile imageFile) throws IOException,IOException{
        Flower existFlower=flowerService.getFlowerById(id);
        existFlower.setName(flower.getName());
        existFlower.setDescription(flower.getDescription());
        existFlower.setPrice(flower.getPrice());
        if(imageFile.isEmpty()){
            flower.setImage(imageFile.getBytes());
        }
        flowerService.updateFlower(existFlower);
        return "redirect:/flower/all";
    }

    @GetMapping("/flower/{id}")
    public String deleteFlower(@PathVariable int id){
        flowerService.deleteFlower(id);
        return "redirect:/flower/all";
    }
    @PostMapping("/order/new")
    public String orderSave(@RequestParam("selectedFlowers") List<Integer> selectedFlowerIds,
                            @RequestParam("quantities") List<Integer> quantities,
                           // @RequestParam("id") Integer id,
                            Principal principal) {
        //User currentUser = userService.getUserById(userId);

        Order order = new Order();
        //order.setUser(currentUser);

        List<OrderItem> orderItems = new ArrayList<>();
        double total=0;
        for (int i = 0; i < selectedFlowerIds.size(); i++) {
            int flowerId = selectedFlowerIds.get(i);
            int quantity = quantities.get(i);

            Flower flower = flowerService.getFlowerById(flowerId);

            OrderItem orderItem = new OrderItem();
            orderItem.setFlower(flower);
            orderItem.setQty(quantity);
            total+=flower.getPrice();

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        order.setTotal(total);

        orderService.saveOrder(order);

        return "redirect:/flower/cart";
    }
}
