package patient.control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import patient.model.Patient;

@WebServlet("/PatientServer")
public class PatientServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientControl patientControl;
       
	public void init() {
		patientControl = new PatientControl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		
		if (action == null)
			action = "/list";
		
	 try {
         switch (action) {
             case "/new":
            	 showNewForm(request, response);
                 break;
             case "/insert":
            	 insertPatient(request, response);
                 break;
             default:
            	 Account(request, response);
            	 break;
         }
     } catch (SQLException ex) {
         throw new ServletException(ex);
     }
 }
	
	// --- New Patient ---
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("PatientRegister.jsp");
		dispatcher.forward(request, response);
	}
	
	// --- Insert Patient ---
	private void insertPatient(HttpServletRequest request, HttpServletResponse response) 
	throws SQLException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String Username = request.getParameter("Username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		
		Patient patient = new Patient(firstName,lastName,Username,password,email,contact);
		
		patientControl.writeData(patient);
		response.sendRedirect("PatientLogin.jsp");
	}
	
	// --- Create Login with registered patient ---
	private void Account(HttpServletRequest request, HttpServletResponse response) 
	throws SQLException, IOException, ServletException {
        String username = request.getParameter("Username");
        String password = request.getParameter("password");
        Patient login = new Patient();
        login.setUsername(username);
        login.setPassword(password);

        try {
            if (patientControl.validate(login)) {
            	int id = patientControl.getIdfromUsername(username);
                
            	HttpSession session = request.getSession();
                session.setAttribute("id",id);
                response.sendRedirect("AppointmentServer");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("PatientLogin.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	
}
