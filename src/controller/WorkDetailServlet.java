package controller;

import java.io.IOException;
import dao.*;
import java.util.*;
import entity.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkDetailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public WorkDetailServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try{
			int work_id=Integer.parseInt(request.getParameter("work_id").toString().trim());
			WorkDaoImpl wdi=new WorkDaoImpl();
			TeamDaoImpl tdi=new TeamDaoImpl();
			VoteDaoImpl vdi=new VoteDaoImpl();
			ReplyDaoImpl rdi=new ReplyDaoImpl();
			
			Work work=wdi.selectWorkById(work_id);
			Team team=tdi.selectTeamByWorkId(work_id);
			int voteCount=vdi.selectVoteCount(work_id);
			ArrayList<?> normalReply=rdi.selectAllNormalReply(work_id);
			ArrayList<?> officialReply=rdi.selectAllOfficialReply(work_id);
			
			request.setAttribute("work", work);
			request.setAttribute("team", team);
			request.setAttribute("voteCount", new Integer(voteCount));
			request.setAttribute("normalReply", normalReply);
			request.setAttribute("officialReply", officialReply);
			request.getRequestDispatcher("TeamInfo.jsp").forward(request, response);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
