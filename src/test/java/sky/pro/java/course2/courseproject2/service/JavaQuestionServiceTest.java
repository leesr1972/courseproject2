package sky.pro.java.course2.courseproject2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sky.pro.java.course2.courseproject2.data.Question;
import sky.pro.java.course2.courseproject2.exceptions.NotFoundException;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static sky.pro.java.course2.courseproject2.constants.QuestionServiceTestConstants.*;

class JavaQuestionServiceTest {
    private final JavaQuestionService out = new JavaQuestionService();

    @BeforeEach
    public void setUp() {
        out.add("Что такое цикл?", "Это когда много раз.");
        out.add("Что такое массив?", "Это хранилище.");
        out.add("Что такое мок?", "Это заглушка.");
        out.add("Что такое метод?", "Это подпрограмма.");
        out.add("Что такое рекурсия?", "Это когда сам себя.");
    }

    @Test
    public void shouldReturnQUESTION_TESTWhenAdd() {
        Question addedQuestion = new Question("Что такое тест?", "Это проверка кода.");
        assertEquals(addedQuestion, out.add("Что такое тест?", "Это проверка кода."));
    }

    @Test
    public void shouldReturnQUESTION_TESTWhenRemove() {
        assertEquals(QUESTION_TEST, out.remove("Что такое цикл?"));
    }

    @Test
    public void shouldThrowExceptionWhenQuestionNotFouns() {
        assertThrows(NotFoundException.class, () -> out.remove("Такого вопроса нет."));
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