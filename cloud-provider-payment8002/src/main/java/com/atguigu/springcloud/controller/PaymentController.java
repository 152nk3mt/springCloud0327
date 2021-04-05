package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private int port;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info(port + " port:插入结果：" + result);
        if (result > 0){
            return new CommonResult(200, "插入成功！", result);
        }
        return new CommonResult(444, "插入失败！", null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment == null) {
            log.error(port + " port:查询失败：" + id +" :" + payment.toString());
            return new CommonResult(400, "查询失败！", payment);
        }
        log.info(port + " port:查询成功：" + id + ":" + payment.toString());
        return new CommonResult<Payment>(200, "查询成功！端口"+ port, payment);

    }

    @GetMapping("/payment/getDiscovery")
    public Object getDiscovery(){
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            log.info("service:" +service + "开始~~~~~~~~~~~~~~~");
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for(ServiceInstance instance : instances){
                log.info(instance.isSecure() + "\t" + instance.getUri());
            }
            log.info(service + "结束~~~~~~~~~~~~~~~");
        }
        return services;
    }
}
