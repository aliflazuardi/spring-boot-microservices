package com.aliflazuardi.orderservice.service;

import com.aliflazuardi.orderservice.dto.OrderLineItemsDto;
import com.aliflazuardi.orderservice.dto.OrderRequest;
import com.aliflazuardi.orderservice.model.Order;
import com.aliflazuardi.orderservice.model.OrderLineItems;
import com.aliflazuardi.orderservice.repository.OrderRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
            .stream()
            .map(this::mapToDto)
            .toList();

        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
