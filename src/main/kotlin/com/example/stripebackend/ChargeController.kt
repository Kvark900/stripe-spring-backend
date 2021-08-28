package com.example.stripebackend

import com.example.stripebackend.service.StripeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ChargeController(val stripeService: StripeService) {

    @PostMapping
    fun charge(@RequestBody chargeRequest: ChargeRequest): ResponseEntity<Any> {
        stripeService.charge(chargeRequest)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/create-checkout-session")
    fun charge(): ResponseEntity<Any> {
        val url = stripeService.createCheckOutSession()
        return ResponseEntity.ok().body(url)
    }
}