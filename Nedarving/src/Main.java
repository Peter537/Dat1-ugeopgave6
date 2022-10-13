import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Person> persons = new ArrayList<>();

        persons.add(new Teacher("John", new ArrayList<>() {
            {
                add("Math");
                add("Physics");
            }
        }));
        persons.add(new Teacher("Jørn", new ArrayList<>() {
            {
                add("Math");
                add("Java 1.0");
            }
        }));

        Student student1 = new Student("Peter");
        student1.addCourse("Math");
        student1.addCourse("Physics");
        student1.addCourse("Java 1.0");
        student1.addCourse("Java 1.0");

        Student student2 = new Student("Oskar");
        student2.addCourse("Math");
        student2.addCourse("Java 1.0");

        persons.add(student1);
        persons.add(student2);





    }
}