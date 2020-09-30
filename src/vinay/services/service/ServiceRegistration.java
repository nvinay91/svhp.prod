package vinay.services.service;

import javax.servlet.http.HttpServletRequest;

import vinay.framework.dao.ServiceRegistrationDAO;
import vinay.framework.interfaces.AbstractBusinessService;
import vinay.services.model.ServiceRegistrationModel;

public class ServiceRegistration implements AbstractBusinessService {

	@Override
	public Object execute(HttpServletRequest request, Object object) {
		int save=0;
		try {
			ServiceRegistrationModel model = (ServiceRegistrationModel) object;

			String sql_stmt = "INSERT INTO USER_REGISTRATION (REGISTRATION_NO, FIRST_NAME, LAST_NAME, MOBILE, EMAIL, ADDRESS1, ADDRESS2, ADDRESS3, PIN_CODE,CUSTOM_USER_ID, CREATED_DATE, STATUS, GROUP_ID, PASSWORD,STATUS_CD,GROUP_CD) VALUES "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			save = ServiceRegistrationDAO.insertOrUpdate(sql_stmt, model);

		} catch (Exception e) {
			System.out.println(e);
		}
		return save;
	}

}
