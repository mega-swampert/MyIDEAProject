package com.sawyer.springcloud.controller;


import com.sawyer.springcloud.entities.CommonResult;
import com.sawyer.springcloud.entities.Payment;
import com.sawyer.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("--------插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverport=" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("-------插入结果：" + paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "查询成功,serverport=" + serverPort, paymentById);
        } else {
            return new CommonResult(444, "查询没有对应记录，查询id=" + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return  serverPort;
    }

}
