package br.com.bots.controller;

import br.com.bots.dto.BotDTO;
import br.com.bots.exceptions.ParametroObrigatorioException;
import br.com.bots.repository.BotRepository;
import br.com.bots.service.BotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;


@RestController
@RequestMapping("/bots")
public class BotController implements Serializable {

    private static final long serialVersionUID = 6221889081690795087L;

    private static final Logger LOGGER = LoggerFactory.getLogger(BotController.class);

    private BotRepository botRepository;

    public BotController(BotRepository hotelRepository) {
        this.botRepository = hotelRepository;
    }

    @Autowired
    private BotService botService;


    @GetMapping
    public ResponseEntity findAll() throws ParametroObrigatorioException {
        LOGGER.info("Finding all bots...");
        return botService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") String id) throws ParametroObrigatorioException {
        LOGGER.info("Finding all bots...");
        return botService.findById(id);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody BotDTO botDTO) throws ParametroObrigatorioException {
        LOGGER.info("Inserting new bot...");
        return botService.save(botDTO);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody BotDTO botDTO) throws ParametroObrigatorioException {
        LOGGER.info("Updating bot...");
        return botService.update(botDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) throws ParametroObrigatorioException {
        LOGGER.info("Deleting bot...");
        return botService.delete(id);
    }
}
