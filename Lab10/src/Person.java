public class Person {
    String name;
    int year_of_birth;
   public Person(String n,int y){
        name=n;
        year_of_birth=y;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", year_of_birth=" + year_of_birth +
                '}';
    }
}
