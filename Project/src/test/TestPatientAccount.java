package test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import application.PatientAccount;

public class TestPatientAccount {

	@Test
	public void testEquals1() {
		
		PatientAccount p1 = new PatientAccount();
		PatientAccount p2 = new PatientAccount();
		
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
		
		p2.setPatientId("42069");
		p2.setFirstName("Orion");
		p2.setLastName("Huxley");
		p2.setBirthday("07/04/1776");
		p2.setPhoneNumber("8675309");
		p2.setEmailAddress("ohoh76@email.com");
		p2.setInsurance("Insurance Policy: Red");
		p2.setPharmacy("Pharmacy on file");
		p2.setPatientHistory("Rashes that burn like the plague. General sickness. Anemia.");
		p2.setPrescriptions("80mg laughter, daily.");
		
		assertTrue("Testing PatientAccount.equals, test1", p1.equals(p2));
		
	}
}
