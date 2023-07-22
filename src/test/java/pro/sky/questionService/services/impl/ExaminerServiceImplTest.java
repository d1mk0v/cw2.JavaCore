package pro.sky.questionService.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import pro.sky.questionService.exceptions.NotEnoughQuestionsException;
import pro.sky.questionService.services.interfaces.QuestionService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(value = MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void setup() {
        examinerService = new ExaminerServiceImpl(questionService);
    }
    @Test
    public void getQuestionsTest() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Question 1", "Answer 1"));
        questions.add(new Question("Question 2", "Answer 2"));
        questions.add(new Question("Question 3", "Answer 3"));

        when(questionService.getRandomQuestion()).thenReturn(questions.get(0)).thenReturn(questions.get(1));

        int amount = 1;

        Collection<Question> randomQuestions = examinerService.getQuestions(amount);

        assertNotNull(randomQuestions);
        assertEquals(amount, randomQuestions.size());
        assertTrue(questions.containsAll(randomQuestions));
    }

    @Test
    public void getQuestionsExceptionTest() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Question 1", "Answer 1"));

//        when(questionService.getRandomQuestion()).thenReturn((Question) questions);
        Mockito.when(questionService.getAll()).thenReturn(questions);

        assertThrows(NotEnoughQuestionsException
                .class, () -> examinerService.getQuestions(2));
    }
}