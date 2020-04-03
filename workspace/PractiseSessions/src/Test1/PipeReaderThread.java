package Test1;

import java.io.PipedReader;

public class PipeReaderThread implements Runnable{
	private PipedReader pr;
	String name = null;
	
	public PipeReaderThread(PipedReader pr,String name) {
		this.pr = pr;
		this.name = name;
	}

	@Override
	public void run() {

		try {
			while(true) {
				char c = (char)pr.read();
				if(c!=-1) {
					System.out.print(c);
				}
			}
		}catch(Exception e) {
			System.out.println("Piped Reader Exception ");
		}
		
	}
}
