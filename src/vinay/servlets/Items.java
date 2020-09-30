package vinay.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vinay.framework.adapter.CustomerContext;
import vinay.framework.constants.GenericModel;
import vinay.services.model.ServiceCartModel;
import vinay.services.service.FetchItems;
import vinay.services.service.ServiceCart;

/**
 * Servlet implementation class Items
 */
@WebServlet("/Items")
public class Items extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Items() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
					CustomerContext ccModel = CustomerContext.getInstance();
					request.setAttribute("user", "Hi "+ ccModel.getFIRST_NAME()+" "+ccModel.getLAST_NAME());
					request.setAttribute("email", ccModel.getEMAIL());
					request.setAttribute("groupid", ccModel.getGROUP_ID());
					List<vinay.services.model.Items> list = new ArrayList<vinay.services.model.Items>();
					if(request.getParameter("param").equalsIgnoreCase("A")){
						list = new FetchItems().fetchItems();
					}else if(request.getParameter("param").equalsIgnoreCase("SP")){
						list = new FetchItems().fetchSpiceItems();
					}else if(request.getParameter("param").equalsIgnoreCase("S")){
						list = new FetchItems().fetchSnacksItems();
					}
					request.setAttribute("items", list);
					
					ServiceCart cart = new ServiceCart();
					ServiceCartModel model1 = new ServiceCartModel();
					model1.setInp_userId(CustomerContext.getInstance().getMOBILE());
					String activeCartCount = cart.getCartCount(model1);
					GenericModel.setCartNumber(activeCartCount);
					
					getServletContext().getRequestDispatcher("/shop.jsp").forward(request, response);
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
