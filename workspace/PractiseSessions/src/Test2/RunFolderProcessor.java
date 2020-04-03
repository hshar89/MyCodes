package Test2;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class RunFolderProcessor {

	public static void main(String[] args) {
		
		ForkJoinPool pool = new ForkJoinPool();
		FolderProcessor documents = new FolderProcessor("C:\\Users\\harshsharma3\\Documents","docx");
		FolderProcessor pdfs = new FolderProcessor("C:\\Users\\harshsharma3\\Documents","pdf");
		pool.execute(documents);
		pool.execute(pdfs);
		do {
			System.out.printf("******************************************\n");
	         System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
	         System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
	         System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
	         System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
	         System.out.printf("******************************************\n");
	         try {
	        	 TimeUnit.SECONDS.sleep(1);
	         }catch(InterruptedException e) {
	        	 System.out.println(e.getMessage());
	         }
		}while((!documents.isDone()) || (!pdfs.isDone()));
		
		pool.shutdown();
		List<String> results;
		results = documents.join();
		System.out.printf("documents: %d files found \n",results.size());
		results = pdfs.join();
		System.out.printf("pds: %d files found \n",results.size());
		
	}

}
