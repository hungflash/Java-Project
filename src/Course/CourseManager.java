package Course;

/**
 *
 * @author Khue Nguyen
 */
public class CourseManager implements Comparable<CourseManager> {

    private String code;
    private String name;
    private int credit;

    public CourseManager() {
    }

    public CourseManager(String code, String name, int credit) {
        this.code = code;
        this.name = name;
        this.credit = credit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return String.format(" %-30s|  %-30s | %-30d", code, name, credit);
    }

    @Override
    public int compareTo(CourseManager o) {
        return this.credit - o.getCredit();
    }
}
