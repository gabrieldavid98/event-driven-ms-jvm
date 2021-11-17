package net.gd.productsservice.command

import java.math.BigDecimal
import java.util.UUID
import net.gd.productsservice.core.events.ProductCreatedEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class ProductAggregate {
    @AggregateIdentifier
    lateinit var id: UUID
    lateinit var title: String
    lateinit var price: BigDecimal
    var quantity: Int = 0

    constructor()

    @CommandHandler
    constructor(createProductCommand: CreateProductCommand) {
        require(createProductCommand.price.signum() > 0) { "Price cannot be less or equal than zero" }
        require(createProductCommand.title.isNotBlank()) { "Title cannot be empty" }

        val productCreatedEvent = createProductCommand.let {
            ProductCreatedEvent(
                id = it.id,
                title = it.title,
                price = it.price,
                quantity = it.quantity
            )
        }

        AggregateLifecycle.apply(productCreatedEvent)
    }

    @EventSourcingHandler
    fun on(productCreatedEvent: ProductCreatedEvent) {
        id = productCreatedEvent.id
        title = productCreatedEvent.title
        price = productCreatedEvent.price
        quantity = productCreatedEvent.quantity
    }
}