package vinay.framework.interfaces;

import javax.servlet.http.HttpServletRequest;

public interface AbstractBusinessService {

	public abstract Object execute(HttpServletRequest request,Object object);
}
