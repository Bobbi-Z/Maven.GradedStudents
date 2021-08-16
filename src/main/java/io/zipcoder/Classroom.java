package io.zipcoder;

import org.decimal4j.util.DoubleRounder;
import java.util.*;

import static java.lang.Double.MIN_VALUE;

public class Classroom {


    private static Map<String, Double []> studentsByExamScores;
    private Integer numberOfStudents;

    public Classroom() {

    }

    public Classroom(Integer maxNumberOfStudents, Map<String, Double []> studentsByExamScores) {

    }

    public static Map<String, Double[]> getStudentsByExamScores() {
        return studentsByExamScores;
    }

    public static void setStudentsByExamScores(Map<String, Double[]> studentsByExamScores) {
        Classroom.studentsByExamScores = studentsByExamScores;
    }

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Map<String, Double []> studentsByExamScores) {
        numberOfStudents = studentsByExamScores.size();
    }

    public static Map<String, Double[]> createMap(Student student){
        studentsByExamScores = new LinkedHashMap<>();
        String key = student. getLastName() + ", " + student.getFirstName();
        Double [] value = student.getTestScores();
        studentsByExamScores.put(key, value);
        return studentsByExamScores;
    }

    public Set<String> getStudents(Map<String, Double[]> studentsByExamScores){
       return studentsByExamScores.keySet();
    }

    public Double getAverageClassScore(Map<String, Double[]> studentsByExamScores){
        Double classAverageTotals = 0.00;
        for (Map.Entry<String, Double[]> mapElement : studentsByExamScores.entrySet()){
           Double [] testScores = mapElement.getValue();
          Double studentAverage = Student.getAverageExamScore2(testScores);
            classAverageTotals += studentAverage;
        }

        Double classAverage = DoubleRounder.round(classAverageTotals / studentsByExamScores.size(), 2);
        return classAverage;
    }

    public static Boolean addStudent(Student student){
      createMap(student);
      return studentsByExamScores.containsKey(student.getLastName() + ", " + student.getFirstName());
    }

    public Boolean removeStudent(Map<String, Double[]> studentsByExamScores, String firstName, String lastName){
        String key = lastName + ", " + firstName;
       for (Map.Entry<String, Double[]> mapElement : studentsByExamScores.entrySet()) {
           if (mapElement.getKey().equals(key)) {
               Double [] value = mapElement.getValue();
               studentsByExamScores.remove(key, value);
               studentsByExamScores.containsKey(key);
           }
       }
        return false;
    }

    public  Map<String, Double> getStudentsByAverages(Map<String, Double[]> studentsByExamScores){ //returns a map of students with their averages
       Map<String, Double> studentsByAverages = new LinkedHashMap<>();
        for (Map.Entry<String, Double[]> mapElement : studentsByExamScores.entrySet()) {
            String key = mapElement.getKey();
            Double[] testScores = mapElement.getValue();
            Double studentAverage = Student.getAverageExamScore2(testScores);
            studentsByAverages.put(key, studentAverage);
        }
          return studentsByAverages;
    }

    public Double findingThePointsToAdd (Map<String, Double> studentsByAverages){
        List<Double> listOfAverages = new ArrayList<>();
        for (Map.Entry<String, Double> mapElement : studentsByAverages.entrySet()) {
            Double studentAverage = mapElement.getValue();
            listOfAverages.add(studentAverage);
        }
        Double highestAverage = sorting(listOfAverages);
        Double pointsToAdd = 100.00 - highestAverage;
        return pointsToAdd;
    }

    public Double sorting(List<Double> listOfAverages){
        Double highest = MIN_VALUE;
        for (Double average : listOfAverages){
//            for (int index = 1; index < listOfAverages.size(); index++)
            if (average > highest){
                highest = average;
            }

        }
        return highest;
    }


    public Map<String, String> getGradeBook(Map<String, Double> mapOfStudent){
        Student [] sortedStudents = getStudentsByScore(students);
       Student studentWithTheHighest = sortedStudents[0];
      Double theCurve = findingTheCurveTheCurve(studentWithTheHighest);
      Map<Student, String> gradeBook = new LinkedHashMap<>();
      for (Student student : sortedStudents){
          Double studentAverage = student.getAverageExamScore(student.createList(student.getTestScores()));
          Double applyCurve = theCurve + studentAverage;
          String letterGrade = letterGrades(applyCurve);
          gradeBook.put(student, letterGrade);
      }
        return gradeBook;
    }



    public String letterGrades (Double grade){
        if(grade >= 90){
            return "A";
        }else if ((grade >= 71) || (grade <= 89)){
            return "B";
        }else if ((grade >= 50) || (grade <= 70)){
            return "C";
        }else if ((grade >= 49) || (grade <= 12)){
            return "D";
        }else{
            return "F";
        }
    }



}
