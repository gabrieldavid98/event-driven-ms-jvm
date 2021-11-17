package net.gd.productsservice.rest

import java.util.UUID
import net.gd.productsservice.command.CreateProductCommand
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductsController(val commandGateway: CommandGateway) {

    @PostMapping
    fun create(@RequestBody createProductRestModel: CreateProductRestModel): UUID =
        commandGateway.sendAndWait(
            CreateProductCommand(
                id = UUID.randomUUID(),
                title = createProductRestModel.title,
                price = createProductRestModel.price,
                quantity = createProductRestModel.quantity
            )
        )
}