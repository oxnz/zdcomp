package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBHelper;
import dao.UserDaoImpl;
import entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nickname = request.getParameter("username").trim();
			String email = request.getParameter("email").trim();
			String password = request.getParameter("password").trim();
			String qq = request.getParameter("qq").trim();
			
			User user = new User(0, email, qq, helper.MD5Helper.encrypt(password), nickname, 2);
			UserDaoImpl udi = new UserDaoImpl();
			
			Connection conn = DBHelper.getConnection();
			String querySql = "select * from user where email='" + email + "';";
			if (DBHelper.executeQuery(conn, querySql).next() == false) {
				boolean isOK = udi.insertNewUser(user);
				if (isOK) {
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("failed.jsp").forward(request, response);
				}
			} else {
				request.getRequestDispatcher("failed.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
