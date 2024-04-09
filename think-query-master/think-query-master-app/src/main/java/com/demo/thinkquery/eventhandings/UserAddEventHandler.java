package com.demo.thinkquery.eventhandings;

import com.amos.think.event.DomainEventConstant;
import com.amos.think.event.UserRegisterEvent;
import com.demo.thinkquery.domain.user.User;
import com.demo.thinkquery.domain.user.gateway.UserGateway;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserAddEventHandler {

    @Autowired
    private UserGateway userGateway;

    @KafkaListener(topics = DomainEventConstant.USER_REGISTER_TOPIC )
    public void onUserRegister(ConsumerRecord<String,Object> event) {
        UserRegisterEvent userRegisterEvent = (UserRegisterEvent)event.value();
        if(userRegisterEvent!=null){
            User user = getUser(userRegisterEvent);
            if(userGateway.save(user)!=null) {
                System.out.println("UserAddEventHandler.onUserRegister: " + user);
            } else {
                System.out.println("UserAddEventHandler.onUserRegister is failed: ");
            }
        }
        System.out.println("UserAddEventHandler.onUserRegister: " + event);
    }

    private static User getUser(UserRegisterEvent userRegisterEvent) {
        User user = new User();
        user.setId(userRegisterEvent.getId());
        user.setUsername(userRegisterEvent.getUsername());
        user.setName(userRegisterEvent.getName());
        user.setPhoneNo(userRegisterEvent.getPhoneNo());
        user.setGender(userRegisterEvent.getGender());
        user.setBirthday(userRegisterEvent.getBirthday());
        user.setDescription(userRegisterEvent.getDescription());
        return user;
    }
}
