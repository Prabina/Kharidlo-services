package com.kharidlo.service.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kharidlo.service.order.Controller.OrderController;
import com.kharidlo.service.order.model.Order;
import com.kharidlo.service.order.model.OrderedItem;
import com.kharidlo.service.order.service.OrderServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    OrderServiceImpl orderService;

    private ObjectMapper objectMapper;

    @Before
    public void init(){
        objectMapper = new ObjectMapper();
    }

    private String getOrderRequest() throws JsonProcessingException {
        List<OrderedItem> itemsInDb = new ArrayList<>();
        itemsInDb.add(new OrderedItem( 1, 10, 10));
        Order order = new Order(1, "abhisek@gmail.com", 102.70, "OPEN",
                "Anandapur, Midnapore, West Bengal", itemsInDb);
        return objectMapper.writeValueAsString(order);
    }

    @Test
    public void shouldReturnSuccessWhenOrderIsCreated() throws Exception {

        when(orderService.create(Mockito.any(Order.class))).thenReturn(Optional.of(1L));

        mockMvc.perform(post("/order").contentType(MediaType.APPLICATION_JSON).content(getOrderRequest()))
                .andExpect(status().isCreated());
    }


    @Test
    public void shouldReturnConflictWhenOrderIsNotCreated() throws Exception {

        when(orderService.create(Mockito.any(Order.class))).thenReturn(Optional.ofNullable(null));

        mockMvc.perform(post("/order").contentType(MediaType.APPLICATION_JSON).content(getOrderRequest()))
                .andExpect(status().isConflict());
    }

}
