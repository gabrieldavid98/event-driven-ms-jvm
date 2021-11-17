package net.gd.productsservice.command

import java.math.BigDecimal
import java.util.UUID
import org.axonframework.modelling.command.TargetAggregateIdentifier

data class CreateProductCommand(
    @TargetAggregateIdentifier
    val id: UUID,
    val title: String,
    val price: BigDecimal,
    val quantity: Int
)