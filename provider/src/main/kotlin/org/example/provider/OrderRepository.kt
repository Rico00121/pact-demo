package org.example.provider

import org.springframework.stereotype.Repository

@Repository
interface OrderRepository {
    fun getOrder(id: Int): Order
}