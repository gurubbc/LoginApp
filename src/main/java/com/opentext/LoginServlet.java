package com.opentext;

import java.io.IOException;
import java.sql.SQLException;

import com.opentext.model.CredentialValidator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("username"); // read from Login.html
		String password=request.getParameter("password"); // read from Login.html
		
		boolean isValidUser=false;
		try {
			isValidUser = CredentialValidator.validateUser(userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("userName", "Mr. "+userName);
		if (isValidUser) {
			request.getRequestDispatcher("success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("failure.jsp").forward(request, response);
		}
	}

}
