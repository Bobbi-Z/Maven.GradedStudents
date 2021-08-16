package io.zipcoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassroomTest {




    @Test
    void constructorTest(){
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
        Student [] testArray = new Student[5];
        Classroom.addStudent(testArray, first);
        Classroom.addStudent(testArray, second);
        Classroom.addStudent(testArray, third);
        Classroom.addStudent(testArray, fourth);
        Classroom.addStudent(testArray, fifth);
        Classroom testClassroom = new Classroom(5);

        Student [] expected = {first, second, third, fourth, fifth};
        Student [] actual = testClassroom.getStudents();
        System.out.println(Arrays.toString(actual));
        System.out.println(first);
        System.out.println(second);

        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(actual));

    }


    @Test
    void setStudentsTest() {
    }

    @Test
    void setMaxNumberOfStudentsTest() {
    }

    @Test
    void createStudentListTest() {
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
    void getStudentsByScoreTest() {
    }

    @Test
    void getGradeBookTest() {
    }

    @Test
    void findingTheCurveTheCurveTest() {
    }

    @Test
    void letterGradesTest() {
    }


}
