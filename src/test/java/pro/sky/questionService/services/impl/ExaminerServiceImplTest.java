package pro.sky.questionService.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import pro.sky.questionService.exceptions.NotEnoughQuestionsException;
import pro.sky.questionService.services.interfaces.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExaminerServiceImplTest {

    private QuestionService questionService;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void setup() {
        questionService = Mockito.mock(QuestionService.class);
        examinerService = new ExaminerServiceImpl(questionService);
    }


    @Test
    void getQuestionsTest() {

        Set<Question> questions = new HashSet<>();

        questions.add(new Question("Question 1", "Answer 1"));
        questions.add(new Question("Question 2", "Answer 2"));
        questions.add(new Question("Question 3", "Answer 3"));
        questions.add(new Question("Question 4", "Answer 4"));
        questions.add(new Question("Question 5", "Answer 5"));

        when(questionService.getRandomQuestion()).thenReturn(questions.toArray(new Question[0]));

        int amount = 3;

        Collection<Question> randomQuestions = examinerService.getQuestions(amount);

        assertNotNull(randomQuestions);
        assertEquals(randomQuestions.size(), amount);

        for (Question question : randomQuestions) {
            assertTrue(questions.contains(question));
        }
    }

    @Test
    public void notEnoughQuestionsExceptionTest() {
        Set<Question> questions = new HashSet<>();
        questions.add(new Question("Question 1", "Answer 1"));

        when(questionService.getRandomQuestion()).thenReturn(questions.toArray(new Question[0]));

        int amount = 3;

        assertThrows(NotEnoughQuestionsException.class, () -> {
            examinerService.getQuestions(amount);
        });
    }
}