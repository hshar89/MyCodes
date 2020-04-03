package Test2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>>{
	
	private final String path;
	private final String extension;
	
	public FolderProcessor(String path, String extension) {
		this.path = path;
		this.extension = extension;
	}
	@Override
	protected List<String> compute() {
		List<String> lst = new ArrayList<String>();
		List<FolderProcessor> tasks = new ArrayList<FolderProcessor>();
		File file = new File(path);
		File content[] = file.listFiles();
		if(content!=null) {
			for(int i=0;i<content.length;i++) {
				if(content[i].isDirectory()) {
					FolderProcessor task = new FolderProcessor(content[i].getAbsolutePath(),extension);
					task.fork();
					tasks.add(task);
				}else {
					if(checkFile(content[i].getName())) {
						lst.add(content[i].getAbsolutePath());
					}
				}
			}
		}
		if(tasks.size()>50) {
			System.out.printf("%s: %d tasks ran.\n", file.getAbsolutePath(), tasks.size());
		}
		addResultsFromTask(lst,tasks);
		return lst;
	}
	private void addResultsFromTask(List<String> lst, List<FolderProcessor> tasks) {
		for(FolderProcessor item: tasks) {
			lst.addAll(item.join());
		}
		
	}
	private boolean checkFile(String name) {
		
		return name.endsWith(extension);
	}
	
}
