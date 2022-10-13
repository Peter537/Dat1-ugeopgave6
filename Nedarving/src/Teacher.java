import java.util.ArrayList;

public class Teacher extends Person {

    private final ArrayList<String> canTeach;
    private final ArrayList<String> currentCourses;

    public Teacher(String name, ArrayList<String> canTeach) {
        super(name);
        this.canTeach = canTeach;
        this.currentCourses = new ArrayList<>();
    }

}