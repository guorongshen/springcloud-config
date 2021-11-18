package cn.siwen.springcloud.service.impl;

import cn.siwen.springcloud.service.PaymentFeignService;

public class PaymentFeignServiceImpl implements PaymentFeignService {
    @Override
    public String payment_OK(Integer id){
        return "404";
    }
    @Override
    public String payment_TimeOut(Integer id){
        return "404";
    }
    @Override
    public String paymentCircuitBreaker(Integer id){
        return "404";
    }
}
