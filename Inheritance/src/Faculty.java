public class Faculty extends Employee {
    protected String designation;
    protected String department;
    protected int years_of_education;
    public Faculty(){
        super();
        designation="Manager";
        department="Accounting";
        years_of_education=17;


    }
    public Faculty(String n,String a,int E,float p,float h,float m,String d,String dept,int y){
        super(n,a,E,p,h,m);
        designation=d;
        department=dept;
        years_of_education=y;
    }

    public float calcSalary(){
        float p=super.calcSalary();
        float pp=0;
        if (years_of_education<16){
            pp=0;
        } else if (years_of_education==16) {
            pp=1500;
        } else if (years_of_education==20) {
            pp=2000;
        } else if (years_of_education>25) {
            pp=3000;
        }
        return p+pp;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "designation='" + designation + '\'' +
                ", department='" + department + '\'' +
                ", years_of_education=" + years_of_education +
                "name: "+name +"\n" +"address: "+ address+
                "Emp_no=" + Emp_no +
                ", pay=" + pay +
                ", house_rent=" + house_rent +
                ", medical_allow=" + medical_allow +'}';

    }
}
