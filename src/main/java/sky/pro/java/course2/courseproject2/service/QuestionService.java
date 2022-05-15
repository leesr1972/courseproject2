package sky.pro.java.course2.courseproject2.service;

import sky.pro.java.course2.courseproject2.data.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(String question);
    Question remove(String question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
