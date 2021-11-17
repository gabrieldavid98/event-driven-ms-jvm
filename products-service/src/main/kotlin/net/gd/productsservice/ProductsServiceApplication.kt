package net.gd.productsservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class ProductsServiceApplication

fun main(args: Array<String>) {
	runApplication<ProductsServiceApplication>(*args)
}
