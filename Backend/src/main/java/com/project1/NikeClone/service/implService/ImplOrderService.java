package com.project1.NikeClone.service.implService;

import com.project1.NikeClone.entity.Ordered;
import com.project1.NikeClone.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplOrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Ordered> getAllOrder(){
        return orderRepository.findAll();
    }

    public Ordered addOrder(Ordered ordered){
        return orderRepository.save(ordered);
    }
}
