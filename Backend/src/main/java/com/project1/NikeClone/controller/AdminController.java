package com.project1.NikeClone.controller;

import com.project1.NikeClone.entity.Product;
import com.project1.NikeClone.model.ProductDetail;
import com.project1.NikeClone.service.implService.ImplAdminService;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
@AllArgsConstructor
@CrossOrigin
public class AdminController {
    private final ImplAdminService implAdminService;

    @GetMapping(path = "getAll")
    public List<Product> list(){
        return implAdminService.getAllProduct();
    }

    @GetMapping(path = "getBy/{id}")
    public ProductDetail detail(@PathVariable Long id){
        return implAdminService.getProductDetail(id);
    }

    @PostMapping(path = "add")
    @Transactional
    public void add(@RequestBody ProductDetail productDetail){
        implAdminService.addProduct(productDetail);
    }

    @PutMapping(path = "update/{id}")
    @Transactional
    public void update(@RequestBody ProductDetail productDetail, @PathVariable Long id){
        implAdminService.updateProduct(id, productDetail);
    }

    @DeleteMapping(path = "delete/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        implAdminService.deleteProduct(id);
    }
}
