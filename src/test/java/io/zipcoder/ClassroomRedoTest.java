package io.zipcoder;

import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ClassroomRedoRedoTest {

    @Test
    void getAverageExamScoreTest() {
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        ClassroomRedo classroom = new ClassroomRedo(students);

        // When
        Double output = classroom.getAverageExamScore();
        // Then
        System.out.println(output);
        Assertions.assertEquals(125.0, output, 0);
    }

    @Test
    void addStudentTest() {
        // : Given
        //Making old students
        Double[] examScores1 = {123.0, 159.0, 170.0};
        Student jack = new Student("Jack","Smith", examScores1);
        Double[] examScores2 = {230.4, 215.0, 50.2};
        Student kate = new Student("Kate", "Green", examScores2);


        //Putting students into classroom
        Student[] oldStudents = {jack, kate};
        ClassroomRedo classroom = new ClassroomRedo(oldStudents);

        //New student
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        //Add leon
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        assertSame(oldStudents.length + 1, postEnrollment.length);

    }

    @Test
    void removeStudentTest() {
// : Given
        //Making old students
        Double[] examScores1 = {123.0, 159.0, 170.0};
        Student jack = new Student("Jack","Smith", examScores1);
        Double[] examScores2 = {230.4, 215.0, 50.2};
        Student kate = new Student("Kate", "Green", examScores2);
        Double[] examScores3 = { 100.0, 150.0, 250.0, 0.0 };
        Student leon = new Student("Leon", "Hunter", examScores3);

        //Putting students into classroom
        Student[] oldStudents = {jack, kate, leon};
        ClassroomRedo classroom = new ClassroomRedo(oldStudents);


        classroom.removeStudent("Leon", "Hunter");
        Student[] postRemoval = classroom.getStudents();

        assertSame(postRemoval.length, (oldStudents.length - 1) );
    }

    @Test
    void getStudentByScoreTest() {
        // : Given
        //Making old students
        Double[] examScores1 = {123.0, 159.0, 170.0};
        Student jack = new Student("Jack","Smith", examScores1);
        Double[] examScores2 = {230.4, 215.0, 50.2};
        Student kate = new Student("Kate", "Green", examScores2);
        Double[] examScores = { 175.0, 150.0, 250.0};
        Student leon = new Student("Leon", "Hunter", examScores);

        //Putting students into classroom
        Student[] allStudents = {jack, kate, leon};
        ClassroomRedo classroom = new ClassroomRedo(allStudents);

        //Sorting students
        classroom.getStudentByScore(allStudents);

    Assertions.assertEquals(allStudents[0], leon);
    }

    @Test
    void getGradeBookTest() {
        // : Given
        //Making old students
        Double[] examScores1 = {70.0, 90.0, 77.0};
        Student jack = new Student("Jack","Smith", examScores1);

        Double[] examScores2 = {69.4, 94.0, 88.2};
        Student kate = new Student("Kate", "Green", examScores2);

        Double[] examScores3 = { 100.0, 93.0, 87.0};
        Student leon = new Student("Leon", "Hunter", examScores3);

        Double[] examScores4 = {87.4, 60.0, 50.2};
        Student tim = new Student("Tim", "Bo", examScores4);

        Double[] examScore5 = { 71.0, 82.0, 83.0};
        Student brian = new Student("Brian", "Jackson", examScore5);

        //Putting students into classroom
        Student[] allStudents = {jack, kate, leon, tim, brian};
        ClassroomRedo classroom = new ClassroomRedo(allStudents);

       Map<Student, String> gradeBook = classroom.getGradeBook(allStudents);
        assertEquals(5, gradeBook.size());

    }

    @Test
    void findingTheCurveToAddTest() {

        // : Given
        //Making old students
        Double[] examScores1 = {70.0, 90.0, 77.0};
        Student jack = new Student("Jack","Smith", examScores1);

        Double[] examScores2 = {69.4, 94.0, 88.2};
        Student kate = new Student("Kate", "Green", examScores2);

        Double[] examScores3 = { 100.0, 93.0, 87.0};
        Student leon = new Student("Leon", "Hunter", examScores3);

        Double[] examScores4 = {87.4, 60.0, 50.2};
        Student tim = new Student("Tim", "Bo", examScores4);

        Double[] examScore5 = { 71.0, 82.0, 83.0};
        Student brian = new Student("Brian", "Jackson", examScore5);

        //Putting students into classroom
        Student[] allStudents = {jack, kate, leon, tim, brian};
        ClassroomRedo classroom = new ClassroomRedo(allStudents);

        Double curveToAdd = classroom.findingTheCurveToAdd(allStudents);
        System.out.println(curveToAdd);

    }

    @Test
    void letterGrades() {
        Double[] examScore5 = { 71.0, 82.0, 83.0};
        Student jack = new Student("Jack","Smith", examScore5);
       Double studentAverage = Student.getAverageExamScore3(jack);
       String studentLetterGrade = ClassroomRedo.letterGrades(studentAverage);
        System.out.println(studentLetterGrade);

    }
}