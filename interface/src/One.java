
interface inter{}

class One {
}
class two extends One{}
class three extends One{}
class four extends two implements inter{}
class five extends four{}
class six extends three{}
class test{
    public static void main(String[] args) {
        inter inter=new four();
        One one=new five();
    }
}
