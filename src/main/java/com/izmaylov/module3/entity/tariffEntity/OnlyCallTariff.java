package com.izmaylov.module3.entity.tariffEntity;

import com.izmaylov.module3.interfaces.AbleToCall;
import com.izmaylov.module3.model.Tariff;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Entity
public class OnlyCallTariff extends Tariff implements AbleToCall {

    public OnlyCallTariff(int price) {
        super(price);
    }

    @Override
    public void makeACall(int callerId, int receiverId) {
        System.out.println("Subscriber " + callerId  +  "calling to " + "subscriber" + receiverId);
    }
}
