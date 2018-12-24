package br.com.bots;

import br.com.bots.controller.BotController;
import br.com.bots.dto.BotDTO;
import br.com.bots.model.Bot;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.security.Principal;
import java.util.ArrayList;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BotController.class)
public class BotTest {

    @Mock
    private Principal principal;

    @MockBean
    private BotController botController;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {

    }

    @Autowired
    private MockMvc mvc;

    @Test
    public void whenFindBots_thenReturnOk() throws Exception {
        given(botController.findAll()).willReturn(ResponseEntity.ok(new ArrayList<>()));

        ResultActions resultActions = this.mvc.perform(get("/bots")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print());

        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(0)));
    }


}
