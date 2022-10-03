package com.project1.NikeClone.controller;

import com.project1.NikeClone.entity.Ordered;
import com.project1.NikeClone.service.implService.ImplOrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "order")
@AllArgsConstructor
@CrossOrigin
public class OrderController {
    private final ImplOrderService implOrderService;

    @GetMapping
    public List<Ordered> getAllOrder(){
        return implOrderService.getAllOrder();
    }

    @PostMapping
    public Ordered addOrder(@RequestBody Ordered ordered){
        return implOrderService.addOrder(ordered);
    }
}
