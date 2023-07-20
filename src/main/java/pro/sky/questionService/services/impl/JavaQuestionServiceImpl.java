package pro.sky.questionService.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.questionService.services.interfaces.QuestionService;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final Set<Question> questions;

    public JavaQuestionServiceImpl(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        questions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {

        Object[] array = questions.toArray();
        Random random = new Random();
        Object randomElement = array[random.nextInt(array.length)];

        return (Question) randomElement;

    }
}
