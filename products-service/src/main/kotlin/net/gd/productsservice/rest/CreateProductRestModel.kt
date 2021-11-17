package net.gd.productsservice.rest

import java.math.BigDecimal

data class CreateProductRestModel(
    val title: String,
    val price: BigDecimal,
    val quantity: Int
)
