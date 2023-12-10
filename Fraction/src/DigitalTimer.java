
import java.text.DecimalFormat;


public class DigitalTimer {
    public Counter hr;
    public Counter min;
    public DigitalTimer(){
         hr=new Counter(24);
         min=new Counter(60);

    }
    public DigitalTimer(int hrs,int mins){
        hr=new Counter(24);
        min=new Counter(60);

        hr.set(hrs);
     min.set(mins);
    }

    public java.lang.String toString() {
        DecimalFormat fmt = new DecimalFormat("00"); // Use at least 2 digits


       return  fmt.format(hr.CValue)+":"+fmt.format(min.CValue);
    }
    public void tick(){
        min.tick();
        if (min.CValue==0){
            hr.tick();
        }
    }
    public void set(int hrs,int mins){
        hr.set(hrs);
        min.set(mins);
    }

}
