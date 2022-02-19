package com.izmaylov.module3.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@ToString
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "sender_id")
    private Subscriber sender;

    @OneToOne
    @JoinColumn(name = "receiver_id")
    private Subscriber receiver;

    @Column(name = "text")
    private String text;

    public Message(Subscriber sender, Subscriber receiver, String text) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
    }
}
