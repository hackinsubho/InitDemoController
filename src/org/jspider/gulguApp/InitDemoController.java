package org.jspider.gulguApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InitDemoController extends GenericServlet{
	Connection con;
	
@Override
	public void init(ServletConfig config) throws ServletException {
	 	
		super.init(config);
		System.out.println("i am init");
		String user=config.getInitParameter("un");
		String password = config.getInitParameter("pass");
		String driver= config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println(con);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("i am service");
		
	}
@Override
public void destroy() {
	// TODO Auto-generated method stub
	super.destroy();
	if(con!=null) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
