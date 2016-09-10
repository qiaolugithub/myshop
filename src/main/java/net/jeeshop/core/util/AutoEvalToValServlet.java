package net.jeeshop.core.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AutoEvalToValServlet extends HttpServlet implements ServletContextListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
        EvaluateUtil EvaluateUtil = new EvaluateUtil();
        EvaluateUtil.autoEvalVal();
    }

    @Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}