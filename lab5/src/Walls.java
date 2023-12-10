import java.util.Scanner;

public class Walls {
    private static String Flavor="Vanilla";
    private static int No_of_scoops=1;
    private static String ConeType="Sugar";
    private static int PriceField;

    public  void setFlavor(String flavor) {
        this.Flavor = flavor;
    }

    public void setNo_of_scoops(int no_of_scoops) {
        this.No_of_scoops = no_of_scoops;
    }

    public void setConeType(String coneType) {
        this.ConeType = coneType;
    }

    public int getNo_of_scoops() {
        return No_of_scoops;
    }

    public int getPriceField() {
        return PriceField;
    }
    public Walls(){
        PriceField=No_of_scoops*75;
        if (ConeType.equals("Waffle")){
            PriceField+=40;
        }
    }

    public Walls(int no_of_scoops, String coneType){
        PriceField=no_of_scoops*75;
        if (ConeType.equals("Waffle")){
            PriceField+=40;
        }
    }
    public String toString(){
        String p= "Your cone type is: "+ ConeType+
                "\n Your chosen flavor is: "+ Flavor+
                "\n No of scoops is: "+ No_of_scoops+
                "\n Hence ur total price is: "+PriceField;
        return p;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose a flavor:\n" +
                "1: chocolate\n" +
                "2: vanilla\n" +
                "3: strawberry\n" +
                "4: mango\n" +
                "5: tutti frutti\n" +
                "6: almond crunch\n" +
                "7: coffee\n" +
                "8: default\n"
        );
        int flavor= sc.nextInt();
        switch (flavor){
            case 1:
                Walls.Flavor="chocolate";
                break;
            case 2:
                Walls.Flavor="vanilla";
                break;
            case 3:
                Walls.Flavor=("strawberry");
                break;
            case 4:
                Walls.Flavor=("mango");
                break;
            case 5:
                Walls.Flavor=("tutti frutti");
                break;
            case 6:
                Walls.Flavor=("almond crunch");
                break;
            case 7:
                Walls.Flavor=("coffee");
                break;
            case 8:
                break;
        }
        System.out.println("Choose number of scoops:" +
                "1: one\n" +
                "2: two\n" +
                "3: three\n" +
                "4: default\n");
        int noOfScoops= sc.nextInt();
        switch (noOfScoops){
            case 1:
                Walls.No_of_scoops=(1);
                break;
            case 2:
                Walls.No_of_scoops=(2);
                break;
            case 3:
                Walls.No_of_scoops=(3);
                break;
            case 4:
                break;
        }
        System.out.println("Choose Cone Type:" +
                "1: Sugar\n" +
                "2: Waffle\n" +
                "3: Pretzel\n" +
                "4: default\n");
        int conetype=sc.nextInt();
        switch (conetype){
            case 1:
                Walls.ConeType=("Sugar");
                break;
            case 2:
                Walls.ConeType=("Waffle");
                break;
            case 3:
                Walls.ConeType=("Pretzel");
                break;
            case 4:
                break;
        }
        Walls walls=new Walls();
        System.out.println(walls);
    }


}
