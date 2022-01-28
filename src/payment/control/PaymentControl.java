package payment.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import payment.model.Payment;

public class PaymentControl {
	
	public PaymentControl() {}
	
	
	
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
	
	//Insert Data
	public void insertData(Payment payment) throws SQLException {
		try {Connection connection = getConnection();
				PreparedStatement preparedstatment = 
						connection.prepareStatement("INSERT INTO payment "+"(cardName,cardNo,secCode,expMonth,expYear,patientId) values"+"(?, ?, ?, ?, ?, ?);");	
				
			preparedstatment.setString(1,payment.getCardName());
			preparedstatment.setString(2,payment.getCardNo());
			preparedstatment.setInt(3,payment.getSecCode());
			preparedstatment.setString(4,payment.getExpMonth());
			preparedstatment.setString(5,payment.getExpYear());
			preparedstatment.setInt(6,payment.getPatientId());
			
			preparedstatment.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//List All Payments
	public List<Payment> listData(int id) {
		List<Payment> payment = new ArrayList<>();
		try (Connection connection = getConnection();
				
			PreparedStatement prepaStatement = connection.prepareStatement("SELECT * FROM payment WHERE patientId = ?");) {
			prepaStatement.setInt(1, id);
			ResultSet rs = prepaStatement.executeQuery();
			
			while(rs.next()) {
				int pId = rs.getInt("pId");
				String cardName = rs.getString("cardName");
				String cardNo = rs.getString("cardNo");
				int secCode = rs.getInt("secCode");
				String expMonth = rs.getString("expMonth");
				String expYear = rs.getString("expYear");
				int patientId = rs.getInt("patientId");
				
				payment.add(new Payment(pId, cardName, cardNo, secCode, expMonth, expYear,patientId));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return payment;
	}

	//Delete Payment from History
	public boolean deleteData(int pId) throws SQLException {
		boolean rowDelete;
		try (Connection connection = getConnection();
				
			PreparedStatement statement = connection.prepareStatement("DELETE FROM payment WHERE pId = ?;");) {
			statement.setInt(1, pId);
			rowDelete = statement.executeUpdate() > 0;
		}
		return rowDelete;
	}
	
	
	//List Payment by Id
	public Payment selectData(int pId) {
		Payment payment = null;
		try (Connection connection = getConnection();
				
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT pId,cardName,cardNo,secCode,expMonth,expYear FROM payment WHERE pId = ?");) {
			preparedStatement.setInt(1, pId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String cardName = rs.getString("cardName");
				String cardNo = rs.getString("cardNo");
				int secCode = rs.getInt("secCode");
				String expMonth = rs.getString("expMonth");
				String expYear = rs.getString("expYear");
				int patientId = rs.getInt("patientId");
				
				payment = new Payment(pId, cardName, cardNo, secCode, expMonth, expYear,patientId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return payment;
	}

}
