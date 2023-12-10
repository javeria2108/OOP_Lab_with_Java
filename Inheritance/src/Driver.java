public class Driver {
    public static void main(String[] args) {
        Employee e=new Employee("Sherlock","221B Baker's Street",2,200000,0.5F,0.2F);
        System.out.println(e);
        System.out.println(e.calcSalary());
        Faculty f=new Faculty("Sherlock","221B Baker's Street",2,200000,0.5F,0.2F,"Detective","private firm",16);
        System.out.println(f);
        System.out.println(f.calcSalary());
    }
}
