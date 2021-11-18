package cn.siwen.springcloud.controller;




import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class paymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String PaymentConsul(){
       return "springcloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }


}
