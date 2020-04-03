package Test2;

import java.util.Date;

public final class DateMutability {
	
	private final Date remindingDate;
	
	private final RandomObject ro;
	
	public DateMutability (Date remindingDate,RandomObject ro) {
		if(remindingDate.getTime()<System.currentTimeMillis()) {
			throw new IllegalArgumentException("Cannot set reminder for past date "+remindingDate);
		}
		this.remindingDate = new Date(remindingDate.getTime());
		this.ro = ro;
	}
	public Date getRemindingDate() {
		return this.remindingDate;
	}
	public RandomObject getRandomObject() throws CloneNotSupportedException {
		return (RandomObject)ro.clone();
	}
	
}
