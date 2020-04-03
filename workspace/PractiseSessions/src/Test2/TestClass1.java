package Test2;

import java.util.Date;

public class TestClass1 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Date d1 = new Date(System.currentTimeMillis()+10000);
		RandomObject ro = new RandomObject(1,"Testy");
		DateMutability dm = new DateMutability(d1,ro);
		Date d2 = dm.getRemindingDate();
		RandomObject ro2 = dm.getRandomObject();
		ro2.setName("Kafi Testy");
		RandomObject ro3 = dm.getRandomObject();
		System.out.println(ro3.getName());

	}

}
