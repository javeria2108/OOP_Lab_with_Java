import java.util.ArrayList;

public class Faculty extends Employee{
    ArrayList <String> CourseId=new ArrayList<String>();

    public Faculty(String n, int y, String e, int J, String j,String C) {
        super(n, y, e, J, j);
        CourseId.add(C);
    }
    public void setCourseId(ArrayList c){
        CourseId=c;
    }
    public ArrayList getCourseID(){
        return CourseId;
    }

    @Override
    public void calcPay() {
        int P=4000*(2022-JoiningYear);
        System.out.println(P);

    }
    public String toString() {
        return "Faculty{" + "name='" + name + '\'' +
                ", year_of_birth=" + year_of_birth+
                " employeeID='" + employeeID + '\'' +
                ", JoiningYear=" + JoiningYear +
                ", jobTitle='" + jobTitle + '\'' +
                ", CourseList= "+ getCourseID()+
                '}';
    }
}
