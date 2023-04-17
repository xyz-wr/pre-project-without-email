package backend.com.backend.answer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AnswerController {
    @PostMapping
    public ResponseEntity postAnswer() {
        return null;
    }
}
