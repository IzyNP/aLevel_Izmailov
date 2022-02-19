package com.izmaylov.module3.entity;

import com.izmaylov.module3.interfaces.AbleToCall;
import com.izmaylov.module3.interfaces.AbleToSendMessage;
import com.izmaylov.module3.interfaces.AbleToSurfInternet;
import com.izmaylov.module3.model.Device;
import com.izmaylov.module3.model.Tariff;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@ToString
@Entity
@NoArgsConstructor
@Table(name = "subscribers")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriber_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device deviceId;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "count_of_messages")
    private int countOfMessage;

    @Column(name = "count_of_calls")
    private int countOfCalls;

    @Column(name = "count_of_internet_surfing")
    private int countOfInternetSurfing;


    public Subscriber(Tariff tariff, Device device, String name, String lastName, Date dateOfBirth, String phoneNumber) {
        this.tariff = tariff;
        this.deviceId = device;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public void makeACall(int receiverId){
        if(tariff instanceof AbleToCall){
            ((AbleToCall) tariff).makeACall(this.id, receiverId);
        }else{
            System.out.println("Enable to make a call");
        }
    }

    public void sendMessage(Subscriber receiverId,String text){
        if(tariff instanceof AbleToSendMessage){
            ((AbleToSendMessage) tariff).sendMessage(this, receiverId, text);
        }else{
            System.out.println("Enable to send a message");
        }
    }

    public void surfingInternet(){
        if(tariff instanceof AbleToSurfInternet){
            ((AbleToSurfInternet) tariff).surfingInternet(this.id);
        }
    }
}
