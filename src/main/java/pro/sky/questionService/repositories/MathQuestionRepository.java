package pro.sky.questionService.repositories;

import org.springframework.stereotype.Repository;
import pro.sky.questionService.services.impl.Question;
import pro.sky.questionService.services.interfaces.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private Set<Question> questions;

    @PostConstruct
    private void init(){
        questions=new HashSet<>(Set.of(
                new Question("A1","a1"),
                new Question("B1","b1"),
                new Question("C1","c1"),
                new Question("D1","d1"),
                new Question("E1","e1"),
                new Question("F1","f1"),
                new Question("G1","g1")
        ));
    }

    public MathQuestionRepository(Set<Question> questions) {
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
}
