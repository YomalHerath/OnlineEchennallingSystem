package payment.control;

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

import payment.model.Payment;

@WebServlet("/PaymentServer")
public class PaymentServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PaymentControl paymentControl;   

    public void init() {
    	paymentControl = new PaymentControl();
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
	            	 New(request, response);
	                 break;
	             case "/insert":
	            	 insertPayment(request, response);
	                 break;
	             case "/delete":
	            	 deletePayment(request, response);
	                 break;
	             default:
	            	 listPayment(request, response);
	                 break;
	         }
	     } catch (SQLException ex) {
	         throw new ServletException(ex);
	     }
	 }

	
	// --- Insert Payment ---
	private void insertPayment(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException {
		String cardName = request.getParameter("cardName");
		String cardNo = request.getParameter("cardNo");
		int secCode = Integer.parseInt(request.getParameter("secCode"));
		String expMonth = request.getParameter("expMonth");
		String expYear = request.getParameter("expYear");
		
		HttpSession session = request.getSession();
		int patientId = (Integer) session.getAttribute("id");
			
		Payment payment = new Payment(cardName,cardNo,secCode,expMonth,expYear,patientId);
			
		paymentControl.insertData(payment);
		response.sendRedirect("AppointmentServer");	
	}


	//--- New Payment ---
	private void New(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Payment.jsp");
		dispatcher.forward(request, response);
	}

	
	// --- List Payment ---
	private void listPayment(HttpServletRequest request, HttpServletResponse response) 
	throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		
		List<Payment> listPayment = paymentControl.listData(id);
		request.setAttribute("listPayment", listPayment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listPayment.jsp");
		dispatcher.forward(request, response);
	}
	
	
	// --- delete Payment ---
	private void deletePayment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int pId = Integer.parseInt(request.getParameter("pId"));
		paymentControl.deleteData(pId);
		response.sendRedirect("PaymentServer");
	}

}
