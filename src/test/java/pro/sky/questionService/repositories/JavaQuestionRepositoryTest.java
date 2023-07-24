package pro.sky.questionService.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.questionService.services.impl.Question;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {

    private JavaQuestionRepository javaQuestionRepository;

    @BeforeEach
    public void setup() {
        Set<Question> questions = new HashSet<>();
        javaQuestionRepository = new JavaQuestionRepository(questions);
    }

    @Test
    void addTest() {
        Question question = javaQuestionRepository.add("Question", "Answer");

        assertTrue(javaQuestionRepository.getAll().contains(question));
        assertEquals(question.getQuestion(), "Question");
        assertEquals(question.getAnswer(), "Answer");
    }

    @Test
    void addObjectTest() {
        Question question = new Question("Question", "Answer");
        Question addedQuestion = javaQuestionRepository.add(question);

        assertTrue(javaQuestionRepository.getAll().contains(addedQuestion));
        assertEquals(addedQuestion, question);
    }

    @Test
    void remove() {
        Question question = new Question("Question", "Answer");
        javaQuestionRepository.add(question);

        Question removedQuestion = javaQuestionRepository.remove(question);

        assertFalse(javaQuestionRepository.getAll().contains(removedQuestion));
        assertEquals(removedQuestion, question);
    }

    @Test
    void getAll() {
        Question question1 = new Question("Question 1", "Answer 1");
        Question question2 = new Question("Question 2", "Answer 2");

        javaQuestionRepository.add(question1);
        javaQuestionRepository.add(question2);

        assertTrue(javaQuestionRepository.getAll().contains(question1));
        assertTrue(javaQuestionRepository.getAll().contains(question2));
        assertEquals(javaQuestionRepository.getAll().size(), 2);
    }
}