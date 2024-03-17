package org.example.provider

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("order")
class OrderController(val orderRepository: OrderRepository) {
    @GetMapping
    fun getOrder(): Order {
        return orderRepository.getOrder(1)
    }
}