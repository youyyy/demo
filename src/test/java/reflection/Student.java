package reflection;

public class Student implements Cloneable,Comparable<Student>{
    private String sid;
    private String sname;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Student() {
    }

    public Student(String sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }

    @Override
    public Student clone() {
        Student s = null;
        try {
            s = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        s.sid = this.sid;
        s.sname = this.sname;
        return s;
    }

    @Override
    public int compareTo(Student o) {
        return this.sid.compareTo(o.sid);
    }
}
