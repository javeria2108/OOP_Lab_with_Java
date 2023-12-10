public abstract class Employee extends Person {
    String employeeID;
    int JoiningYear;
    String jobTitle;
    public Employee(String n, int y,String e,int J,String j){
        super(n,y);
        employeeID=e;
        jobTitle=j;
        JoiningYear=J;
    }
    public abstract void calcPay();

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' +
                ", year_of_birth=" + year_of_birth+
                " employeeID='" + employeeID + '\'' +
                ", JoiningYear=" + JoiningYear +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
