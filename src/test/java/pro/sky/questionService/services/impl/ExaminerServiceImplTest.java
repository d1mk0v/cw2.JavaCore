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

        Set<Question> questions= new HashSet<>();

        questions.add(new Question("Question 1", "Answer 1"));
        questions.add(new Question("Question 2", "Answer 2"));
        questions.add(new Question("Question 3", "Answer 3"));

        Mockito.when(questionService.getAll()).thenReturn(questions);

        Question randomQuestion = new Question("Question 3", "Answer 3");

        Mockito.when(questionService.getRandomQuestion()).thenReturn(randomQuestion);

        Set<Question> expected = new HashSet<>();
        expected.add(new Question("Question 3", "Answer 3"));

        Set<Question> actual = examinerService.getQuestions(1);

        assertEquals(expected, actual);
    }

    @Test
    public void getQuestionsExceptionTest() {

        Set<Question> questions= new HashSet<>();
        questions.add(new Question("Question 1", "Answer 1"));
        questions.add(new Question("Question 2", "Answer 2"));

        Mockito.when(questionService.getAll()).thenReturn(questions);

        assertThrows(NotEnoughQuestionsException.class, () -> examinerService.getQuestions(3));
    }
}