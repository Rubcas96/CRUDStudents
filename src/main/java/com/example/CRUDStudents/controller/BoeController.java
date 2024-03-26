package com.example.CRUDStudents.controller;

import com.example.CRUDStudents.chatGpt.ChatGptRequest;
import com.example.CRUDStudents.chatGpt.ChatGptResponse;
import com.example.CRUDStudents.service.BoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class BoeController {

    @Autowired
    private BoeService boeService;
    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt) {

        ChatGptRequest request = new ChatGptRequest(model, prompt);
        ChatGptResponse chatGptResponse = template.postForObject(apiUrl, request, ChatGptResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }


    @DeleteMapping("/boe/delete/all")
    public void  DeleteALLBoes(){
        boeService.deleteAllBoes();
    }

}