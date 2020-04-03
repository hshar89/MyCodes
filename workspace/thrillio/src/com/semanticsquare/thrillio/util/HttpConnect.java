package com.semanticsquare.thrillio.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpConnect {
   public static String download(String sourceurl) throws MalformedURLException, URISyntaxException{
	   System.out.println("Downloading: "+sourceurl);
	   URL url = new URI(sourceurl).toURL();
	   try {
		   HttpURLConnection con = (HttpURLConnection)url.openConnection();
		   int responseCode = con.getResponseCode();
		   if(responseCode>=200 && responseCode<300) {
			   System.out.print("Returned successful download");
			   return IOUtil.read(con.getInputStream());
		   }
	   }catch(IOException e) {
		   e.printStackTrace();
	   }
	   return null;
   }
}
