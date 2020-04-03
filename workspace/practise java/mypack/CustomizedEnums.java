package mypack;
enum TrafficSignal{
	 RED("STOP"), GREEN("GO"), ORANGE("SLOW DOWN"); 
	 private String action;
	 public String getAction(){
		 return this.action;
	 }
	 private TrafficSignal(String action){
		 this.action = action;
	 }
}
public class CustomizedEnums {
	TrafficSignal  sig;
    private CustomizedEnums(TrafficSignal ts){
    	this.sig = ts;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       TrafficSignal[] ts = TrafficSignal.values();
       for(TrafficSignal tss: ts){
    	   System.out.println("name"+tss.name()+" "+tss.getAction());
       }
	}
	

}
