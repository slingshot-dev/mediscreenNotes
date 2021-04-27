package com.example.MediscreenNotes.Controllers;

import com.example.MediscreenNotes.modeles.Notes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@AutoConfigureMockMvc(addFilters = false)
@AutoConfigureMockMvc
//@EnableAutoConfiguration(exclude = {SecurityFilterAutoConfiguration.class, SecurityAutoConfiguration.class})
public class ControllersTests {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    Notes notes1 = new Notes( "8076b1c3ea6f313677ed917e",  "1", "BlaBla1");
    Notes notes1u = new Notes( "607c548c7c65654ca2a8f44d",  "1", "BlaBla1u");

    @Test
    public void getNotesList() throws Exception {
        // Arange & Act
        this.mockMvc.perform(get("/api/notes"))
                // Assert
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getNotes() throws Exception {
        // Arange & Act
        this.mockMvc.perform(get("/api/notes/list").param("id", "6076b1c3ea6f313677ed917e"))
                // Assert
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void AddNote() throws Exception {
        // Arange & Act
        this.mockMvc.perform(post("/api/notes/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(notes1)))
                // Assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void UpdateNote() throws Exception {
        // Arange & Act
        this.mockMvc.perform(post("/api/notes/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(notes1u)))
                // Assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void DeleteNote() throws Exception {
        // Arange & Act
        this.mockMvc.perform(delete("/api/notes/delete?id=807c548c7c65654ca2a8f44d"))
                // Assert
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
