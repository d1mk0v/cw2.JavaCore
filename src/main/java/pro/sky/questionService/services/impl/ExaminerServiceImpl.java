package pro.sky.questionService.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.questionService.exceptions.NotEnoughQuestionsException;
import pro.sky.questionService.services.interfaces.ExaminerService;
import pro.sky.questionService.services.interfaces.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Set<Question> getQuestions(int amount) {

        Set<Question> questions = new HashSet<>();

        if (questionService.getAll().size() < amount){
            throw new NotEnoughQuestionsException("Недостаточно вопросов!!!");
        }

        while (questions.size() != amount) {
            questions.add(questionService.getRandomQuestion());
        }

        return questions;
    }
}
