package cn.siwen.springcloud.service.impl;



import cn.hutool.core.util.IdUtil;
import cn.siwen.springcloud.service.PaymentService;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
@DefaultProperties(defaultFallback = "payment_global")
public class PaymentServiceImpl implements PaymentService {
    public String paymentInfo_OK(Integer id){
        return "线程池: "+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id+"哈哈呵呵";
    }
    @HystrixCommand(fallbackMethod = "payment_TimeOutHandle",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String payment_TimeOut(Integer id){
        int timeNumber=id;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id+"哇呜呜,耗时(s): "+timeNumber;
    }
    public String payment_TimeOutHandle(Integer id){
        return "线程池: "+Thread.currentThread().getName()+"系统繁忙,id: "+id+"哇呜呜";
    }

    public String payment_global(Integer id){
        return "我是全局服务降级方法";
    }
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id<0){
            throw new RuntimeException("****id不能负数");
        }
        String serialNumber= IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号: "+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能负数,请稍后再试,(T_T)/~~  id:"+id;
    }
}
