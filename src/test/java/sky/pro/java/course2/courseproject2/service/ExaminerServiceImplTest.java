package sky.pro.java.course2.courseproject2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.java.course2.courseproject2.exceptions.BadRequestException;

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
        when(javaQuestionServiceMock.getRandomQuestion()).thenCallRealMethod();
        assertEquals(3, out.getQuestions(3).size());
        verify(javaQuestionServiceMock, atLeast(3)).getRandomQuestion();
    }
}