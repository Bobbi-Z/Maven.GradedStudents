package io.zipcoder;

import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentTest {

    @Test
    void constructorTest(){
        String givenFirstName = "Leon";
        String givenLastName = "Hunter";
        Double [] givenTestScores = {100.00, 95.00, 85.00};
        Student testStudent = new Student(givenFirstName, givenLastName, givenTestScores);

        String expectedFirstName = testStudent.getFirstName();
        String expectedLastName = testStudent.getLastName();
        Double [] expectedTestScores = testStudent.getTestScores();


        Assertions.assertEquals(expectedFirstName, givenFirstName);
        Assertions.assertEquals(expectedLastName, givenLastName);
        Assertions.assertEquals(Arrays.toString(expectedTestScores), Arrays.toString(givenTestScores));

        System.out.println(Arrays.toString(expectedTestScores));
        System.out.println(Arrays.toString(givenTestScores));
        System.out.println(testStudent);
    }

    @Test
    void setFirstNameTest() {
        Student testStudent = new Student();
        String expectedFirstName = "Bobbi";
        testStudent.setFirstName(expectedFirstName);
        String actualFirstName = testStudent.getFirstName();
        Assertions.assertEquals(expectedFirstName, actualFirstName);
    }

    @Test
    void setLastNameTest() {
        Student testStudent = new Student();
        String expectedLastName = "Zupon";
        testStudent.setLastName(expectedLastName);
        String actualLastName = testStudent.getLastName();
        Assertions.assertEquals(expectedLastName, actualLastName);
    }

    @Test
    void setTestScoresTest() {
        Student testStudent = new Student();
        List<Double> testExamsScoresList = new ArrayList<>();
        testExamsScoresList.add(100.00);
        testExamsScoresList.add(95.00);
        testExamsScoresList.add(85.00);
        Double [] expectedTestScores = {100.00, 95.00, 85.00};
        testStudent.setTestScores(testExamsScoresList);
        Double [] actualTestScores = testStudent.getTestScores();
        String expected = Arrays.toString(expectedTestScores);
        String actual = Arrays.toString(actualTestScores);
        Assertions.assertEquals(expected, actual);
        System.out.println(expected);
        System.out.println(actual);
        testExamsScoresList.clear();
    }

    @Test
    void numberOfExamsTakenTest() {
        List<Double> testExamsScoresList = new ArrayList<>();
        testExamsScoresList.add(100.00);
        testExamsScoresList.add(95.00);
        testExamsScoresList.add(85.00);
        Integer expected = 3;
        Integer actual = Student.numberOfExamsTaken(testExamsScoresList);
        Assertions.assertEquals(expected, actual);
        testExamsScoresList.clear();
    }

    @Test
    void getExamScoresTest() {
        List<Double> testExamsScoresList = new ArrayList<>();
        testExamsScoresList.add(100.00);
        testExamsScoresList.add(95.00);
        testExamsScoresList.add(85.00);
        String expected = "> Exam Scores: \n" + "   " + "Exam 1 -> 100.0 \n" +
                "   " + "Exam 2 -> 95.0 \n" +
                "   " + "Exam 3 -> 85.0 \n";
        String actual = Student.getExamScores(testExamsScoresList);
        Assertions.assertEquals(expected, actual);
        System.out.println(Student.getExamScores(testExamsScoresList));
        System.out.println(expected);
        testExamsScoresList.clear();
    }

    @Test
    void getExamScoreByExamNumberTest() {
        List<Double> testExamsScoresList = new ArrayList<>();
        testExamsScoresList.add(100.00);
        testExamsScoresList.add(95.00);
        testExamsScoresList.add(85.00);
        Integer examNumber = 2;
        String expected = "Exam 2 -> 95.0";
        String actual = Student.getExamScoreByExamNumber(testExamsScoresList, examNumber);
        Assertions.assertEquals(expected, actual);
        System.out.println(actual);
        testExamsScoresList.clear();
    }

    @Test
    void addExamScoreTest() {
        List<Double> testExamsScoresList = new ArrayList<>();
        Double testExamScore = 80.00;
        Student.addExamScore(testExamsScoresList, testExamScore);
        Boolean expected = true;
        Boolean actual = testExamsScoresList.contains(testExamScore);
        Assertions.assertEquals(expected, actual);
        testExamsScoresList.clear();
    }

    @Test
    void getAverageExamScoreTest() {
        List<Double> testExamsScoresList = new ArrayList<>();
        testExamsScoresList.add(100.00);
        testExamsScoresList.add(95.00);
        testExamsScoresList.add(85.00);
        Double expected = 93.33;
        Double actual = Student.getAverageExamScore(testExamsScoresList);
        Assertions.assertEquals(expected, actual);
        System.out.println(actual);
        testExamsScoresList.clear();
    }

    @Test
    void createListTest() {
        Double [] givenTestScores = {100.00, 95.00, 85.00};
        List<Double> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, givenTestScores);
        List<Double> actualList = Student.createList(givenTestScores);
        Assertions.assertEquals(expectedList, actualList);
        expectedList.clear();
        actualList.clear();
    }

    @Test
    void testToStringTest() {
        String givenFirstName = "Leon";
        String givenLastName = "Hunter";
        Double [] givenTestScores = {100.00, 95.00, 85.00};
        Student testStudent = new Student(givenFirstName, givenLastName, givenTestScores);
        String actual = testStudent.toString();
        System.out.println(actual);

    }

    @Test
    void getAverageExamScore2() {
    }
}