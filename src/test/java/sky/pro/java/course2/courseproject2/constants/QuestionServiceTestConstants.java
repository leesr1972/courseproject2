package sky.pro.java.course2.courseproject2.constants;

import sky.pro.java.course2.courseproject2.data.Question;

import java.util.HashSet;
import java.util.Set;

public class QuestionServiceTestConstants {
    public static final Set<Question> QUESTIONS_TEST = new HashSet<>(Set.of(
            new Question("Что такое цикл?", "Это когда много раз."),
            new Question("Что такое массив?", "Это хранилище."),
            new Question("Что такое мок?", "Это заглушка."),
            new Question("Что такое метод?", "Это подпрограмма."),
            new Question("Что такое рекурсия?", "Это когда сам себя.")
    ));

    public static final Question QUESTION_TEST = new Question("Что такое цикл?",
            "Это много раз.");
}
