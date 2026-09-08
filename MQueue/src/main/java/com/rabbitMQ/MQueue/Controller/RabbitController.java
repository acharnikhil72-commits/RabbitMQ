package com.rabbitMQ.MQueue.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rabbitMQ.MQueue.Services.RabbitProviderService;

@RestController 
@RequestMapping("/api/v1/rabbit")
public class RabbitController {


    public RabbitProviderService rabbitProviderService;

    public RabbitController(RabbitProviderService rabbitProviderService) {
        this.rabbitProviderService = rabbitProviderService;
    }


    //@RequestMapping(http://localhost:8080/api/v1/rabbit/send?message= Hello RabbitMQ)
    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitProviderService.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully!");
    }

}
