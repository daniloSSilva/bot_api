package br.com.bots.dto;

import lombok.Getter;
import lombok.Setter;

public class MessageDTO {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String conversationId;

    @Getter
    @Setter
    private String timestamp;

    @Getter
    @Setter
    private String from;

    @Getter
    @Setter
    private String to;

    @Getter
    @Setter
    private String text;
}
