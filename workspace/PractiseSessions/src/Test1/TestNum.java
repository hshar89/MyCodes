package Test1;

public enum TestNum {
		TEST1(78){
			@Override
			public String color() {
				return "golden";
			}
		},
		TEST2(35){
			@Override
			public String color() {
				return "Gray";
			}
		},
		TEST3(46){
			@Override
			public String color() {
				return "Black";
			}
		},
		TEST4(23){
			@Override
			public String color() {
				return "Blue";
			}
		};
	public int value;
	
	public abstract String color();
	private TestNum(int value){
		this.value = value;
	}
	public String toString() {
		switch(this) {
		case TEST1:
			return "This is test1";
		case TEST2:
			return "This is test2";
		case TEST3:
			return "This is test3";
		case TEST4:
			return "This is test 4";
	}
		return "";
 }
}
