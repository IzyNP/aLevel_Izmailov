package com.izmaylov.hw11.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractPhone {
    private  PhoneTypes phoneType;
    private  Manufacturer manufacturer;


    public AbstractPhone(PhoneTypes phoneType, Manufacturer manufacturer) {
        this.phoneType = phoneType;
        this.manufacturer = manufacturer;
    }

    public abstract void createDefect();

    public abstract void addContact(Contact contact);

    public abstract void listOfContacts();

    public abstract void call(Contact contact);
}
