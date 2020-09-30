package vinay.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/SendOTP")
public class SendOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendOTP() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean flag = false;
		boolean isemail = false;
		String mode = "";
		if (request.getParameter("mobile") != null
				&& request.getParameter("mobile").toString().length() >= 10) {
			flag = true;
			mode = "Mobile Number";
		}

		if (!flag && request.getParameter("email") != null
				&& request.getParameter("email") != "") {
			flag = true;
			isemail = true;
			mode = "E-mail";
		}

		if (!flag) {
			request.setAttribute("errorMessage",
					"Please specify Email or Mobile Number..");
			getServletContext().getRequestDispatcher("/forgotpassword.jsp")
					.forward(request, response);
		} else {
			if (isemail) {
				request.setAttribute("successMessage",
						"OTP sent successfully to your " + mode + ":- "
								+ request.getParameter("email"));
			} else {

				int otp = sendOTP(request.getParameter("mobile").toString());
//				int otp = 12345;
				request.setAttribute("successMessage",
						"OTP sent successfully to your " + mode + ":- "
								+ request.getParameter("mobile"));
				request.setAttribute("mobile", request.getParameter("mobile"));
				request.setAttribute("otpValue",otp);
			}
			getServletContext().getRequestDispatcher("/forgotpassword.jsp")
					.forward(request, response);
		}
	}

	private int sendOTP(String phone) {
		Random rand = new Random();
		int value = new Random().nextInt(90000) + 10000;
		
		String textmessage = String.valueOf(value);
		String authkey = "322723e7-e8cb-11ea-9fa5-0200cd936042";
		// Multiple mobiles numbers separated by comma
		String mobiles = phone;
		// Sender ID,While using route4 sender id should be 6 characters long.
		String senderId = "ABCDEF";
		// Your message to send, Add URL encoding here.
		String message = textmessage;
		// define route
		String route = "4";
		// Prepare Url
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		// encoding message
		String encoded_message = URLEncoder.encode(message);
		String mainUrl = "https://2factor.in/API/V1/"+authkey+"/SMS/+91"+phone+"/"+textmessage;// Your sms
																	// gateway
																	// provider
																	// API
		// Prepare parameter string
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		// final string
		mainUrl = sbPostData.toString();
		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(
					myURLConnection.getInputStream()));			
			// finally close connection
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
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
