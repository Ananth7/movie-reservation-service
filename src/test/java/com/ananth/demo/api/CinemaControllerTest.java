package com.ananth.demo.api;

import com.ananth.demo.request.CreateCinemaRequest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;


@SpringBootTest
@AutoConfigureMockMvc
public class CinemaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCinemaTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/cinema")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Sathyam")));
    }

    @Test
    public void shouldFailWhenNonAdminUserTriesToAddCinema() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        CreateCinemaRequest testCinema = new CreateCinemaRequest("adefb5b6-b078-4001-9bf0-d81e741b3391", "444e8cc0-29ab-49d0-9aba-c2066a801ad1",
                "TestCinema", "fb2dcb56-a766-4086-a5e0-0e447e7a53a3", 30);
        this.mockMvc.perform(post("/api/v1/cinema/create_cinema")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(testCinema))
        ).andExpect(status().is4xxClientError());
    }

}