package pro.sky.questionService.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pro.sky.questionService.services.interfaces.QuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class JavaQuestionServiceImplTest {
    private JavaQuestionServiceImpl javaQuestionService;
    private QuestionRepository questionRepository;

    @BeforeEach
    public void setup() {
        Set<Question> questions = new HashSet<>();
        questionRepository = Mockito.mock(QuestionRepository.class);
        javaQuestionService = new JavaQuestionServiceImpl(questionRepository);
    }


    @Test
    void addTest() {

        Question question = javaQuestionService.add("Question", "Answer");

        Mockito.verify(questionRepository, Mockito.times(1)).add(question);
    }

    @Test
    void addObjectTest() {

        Question question = new Question("Question", "Answer");
        Question addedQuestion = javaQuestionService.add(question);

        Mockito.verify(questionRepository, Mockito.times(1)).add(question);
        assertEquals(addedQuestion, question);
    }

    @Test
    void removeTest() {

        Question question = new Question("Question", "Answer");
        javaQuestionService.remove(question);

        Mockito.verify(questionRepository, Mockito.times(1)).remove(question);
    }

    @Test
    void getAllTest() {

        javaQuestionService.getAll();

        Mockito.verify(questionRepository, Mockito.times(1)).getAll();
    }

    @Test
    void getRandomQuestion() {

        Question question = new Question("Question", "Answer");
        Set<Question> questions = new HashSet<>();
        questions.add(question);

        when(questionRepository.getAll()).thenReturn(questions);

        Question randomQuestion = javaQuestionService.getRandomQuestion();

        assertNotNull(randomQuestion);
    }
}