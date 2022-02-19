package com.izmaylov.module3.entity.tariffEntity;

import com.izmaylov.module3.entity.Message;
import com.izmaylov.module3.entity.Subscriber;
import com.izmaylov.module3.interfaces.AbleToCall;
import com.izmaylov.module3.interfaces.AbleToSendMessage;
import com.izmaylov.module3.model.Tariff;

import javax.persistence.Entity;

@Entity
public class CommunicationTariff extends Tariff implements AbleToCall, AbleToSendMessage {
    @Override
    public void makeACall(int callerId, int receiverId) {
        System.out.println("Subscriber " + callerId  +  "calling to " + "subscriber" + receiverId);
    }

    @Override
    public Message sendMessage(Subscriber senderId, Subscriber receiverId, String text) {
      return  new Message(senderId, receiverId, text);
    }
}
