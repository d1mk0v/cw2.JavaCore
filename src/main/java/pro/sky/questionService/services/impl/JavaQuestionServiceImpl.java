package pro.sky.questionService.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.questionService.repositories.JavaQuestionRepository;
import pro.sky.questionService.services.interfaces.QuestionRepository;
import pro.sky.questionService.services.interfaces.QuestionService;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final QuestionRepository javaquestionRepository;


    public JavaQuestionServiceImpl(@Qualifier(value = "javaQuestionRepository") QuestionRepository questionRepository) {
        this.javaquestionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        javaquestionRepository.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        javaquestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        javaquestionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return javaquestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {

        Object[] array = javaquestionRepository.getAll().toArray();
        Random random = new Random();
        Object randomElement = array[random.nextInt(array.length)];

        return (Question) randomElement;

    }
}
