package com.dtec.ms.user.producer;

import com.dtec.ms.user.domain.user.User;
import com.dtec.ms.user.dtos.EmailDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail (User user) {
        var emailDto = new EmailDto();
        emailDto.setUserId(user.getId());
        emailDto.setEmailTo(user.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(user.getName() + ", seja vem vindo!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}
