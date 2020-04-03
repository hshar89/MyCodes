package Test1;

import java.io.PipedWriter;

public class PipedWriterThread implements Runnable{
  
	private PipedWriter pw;
	
    String name = null;
    
    public PipedWriterThread(PipedWriter pw, String name) {
    	this.name = name;
    	this.pw = pw;
    }

	@Override
	public void run() {
		try {
			while(true) {
				String s = "Write some bulshit text here....\n";
				pw.write(s);
				pw.flush();
				Thread.sleep(2000);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
