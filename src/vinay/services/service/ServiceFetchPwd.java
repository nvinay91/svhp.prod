package vinay.services.service;

import javax.servlet.http.HttpServletRequest;

import vinay.framework.dao.ServiceFetchPwdDAO;
import vinay.framework.interfaces.AbstractBusinessService;
import vinay.services.model.ServiceFetchPwdModel;

public class ServiceFetchPwd implements AbstractBusinessService {

	@Override
	public Object execute(HttpServletRequest request, Object object) {

		ServiceFetchPwdDAO dao = new ServiceFetchPwdDAO();
		ServiceFetchPwdModel model = (ServiceFetchPwdModel) object;
		String _return = "";

		String sql_stmt = "Select PASSWORD from USER_REGISTRATION where MOBILE=?";
		_return = ServiceFetchPwdDAO.fetchData(sql_stmt, model);
		

		return _return;
	}

}
