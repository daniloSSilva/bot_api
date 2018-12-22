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
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    private MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity findAll() {
        LOGGER.info("Finding all bots...");
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") String id) {
        LOGGER.info("Finding all bots...");
        return messageService.findById(id);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody MessageDTO messageDTO) {
        LOGGER.info("Inserting new bot...");
        return messageService.save(messageDTO);
    }
}
