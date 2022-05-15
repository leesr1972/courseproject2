package sky.pro.java.course2.courseproject2.service;

import org.springframework.stereotype.Service;
import sky.pro.java.course2.courseproject2.data.Question;
import sky.pro.java.course2.courseproject2.exceptions.BadRequestException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;
    private final List<Question> listOfQuestions = new ArrayList<>();

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new BadRequestException("Запрошено слишком много вопросов.");
        }
        Question addedQuestion;
        while (listOfQuestions.size() < amount) {
            addedQuestion = questionService.getRandomQuestion();
            if (!(listOfQuestions.contains(addedQuestion))) {
                listOfQuestions.add(addedQuestion);
            }
        }
        return listOfQuestions;
    }
}
