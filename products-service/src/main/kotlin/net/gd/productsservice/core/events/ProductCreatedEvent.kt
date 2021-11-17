package net.gd.productsservice.core.events

import java.math.BigDecimal
import java.util.UUID

data class ProductCreatedEvent(
    val id: UUID,
    val title: String,
    val price: BigDecimal,
    val quantity: Int
)