package com.kharidlo.service.order;

import com.kharidlo.service.order.model.Order;
import com.kharidlo.service.order.model.OrderCreationResponse;
import com.kharidlo.service.order.model.OrderedItem;
import com.kharidlo.service.order.repository.OrderRepository;
import com.kharidlo.service.order.service.OrderServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    private OrderServiceImpl orderService;

    @Before
    public void setUp(){
        this.orderService = new OrderServiceImpl(orderRepository);
    }

    @Test
    public void shouldReturnOrderIdIOnSuccessfulOrderCreation() {

        List<OrderedItem> itemsInDb = new ArrayList<>();
        itemsInDb.add(new OrderedItem( 1, 10, 10));
        Order order = new Order(1, "abhisek@gmail.com", 102.70, "OPEN",
                "Anandapur, Midnapore, West Bengal", itemsInDb);

        when(orderRepository.save(Mockito.any(Order.class))).thenReturn(order);

        OrderCreationResponse response = orderService.create(order);
        Assert.assertEquals(1, response.getOrderId());
    }


}
