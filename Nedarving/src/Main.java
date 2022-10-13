import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();

        ArrayList<String> canTeach = new ArrayList<>();
        canTeach.add("Computer Science");
        canTeach.add("Java 1.0");

        persons.add(new Teacher("John", new ArrayList<>()));
        persons.add(new Teacher("Jørn", canTeach));

        ArrayList<String> passedCourses = new ArrayList<>();
        passedCourses.add("Math");
        passedCourses.add("Java 1.0");

        persons.add(new Student("Peter", passedCourses));
        persons.add(new Student("Oskar", passedCourses));
        persons.add(new Student("Magnus", new ArrayList<>()));

        for (Person p : persons) {
            if (!p.addCourse("Java 1.0")) {
                if (p instanceof Student) {
                    System.out.println(p.getName() + " har allerede bestået dette kursus.");
                } else {
                    System.out.println(p.getName() + " kan ikke undervise i dette fag");
                }
            }
        }
    }
}