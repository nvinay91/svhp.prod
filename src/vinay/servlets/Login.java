package vinay.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vinay.framework.adapter.CustomerContext;
import vinay.framework.adapter.GenericAdapter;
import vinay.framework.constants.GenericModel;
import vinay.services.model.Items;
import vinay.services.model.ServiceCartModel;
import vinay.services.model.ServiceLoginModel;
import vinay.services.service.FetchItems;
import vinay.services.service.ServiceCart;
import vinay.services.service.ServiceLogin;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String actionParam = request.getParameter("param");
		if(actionParam!= null && actionParam.equalsIgnoreCase("forgotPwd")){
			getServletContext().getRequestDispatcher("/forgotpassword.jsp").forward(request, response);
		}if(actionParam!= null && actionParam.equalsIgnoreCase("register")){
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		}else{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if(!password.equalsIgnoreCase("")){
				ServiceLogin service = new ServiceLogin();
				ServiceLoginModel model = new ServiceLoginModel();
				model.setPassword(password);
				model.setUsername(username);
				int _return = (int)service.execute(request, model);
				if(_return == 1 || _return == 44){
					GenericAdapter.createCustomerContext(username);
					CustomerContext ccModel = CustomerContext.getInstance();
					request.setAttribute("user", "Hi "+ ccModel.getFIRST_NAME()+" "+ccModel.getLAST_NAME());
					request.setAttribute("email", ccModel.getEMAIL());
					request.setAttribute("groupid", ccModel.getGROUP_ID());
					List<Items> list = new FetchItems().fetchItems();
					request.setAttribute("items", list);
					
					ServiceCart cart = new ServiceCart();
					ServiceCartModel model1 = new ServiceCartModel();
					model1.setInp_userId(CustomerContext.getInstance().getMOBILE());
					String activeCartCount = cart.getCartCount(model1);
					GenericModel.setCartNumber(activeCartCount);
					getServletContext().getRequestDispatcher("/shop.jsp?param=A").forward(request, response);
				}else{
					if(_return == 2){ 
						request.setAttribute("errorMessage", "Invalid Username or Password..");
						getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
					}else if(_return == 11){
						request.setAttribute("errorMessage", "User Already Logged in another session.Clearing the session and creating new one..");
						getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
					}else if(_return == 22){
						request.setAttribute("errorMessage", "User exceeded the limit with wrong Password/Username..");
						getServletContext().getRequestDispatcher("/forgotpassword.jsp").forward(request, response);
					}else if(_return == 33){
						request.setAttribute("errorMessage", "Invalid Username or Password..");
						getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);	
					}else{
						request.setAttribute("errorMessage", "Error occured while processing the request...");
						getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
					}
				}
			}
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
