package com.example.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
@Component
public class PdfGenerator {

	private static final String FILE_NAME="C:\\springbootproject\\web-application\\pdfdocs";
	
	public void writeUsingText() {
		
		Document document = new Document();
		
		try {
			
			PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
			
			document.open();
			
			Paragraph p = new Paragraph();
			p.add("This is my paragraph 1");
			p.setAlignment(Element.ALIGN_CENTER);
			document.add(p);
			
			Paragraph p2 = new Paragraph();
			p2.add("This is my paragraph 2");
			document.add(p2);
			
			Font f = new Font();
			f.setStyle(Font.BOLD);
			f.setSize(8);
			document.add(new Paragraph("This my paragraph 3",f));
			
			document.close();
			
			System.out.println("DONE");
			
		} catch (FileNotFoundException |DocumentException e) {
			e.printStackTrace();
			
		}
	}
}
