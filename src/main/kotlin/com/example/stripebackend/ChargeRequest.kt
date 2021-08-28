package com.example.stripebackend

data class ChargeRequest(
        val description: String,
        val amount: Int,
        val currency: Currency,
        val stripeEmail: String,
        val stripeToken: String)
{
    enum class Currency {
        EUR, USD;
    }

}
