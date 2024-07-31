package com.common.inventory.service;

import com.common.inventory.entity.ProductEntity;
import com.common.inventory.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private ProductRepository productRepository;

    private JmsTemplate jmsTemplate;

    @Autowired
    public InventoryService(ProductRepository productRepository, JmsTemplate jmsTemplate) {
        this.productRepository = productRepository;
        this.jmsTemplate = jmsTemplate;
    }

    @JmsListener(destination = "inventory.reserve", containerFactory = "jmsListenerContainerFactory")
    public void reserveInventory(String message) {
        // Reserve the inventory for the product
        // Send a message back to the saga to indicate success or failure
        jmsTemplate.convertAndSend("saga.order", "inventory.reserved");
    }


    @Transactional
    public boolean releaseProduct(String productId) {
        try {
            ProductEntity product = productRepository.findById(Long.valueOf(productId)).get();
            product.setCount(product.getCount() - 1);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
