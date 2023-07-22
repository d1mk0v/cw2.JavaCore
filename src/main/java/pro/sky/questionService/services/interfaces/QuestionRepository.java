package pro.sky.questionService.services.interfaces;

import pro.sky.questionService.services.impl.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
