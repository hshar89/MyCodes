package mypack;
enum Day{
	MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY, SUNDAY;
	 private Day() 
    { 
        System.out.println("Constructor called for : " + 
        this.toString()); 
    } 
	private void printInfo(){
		 System.out.println("Universal Holiday"); 
	}
}
public class UsingEnums {
	Day day;
	public UsingEnums(Day day){
		this.day= day;
	}
     public void findDay(){
    	 switch(day){
    	 case MONDAY: 
             System.out.println("Mondays are bad."); 
             break; 
         case FRIDAY: 
             System.out.println("Fridays are better."); 
             break; 
         case SATURDAY: 
         case SUNDAY: 
             System.out.println("Weekends are best."); 
             break; 
         default: 
             System.out.println("Midweek days are so-so."); 
             break; 
    	 }
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String str = "MONDAY";
         UsingEnums e1 = new UsingEnums(Day.valueOf(str));
         e1.findDay();
	}

}
