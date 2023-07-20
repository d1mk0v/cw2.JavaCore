package pro.sky.questionService.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceImplTest {
    private JavaQuestionServiceImpl javaQuestionService;

    @BeforeEach
    public void setup() {
        Set<Question> questions = new HashSet<>();
        javaQuestionService = new JavaQuestionServiceImpl(questions);
    }

    @Test
    void addTest() {

        Question question = javaQuestionService.add("Question", "Answer");

        assertTrue(javaQuestionService.getAll().contains(question));
        assertEquals(question.getQuestion(), "Question");
        assertEquals(question.getAnswer(), "Answer");
    }

    @Test
    void addObjectTest() {

        Question question = new Question("Question", "Answer");
        Question addedQuestion = javaQuestionService.add(question);

        assertTrue(javaQuestionService.getAll().contains(addedQuestion));
        assertEquals(addedQuestion, question);
    }

    @Test
    void removeTest() {

        Question question = new Question("Question", "Answer");
        javaQuestionService.add(question);

        Question removedQuestion = javaQuestionService.remove(question);

        assertFalse(javaQuestionService.getAll().contains(removedQuestion));
        assertEquals(removedQuestion, question);
    }

    @Test
    void getAllTest() {

        Question question1 = new Question("Question 1", "Answer 1");
        Question question2 = new Question("Question 2", "Answer 2");

        javaQuestionService.add(question1);
        javaQuestionService.add(question2);

        assertTrue(javaQuestionService.getAll().contains(question1));
        assertTrue(javaQuestionService.getAll().contains(question2));
        assertEquals(javaQuestionService.getAll().size(), 2);
    }

    @Test
    void getRandomQuestion() {

        javaQuestionService.add("Question", "Answer");

        Question randomQuestion = javaQuestionService.getRandomQuestion();

        assertNotNull(randomQuestion);
        assertTrue(javaQuestionService.getAll().contains(randomQuestion));
    }
}