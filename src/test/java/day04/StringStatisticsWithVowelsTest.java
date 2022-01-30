package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringStatisticsWithVowelsTest {

    StringStatisticsWithVowels stat=new StringStatisticsWithVowels();

    @Test
    void testCountLetters(){
        assertEquals(1,stat.countVowels("HELLO").get('e'));
        assertEquals(1,stat.countVowels("HEllO").get('o'));
        assertEquals(1,stat.countVowels("apple").get('a'));
        assertEquals(1,stat.countVowels("apple").get('e'));
        assertEquals(1,stat.countVowels("carefree").get('a'));
        assertEquals(3,stat.countVowels("carefree").get('e'));
        assertEquals(1,stat.countVowels("shoulder").get('o'));
        assertEquals(1,stat.countVowels("shoulder").get('u'));
    }

}