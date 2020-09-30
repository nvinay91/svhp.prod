package vinay.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vinay.framework.constants.GenericModel;
import vinay.services.model.OpenCartModel;
import vinay.services.service.ServiceOpenCart;

/**
 * Servlet implementation class OpenCart
 */
@WebServlet("/OpenCart")
public class OpenCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OpenCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceOpenCart service = new ServiceOpenCart();
		OpenCartModel model = service.getcartList();
		GenericModel.setCartNumber(String.valueOf(model.cartList.size()));
		request.setAttribute("CART_MODEL", model);
		getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

}
