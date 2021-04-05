package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entites.Payment;

import java.util.List;

public interface PaymentService {
    public int create(Payment payment);

    public int update(Payment payment);

    public int delById(Long id);

    public Payment getPaymentById(Long id);

    public List<Payment> getPaymentList(Payment payment);
}

