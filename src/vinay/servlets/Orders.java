package vinay.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

/**
 * Servlet implementation class Orders
 */
@WebServlet("/orders")
public class Orders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, RazorpayException {
		RazorpayClient razorpay = new RazorpayClient("rzp_test_T2bukJtmv4smM9",
				"KAfZTUMndq0q4mXb7jRsvs16");

		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount", 50000); // amount in the smallest currency
											// unit
		orderRequest.put("currency", "INR");
		orderRequest.put("receipt", "order_rcptid_11");

		try {
			Order order = razorpay.Orders.create(orderRequest);

			if (order
					.get("razorpay_order_id")
					.toString()
					.equalsIgnoreCase(
							orderRequest.getString("razorpay_order_id"))) {
				request.setAttribute("orderId", orderRequest.get("orderId"));
				getServletContext().getRequestDispatcher("/success.jsp")
						.forward(request, response);
			}
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			execute(request, response);
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
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
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
