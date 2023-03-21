package db.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.interfaces.PatientManager;
import db.pojos.*;

public class PatientSQL implements PatientManager{

	

	@Override
	public void addPatient(PatientPojo patient) {
		
		try {

			String sql = "INSERT INTO Patient (name, gender, age /*, userId*/)";
			sql+= " VALUES (?,?,?,?,?,?)";
			PreparedStatement pstmt = DBManagerSQL.c.prepareStatement(sql); 
			
			//pstmt.setInt(1, patient.getId());
			pstmt.setString(1,patient.getName().toString());
			pstmt.setString(2,patient.getGender().toString());
			pstmt.setInt(3,patient.getAge());

			
			pstmt.executeUpdate();
			pstmt.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}//addPatient
	
	
	public List<PatientPojo> listPatients() { //we show all the animals in the database
		List<PatientPojo> thePatients = new ArrayList<PatientPojo>();
		
		try {	
			
			String sql = "SELECT * FROM Patient "; 			
			PreparedStatement prep = DBManagerSQL.c.prepareStatement(sql);	
			ResultSet rs = prep.executeQuery();
		
		while (rs.next()) { 
			int id = rs.getInt("id");	
			String name = rs.getString("name");
			String gender = rs.getString("gender"); //Revisar esto pq es un ENUM
			int age = rs.getInt("age"); 
			

			//PatientPojo unpatient = new PatientPojo(id, name, gender, age);
			
			
			}

		prep.close();
		rs.close();
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return thePatients;
	}
	
	/*@Override
	public List<String> getPatientsByName() {
		List<String> thePatients = new ArrayList<String>();
		
		try {
			//String sql = "SELECT type FROM animals_characteristics"; 			    
			PreparedStatement prep = JDBCManager.c.prepareStatement(sql);	
			ResultSet rs = prep.executeQuery();
			
			while (rs.next()) { 
				String type = rs.getString("type");
				typesOfAnimals.add(type);
			}
			
			
			//System.out.println(sql);
			rs.close();
			prep.close();// Close database connection
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		
	return typesOfAnimals;	
	}	*/
	

}//class