package Test1;

import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedCommunicationTest {

	public static void main(String[] args) {
		
		new PipedCommunicationTest();
	}
	public PipedCommunicationTest() {
		try {
			PipedReader pr = new PipedReader();
			PipedWriter pw = new PipedWriter();
			
			pw.connect(pr);
			Thread t1 = new Thread(new PipeReaderThread(pr,"reader"));
			Thread t2 = new Thread(new PipedWriterThread(pw,"writer"));
			t1.start();
			t2.start();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
