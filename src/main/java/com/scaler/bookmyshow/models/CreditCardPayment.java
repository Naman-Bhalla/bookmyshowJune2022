package com.scaler.bookmyshow.models;

public class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment() {
        super(PaymentMethod.CREDIT_CARD);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
