package cn.siwen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OneEurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(OneEurekaMain7001.class,args);
    }
}
