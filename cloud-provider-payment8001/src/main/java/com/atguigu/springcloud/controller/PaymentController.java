package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PaymentController
 * @Author cy
 * @Date 2021/3/27 14:52
 * @Description TODO
 * @Version 1.0
 **/
@RestController
@Slf4j
@CrossOrigin
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private int port;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info(port + " port:插入结果：" + result);
        if (result > 0){
            return new CommonResult(20000, "插入成功！", result);
        }
        return new CommonResult(444, "插入失败！", null);
    }
    @PostMapping(value = "/payment/update")
    public CommonResult update(@RequestBody Payment payment){
        int result = paymentService.update(payment);
        log.info(port + " port:更新结果：" + result);
        if (result > 0){
            return new CommonResult(20000, "更新成功！", result);
        }
        return new CommonResult(444, "更新失败！", null);
    }
    @GetMapping(value = "/payment/del/{id}")
    public CommonResult del(@PathVariable("id") Long id){
        int result = paymentService.delById(id);
        log.info(port + " port:删除结果：" + result);
        if (result > 0){
            return new CommonResult(20000, "删除成功！", result);
        }
        return new CommonResult(444, "删除失败！", null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment == null) {
            log.error(port + " port:查询失败：" + id +" :" + payment.toString());
            return new CommonResult(400, "查询失败！", payment);
        }
        log.info(port + " port:查询成功：" + id + ":" + payment.toString());
        return new CommonResult<Payment>(20000, "查询成功！端口"+ port, payment);
    }

    @PostMapping("/payment/getList")
    public CommonResult getPaymentList(@RequestBody(required = false) Payment payment){
        return new CommonResult<List<Payment>>(20000, "查询成功！端口"+ port, paymentService.getPaymentList(payment));
    }



}
