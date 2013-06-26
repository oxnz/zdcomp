package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RemarkDaoImpl;

import entity.Remark;
import entity.User;

/**
 * Servlet implementation class RemarkServlet
 */
@WebServlet("/RemarkServlet")
public class RemarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemarkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			if (session.getAttribute("login_user") != null) {
				User login_user = (User)session.getAttribute("login_user");
				RemarkDaoImpl rdi = new RemarkDaoImpl();
				int work_id = Integer.parseInt(request.getParameter("work_id").trim());
				if (!rdi.selectIsRemarked(login_user.getUser_id(), work_id)) {
					double score = Double.parseDouble(request.getParameter("score").trim());
					java.text.DateFormat df = java.text.DateFormat.getDateInstance();
					Date now = new Date();
					String time = df.format(now);
					
					Remark remark = new Remark(0, login_user.getUser_id(), work_id, score, time);
					boolean isOK = rdi.insertNewRemark(remark);
					if (isOK) {
						String page = "WorkDetail.do";
						String info = "remarksuccess";
						request.getRequestDispatcher("remark_result.jsp?page=" + page + "&&info=" + info + "&&work_id=" + work_id).forward(request, response);
						System.out.println("Remark Success!");
					}
				} else {
					String page = "WorkDetail.do";
					String info = "isremarked";
					request.getRequestDispatcher("remark_result.jsp?page=" + page + "&&info=" + info + "&&work_id=" + work_id).forward(request, response);
					System.out.println("打过分了");
				}
			} else {
				String info = "unlogged";
				String page = "index.do";
				request.getRequestDispatcher("result.jsp?page=" + page + "&&info=" + info).forward(request, response);
				System.out.println("没登录");
			}
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
