package io.zipcoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.zipcoder.Classroom.createMap;
import static org.junit.jupiter.api.Assertions.fail;

public class ClassroomTest {


    @Test
    void constructorTest(){
        Classroom classroom = new Classroom();
        Integer givenNumberOfStudents = 5;
        Map<String, Double[]> givenStudentMap = new LinkedHashMap<>();
        Double [] examScores1 = {100.00, 95.00, 85.00};
        Student first = new Student("Bobbi", "Zupon", examScores1);
        Double [] examScore2 = {100.00, 100.00, 95.00};
        Student second = new Student("Leon", "Hunter", examScore2);
//        Double [] examScore3 = {100.00, 100.00, 95.00};
//        Student third = new Student("Craig", "Hunter", examScore3);
//        Double [] examScores4 = { 100.00, 100.00, 85.00};
//        Student fourth = new Student ("Zach", "Singer", examScores4);
//        Double [] examScores5 = {100.00, 100.00, 80.00};
//        Student fifth = new Student ("Zach", "Singer", examScores5);
       classroom.createMap(givenStudentMap, first);
       classroom.addStudent(givenStudentMap, second);
//       classroom.addStudent(givenStudentMap, third);
//       classroom.addStudent(givenStudentMap, fourth);
//       classroom.addStudent(givenStudentMap, fifth);

        classroom = new Classroom(givenStudentMap, givenNumberOfStudents);

       Map<String, Double []> actualMap = classroom.getStudentsByExamScores();
        Integer actual = classroom.getNumberOfStudents();
        System.out.println(givenStudentMap.entrySet());
        System.out.println(actualMap.entrySet());
        System.out.println(givenNumberOfStudents);
        System.out.println(actual);;
       Assertions.assertEquals(givenNumberOfStudents, 1);
       Assertions.assertEquals(givenStudentMap, actualMap);

       givenStudentMap.clear();
    }

    @Test
    void setStudentsByExamScoresTest() {
        Classroom classroom = new Classroom();
        Map<String, Double[]> givenStudentMap = new LinkedHashMap<>();
        Double [] examScores1 = {100.00, 95.00, 85.00};
        Student first = new Student("Bobbi", "Zupon", examScores1);
        Double [] examScore2 = {100.00, 100.00, 95.00};
        Student second = new Student("Leon", "Hunter", examScore2);
        Double [] examScore3 = {100.00, 100.00, 95.00};
        Student third = new Student("Craig", "Hunter", examScore3);
        Double [] examScores4 = { 100.00, 100.00, 85.00};
        Student fourth = new Student ("Zach", "Singer", examScores4);
        Double [] examScores5 = {100.00, 100.00, 80.00};
        Student fifth = new Student ("Zach", "Singer", examScores5);
        classroom.createMap(givenStudentMap, first);
        classroom.addStudent(givenStudentMap, second);
        classroom.addStudent(givenStudentMap, third);
        classroom.addStudent(givenStudentMap, fourth);
        classroom.addStudent(givenStudentMap, fifth);


       classroom.setStudentsByExamScores(givenStudentMap);

        Map<String, Double []> actualMap = classroom.getStudentsByExamScores();

        Assertions.assertEquals(givenStudentMap, actualMap);
        givenStudentMap.clear();
    }

    @Test
    void setNumberOfStudentsTest() {
        Classroom classroom = new Classroom();
        Integer givenNumberOfStudents = 5;
        Map<String, Double[]> givenStudentMap = new LinkedHashMap<>();
        Double [] examScores1 = {100.00, 95.00, 85.00};
        Student first = new Student("Bobbi", "Zupon", examScores1);
        Double [] examScore2 = {100.00, 100.00, 95.00};
        Student second = new Student("Leon", "Hunter", examScore2);
        Double [] examScore3 = {100.00, 100.00, 95.00};
        Student third = new Student("Craig", "Hunter", examScore3);
        Double [] examScores4 = { 100.00, 100.00, 85.00};
        Student fourth = new Student ("Zach", "Singer", examScores4);
        Double [] examScores5 = {100.00, 100.00, 80.00};
        Student fifth = new Student ("Zach", "Singer", examScores5);
        classroom.createMap(givenStudentMap, first);
        classroom.addStudent(givenStudentMap, second);
        classroom.addStudent(givenStudentMap, third);
        classroom.addStudent(givenStudentMap, fourth);
        classroom.addStudent(givenStudentMap, fifth);


        classroom.setStudentsByExamScores(givenStudentMap);
        classroom.setNumberOfStudents(givenStudentMap);

        Integer actual = classroom.getNumberOfStudents();
        System.out.println(givenStudentMap);
        Assertions.assertEquals(givenNumberOfStudents, actual);
    }

    @Test
    void createMapTestTest() {
    }

    @Test
    void getStudentsTest() {
    }

    @Test
    void getAverageClassScoreTest() {
    }

    @Test
    void addStudentTest() {
    }

    @Test
    void removeStudentTest() {
    }

    @Test
    void getStudentsByAveragesTest() {
    }

    @Test
    void findingThePointsToAddTest() {
    }

    @Test
    void findingTheHighestTest() {
    }

    @Test
    void addingTheCurveTest() {
    }

    @Test
    void sortByAverageTest() {
    }

    @Test
    void getGradeBookTest() {
    }

    @Test
    void letterGradesTest() {
    }





}
