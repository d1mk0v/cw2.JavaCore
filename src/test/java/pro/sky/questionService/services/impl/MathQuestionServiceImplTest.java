package pro.sky.questionService.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionServiceImplTest {

    private MathQuestionServiceImpl mathQuestionService;

    @BeforeEach
    public void setup() {
        Set<Question> questions = new HashSet<>();
        mathQuestionService = new MathQuestionServiceImpl(questions);
    }

    @Test
    void addTest() {
        Question question = mathQuestionService.add("Question", "Answer");

        assertTrue(mathQuestionService.getAll().contains(question));
        assertEquals(question.getQuestion(), "Question");
        assertEquals(question.getAnswer(), "Answer");
    }

    @Test
    void addObjectTest() {
        Question question = new Question("Question", "Answer");
        Question addedQuestion = mathQuestionService.add(question);

        assertTrue(mathQuestionService.getAll().contains(addedQuestion));
        assertEquals(addedQuestion, question);
    }

    @Test
    void remove() {
        Question question = new Question("Question", "Answer");
        mathQuestionService.add(question);

        Question removedQuestion = mathQuestionService.remove(question);

        assertFalse(mathQuestionService.getAll().contains(removedQuestion));
        assertEquals(removedQuestion, question);
    }

    @Test
    void getAll() {
        Question question1 = new Question("Question 1", "Answer 1");
        Question question2 = new Question("Question 2", "Answer 2");

        mathQuestionService.add(question1);
        mathQuestionService.add(question2);

        assertTrue(mathQuestionService.getAll().contains(question1));
        assertTrue(mathQuestionService.getAll().contains(question2));
        assertEquals(mathQuestionService.getAll().size(), 2);
    }

    @Test
    void getRandomQuestion() {
        mathQuestionService.add("Question", "Answer");

        Question randomQuestion = mathQuestionService.getRandomQuestion();

        assertNotNull(randomQuestion);
        assertTrue(mathQuestionService.getAll().contains(randomQuestion));
    }
}