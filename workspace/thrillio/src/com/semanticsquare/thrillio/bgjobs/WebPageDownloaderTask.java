package com.semanticsquare.thrillio.bgjobs;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.semanticsquare.thrillio.dao.BookmarkDao;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.Weblink;
import com.semanticsquare.thrillio.util.HttpConnect;
import com.semanticsquare.thrillio.util.IOUtil;

public class WebPageDownloaderTask implements Runnable{
    private static BookmarkDao dao = new BookmarkDao();
    private static final long TIME_FRAME =3000000000l;
    private boolean downloadAll = false;
    ExecutorService downloadExecutor = Executors.newFixedThreadPool(5);
    
    private static class Downloader<T extends Weblink> implements Callable<T> {
		private T weblink;
		public Downloader(T weblink) {
			this.weblink = weblink;
		}
		public T call() {
			try {
			 if(weblink.getUrl().endsWith(".pdf")) {
				weblink.setDownloadStatus(Weblink.DownloadStatus.FAILED);
				String htmlPage = HttpConnect.download(weblink.getUrl());
				weblink.setHtmlPage(htmlPage);		
			 }else {
				 weblink.setDownloadStatus(Weblink.DownloadStatus.NOT_ELIGIBLE); 
			 }
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return weblink;
		}
	}
    
	public WebPageDownloaderTask(boolean downloadAll) {
		// TODO Auto-generated constructor stub
		this.downloadAll = downloadAll;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!Thread.currentThread().isInterrupted()) {
			//Get Weblinks
			List<Weblink> webLinks = getWeblinks();
			//Download Concurrently
			if(webLinks.size()>0) {
				download(webLinks);
			}else {
				System.out.println("No new Web Links to download!!");
			}
			//Wait
			try {
				TimeUnit.SECONDS.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		downloadExecutor.shutdown();
	}
	private void download(List<Weblink> webLinks) {
		List<Downloader<Weblink>> tasks = getTasks(webLinks);
		List<Future<Weblink>> futures= new ArrayList<>();
		try {
			futures = downloadExecutor.invokeAll(tasks,TIME_FRAME,TimeUnit.NANOSECONDS);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		for(Future<Weblink> future: futures) {
			try {
				if(!future.isCancelled()) {
					Weblink weblink = future.get();
					String webPage = weblink.getHtmlPage();
					if(webPage!=null) {
						IOUtil.write(webPage, weblink.getId());
						weblink.setDownloadStatus(Weblink.DownloadStatus.SUCCESS);
						System.out.println("Download Success: "+weblink.getUrl());
					}else {
						System.out.println("Webpage not downloaded: "+weblink.getUrl());
					}
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}catch(ExecutionException e) {
				e.printStackTrace();
			}
		}
		
	}
	private List<Downloader<Weblink>> getTasks(List<Weblink> webLinks) {
		List<Downloader<Weblink>> tasks = new ArrayList<>();
		for(Weblink weblink: webLinks) {
			tasks.add(new Downloader<Weblink>(weblink));
		}
		return tasks;
	}
	private List<Weblink> getWeblinks() {
		List<Weblink> weblinks = null;
		if(downloadAll) {
			weblinks = dao.getAllWeblinks();
			downloadAll = false;
		}else {
			weblinks = dao.getWebLinks(Weblink.DownloadStatus.NOT_ATTEMPTED);
		}
		return weblinks;
	}

}
