package cn.siwen.springcloud.controller;


import cn.siwen.springcloud.config.CommonResult;
import cn.siwen.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
public class OrderController {
    @Autowired
    PaymentFeignService paymentFeignService;


    @GetMapping("/payment/ok/{id}")
    public String getPaymentById(@PathVariable("id") Integer id){
      return   paymentFeignService.payment_OK(id);
    };

    @GetMapping("/payment/timeout/{id}")
    public String payment_TimeOut(@PathVariable("id") Integer id){
        return   paymentFeignService.payment_TimeOut(id);
    };

    @GetMapping("/payment/break/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return   paymentFeignService.paymentCircuitBreaker(id);
    };




}
