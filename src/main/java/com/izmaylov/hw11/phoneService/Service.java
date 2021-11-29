package com.izmaylov.hw11.phoneService;

import com.izmaylov.hw11.model.AbstractPhone;
import com.izmaylov.hw11.model.PhoneTypes;
import com.izmaylov.hw11.specificPhone.HomePhone;
import com.izmaylov.hw11.specificPhone.MobilePhone;

public class Service {

    public static void checkPhone(AbstractPhone abstractPhone){
        if(abstractPhone.getPhoneType() == PhoneTypes.SMARTPHPONE){
            MobilePhone phone = (MobilePhone) abstractPhone;
            if(phone.isDefect()){
                fixPhone(phone);
            }else{
                System.out.println("Телефон в порядке.");
            }
        }else{
            HomePhone phone = (HomePhone) abstractPhone;
            if(phone.isDefect()){
                fixPhone(phone);
            }else {
                System.out.println("Телефон в порядке.");
            }
        }
    }

    private static void fixPhone(AbstractPhone abstractPhone){
        if(abstractPhone.getPhoneType() == PhoneTypes.SMARTPHPONE){
            MobilePhone phone = (MobilePhone) abstractPhone;
            if(phone.getBattery().isBroken()){
                phone.getBattery().setBroken(false);
                System.out.println("Неисправность вызвана поломкой батареи. Исправлено");
            }
        }else{
            HomePhone phone = (HomePhone) abstractPhone;
            if(phone.getBattery().isBroken()){
                phone.getBattery().setBroken(false);
                System.out.println("Неисправность вызвана поломкой батареи. Исправлено");
            }
            if(phone.getCord().isBroken()){
                phone.getCord().setBroken(false);
                System.out.println("Неисправность вызвана поломкой шнура. Исправлено");
            }
        }
        System.out.println("Телефон починен");
    }
}
