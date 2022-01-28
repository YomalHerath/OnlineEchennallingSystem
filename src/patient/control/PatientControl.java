package patient.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import patient.model.Patient;

public class PatientControl {

	//SQL Query
	private static final String INSERT_PATIENT = "INSERT INTO patient" + "(firstName,lastName,Username,password,email,contact) values" + "(?, ?, ?, ?, ?, ?);";
	private static final String LOGIN_PATIENT = "SELECT * FROM patient WHERE Username = ? and password = ?";
	private static final String GETID_PATIENT = "SELECT id FROM patient WHERE Username = ?";
	
	public PatientControl() {}
	
	//Make Database Connection
	protected Connection getConnection() {
		Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/echannel?useSSL=false","root","4092");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {	
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
	}
		
	//Insert Patient
	public void writeData(Patient patient) throws SQLException {
		try {Connection connection = getConnection();
			
			PreparedStatement preparedstatment = connection.prepareStatement(INSERT_PATIENT);	
				
			preparedstatment.setString(1,patient.getFirstName());
			preparedstatment.setString(2,patient.getLastName());
			preparedstatment.setString(3,patient.getUsername());
			preparedstatment.setString(4,patient.getPassword());
			preparedstatment.setString(5,patient.getEmail());
			preparedstatment.setString(6,patient.getContact());
			
			preparedstatment.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(patient);
	}
	
	//Login Validate
	public boolean validate(Patient patient) throws ClassNotFoundException, SQLException {
		boolean status = false;
		
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection
			.prepareStatement(LOGIN_PATIENT);) {
		            preparedStatement.setString(1, patient.getUsername());
		            preparedStatement.setString(2, patient.getPassword());
				
		            ResultSet rs = preparedStatement.executeQuery();
		            status = rs.next();

		        return status;
			}
	}
	
	public int getIdfromUsername(String username) throws SQLException {
		int id = 0;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
				.prepareStatement(GETID_PATIENT);) {
			
				preparedStatement.setString(1,username);
				
				ResultSet rs = preparedStatement.executeQuery();
				if(rs.next()) {
					id = rs.getInt("id"); 
				}
		}
		return id;
	}
	
}






