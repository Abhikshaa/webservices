package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.utility.PdfGenerator;

@SpringBootTest
class WebApplicationTests {
	
	

	@Test
	void contextLoads() {
		
		PdfGenerator pdf = new PdfGenerator();
		pdf.writeUsingText();
	}

}
