public class TASKA {
    int x=9;
    void print(){
        System.out.println("hhahah");
    }

}
class V extends TASKA{
    void print(){
        System.out.println("sdsdds");
    }
}
class S extends V{
    int x=0;
    void print(){
        System.out.println("nopeee");
    }

    public static void main(String[] args) {
        TASKA a=new S();
        a.print();
        System.out.println(a.x);
    }
}
