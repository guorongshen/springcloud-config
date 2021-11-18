package cn.siwen.springcloud.service;

import cn.siwen.springcloud.config.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id);
    @GetMapping(value = "/payment/timeout/{id}")
    public String payment_TimeOut(@PathVariable("id") Integer id);
    @GetMapping(value = "/payment/break/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
