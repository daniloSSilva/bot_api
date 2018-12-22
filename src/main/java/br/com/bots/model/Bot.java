package br.com.bots.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bot")
public class Bot {

    @Getter @Setter
    private String id;

    @Getter @Setter
    private String name;


}