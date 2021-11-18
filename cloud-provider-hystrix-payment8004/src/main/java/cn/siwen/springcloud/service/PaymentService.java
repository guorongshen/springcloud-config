package cn.siwen.springcloud.service;



public interface PaymentService {
    String paymentInfo_OK(Integer id);
    String payment_TimeOut(Integer id);
    String paymentCircuitBreaker(Integer id);
}
