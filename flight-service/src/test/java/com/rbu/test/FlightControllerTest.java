package com.rbu.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllFlights() throws Exception {

        mockMvc.perform(get("/flight/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSaveFlight() throws Exception {

        String json = """
                {
                    "code":101,
                    "carrier":"Indigo",
                    "source":"Nagpur",
                    "destination":"Pune",
                    "cost":4500
                }
                """;

        mockMvc.perform(post("/flight/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    public void testDeleteFlight() throws Exception {

        mockMvc.perform(delete("/flight/delete/101"))
                .andExpect(status().isOk());
    }
}