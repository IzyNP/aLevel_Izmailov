package com.izmaylov.hw11.specificPhone;

import com.izmaylov.hw11.model.*;
import com.izmaylov.hw11.util.DynamicArray;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public class MobilePhone extends AbstractPhone {
    private Battery battery = new Battery();
    private Contact[] contacts;
    private boolean defect;
    private boolean SoundOn = true;

    public MobilePhone(PhoneTypes phoneType, Manufacturer manufacturer) {
        super(phoneType, manufacturer);
        contacts = new Contact[10];
    }

    public boolean isDefect() {
        return defect;
    }

    public void setSoundOn(boolean soundOn) {
        SoundOn = soundOn;
    }

    @Override
    public void addContact(Contact contact) {
        if (battery.isBroken()) {
            System.out.println("Телефон сломан.");
        } else {
            if (this.contacts[this.contacts.length - 1] != null) {
                contacts = DynamicArray.makeArrayBigger(contacts);
            } else {
                for (int i = 0; i < this.contacts.length; i++) {
                    if (this.contacts[i] == null) {
                        this.contacts[i] = contact;
                        System.out.println("Контакт добавлен.");
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void listOfContacts() {
        for (Contact contact : contacts) {
            if (contact != null)
                System.out.println(contact);
        }
    }

    @Override
    public void call(Contact contact) {
        if (battery.isBroken()) {
            System.out.println("Телефон сломан.");
        } else {
            for (Contact contact1 : contacts) {
                if (contact.getName().equals(contact1.getName())) {
                    System.out.println("Вызываю абонента " + contact.getName());
                }
            }
        }
    }

    public void ring(){
        if(isSoundOn()){
            System.out.println("Трынь-трынь");
        }else {
            System.out.println("*телефон вибрирует*");
        }
    }

    @Override
    public void createDefect() {
        battery.setBroken(true);
        defect = true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobilePhone that = (MobilePhone) o;
        return defect == that.defect && SoundOn == that.SoundOn && Arrays.equals(contacts, that.contacts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(defect, SoundOn);
        result = 31 * result + Arrays.hashCode(contacts);
        return result;
    }
}
