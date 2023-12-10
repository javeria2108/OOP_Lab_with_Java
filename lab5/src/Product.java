public class Product {
    private String name;
    private int price;
    private int quantity;
    private static int totalProduct;
    public Product(){
        name="Nike shoes";
        quantity=2;
        price=7000;
        this.counter();

    }
    public Product(String name,int quantity){
        this.counter();
        this.name=name;
        this.quantity=quantity;
        price=7000;

    }
    public Product(String name, int quantity,int price){
        this.quantity=quantity;
        this.name=name;
        this.price=price;
        this.counter();
    }
    public void getData(){
        System.out.println("name of product: "+name+
                "\n price of product: "+price+
                "\n quantity: "+ quantity);
    }
    public void counter(){
        totalProduct++;
    }
    public static int countProduct(){
        return totalProduct;
    }

    public static void main(String[] args) {
        Product product=new Product();
        product.getData();
        Product product1=new Product("Black Hoodie",3,8000);
        product1.getData();
        System.out.println(Product.countProduct());
    }

}

