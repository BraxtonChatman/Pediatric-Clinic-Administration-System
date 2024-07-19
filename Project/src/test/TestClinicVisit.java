package test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import application.ClinicVisit;

public class TestClinicVisit {

	@Test
	public void testEquals1() {
		ClinicVisit v1 = new ClinicVisit();
		ClinicVisit v2 = new ClinicVisit();
		
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
		
		v2.setPatientId("12345");
		v2.setProviderId("99878");
		v2.setVisitId(28);
		v2.setVisitDate("06/20/2024");
		v2.setVisitTime("3:30");
		v2.setReason("Ouchies");
		v2.setHeight(177);
		v2.setWeight(90);
		v2.setTemperature(102);
		v2.setBloodPressure("110/70");
		v2.setAtLeastTwelve(false);
		v2.setAllergies("Grass");
		v2.setConcerns("Flu");
		v2.setPrescriptions("None");
		v2.setExamSummary("Patient is dying");
		
		assertTrue("Testing ClinicVisit.equals", v1.equals(v2));
	}
}
