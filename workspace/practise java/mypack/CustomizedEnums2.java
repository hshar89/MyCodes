package mypack;
enum Weekdays{
	SUNDAY("Sunday Funday", true,7), 
	   MONDAY("Marketing Monday",false,1),
	   TUESDAY("Trendy Tuesday",false,2), 
	   WEDNESDAY("Wellness Wednesday",false,3),
	   THURSDAY("Thankful Thursday",false,4),
	   FRIDAY("Foodie Friday",false,5),
	   SATURDAY("Social Saturday", true,6);
	private String dayGreeting;
	private boolean isWeekend;
	private int weekNum;
	private Weekdays(String dayGreeting){
		this.dayGreeting = dayGreeting;
	}
	private Weekdays(String dayGreeting, Boolean isWeekend){
		this(dayGreeting);
		this.isWeekend = isWeekend;
	}
	private Weekdays(String dayGreeting, Boolean isWeekend,int weekNum){
		this(dayGreeting,isWeekend);
		this.weekNum = weekNum;
	}
    public String getDaysGreeting() {
	  return dayGreeting;
	  }
	  public boolean isWeekend() {
	  return isWeekend;
	  }
}
public class CustomizedEnums2 {
    private static void doYourTaskForWeekEnds(){
    	System.out.println("Relax and Enjoy! It's Weekend :)");
    }
    private static void doYourTaskForWeekDays(Weekdays weekdays){
    	 System.out.println("Ohh! It's a weekday. Have to work!");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Weekdays weekdays = Weekdays.THURSDAY;
      System.out.println(weekdays.getDaysGreeting());
      if (weekdays.isWeekend()) {
          doYourTaskForWeekEnds();
        } else {
          doYourTaskForWeekDays(weekdays);
        }
      
	}

}
