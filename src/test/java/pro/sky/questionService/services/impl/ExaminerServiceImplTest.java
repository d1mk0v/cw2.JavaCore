package pro.sky.questionService.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.questionService.services.interfaces.QuestionService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(value = MockitoExtension.class)
public class ExaminerServiceImplTest {

    private ExaminerServiceImpl examinerService;
    private QuestionService javaQuestionService;
    private QuestionService mathQuestionService;

    @BeforeEach
    public void setup() {
        Set<Question> javaQuestions = new HashSet<>();
        Set<Question> mathQuestions = new HashSet<>();

        javaQuestionService = Mockito.mock(QuestionService.class);
        mathQuestionService = Mockito.mock(QuestionService.class);

        examinerService = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);
    }
    @Test
    public void getQuestionsTest() {

        Question javaQuestion = new Question("Java question", "Java answer");
        Question mathQuestion = new Question("Math question", "Math answer");

        Set<Question> javaQuestions = new HashSet<>();
        Set<Question> mathQuestions = new HashSet<>();

        javaQuestions.add(javaQuestion);
        mathQuestions.add(mathQuestion);

        when(javaQuestionService.getAll()).thenReturn(javaQuestions);
        when(mathQuestionService.getAll()).thenReturn(mathQuestions);

        Collection<Question> randomQuestions = examinerService.getQuestions(2);

        assertNotNull(randomQuestions);
        assertEquals(randomQuestions.size(), 2);
    }

    @Test
    public void getQuestionsExceptionTest() {

        when(javaQuestionService.getAll()).thenReturn(new HashSet<>());
        when(mathQuestionService.getAll()).thenReturn(new HashSet<>());

        Collection<Question> randomQuestions = examinerService.getQuestions(2);

        assertNull(randomQuestions);
    }
}