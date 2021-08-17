package io.zipcoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.fail;

public class ClassroomCancelledTest {


    @Test
    void constructorTest(){
        ClassroomCancelled classroomCancelled = new ClassroomCancelled();
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
       classroomCancelled.createMap(givenStudentMap, first);
       classroomCancelled.addStudent(givenStudentMap, second);
//       classroomCancelled.addStudent(givenStudentMap, third);
//       classroomCancelled.addStudent(givenStudentMap, fourth);
//       classroomCancelled.addStudent(givenStudentMap, fifth);

        classroomCancelled = new ClassroomCancelled(givenStudentMap, givenNumberOfStudents);

       Map<String, Double []> actualMap = classroomCancelled.getStudentsByExamScores();
        Integer actual = classroomCancelled.getNumberOfStudents();
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
        ClassroomCancelled classroomCancelled = new ClassroomCancelled();
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
        classroomCancelled.createMap(givenStudentMap, first);
        classroomCancelled.addStudent(givenStudentMap, second);
        classroomCancelled.addStudent(givenStudentMap, third);
        classroomCancelled.addStudent(givenStudentMap, fourth);
        classroomCancelled.addStudent(givenStudentMap, fifth);


       classroomCancelled.setStudentsByExamScores(givenStudentMap);

        Map<String, Double []> actualMap = classroomCancelled.getStudentsByExamScores();

        Assertions.assertEquals(givenStudentMap, actualMap);
        givenStudentMap.clear();
    }

    @Test
    void setNumberOfStudentsTest() {
        ClassroomCancelled classroomCancelled = new ClassroomCancelled();
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
        classroomCancelled.createMap(givenStudentMap, first);
        classroomCancelled.addStudent(givenStudentMap, second);
        classroomCancelled.addStudent(givenStudentMap, third);
        classroomCancelled.addStudent(givenStudentMap, fourth);
        classroomCancelled.addStudent(givenStudentMap, fifth);


        classroomCancelled.setStudentsByExamScores(givenStudentMap);
        classroomCancelled.setNumberOfStudents(givenStudentMap);

        Integer actual = classroomCancelled.getNumberOfStudents();
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
