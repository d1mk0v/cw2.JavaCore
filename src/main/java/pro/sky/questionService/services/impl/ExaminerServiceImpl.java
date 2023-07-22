package pro.sky.questionService.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    private final Random random;
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    @Autowired
    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        Set<Question> listOfRandomQuestions = new HashSet<>();

        if (listOfRandomQuestions.size() < amount) {
            throw new NotEnoughQuestionsException("Недостаточно вопросов!!!");
        }

        while (listOfRandomQuestions.size() < amount) {
            Question randomQuestion = questionService.getRandomQuestion();
            listOfRandomQuestions.add(randomQuestion);

            if (randomQuestion == null) {
                break;
            }
        }


        return listOfRandomQuestions;
    }
}
