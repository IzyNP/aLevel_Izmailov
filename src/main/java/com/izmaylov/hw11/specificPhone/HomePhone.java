package com.izmaylov.hw11.specificPhone;

import com.izmaylov.hw11.model.*;
import com.izmaylov.hw11.util.DynamicArray;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public class HomePhone extends AbstractPhone {
    private Cord cord = new Cord();
    private Battery battery = new Battery();
    private Contact[] contacts = new Contact[10];
    private StringBuilder stringBuilder = new StringBuilder();
    private String notebook;
    private boolean defect;

    public HomePhone(PhoneTypes phoneType, Manufacturer manufacturer) {
        super(phoneType, manufacturer);
    }

    @Override
    public void addContact(Contact contact) {
        if (cord.isBroken() || battery.isBroken()) {
            System.out.println("Телефон сломан.");
        } else {
            if (this.getPhoneType() == PhoneTypes.WIRELESS_PHONE) {
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
            } else {
                notebook = String.valueOf(stringBuilder.append(contact).append("\n"));
                System.out.println("Контакт записан в блокнот");
            }
        }
    }

    @Override
    public void listOfContacts() {
        if (this.getPhoneType() == PhoneTypes.WIRELESS_PHONE) {
            for (Contact contact : contacts) {
                if (contact != null)
                    System.out.println(contact);
            }
        } else {
            System.out.println(notebook);
        }
    }

    @Override
    public void call(Contact contact) {
        if (cord.isBroken() || battery.isBroken()) {
            System.out.println("Телефон сломан.");
        } else {
            if (this.getPhoneType() == PhoneTypes.WIRELESS_PHONE) {
                for (Contact contact1 : contacts) {
                    if (contact.getName().equals(contact1.getName())) {
                        System.out.println("Вызываю абонента " + contact.getName());
                    }
                }
            } else {
                System.out.println("*Вводит номер и нажимает кнопку вызова*");
            }
        }
    }

    @Override
    public void createDefect() {
        if (getPhoneType() == PhoneTypes.WIRED_PHONE) {
            cord.setBroken(true);
            defect = true;
        } else {
            battery.setBroken(true);
            defect = true;
        }
    }

    public void ring(){
        System.out.println("Трынь-трынь");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomePhone phone = (HomePhone) o;
        if(phone.getPhoneType() == PhoneTypes.WIRED_PHONE){
            return defect == phone.defect && Objects.equals(notebook, phone.notebook);
        }else{
            return defect == phone.defect && Arrays.equals(contacts, phone.contacts);
        }
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(notebook, defect);
        result = 31 * result + Arrays.hashCode(contacts);
        return result;
    }
}
