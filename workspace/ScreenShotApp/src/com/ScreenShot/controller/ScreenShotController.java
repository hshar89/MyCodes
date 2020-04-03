package com.ScreenShot.controller;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.poi.EmptyFileException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.ScreenShot.Launcher.MainApp;

import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.Mnemonic;

public class ScreenShotController {

	private XWPFDocument docx;
	private XWPFParagraph paragraph;
	private XWPFRun run;
	private FileOutputStream out;
	private static ScreenShotController ssc;
	private String fileName;
	private String filePath;
	private boolean isScreenShotTaken;
	public Mnemonic mnemonicScreenShotButton;
	
	public boolean getIsScreenShotTaken() {
		return this.isScreenShotTaken;
	}
	private ScreenShotController() {
		isScreenShotTaken = false;
	}
    
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFilePath(String path) {
		this.filePath = path;
	}

	public void initializeFile() {
		try {
			System.out.println("Initialzing file");
			System.out.println("FileName: "+(filePath+fileName));
			File file = new File(filePath+fileName);
			System.out.println("file: "+file);
			FileInputStream fis = new FileInputStream(file);
			System.out.println("created input file stream: "+fis);
			docx = new XWPFDocument(OPCPackage.open(fis));
			System.out.println("docx took existing file: " + docx);
		} catch (IOException e) {
			System.out.println("Failed to create file");
		} catch (EmptyFileException e) {
			MainApp.showAlert(AlertType.INFORMATION,MainApp.primaryStage,"File Found","Empty File Found");
			System.out.println("Empty file found###");
		} catch (Exception e) {
			MainApp.showAlert(AlertType.ERROR,MainApp.primaryStage,"File Exception",e.getMessage());
			System.out.println("Unknown Exception caught");
			e.printStackTrace();
		} finally {
			if(docx == null) {
				docx = new XWPFDocument();
			}
			paragraph = docx.createParagraph();
			run = paragraph.createRun();
			paragraph.setAlignment(ParagraphAlignment.CENTER);
			try {
				out = new FileOutputStream(filePath+"\\"+fileName);
			} catch (FileNotFoundException e) {
				System.out.println("Output stream not generated");
				e.printStackTrace();
			}
		}

	}
    
	public void clickScreenShot() 
    { 
        try { 
        	isScreenShotTaken = true;
            Robot r = new Robot();            
            String screenShotName = System.currentTimeMillis()+".jpeg";           
            // Used to get ScreenSize and capture image 
            Rectangle capture =  
            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());    
            
            BufferedImage Image = r.createScreenCapture(capture); 
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(Image, "jpeg", baos);
            baos.flush();
            ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
            baos.close();           
            //Adding a page before inserting the captured screenshots
            run.addBreak();         
            //Inserting the screenshot 
            run.addPicture(bis, XWPFDocument.PICTURE_TYPE_JPEG, screenShotName, Units.toEMU(450), Units.toEMU(350));
            bis.close();
            System.out.println("Screenshot saved"); 
        } 
        catch (AWTException | IOException ex) { 
            System.out.println(ex); 
        } catch (InvalidFormatException e) {
			e.printStackTrace();
		} 
    }
	
	public void closeOutputStream() {
		try {
			try {
				docx.write(out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			isScreenShotTaken = false;
			MainApp.primaryStage.close();
		}
	}
	
	public void addScreenshotCommentToFile(String text) {
		run.addBreak(BreakType.TEXT_WRAPPING);
		run.setText(text);
	}

	public static ScreenShotController getInstance() {
		if (ssc == null) {
			ssc = new ScreenShotController();
		}
		return ssc;
	}
}
