import dev.lpa.util.QueryList;
import model.Student;
import model.StudentComparator;

public class Main {

    public static void main(String[] args) {

        QueryList<Student> queryList = new QueryList<>();

        for (int i = 0; i < 2500; i++) {
            queryList.add(new Student());
        }

        queryList.sort(new StudentComparator());
        queryList.printList();
        var matches = queryList
                .getMatches("course", "C")
                .getMatches("percent_completed", "50");
        matches.printList();
    }
}
