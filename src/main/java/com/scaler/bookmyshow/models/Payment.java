package com.scaler.bookmyshow.models;

import java.util.Date;

public abstract class Payment {
    private PaymentMethod paymentMethod;
    private Date timeOfPayment;
    private double amount;

    public Payment(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
