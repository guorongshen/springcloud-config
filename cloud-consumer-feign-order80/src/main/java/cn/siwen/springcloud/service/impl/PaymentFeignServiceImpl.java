package cn.siwen.springcloud.service.impl;

import cn.siwen.springcloud.config.CommonResult;
import cn.siwen.springcloud.entity.Payment;
import cn.siwen.springcloud.service.PaymentFeignService;

public class PaymentFeignServiceImpl implements PaymentFeignService {
    @Override
    public CommonResult getPaymentById(Long id){
        return new CommonResult(404,"404兜底方法",new Payment(id,"not found"));
    }
}
