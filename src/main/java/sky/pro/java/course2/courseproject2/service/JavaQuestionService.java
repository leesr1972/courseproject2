package sky.pro.java.course2.courseproject2.service;

import org.springframework.stereotype.Service;
import sky.pro.java.course2.courseproject2.data.Question;
import sky.pro.java.course2.courseproject2.exceptions.NotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService{
    public static final Set<Question> questions = new HashSet<>(Set.of(
            new Question("Что такое цикл?", "Это когда много раз."),
            new Question("Что такое массив?", "Это хранилище."),
            new Question("Что такое мок?", "Это заглушка."),
            new Question("Что такое метод?", "Это подпрограмма."),
            new Question("Что такое рекурсия?", "Это когда сам себя.")
    ));

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(String question) {
        Question newQuestion = new Question(question, "Ответа нет.");
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(String question) {
        Question removedQuestion = null;
        for (Question q: questions) {
            if (q.getQuestion().equals(question)) {
                removedQuestion = q;
            }
        }
        if (removedQuestion == null) {
            throw new NotFoundException("Такого вопроса нет.");
        }
        questions.remove(removedQuestion);
        return removedQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Question randomQuestion = null;
        Random random = new Random();
        int numberOfQuestion = random.nextInt(questions.size()) + 1;
        int counterOfQuestion = 0;
        for (Question q : questions) {
            counterOfQuestion++;
            if (counterOfQuestion == numberOfQuestion) {
                randomQuestion = q;
            }
        }
        return randomQuestion;
    }
}
