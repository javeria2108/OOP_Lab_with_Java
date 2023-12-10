public class Employee extends Person {
    protected int Emp_no;
    protected float pay;
    protected float house_rent;
    protected float medical_allow;
    public Employee(){
        super();
        Emp_no=1;
        pay=1000;
        house_rent= 0.05F;
        medical_allow=0.02F;
    }
    public Employee(String n,String a,int E,float p,float h,float m){
        super(n,a);
        Emp_no=E;
        pay=p;
        house_rent=h;
        medical_allow=m;
    }
    public float calcSalary(){
        float Salary=pay/(1+house_rent+medical_allow);
        return Salary;
    }

    @Override
    public String toString() {
        return "name: "+name +"\n" +"address: "+ address+
                "Emp_no=" + Emp_no +
                ", pay=" + pay +
                ", house_rent=" + house_rent +
                ", medical_allow=" + medical_allow ;
    }
}
