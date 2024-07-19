package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import application.*;

public class TestClinic {

	@Test
	public void testReadWriteProvider1() {
		Clinic c1 = new Clinic();
				
		ProviderAccount p1 = new ProviderAccount("1001", true);
		p1.setFirstName("Alfred");
		p1.setLastName("Mansley");		
		c1.writeProviderAccount(p1);
		Clinic c2 = new Clinic();
		
		assertEquals("Testing providerId mathces: ", p1.getProviderId(), c2.viewProviders().get(0).getProviderId());
		assertEquals("Testing firstName matches: ", p1.getFirstName(), c2.viewProviders().get(0).getFirstName());
		assertEquals("Testing lastName matches: ", p1.getLastName(), c2.viewProviders().get(0).getLastName());
		assertEquals("Testing doctorStatus matches: ", p1.isDoctor(), c2.viewProviders().get(0).isDoctor());
	}
	
	@Test
	public void testReadWritePatient1() {
		
		Clinic c1 = new Clinic();
		
		PatientAccount p1 = new PatientAccount();
		p1.setPatientId("42069");
		p1.setFirstName("Orion");
		p1.setLastName("Huxley");
		p1.setBirthday("07/04/1776");
		p1.setPhoneNumber("8675309");
		p1.setEmailAddress("ohoh76@email.com");
		p1.setInsurance("Insurance Policy: Red");
		p1.setPharmacy("Pharmacy on file");
		p1.setPatientHistory("Rashes that burn like the plague. General sickness. Anemia.");
		p1.setPrescriptions("80mg laughter, daily.");
		
		c1.writePatientAccount(p1);
		Clinic c2 = new Clinic();
		
		assertEquals("Testing patientId matches", p1.getPatientId(), c2.viewPatients().get(0).getPatientId());
		assertEquals("Testing firstName matches", p1.getFirstName(), c2.viewPatients().get(0).getFirstName());
		assertEquals("Testing lastName matches", p1.getLastName(), c2.viewPatients().get(0).getLastName());
		assertEquals("Testing birthday matches", p1.getBirthday(), c2.viewPatients().get(0).getBirthday());
		assertEquals("Testing phoneNumber matches", p1.getPhoneNumber(), c2.viewPatients().get(0).getPhoneNumber());
		assertEquals("Testing email matches", p1.getEmailAddress(), c2.viewPatients().get(0).getEmailAddress());
		assertEquals("Testing insurance matches", p1.getInsurance(), c2.viewPatients().get(0).getInsurance());
		assertEquals("Testing pharmacy matches", p1.getPharmacy(), c2.viewPatients().get(0).getPharmacy());
		assertEquals("Testing patientHistory matches", p1.getPatientHistory(), c2.viewPatients().get(0).getPatientHistory());
		assertEquals("Testing prescriptions matches", p1.getPrescriptions(), c2.viewPatients().get(0).getPrescriptions());
		
		assertTrue("Testing PatientAccount matches", p1.equals(c2.viewPatients().get(0)));
		
	}
	
	@Test
	public void testReadWriteVisit1() {
		Clinic c1 = new Clinic();
		
		ClinicVisit v1 = new ClinicVisit();
		v1.setPatientId("12345");
		v1.setProviderId("99878");
		v1.setVisitId(28);
		v1.setVisitDate("06/20/2024");
		v1.setVisitTime("3:30");
		v1.setReason("Ouchies");
		v1.setHeight(177);
		v1.setWeight(90);
		v1.setTemperature(102);
		v1.setBloodPressure("110/70");
		v1.setAtLeastTwelve(false);
		v1.setAllergies("Grass");
		v1.setConcerns("Flu");
		v1.setPrescriptions("None");
		v1.setExamSummary("Patient is dying");
		
		c1.writeVisit(v1);
		
		Clinic c2 = new Clinic();
		Clinic c3 = new Clinic();
		c2.setCurrentUser(v1.getPatientId());
		
		c3.setProviderStatus(true);
		c3.setCurrentUser(v1.getProviderId());
		
		assertTrue("Testing ClinicVisit matches 1", v1.equals(c2.viewVisits().get(0)));
		assertTrue("Testing ClinicVisit matches 2", v1.equals(c3.viewVisits().get(0)));
	}
	
	@Test
	public void testReadWriteMessage1() {
		
	}
	
	@Test
	public void testReadWriteLogin1() {
		
	}
}
