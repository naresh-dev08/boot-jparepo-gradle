package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.repository.IDoctorRepository;
import com.nt.repository.IPatientRepository;

@Service("mtomService")
public class MToMAssociationMgmtServiceImpl implements IMToMAssociationMgmtService {

	@Autowired
	private IDoctorRepository doctorRepo;
	
	@Autowired
	private IPatientRepository patientRepo;
	
	
	@Override
	public void saveDataUsingDoctor() {
		try {
		
		Doctor doc1 = new Doctor("Suresh", "Physican");
		Doctor doc2 = new Doctor("Raju", "Ortho");
		
		Patient pat1 =  new Patient("Kiran", 40, "Heart");
		Patient pat2 =  new Patient("Ramesh", 34, "Kidney");
		Patient pat3 =  new Patient("Ram", 45, "BP");
		Patient pat4 =  new Patient("Raghu", 43, "Stomach");
		
		//add patient to doctors
		/*doc1.setPatients(List.of(pat1, pat2));
		doc2.setPatients(List.of(pat3, pat4));*/
		
		List<Patient> doc1Patients = new ArrayList<Patient>();
		doc1Patients.add(pat1); doc1Patients.add(pat2); //doc1Patients.add(pat3);
		
		List<Patient> doc2Patients = new ArrayList<Patient>();
		doc2Patients.add(pat3); doc2Patients.add(pat4);
		
		doc1.setPatients(doc1Patients);
		doc2.setPatients(doc2Patients);
		
		
		//add doctors to 
		pat1.setDoctors(List.of(doc1));
		pat2.setDoctors(List.of(doc1));
		pat3.setDoctors(List.of(doc1, doc2));
		pat4.setDoctors(List.of(doc2));
		
		//save above data 
		doctorRepo.saveAll(List.of(doc1, doc2));
		System.out.println("Doctors and thier oatients are saved");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void saveDataUsingPatient() {
		try {
			
			Doctor doc1 = new Doctor("Suresh", "Physican");
			Doctor doc2 = new Doctor("Raju", "Ortho");
			
			Patient pat1 =  new Patient("Kiran", 40, "Heart");
			Patient pat2 =  new Patient("Ramesh", 34, "Kidney");
			Patient pat3 =  new Patient("Ram", 45, "BP");
			Patient pat4 =  new Patient("Raghu", 43, "Stomach");
			
			List<Patient> doc1Patients = new ArrayList<Patient>();
			doc1Patients.add(pat1); doc1Patients.add(pat2); 
			
			List<Patient> doc2Patients = new ArrayList<Patient>();
			doc2Patients.add(pat3); doc2Patients.add(pat4);
			
			doc1.setPatients(doc1Patients);
			doc2.setPatients(doc2Patients);
			
			
			//add doctors to 
			pat1.setDoctors(List.of(doc1));
			pat2.setDoctors(List.of(doc1));
			pat3.setDoctors(List.of(doc1, doc2));
			pat4.setDoctors(List.of(doc2));
			
			//save above data 
			patientRepo.saveAll(List.of(pat1, pat2, pat3, pat4));
			System.out.println("Doctors and thier oatients are saved");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}


	@Override
	public void loadDataUsingDoctor() {
		List<Doctor> list = doctorRepo.findAll();
		list.forEach(doc->{
			System.out.println("Parent:: "+doc);
			//get patients of a doctor
			List<Patient> patient = doc.getPatients();
			patient.forEach(pat->{
				System.out.println("Child::: "+pat);
			});
		});
		
	}


	@Override
	public void loadDataUsingPatient() {
		List<Patient> list = patientRepo.findAll();
		list.forEach(pat->{
			System.out.println("Child:: "+pat);
			//get doctors of patients
			List<Doctor> doc = pat.getDoctors();
			doc.forEach(doct->{
				System.out.println("Parent::: "+doct);
				System.out.println("====================================================================================================================");
			});
		});
		
	}

}
