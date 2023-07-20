package pro.sky.questionService.services.interfaces;

import pro.sky.questionService.services.impl.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
