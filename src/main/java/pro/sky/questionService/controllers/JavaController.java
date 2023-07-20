package pro.sky.questionService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.questionService.services.impl.Question;
import pro.sky.questionService.services.impl.JavaQuestionServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {
    private final JavaQuestionServiceImpl javaQuestionService;

    public JavaController(JavaQuestionServiceImpl javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "get")
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

    @GetMapping(path = "/add")
    public Question add(@RequestParam(name = "question") String question,
                        @RequestParam(name = "answer") String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(@RequestParam(name = "question") Question question) {
        return javaQuestionService.remove(question);

    }

}
