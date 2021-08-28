package com.example.stripebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StripeBackendApplication

fun main(args: Array<String>) {
    runApplication<StripeBackendApplication>(*args)
}
