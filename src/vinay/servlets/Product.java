package vinay.servlets;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vinay.framework.adapter.CustomerContext;
import vinay.framework.constants.GenericModel;

/**
 * Servlet implementation class Product
 */
@WebServlet("/Product")
@MultipartConfig
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List items = new ArrayList();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final String DATA_DIRECTORY = "data";
	private static final int MAX_MEMORY_SIZE = 1024 * 2048 * 2;
	private static final int MAX_REQUEST_SIZE = 1024 * 2048;
	String productName = "";
	String category = "";
	String productAmount = "";
	String offerValue = "";
	String productId_upd="";
	String message ="";
			
	private void execute(HttpServletRequest request,
			HttpServletResponse response, String mode) throws SQLException,
			IOException, ServletException {

		String imageAsString = getFileData(request, response);
		// String blobAsString = fileData(request,response);
		Connection con = GenericModel.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String imageId = "";
		// imageId = blobAsString;
		if (mode.equalsIgnoreCase("1")) {
			String sqlIdentifier = "select PRD_SEQ.NEXTVAL from dual";
			pstmt = con.prepareStatement(sqlIdentifier);
			synchronized (pstmt) {
				rs = pstmt.executeQuery();
				if (rs.next())
					imageId = String.valueOf((int) rs.getInt(1));
			}

			pstmt = con
					.prepareStatement("insert into PRD_IMAGE values(?,?,?,?)");
			pstmt.setString(1, imageId);

			FileInputStream fin = new FileInputStream(
					GenericModel.IMAGE_UPLOAD_FILE_PATH + File.separator
							+ "image.png");
			pstmt.setBinaryStream(2, fin, fin.available());
			pstmt.setDate(3, new Date(new java.util.Date().getTime()));
			pstmt.setString(4, imageId);
			int i = pstmt.executeUpdate();
			System.out.println(i + " records affected in PRD_IMAGES");

			pstmt = con
					.prepareStatement("insert into PRD_DTLS values(?,?,?,?,?,?)");
			pstmt.setString(1, imageId);
			pstmt.setString(2, productName);
			pstmt.setString(3, category);
			pstmt.setString(4, productAmount);
			pstmt.setString(5, CustomerContext.getInstance().getMOBILE());
			pstmt.setDate(6, new Date(new java.util.Date().getTime()));
			int j = pstmt.executeUpdate();
			System.out.println(j + " records affected in PRD_DTLS");

			pstmt = con
					.prepareStatement("insert into PRD_OFFERS values(?,?,?,?,?)");
			pstmt.setString(1, imageId);
			pstmt.setString(2, imageId);
			pstmt.setString(3, offerValue);
			pstmt.setDate(4, new Date(new java.util.Date().getTime()));
			pstmt.setString(5, imageId);
			int k = pstmt.executeUpdate();
			System.out.println(k + " records affected in PRD_DTLS");
			message = "Added new Product Successfully..";
		} else {
			pstmt = con
					.prepareStatement("update PRD_IMAGE set image =? where image_id=?");
			FileInputStream fin = new FileInputStream(
					GenericModel.IMAGE_UPLOAD_FILE_PATH + File.separator
					+ "image.png");
			pstmt.setBinaryStream(1, fin, fin.available());
			pstmt.setString(2, productId_upd);
			int l = pstmt.executeUpdate();
			System.out.println(l + " records affected in PRD_IMAGE");

			pstmt = con
					.prepareStatement("update PRD_DTLS set prd_name =?,prd_ctgry=?,prd_amount=? where prd_code=?");
			pstmt.setString(1, productName);
			pstmt.setString(2, category);
			pstmt.setString(3, productAmount);
			pstmt.setString(4, productId_upd);
			int m = pstmt.executeUpdate();
			System.out.println(m + " records affected in PRD_DTLS");

			pstmt = con
					.prepareStatement("update PRD_OFFERS set offer_value =? where image_id=?");
			pstmt.setString(1, offerValue);
			pstmt.setString(2, productId_upd);
			int n = pstmt.executeUpdate();
			System.out.println(n + " records affected in PRD_OFFERS");
			message = "Updated Product "+productId_upd+" Successfully..";
		}
		request.setAttribute("successMessage", message);
		HttpSession session = request.getSession(false);
		session.setAttribute("successMessage", message);
//		getServletContext().getRequestDispatcher("/done.jsp").forward(
//                request, response);
		response.sendRedirect(request.getContextPath()+"/Admin");
	}

	private String getFileData(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		String ImageDataAsString = "";
		try {
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				try {
					// Part item =(Part) iter.next();
					FileItem item = (FileItem) iter.next();
					if (item.getFieldName().equalsIgnoreCase("image")) {
						String fileName = new File("image.png").getName();
						String filePath = GenericModel.IMAGE_UPLOAD_FILE_PATH
								+ File.separator + fileName;
						File uploadedFile = new File(filePath);
						System.out.println(filePath);
						InputStream imageInputStream = item.getInputStream();

						// saves the file to upload directory
						item.write(uploadedFile);

						// BufferedImage bImage = ImageIO.read(new
						// File(filePath));
						// ByteArrayOutputStream bos = new
						// ByteArrayOutputStream();
						// ImageIO.write(bImage, "png", bos );
						// byte [] data = bos.toByteArray();
						// ImageDataAsString = data.toString();
					}
				} catch (Exception e) {
					System.out.println("Not a file");
				}
			}

			// displays done.jsp page after upload finished
			// getServletContext().getRequestDispatcher("/done.jsp").forward(
			// request, response);

		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		return ImageDataAsString;
	}

	public String fileData(String filePath) throws IllegalStateException,
			IOException, ServletException {
		InputStream isFoto = new FileInputStream(new File(filePath));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte buf[] = new byte[MAX_REQUEST_SIZE];
		int qt = 0;
		while ((qt = isFoto.read(buf)) != -1) {
			baos.write(buf, 0, qt);
		}
		String sResumen = baos.toString();
		return sResumen;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			execute(request, response, request.getParameter("mode").toString());
		} catch (SQLException e) {
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
			// Check that we have a file upload request
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			String ImageDataAsString = "";

			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Sets the size threshold beyond which files are written directly
			// to
			// disk.
			factory.setSizeThreshold(MAX_MEMORY_SIZE);

			// Sets the directory used to temporarily store files that are
			// larger
			// than the configured size threshold. We use temporary directory
			// for
			// java
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

			// constructs the folder where uploaded file will be stored
			String uploadFolder = GenericModel.IMAGE_UPLOAD_FILE_PATH;
			// + File.separator + DATA_DIRECTORY;

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Set overall request size constraint
			upload.setSizeMax(MAX_REQUEST_SIZE);
			items = upload.parseRequest(request);

			for(int i=0;i<items.size();i++){
				if (((DiskFileItem) items.get(i)).getFieldName().equalsIgnoreCase("productName")) {
					productName = ((DiskFileItem) items.get(i)).getString();
				} else if (((DiskFileItem) items.get(i)).getFieldName().equalsIgnoreCase("category")) {
					category = ((DiskFileItem) items.get(i)).getString();
				} else if (((DiskFileItem) items.get(i)).getFieldName().equalsIgnoreCase(
						"productAmount")) {
					productAmount = ((DiskFileItem) items.get(i)).getString();
				} else if (((DiskFileItem) items.get(i)).getFieldName().equalsIgnoreCase(
						"offerValue")) {
					offerValue = ((DiskFileItem) items.get(i)).getString();
					
				} else if (((DiskFileItem) items.get(i)).getFieldName().equalsIgnoreCase(
						"productId")) {
					productId_upd = ((DiskFileItem) items.get(i)).getString();
					
				}
			}
			
			execute(request, response,
					((DiskFileItem) items.get(0)).getString());
		} catch (Exception e) {
			HttpSession session = request.getSession(false);
			session.setAttribute("errorMessage", "Technical Error!!");
//			request.setAttribute("errorMessage", "Technical Error!!");

			response.sendRedirect(request.getContextPath()+"/Admin");
			
			e.printStackTrace();
		}
	}

}
