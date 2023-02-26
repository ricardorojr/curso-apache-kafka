package com.ricardo.paymentservice.service;

import com.ricardo.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
