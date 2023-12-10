public class Administartion extends Employee{
    public Administartion(String n, int y, String e, int J, String j) {
        super(n, y, e, J, j);
    }

    @Override
    public void calcPay() {
        int P=5000*(2022-JoiningYear);
        System.out.println(P);
    }
    public void setJobtitle(String J){
        this.jobTitle=J;
    }
    public String getJobTitle(){
        return this.jobTitle;
    }
    public String toString() {
        return "Administration{" + "name='" + name + '\'' +
                ", year_of_birth=" + year_of_birth+
                " employeeID='" + employeeID + '\'' +
                ", JoiningYear=" + JoiningYear +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }

}
