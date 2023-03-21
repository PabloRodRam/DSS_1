package db.interfaces;
import java.util.List;

import db.pojos.*;


public interface PatientManager {

	public void addPatient(PatientPojo patient);
	public List<PatientPojo> listPatients();
}
