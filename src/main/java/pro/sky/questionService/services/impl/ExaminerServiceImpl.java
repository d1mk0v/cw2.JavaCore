package pro.sky.questionService.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.questionService.services.interfaces.ExaminerService;
import pro.sky.questionService.services.interfaces.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

//    private final Random random;
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    @Autowired
    public ExaminerServiceImpl(@Qualifier("javaQuestionServiceImpl") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionServiceImpl") QuestionService mathQuestionService) {
//        this.random = random;

        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        List<Question> allQuestions = new ArrayList<>();
        int randomIndex;

        allQuestions.addAll(javaQuestionService.getAll());
        allQuestions.addAll(mathQuestionService.getAll());

        if (allQuestions.isEmpty()) {
            return null;
        }

        Collection<Question> randomQuestions = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            if (allQuestions.isEmpty()) {
                break;
            }

            randomIndex = random.nextInt(allQuestions.size());
            Question randomQuestion = allQuestions.get(randomIndex);
            randomQuestions.add(randomQuestion);
            allQuestions.remove(randomQuestion);
        }

        return randomQuestions;
    }
}
