import java.util.ArrayList;

public class Student extends Person {

    private final ArrayList<String> passedCourses;
    private final ArrayList<String> currentCourses;

    public Student(String name) {
        super(name);
        this.passedCourses = new ArrayList<>();
        this.currentCourses = new ArrayList<>();
    }

}