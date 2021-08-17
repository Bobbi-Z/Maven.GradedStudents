package io.zipcoder;

import org.decimal4j.util.DoubleRounder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student implements Comparable<Student> {

    private static String firstName;
    private static String lastName;
    private static List<Double> examScores = new ArrayList<>();
    private static Double [] testScores = new Double[Student.numberOfExamsTaken(examScores)];

    public Student() {
    }

    public Student(String firstName, String lastName, Double [] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        setTestScores(createList(testScores));

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static Double[] getTestScores() {
        return testScores;
    }

    public void setTestScores(List<Double> examScores){
       testScores =  examScores.toArray(new Double[0]);
    }

    public static List<Double> createList(Double[] testScores){
        for (Double score : testScores){
            addExamScore(examScores, score);
        }
        return examScores;
    }

    public static Integer numberOfExamsTaken(List<Double> examScores){
        return examScores.size();
    }

    public static String getExamScores(List<Double> examScores) {
        String allExams = "";
        for (int index = 0; index < examScores.size(); index++){
            String oneExam = "   Exam " + (index+1) + " -> " + examScores.get(index) + " \n";
            allExams += oneExam;
        }
        return "> Exam Scores: \n" + allExams;
    }

    public static String getExamScoreByExamNumber(List<Double> examScores, Integer examNumber){
        String oneExam = "Exam " + examNumber + " -> " + examScores.get(examNumber-1);
        return oneExam;
    }

    public static Boolean addExamScore(List<Double> examScores, double examScore) {

        return examScores.add(examScore);
    }

    public static Double getAverageExamScore(List<Double> examScores){
        Double totalScores = 0.00;
        for(Double score : examScores){
            totalScores += score;
        }
        Double average = DoubleRounder.round((totalScores / examScores.size()), 2);
        return average;
    }

    public static Double getAverageExamScore3(Student student){
        Double [] examScores = student.getTestScores();
        Double totalScores = 0.00;
        for(Double score : examScores){
            totalScores += score;
        }
        Double average = DoubleRounder.round((totalScores / examScores.length), 2);
        return average;
    }

    public static Double getAverageExamScore2(Double [] examScores){
        Double totalScores = 0.00;
        for(Double score : examScores){
            totalScores += score;
        }
        Double average = DoubleRounder.round((totalScores / examScores.length), 2);
        return average;
    }

    public String toString(){
        return "Student Name: " + getFirstName() + " " + getLastName() + " \n" +
                "> Average Score: " + Student.getAverageExamScore(examScores) + " \n" +
                    Student.getExamScores(examScores);
    }

    @Override
    public int compareTo(Student secondStudent) {
        Double student1Average = this.getAverageExamScore(this.createList(this.getTestScores()));
        Double student2Average = secondStudent.getAverageExamScore(secondStudent.createList(secondStudent.getTestScores()));
        if (student1Average == student2Average){
            compareToLastName(this, secondStudent );
        }

      return Double.compare(student1Average, student2Average);
    }

    public Student compareToLastName(Student firstStudent, Student secondStudent){
        String student1LastName = firstStudent.getLastName();
        String student2LastName = secondStudent.getLastName();
        if (student1LastName == student2LastName){
            compareToFirstName(firstStudent, secondStudent);
        }
        for (int index1 = 0; index1 < student1LastName.length(); index1++){
            for (int index2 = index1; index2 < student2LastName.length(); index2++){
                if (student1LastName.charAt(index1) < student2LastName.charAt(index2)){
                    return firstStudent;
                }else if (student1LastName.charAt(index1) > student2LastName.charAt(index2)){
                    return secondStudent;
                }
            }
        }
        return null;
    }

    public Student compareToFirstName(Student firstStudent, Student secondStudent){
        String student1FirstName = firstStudent.getFirstName();
        String student2FirstName = secondStudent.getFirstName();
        for (int index1 = 0; index1 < student1FirstName.length(); index1++){
            for (int index2 = index1; index2 < student2FirstName.length(); index2++){
                if (student1FirstName.charAt(index1) < student2FirstName.charAt(index2)){
                    return firstStudent;
                }else if (student1FirstName.charAt(index1) > student2FirstName.charAt(index2)){
                    return secondStudent;
                }
            }
        }
        System.out.println("There cannot be 2 of the same student!");
        return null;


    }

}
