public class Student extends Person{
    String StudentId;
    int enrolledSemester;
    public Student (String n,int y,String s,int e){
        super(n,y);
        StudentId=s;
        enrolledSemester=e;
    }

    @Override
    public String toString() {
        return "Student{"+
        "name='" + name + '\'' +
                ", year_of_birth=" + year_of_birth+" "+
                "StudentId='" + StudentId + '\'' +
                ", enrolledSemester=" + enrolledSemester +
                '}';
    }
    public String diplay(){
        return toString();
    }
}

