package sky.pro.java.course2.courseproject2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.java.course2.courseproject2.data.Question;
import sky.pro.java.course2.courseproject2.exceptions.BadRequestException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static sky.pro.java.course2.courseproject2.constants.QuestionServiceTestConstants.QUESTIONS_TEST;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    public void shouldThrowExceptionWhenTooMuchQuestions() {
        when(javaQuestionServiceMock.getAll()).thenReturn(QUESTIONS_TEST);
        assertThrows(BadRequestException.class, () -> out.getQuestions(10));
    }

    @Test
    public void checkQuantityOfQuestions() {
        when(javaQuestionServiceMock.getAll()).thenReturn(QUESTIONS_TEST);
        List<Question> questionList = new ArrayList<>();
        questionList.addAll(QUESTIONS_TEST);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(questionList.get(0)).
                thenReturn(questionList.get(1)).thenReturn(questionList.get(2)).
                thenReturn(questionList.get(3)).thenReturn(questionList.get(4));
        assertEquals(3, out.getQuestions(3).size());
        verify(javaQuestionServiceMock, atLeast(3)).getRandomQuestion();
    }
}