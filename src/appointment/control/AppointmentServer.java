package appointment.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import appointment.model.Appointment;


@WebServlet("/AppointmentServer")
public class AppointmentServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AppointmentControl appointmentControl;
    
    public void init() {
        appointmentControl = new AppointmentControl();
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action == null)
			action = "list";
		
	 try {
         switch (action) {
             case "/new":
            	 showNewForm(request, response);
                 break;
             case "/insert":
            	 insertAppointment(request, response);
                 break;
             case "/delete":
            	 deleteAppointment(request, response);
                 break;
             case "/edit":
            	 showEditForm(request, response);
                 break;
             case "/update":
            	 updateAppointmnet(request, response);
                 break;
             case "/search":
            	 searchAppointmnet(request, response);
            	 break;
             default:
            	 listAppointmnet(request, response);
                 break;
         }
     } catch (SQLException ex) {
         throw new ServletException(ex);
     }
 }
	
	// --- New Patient ---
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Appointment.jsp");
		dispatcher.forward(request, response);
	}
	
	// --- Insert Appointment ---
	private void insertAppointment(HttpServletRequest request, HttpServletResponse response) 
	throws SQLException, IOException {
		String firstName = request.getParameter("firstName");
		String secondName = request.getParameter("secondName");
		String contact = request.getParameter("contact");
		String doctorName = request.getParameter("doctorName");
		String hospitalName = request.getParameter("hospital");
		String date = request.getParameter("date");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		
		HttpSession session = request.getSession();
		int patientId = (Integer) session.getAttribute("id");
		
		Appointment appointment = new Appointment(firstName,secondName,contact,doctorName,hospitalName,date,month,year,patientId);
		
		appointmentControl.writeData(appointment);
		response.sendRedirect("Payment.jsp");
		
	}
	
	// --- delete Appointment ---
	private void deleteAppointment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int Id = Integer.parseInt(request.getParameter("Id"));
		appointmentControl.deleteData(Id);
		response.sendRedirect("AppointmentServer");
	}
	
	// --- edit Appointment ---
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException {
		int Id = Integer.parseInt(request.getParameter("Id"));
		Appointment existingAppointment = appointmentControl.selectData(Id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateAppointment.jsp");
		request.setAttribute("existingAppointment", existingAppointment);
		dispatcher.forward(request, response);
	}
	
	// --- Update Appointment ---
	private void updateAppointmnet(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("Id"));
		String firstName = request.getParameter("firstName");
		String secondName = request.getParameter("secondName");
		String contact = request.getParameter("contact");
		String doctorName = request.getParameter("doctorName");
		String hospitalName = request.getParameter("hospital");
		String date = request.getParameter("date");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		
		HttpSession session = request.getSession();
		int patientId = (Integer) session.getAttribute("id");
		
		Appointment appointment = new Appointment(id,firstName,secondName,contact,doctorName,hospitalName,date,month,year,patientId);
		
		appointmentControl.updateData(appointment);
		response.sendRedirect("AppointmentServer");
	}
	
	// --- List Appointments ---
	private void listAppointmnet(HttpServletRequest request, HttpServletResponse response) 
	throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		
		List<Appointment> listAppointment = appointmentControl.listData(id);
		request.setAttribute("listAppointment", listAppointment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listAppointment.jsp");
		dispatcher.forward(request, response);
	}

	// --- search Appointment ---
	private void searchAppointmnet(HttpServletRequest request, HttpServletResponse response) 
	throws SQLException, IOException, ServletException {
		String search = request.getParameter("search");
		
		HttpSession session = request.getSession();
		int patientId = (Integer) session.getAttribute("id");
		
		List<Appointment> searchAppointment = appointmentControl.listSearch(search,patientId);
		request.setAttribute("searchAppointment", searchAppointment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchAppointment.jsp");
		dispatcher.forward(request, response);
	}
}
