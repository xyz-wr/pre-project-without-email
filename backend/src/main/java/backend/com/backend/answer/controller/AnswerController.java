package backend.com.backend.answer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    @PostMapping
    public ResponseEntity postAnswer() {
        return null;
    }

    @GetMapping("/")
    public ResponseEntity getAnswers() {
        return null;
    }
}
