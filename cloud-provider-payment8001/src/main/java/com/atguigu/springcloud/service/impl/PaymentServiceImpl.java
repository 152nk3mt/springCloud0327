package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PaymentServiceImpl
 * @Author cy
 * @Date 2021/3/27 14:49
 * @Description TODO
 * @Version 1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public int update(Payment payment) {
        return paymentDao.update(payment);
    }

    @Override
    public int delById(Long id) {
        return paymentDao.delById(id);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public List<Payment> getPaymentList(Payment payment) {
        return paymentDao.getPaymentList(payment);
    }
}
