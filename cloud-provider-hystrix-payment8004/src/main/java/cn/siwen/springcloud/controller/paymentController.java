package cn.siwen.springcloud.controller;


import cn.siwen.springcloud.config.CommonResult;
import cn.siwen.springcloud.entity.Payment;
import cn.siwen.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class paymentController {
    @Autowired
    private PaymentService paymentService;
    @GetMapping("/payment/ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id){
        String info_ok = paymentService.paymentInfo_OK(id);
        if (info_ok==null){
            return "出现了意外情况";
        }else{
            return info_ok;
        }
    }

    @GetMapping("/payment/timeout/{id}")
    public String payment_TimeOut(@PathVariable("id") Integer id){
        String info_ok = paymentService.payment_TimeOut(id);
        if (info_ok==null){
            return "出现了意外情况";
        }else{
            return info_ok;
        }
    }

    @GetMapping("/payment/break/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String info_ok = paymentService.paymentCircuitBreaker(id);
        if (info_ok==null){
            return "出现了意外情况";
        }else{
            return info_ok;
        }
    }
}
