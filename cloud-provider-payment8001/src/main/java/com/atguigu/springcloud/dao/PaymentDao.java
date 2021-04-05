package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName PaymentDao
 * @Author cy
 * @Date 2021/3/27 14:30
 * @Description TODO
 * @Version 1.0
 **/
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public int update(Payment payment);

    public int delById(@Param("id") Long id);

    public Payment getPaymentById(@Param("id") Long id);

    public List<Payment> getPaymentList(Payment payment);
}
