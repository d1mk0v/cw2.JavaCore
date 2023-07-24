package pro.sky.questionService.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.questionService.services.impl.JavaQuestionServiceImpl;
import pro.sky.questionService.services.impl.MathQuestionServiceImpl;
import pro.sky.questionService.services.impl.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final MathQuestionServiceImpl mathQuestionService;

    public MathQuestionController(@Qualifier("mathQuestionServiceImpl")MathQuestionServiceImpl mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping(path = "get")
    public Collection<Question> getAll() {
        return mathQuestionService.getAll();
    }

    @GetMapping(path = "/add")
    public Question add(@RequestParam(name = "question") String question,
                        @RequestParam(name = "answer") String answer) {
        return mathQuestionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(@RequestParam(name = "question") Question question) {
        return mathQuestionService.remove(question);

    }

}
