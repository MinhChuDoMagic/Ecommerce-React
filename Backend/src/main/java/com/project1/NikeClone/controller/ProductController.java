package com.project1.NikeClone.controller;

import com.project1.NikeClone.entity.Product;
import com.project1.NikeClone.service.implService.ImplProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ImplProductService implProductService;

    @GetMapping("/getAll")
    public List<Product> list(){
        return implProductService.getAllProduct();
    }
}
