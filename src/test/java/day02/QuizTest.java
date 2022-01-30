package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    Path path= Paths.get("src/test/resources/result.txt");
    Quiz quiz=new Quiz();

    @BeforeEach
    void init(){
        quiz.read(path);
        quiz.extractIDs(path);
        quiz.extractAnswers(path);
    }

    @Test
    void testRead(){
        assertEquals("ABACD",quiz.read(path).get(0));
    }

    @Test
    void testAnsweredCorrectly(){
        assertTrue(quiz.answeredCorrectly("GH1234",4));
        assertFalse(quiz.answeredCorrectly("AB123",4));
    }

    @Test
    void testReturnBestContestant(){
        quiz.returnPointsAchieved();
        assertEquals("GH1234",quiz.returnBestContestant());
    }
}