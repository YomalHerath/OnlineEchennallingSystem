package appointment.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import appointment.model.Appointment;

public class AppointmentControl {

	//SQL Query
	private static final String INSERT_APPOINTMENT = "INSERT INTO appointment" + "(firstName,secondName,contact,doctorName,hospitalName,date,month,year,patientId) values" + "(?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_APPOINTMENT = "SELECT * FROM appointment WHERE PatientId = ?";
	private static final String SELECT_APPOINTMENT_BY_ID = "SELECT Id,firstName,secondName,contact,doctorName,hospitalName,date,month,year,patientId FROM appointment WHERE Id = ?";
	private static final String DELETE_APPOINTMENT = "DELETE FROM appointment WHERE Id = ?;";
	private static final String UPDATE_APPOINTMENT = "UPDATE appointment set firstName = ?, secondName = ?, contact = ?, doctorName = ?, hospitalName = ?, date = ?, month = ?, year = ? WHERE Id = ?;"; 
	private static final String SEARCH_APPOINTMENT = "SELECT * FROM appointment WHERE (hospitalName LIKE ? OR doctorName LIKE ? OR date LIKE ? OR month LIKE ? OR year LIKE ?) AND patientId = ?";
	
	public AppointmentControl() {}
	
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
		
	//Insert Appointments
	public void writeData(Appointment appointment) throws SQLException {
		try {Connection connection = getConnection();
			
			PreparedStatement preparedstatment = connection.prepareStatement(INSERT_APPOINTMENT);	
				
			preparedstatment.setString(1,appointment.getFirstName());
			preparedstatment.setString(2,appointment.getSecondName());
			preparedstatment.setString(3,appointment.getContact());
			preparedstatment.setString(4,appointment.getDoctorName());
			preparedstatment.setString(5,appointment.getHospitalName());
			preparedstatment.setString(6,appointment.getDate());
			preparedstatment.setString(7,appointment.getMonth());
			preparedstatment.setString(8,appointment.getYear());
			preparedstatment.setInt(9,appointment.getPatientId());
			
			preparedstatment.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Update Appointment
	public boolean updateData(Appointment appointment) throws SQLException{
		boolean rowUpdate;
		try (Connection connection = getConnection();
				
			PreparedStatement statment = connection.prepareStatement(UPDATE_APPOINTMENT);) {
			
			statment.setString(1,appointment.getFirstName());
			statment.setString(2,appointment.getSecondName());
			statment.setString(3,appointment.getContact());
			statment.setString(4,appointment.getDoctorName());
			statment.setString(5,appointment.getHospitalName());
			statment.setString(6,appointment.getDate());
			statment.setString(7,appointment.getMonth());
			statment.setString(8,appointment.getYear());
			statment.setInt(9,appointment.getId());

			rowUpdate = statment.executeUpdate() > 0;
		}
		return rowUpdate;
	}
	
	//List Appointment by Id
	public Appointment selectData(int id) {
		Appointment appointment = null;
		try (Connection connection = getConnection();
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_APPOINTMENT_BY_ID);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String firstName = rs.getString("firstName");
				String secondName = rs.getString("secondName");
				String contact = rs.getString("contact");
				String doctorName = rs.getString("doctorName");
				String hospitalName = rs.getString("hospitalName");
				String date = rs.getString("date");
				String month = rs.getString("month");
				String year = rs.getString("year");
				int patientId = rs.getInt("patientId");
				appointment = new Appointment(id, firstName, secondName, contact, doctorName, hospitalName, date, month, year,patientId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appointment;
	}
	
	//List All Appointment
	public List<Appointment> listData(int id) {
		List<Appointment> appointment = new ArrayList<>();
		try (Connection connection = getConnection();
				
			PreparedStatement prepaStatement = connection.prepareStatement(SELECT_APPOINTMENT);) {
			
			prepaStatement.setInt(1, id);
			ResultSet rs = prepaStatement.executeQuery();
			
			while(rs.next()) {
				int aid = rs.getInt("Id");
				String firstName = rs.getString("firstName");
				String secondName = rs.getString("secondName");
				String contact = rs.getString("contact");
				String doctorName = rs.getString("doctorName");
				String hospitalName = rs.getString("hospitalName");
				String date = rs.getString("date");
				String month = rs.getString("month");
				String year = rs.getString("year");
				int patientId = rs.getInt("patientId");
				appointment.add(new Appointment(aid, firstName, secondName, contact, doctorName, hospitalName, date, month, year, patientId));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return appointment;
	}
	
	//Delete Appointment
	public boolean deleteData(int id) throws SQLException {
		boolean rowDelete;
		try (Connection connection = getConnection();
				
				PreparedStatement statement = connection.prepareStatement(DELETE_APPOINTMENT);) {
			statement.setInt(1, id);
			rowDelete = statement.executeUpdate() > 0;
		}
		return rowDelete;
	}
	
	//search Appointment
	public List<Appointment> listSearch(String search, int patientID) throws SQLException {
		List<Appointment> appointment = new ArrayList<>();
		
		try (Connection connection = getConnection();		
			PreparedStatement preparStatement = connection.prepareStatement(SEARCH_APPOINTMENT);) {
			preparStatement.setString(1, "%"+search+"%");
			preparStatement.setString(2, "%"+search+"%");
			preparStatement.setString(3, "%"+search+"%");
			preparStatement.setString(4, "%"+search+"%");
			preparStatement.setString(5, "%"+search+"%");
			preparStatement.setInt(6, patientID);
			
			ResultSet rs = preparStatement.executeQuery();
			
				while(rs.next()) {
					int id = rs.getInt("Id");
					String firstName = rs.getString("firstName");
					String secondName = rs.getString("secondName");
					String contact = rs.getString("contact");
					String doctorName = rs.getString("doctorName");
					String hospitalName = rs.getString("hospitalName");
					String date = rs.getString("date");
					String month = rs.getString("month");
					String year = rs.getString("year");
					int patientId = rs.getInt("patientId");
					
					appointment.add(new Appointment(id, firstName, secondName, contact, doctorName, hospitalName, date, month, year,patientId));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return appointment;
		}

}







