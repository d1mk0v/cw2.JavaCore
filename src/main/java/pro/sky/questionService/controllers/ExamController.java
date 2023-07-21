package pro.sky.questionService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.questionService.services.impl.ExaminerServiceImpl;
import pro.sky.questionService.services.impl.JavaQuestionServiceImpl;
import pro.sky.questionService.services.impl.Question;
import pro.sky.questionService.services.interfaces.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

@GetMapping
public Collection<Question>(@PathVariable Integer amount)
    public Collection<Question> getQuestions(int amount){
        return examinerService.getQuestions(amount);
    }

}
