package vinay.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vinay.services.model.ServiceRegistrationModel;
import vinay.services.service.ServiceRegistration;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");
		String pincode = request.getParameter("pincode");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		
		ServiceRegistrationModel model = new ServiceRegistrationModel();
		
		if(password!= null && confirmpassword!=null && password!= "" && confirmpassword!="" && !confirmpassword.equalsIgnoreCase(password)){
			request.setAttribute("errorMessage", "Password and Confirm Password are not matching..");
			request.setAttribute("firstname", firstname);
			request.setAttribute("lastname", lastname);
			request.setAttribute("mobile", mobile);
			request.setAttribute("email", email);
			request.setAttribute("address1", address1);
			request.setAttribute("address2", address2);
			request.setAttribute("address3", address3);
			request.setAttribute("pincode", pincode);			
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);

		}else if(firstname!=null && mobile!=null && mobile.length()>=10){
			ServiceRegistration service = new ServiceRegistration();		
			model.setFirstname(firstname);
			model.setLastname(lastname);
			model.setMobile(mobile);
			model.setEmail(email);
			model.setAddress1(address1);
			model.setAddress2(address2);
			model.setAddress3(address3);
			model.setPincode(pincode);
			model.setPassword(password);
			
			int save = (int) service.execute(request,model);
			if(save == 1){
				request.setAttribute("successMessage", "User Registration Completed.. Please try login with the Mobile Number and Password..");
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				request.setAttribute("errorMessage", "Error occured while processing the request...");
				getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("errorMessage", "FirstName or Mobile Number is not Specified..");
			request.setAttribute("firstname", firstname);
			request.setAttribute("lastname", lastname);
			request.setAttribute("mobile", mobile);
			request.setAttribute("email", email);
			request.setAttribute("address1", address1);
			request.setAttribute("address2", address2);
			request.setAttribute("address3", address3);
			request.setAttribute("pincode", pincode);			
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

}
