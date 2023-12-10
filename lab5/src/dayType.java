public class dayType
{   private String day;
    String[] days={"Mon","Tues","Wed","Thurs","Fri","Sat","Sun"};


    public void setDay(String day) {
        this.day = day;
    }
    public String getDay(){
        return day;

    }
    public void print(){
        System.out.println("current day is: "+ day);
    }
    public String nextDay(){
        String nextDay=new String();
        int index=0;
        while (!days[index].equals(day)){
            index++;
        }
        if (index==6){
            nextDay="Mon";

        }
        else
        {nextDay=days[index+1];}



        return nextDay;

    }

    public String previousDay(){
        int index=0;
        String PrevDay=new String();
        while (!days[index].equals(day)){
            index++;
        }
        if (index==0){
            PrevDay="Sun";

        }
        else
        {PrevDay=days[index-1];}

        return PrevDay;

    }
    public String addDay(int num){
        int index=0;
        String addDay=new String();
        while (!days[index].equals(day)){
            index++;
        }
        if (index+(num%7)>=(days.length)){
            int num2=num%7;
            num2=num2-((days.length)-index);
            index=0;
            addDay=days[index+num2];

        }
        else {
            addDay = days[index + (num % 7)];
        }
        return addDay;
    }

    public static void main(String[] args) {
        dayType day1=new dayType();
        day1.setDay("Mon");
        System.out.println("current day: "+day1.getDay());
        System.out.println("Previous Day: "+day1.previousDay());
        System.out.println("Next Day: "+day1.nextDay());
        System.out.println("Add days: "+day1.addDay(19));

    }

}
