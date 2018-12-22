package br.com.bots.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Message")
public class Message {
    @Getter @Setter
    private String id;

    @Getter @Setter
    private String conversationId;

    @Getter @Setter
    private Date timestamp;

    @Getter @Setter
    private String from;

    @Getter @Setter
    private String to;

    @Getter @Setter
    private String text;

}
