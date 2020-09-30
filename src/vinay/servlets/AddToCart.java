package vinay.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vinay.framework.adapter.CustomerContext;
import vinay.framework.constants.GenericModel;
import vinay.services.model.ServiceCartModel;
import vinay.services.service.ServiceCart;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, SQLException {
		
		ServiceCart servCart = new ServiceCart();
		ServiceCartModel model = new ServiceCartModel();
		model.setInp_quantity(request.getParameter("Q"));
		model.setInp_productId(request.getParameter("d"));
		model.setInp_userId(CustomerContext.getInstance().getMOBILE());
		
		String activeCartCount = cartCount(request,response,servCart,model);
		
		int i = servCart.insertNewProductToCart(model);
		
		String _return = "CART_VALUE=" + String.valueOf(Integer.valueOf(activeCartCount)+i);
		GenericModel.setCartNumber(activeCartCount);
		response.setContentType("json");
		response.getWriter().write(_return);
	}

	private String cartCount(HttpServletRequest request,
			HttpServletResponse response, ServiceCart servCart, ServiceCartModel model) {				

		String activeCartCount = servCart.getCartCount(model);
		return activeCartCount;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			execute(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			execute(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
