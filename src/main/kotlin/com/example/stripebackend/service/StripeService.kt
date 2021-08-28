package com.example.stripebackend.service

import com.example.stripebackend.ChargeRequest
import com.stripe.Stripe
import com.stripe.model.Charge
import com.stripe.model.checkout.Session
import com.stripe.param.checkout.SessionCreateParams
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct


@Service
class StripeService {

    @Value("\${STRIPE_SECRET_KEY}")
    lateinit var secretKey: String


    @PostConstruct
    fun init() {
        Stripe.apiKey = secretKey
    }

    fun charge(chargeRequest: ChargeRequest): Charge {
        val map = mapOf<String, Any>(
                "amount" to chargeRequest.amount,
                "currency" to chargeRequest.currency,
                "description" to chargeRequest.description,
                "source" to chargeRequest.stripeToken)
        return Charge.create(map)
    }

    fun createCheckOutSession(): String? {
        val DOMAIN = "http://localhost:3000/checkout";
        val params =
        SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.EPS)
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.SOFORT)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(DOMAIN + "?success=true")
                .setCancelUrl(DOMAIN + "?canceled=true")
                .addLineItem(
                        SessionCreateParams.LineItem.builder()
                            .setPriceData(
                                SessionCreateParams.LineItem.PriceData.builder()
                                .setCurrency("EUR")
                                .setUnitAmount(5000_00)
                                .setProductData(
                                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                    .setName("Laptop X")
                                    .setDescription("Laptop X for sale")
                                    .build()
                                )
                                .build()
                            )
                                .setQuantity(1L)
                                // TODO: replace this with the `price` of the product you want to sell
                                .build())
                .build();
        val session = Session.create(params)
        return session.url
    }
}