package sky.pro.java.course2.courseproject2.service;

import org.junit.jupiter.api.Test;
import sky.pro.java.course2.courseproject2.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static sky.pro.java.course2.courseproject2.constants.QuestionServiceTestConstants.*;

class JavaQuestionServiceTest {
    private final JavaQuestionService out = new JavaQuestionService();

    @Test
    public void shouldReturnQUESTION_TESTWhenAdd() {
        assertEquals (QUESTION_TEST, out.add("Что такое цикл?", "Это когда много раз."));
    }

    @Test
    public void shouldReturnQUESTION_TESTWhenRemove() {
        assertEquals (QUESTION_TEST, out.remove("Что такое цикл?"));
    }

    @Test
    public void shouldThrowExceptionWhenQuestionNotFouns() {
        assertThrows(NotFoundException.class, ()->out.remove("Такого вопроса нет."));
    }

    @Test
    public void shouldReturnQUESTOINS_TEST() {
        assertEquals(QUESTIONS_TEST, out.getAll());
    }

    @Test
    public void checkNotNullWhenGetRandomQuestion() {
        assertNotNull(out.getRandomQuestion());
    }
}