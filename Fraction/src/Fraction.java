
public class Fraction {
    private int num;
    private int denom;

    public int getDenom() {
        return denom;
    }

    public void setDenom(int denom) {
        this.denom = denom;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public Fraction(){

    }
    public Fraction(int num,int denom){
        this.num=num;
        this.denom=denom;
    }


    public String toString() {
        String p=(num+"/"+denom);
        return p;
    }
    public Fraction add(Fraction x){
        Fraction m=new Fraction();
        m.num=(this.num*x.denom)+(this.denom*x.num);
        m.denom=(this.denom* x.denom);
        return m;
    }
    public Fraction sub(Fraction x){
        Fraction m=new Fraction();
        m.num=(this.num*x.denom)-(this.denom*x.num);
        m.denom=(this.denom* x.denom);
        return m;
    }
    public Fraction mul(Fraction x){
        Fraction m=new Fraction();
        m.num=(this.num*x.num);
        m.denom=(this.denom*x.denom);
        return m;
    }
    public Fraction div(Fraction x){
        Fraction m=new Fraction();
        m.num=(this.num*x.denom);
        m.denom=(this.denom*x.num);
        return m;
    }
    public String simplify(){
        int i;
        if (this.denom>this.num){
             i=this.denom;
        }else {
            i=this.num;
        }
        while (!(this.num%i==0 && this.denom%i==0) && i!=0){
            i--;

        }
        this.num=this.num/i;
        this.denom=this.denom/i;
        return this.toString();
    }
    public static void main(String[] args) {
        Fraction c = new Fraction(3, 2);
        Fraction d = new Fraction(1, 7);
        Fraction e,f;

        e = c.add(d);
        System.out.println(">>Add" +c+" +"+d+"="+ e);
        f=e;
        e=c.sub(d).add(e);
        System.out.println(">>Result" +c+" - "+d+"+"+(c.add(d))+"="+ e);
        e=e.add(c.add(d));
        System.out.println(">>Reduced form" + e.simplify());

        System.out.println(">>Result" +e+" + ("+c+"+"+d+")="+ e);

        e = c.mul(d);
        System.out.println(">>Multiplication" +c+"*"+d+"="+ e);
        e = c.div(d);
        System.out.println(">>Division" +c+"/"+d+"="+ e);
        System.out.println(">>Reduced form" + e.simplify());
        Fraction g=new Fraction(400,3);
        System.out.println(g.num+"/"+g.denom+"="+g.simplify());
}}
