package com.izmaylov.module3.interfaces;

import com.izmaylov.module3.entity.Message;
import com.izmaylov.module3.entity.Subscriber;

public interface AbleToSendMessage {
     Message sendMessage(Subscriber senderId, Subscriber receiverId, String text);
}
