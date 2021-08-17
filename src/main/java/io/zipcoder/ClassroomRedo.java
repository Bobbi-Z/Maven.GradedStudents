package io.zipcoder;

import org.decimal4j.util.DoubleRounder;

import java.util.*;

public class ClassroomRedo {


    private Student [] students;

    public ClassroomRedo(int numOfStudents){
        this.students = new Student[numOfStudents];
    }

    public ClassroomRedo (Student[] students){
        this.students = students;
    }

    public ClassroomRedo() {
        this.students = new Student [30];
    }

    public Student [] getStudents (){
        return students;
    }

    public Double getAverageExamScore(){
        Double classAverages = 0.00;
    for (Student student : students){
      Double studentAverage =  Student.getAverageExamScore2(student.getTestScores());
      classAverages += studentAverage;
    }
    Double classTotalAverage = classAverages / students.length;
    return classTotalAverage;
    }

    public Boolean addStudent(Student student){
        List<Student> studentsAsList = new ArrayList<>(Arrays.asList(students));
        studentsAsList.add(student);
        students = studentsAsList.toArray(new Student[0]);
        return studentsAsList.contains(student);
    }

    public Boolean removeStudent (String firstName, String lastName){
        List<Student> studentsAsList = new ArrayList<>(Arrays.asList(students));
        for(int index = 0; index < studentsAsList.size(); index++){
            Student current = students[index];
            if (current.getFirstName().equals(firstName) && current.getLastName().equals(lastName)){
                Student removed = current;
               studentsAsList.remove(current);
               students = studentsAsList.toArray(new Student[0]);
                return studentsAsList.contains(removed);
            }

        }
        return false;
    }

    public Student [] getStudentByScore(Student [] students){
        List<Student> sorted = Arrays.asList(students);
        Comparator<Student> byScore = Comparator.comparing(Student :: getAverageExamScore3);
        Comparator<Student> byLastName = Comparator.comparing(Student :: getLastName);
        Comparator<Student> byFirstName = Comparator.comparing(Student :: getFirstName);
        sorted.sort(byScore.thenComparing(byLastName.thenComparing(byFirstName)));
        Collections.reverse(sorted);
        students = sorted.toArray(new Student[0]);
        return students;
    }

    public Map<Student, String> getGradeBook(Student [] students){
        Map<Student, String> gradeBook = new LinkedHashMap<>();
        Student [] sortedStudents = getStudentByScore(students);
        Double curve = findingTheCurveToAdd(students);
        for(Student student : sortedStudents){
            Double studentAverageWithCurve = Student.getAverageExamScore3(student) + curve;
            String value = letterGrades(studentAverageWithCurve);
            gradeBook.put(student, value);
        }
        return gradeBook;
    }

    public Double findingTheCurveToAdd(Student [] students){
        Student personWithTheHighestAverage = students[0]; //already sorted w/i  getGradeBook()
        Double highestAverage = Student.getAverageExamScore3(personWithTheHighestAverage);
        Double curveToAdd = DoubleRounder.round(100 - highestAverage, 2);
        return curveToAdd;
    }



    public static String letterGrades(Double grade){
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
