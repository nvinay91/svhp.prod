package vinay.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vinay.services.model.ServiceFetchPwdModel;
import vinay.services.service.ServiceFetchPwd;

/**
 * Servlet implementation class FetchPwd
 */
@WebServlet("/FetchPwd")
public class FetchPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchPwd() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String mobileNumber = request.getParameter("mobile");
    	ServiceFetchPwdModel model = new ServiceFetchPwdModel();
    	model.setMobile(mobileNumber);
    	ServiceFetchPwd service = new ServiceFetchPwd();
    	String _return = (String)service.execute(request, model);
    	response.setContentType("json");
    	response.getWriter().write(_return);
//    	request.setAttribute("displaysuccessMessage", _return);
//    	getServletContext().getRequestDispatcher("/forgotpassword.jsp").forward(request, response);
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
