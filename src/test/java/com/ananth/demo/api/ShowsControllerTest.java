package com.ananth.demo.api;

import com.ananth.demo.request.SeatsRequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ShowsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldFailWhenUserTriesToBookReservedSeat() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        SeatsRequestBody seatsRequestBody = new SeatsRequestBody("1s2dnk32-1f32-47ec-880b-8k12h1899oo", Arrays.asList(24, 25));
        this.mockMvc.perform(post("/api/v1/shows/reserve")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(seatsRequestBody))
        ).andExpect(status().is4xxClientError());
    }

}