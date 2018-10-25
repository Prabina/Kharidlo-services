package com.kharidlo.service.order.service;

import com.kharidlo.service.order.model.Order;
import com.kharidlo.service.order.model.OrderCreationResponse;
import com.kharidlo.service.order.model.OrderedItem;
import com.kharidlo.service.order.repository.OrderRepository;
import com.kharidlo.service.product.model.Product;
import com.kharidlo.service.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl {

    private OrderRepository orderRepository;

    private IProductRepository productRepository;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, IProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Optional<Long> create(Order order) {
        if (preValidateOrderSucess(order)) {
            long orderId = orderRepository.save(order).getId();
            return Optional.of(orderId);
        } else {
            return Optional.ofNullable(null);
        }
    }

    private boolean preValidateOrderSucess(Order order) {

        if (!order.getItems().isEmpty()) {
            for (OrderedItem orderedItem : order.getItems()) {
                if (!isProductAvailable(orderedItem.getProductId())) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean isProductAvailable(int prductId) {
        Optional<Product> product = productRepository.findById(prductId);
        return product.isPresent() ? true : false;
    }
}
