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
//    private Random random;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
//        random = new Random();
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        Set<Question> listOfRandomQuestions = new HashSet<>();

        while (listOfRandomQuestions.size() < amount) {
            Question randomQuestion = questionService.getRandomQuestion();
            listOfRandomQuestions.add(randomQuestion);

            if (randomQuestion == null) {
                break;
            }
        }

        if (listOfRandomQuestions.size() < amount) {
            throw new NotEnoughQuestionsException("Недостаточно вопросов!!!");
        }

        return listOfRandomQuestions;
    }
}
