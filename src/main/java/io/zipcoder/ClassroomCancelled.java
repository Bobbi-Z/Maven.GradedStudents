package io.zipcoder;

import org.decimal4j.util.DoubleRounder;
import java.util.*;

import static java.lang.Double.MIN_VALUE;

public class ClassroomCancelled {

   private static Map<String, Double> studentsByAverages = new LinkedHashMap<>(30, 1, false);
    private static Map<String, Double []> studentsByExamScores = new LinkedHashMap<>(30, 1, false);
    private Integer numberOfStudents;

    public ClassroomCancelled() {

    }

    public ClassroomCancelled(Map<String, Double []> studentsByExamScores, Integer numberOfStudents) {
            setStudentsByExamScores(studentsByExamScores);
            this.numberOfStudents = numberOfStudents;
    }

    public static Map<String, Double[]> getStudentsByExamScores() {
        return studentsByExamScores;
    }

    public static void setStudentsByExamScores(Map<String, Double[]> studentsByExamScores) {
        ClassroomCancelled.studentsByExamScores = studentsByExamScores;
    }

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Map<String, Double []> studentsByExamScores) {
        numberOfStudents = studentsByExamScores.size();
    }

    public static Map<String, Double[]> createMap(Map<String, Double []> studentsByExamScores, Student student){
//        studentsByExamScores = new LinkedHashMap<>();
        String key = student.getLastName() + ", " + student.getFirstName();
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

    public static Boolean addStudent(Map<String, Double []> studentsByExamScores, Student student){
      createMap(studentsByExamScores, student);
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

        for (Map.Entry<String, Double[]> mapElement : studentsByExamScores.entrySet()) {
            String key = mapElement.getKey();
            Double[] testScores = mapElement.getValue();
            Double studentAverage = Student.getAverageExamScore2(testScores);
            studentsByAverages.put(key, studentAverage);
        }
          return studentsByAverages;
    }

    public Double findingThePointsToAdd ( Map<String, Double> studentsByAverages){
        List<Double> listOfAverages = new ArrayList<>();
        for (Map.Entry<String, Double> mapElement : studentsByAverages.entrySet()) {
            Double studentAverage = mapElement.getValue();
            listOfAverages.add(studentAverage);
        }
        Double highestAverage = findingTheHighest(listOfAverages);
        Double pointsToAdd = 100.00 - highestAverage;
        return pointsToAdd;
    }

    public Double findingTheHighest(List<Double> listOfAverages){
        Double highest = MIN_VALUE;
        for (Double average : listOfAverages){
            if (average > highest){
                highest = average;
            }
        }
        return highest;
    }

    public Map<String, Double> addingTheCurve(Map<String, Double> studentsByAverages){
        for (Map.Entry<String, Double> mapElement : studentsByAverages.entrySet()) {
            Double studentAverage = mapElement.getValue();
            Double theCurve = studentAverage + findingThePointsToAdd(studentsByAverages);
            String key = mapElement.getKey();
            studentsByAverages.put(key, theCurve);
        }
        sortByAverage(studentsByAverages);
        return studentsByAverages;
    }

    public Map<Double, String> sortByAverage(Map<String, Double> studentsByAverages){
        Map<Double, String> studentsArrangedByAverage = new TreeMap<>();
        for (Map.Entry<String, Double> mapEntry : studentsByAverages.entrySet()){
            String value = mapEntry.getKey();
            Double key = mapEntry.getValue();
            studentsArrangedByAverage.put(key, value);
        }
        getGradeBook(studentsArrangedByAverage);
        return studentsArrangedByAverage;
    }


    public Map<String, String> getGradeBook(Map<Double, String> studentsArrangedByAverage){
      Map<String, String> gradeBook = new LinkedHashMap<>();
      for (Map.Entry<Double, String> entrySet : studentsArrangedByAverage.entrySet()){
         String key = entrySet.getValue();
         Double value = entrySet.getKey();
         String newValue = letterGrades(value);
         gradeBook.put(key, newValue);
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
