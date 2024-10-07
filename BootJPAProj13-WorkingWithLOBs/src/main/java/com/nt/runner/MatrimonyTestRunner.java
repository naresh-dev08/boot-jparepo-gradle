package com.nt.runner;

import java.io.FileOutputStream;
import java.io.FileWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.MarriageSeeker;
import com.nt.service.IMatrimonyMgmtService;


@Component
public class MatrimonyTestRunner implements CommandLineRunner {

	@Autowired
	private IMatrimonyMgmtService marriageService;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*try(Scanner sc = new Scanner(System.in)){
			
			System.out.println("Enter Name::");
			String name = sc.next();
			
			System.out.println("Enter address::");
			String addrs = sc.next();
					
			System.out.println("Enter DOB (yyyy-MM-ddThh:mm:ss)::");
			String dob = sc.next();
			LocalDateTime ldob = LocalDateTime.parse(dob);
			
			System.out.println("Is the customer indian?");
			boolean indian = sc.nextBoolean();
			
			System.out.println("Enter photo file path::");
			String photoPath = sc.next();
			
			System.out.println("Enter resume file path::");
			String resumePath = sc.next();
			
			//create streams representing photo file and resume file
			//create byte[] and char[] having data
			FileInputStream fis = new FileInputStream(photoPath);
			byte[] photoContent = fis.readAllBytes();
			
			
			File file = new File(resumePath);
			FileReader reader = new FileReader(file);
			char[] resumeContent = new char[(int) file.length()];
			reader.read(resumeContent);
			
			//create model/entity class obj
			MarriageSeeker seeker = new MarriageSeeker(name, addrs, ldob, photoContent, resumeContent, indian);
			
			//save the obj
			System.out.println(marriageService.registerMarriageSeeker(seeker));
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
       try{
		   //load obj operation
    	   MarriageSeeker seeker = marriageService.getMarraigeSeekerById(1L);
    	   System.out.println(seeker.getMid()+" "+seeker.getName()+" "+seeker.getAddrs()+" "+seeker.getDob());
    	   byte[] photoContent = seeker.getPhoto();
    	   char[] resumeContent = seeker.getResume();
    	   
			 //write the content to destination files
			 FileOutputStream fos = new FileOutputStream("retrieve_photo.jpg");
			// fos.write(seeker.getPhoto());
			 fos.write(photoContent);
			 fos.flush();
			 fos.close();
			 
			 
			 FileWriter writer = new FileWriter("retrieve_resume.txt");
			 // writer.write(seeker.getResume());
			 writer.write(resumeContent);
			 writer.flush();
			 writer.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}//run()

}//class
