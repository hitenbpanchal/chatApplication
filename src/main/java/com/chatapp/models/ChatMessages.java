package com.chatapp.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessages {

    private String content;
    private String sender;
    private MessageType type;
}
