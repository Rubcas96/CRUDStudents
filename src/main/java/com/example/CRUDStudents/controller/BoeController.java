package com.example.CRUDStudents.controller;

import com.example.CRUDStudents.chatGpt.ChatGptRequest;
import com.example.CRUDStudents.chatGpt.ChatGptResponse;
import com.example.CRUDStudents.service.BoeService;
import jakarta.servlet.http.HttpServletRequest;
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

    @PostMapping("/boe/solicitar")
    public ResponseEntity<String> solicitarBoe(HttpServletRequest request, @RequestParam Long boeId) {
        try {
            boeService.solicitarBoe(request, boeId);
            return ResponseEntity.ok("El resumen del BOE ha sido enviado al correo electrónico del usuario.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al solicitar el resumen del BOE: " + e.getMessage());
        }
    }

    @PostMapping("/boe/all")
    public ResponseEntity<String> sendUnsubscribedBoeSummary(HttpServletRequest request) {
        try {
            Long userId = boeService.getUserIdFromHeader(request);;
            if (userId != null) {
                boeService.sendUnsubscribedBoeSummaryToUser(userId);
                return ResponseEntity.ok("Se han enviado los resúmenes de boletines no suscritos al usuario.");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Usuario no autenticado.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al enviar los resúmenes de boletines no suscritos: " + e.getMessage());
        }
    }

    @DeleteMapping("/boe/delete/all")
    public void  DeleteALLBoes(){
        boeService.deleteAllBoes();
    }

}