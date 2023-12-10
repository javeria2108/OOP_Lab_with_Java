public class Driver {
    public static void main(String[] args) {
        Student s1=new Student("Harry",1996,"G-22",3);
        System.out.println(s1);
        Student s2=new Student("Hermione",1996,"G-23",3);
        System.out.println(s2);
        Student s3=new Student("Ron",1996,"G-24",3);
        System.out.println(s3);
        Administartion A=new Administartion("Hagrid",1960,"E-111",1994,"GroundKeeper");
        System.out.println(A);
        A.calcPay();
        Faculty f1=new Faculty("snape",1970,"F-4565",1995,"SlytherinHead","Defense against the dark arts");
        f1.CourseId.add("Potions");
        System.out.println(f1);
        f1.calcPay();
        Faculty f2=new Faculty("McGonagall",1965,"F-7676",1993,"GryffindorHead","Transfiguration");
        System.out.println(f2);
        f2.calcPay();

    }
}
