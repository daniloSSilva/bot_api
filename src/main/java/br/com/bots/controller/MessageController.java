package br.com.bots.controller;

import br.com.bots.dto.MessageDTO;
import br.com.bots.repository.MessageRepository;
import br.com.bots.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("/messages")
public class MessageController implements Serializable {
    private static final long serialVersionUID = -3178211173687673907L;

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    private MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Autowired
    private MessageService messageService;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") String id) {
        LOGGER.info("Finding message id ...".concat(id));
        return messageService.findById(id);
    }

    @GetMapping
    public ResponseEntity findByConversationId( @RequestParam("conversationId") String conversationId ) {
        LOGGER.info("Finding message id ...".concat(conversationId));
        return messageService.findByConversationId(conversationId);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody MessageDTO messageDTO) {
        LOGGER.info("Inserting new message...");
        return messageService.save(messageDTO);
    }

}
