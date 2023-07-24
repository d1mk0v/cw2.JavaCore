package pro.sky.questionService.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.questionService.services.impl.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {

    private MathQuestionRepository mathQuestionRepository;

    @BeforeEach
    public void setup() {
        Set<Question> questions = new HashSet<>();
        mathQuestionRepository = new MathQuestionRepository(questions);
    }

    @Test
    void addTest() {
        Question question = mathQuestionRepository.add("Question", "Answer");

        assertTrue(mathQuestionRepository.getAll().contains(question));
        assertEquals(question.getQuestion(), "Question");
        assertEquals(question.getAnswer(), "Answer");
    }

    @Test
    void addObjectTest() {
        Question question = new Question("Question", "Answer");
        Question addedQuestion = mathQuestionRepository.add(question);

        assertTrue(mathQuestionRepository.getAll().contains(addedQuestion));
        assertEquals(addedQuestion, question);
    }

    @Test
    void remove() {
        Question question = new Question("Question", "Answer");
        mathQuestionRepository.add(question);

        Question removedQuestion = mathQuestionRepository.remove(question);

        assertFalse(mathQuestionRepository.getAll().contains(removedQuestion));
        assertEquals(removedQuestion, question);
    }

    @Test
    void getAll() {
        Question question1 = new Question("Question 1", "Answer 1");
        Question question2 = new Question("Question 2", "Answer 2");

        mathQuestionRepository.add(question1);
        mathQuestionRepository.add(question2);

        assertTrue(mathQuestionRepository.getAll().contains(question1));
        assertTrue(mathQuestionRepository.getAll().contains(question2));
        assertEquals(mathQuestionRepository.getAll().size(), 2);
    }
}