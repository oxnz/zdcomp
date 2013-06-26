package controller;

import java.io.IOException;
import java.util.Date;

import dao.VoteDaoImpl;
import entity.User;
import entity.Vote;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VoteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public VoteServlet() {
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
			//���û��Ƿ��Ѿ���¼
			HttpSession session=request.getSession(false);
			int work_id=Integer.parseInt(request.getParameter("work_id").trim());
			if(session.getAttribute("login_user")!=null){
				User login_user=(User)session.getAttribute("login_user");
				
				//�����û��Ƿ�Ͷ��Ʊ
				VoteDaoImpl vdi=new VoteDaoImpl();
				
				if(!vdi.selectIsVoted(login_user.getUser_id(), work_id)){
					java.text.DateFormat df=java.text.DateFormat.getDateTimeInstance();
					Date now=new Date();
					String vote_time=df.format(now);
					
					Vote vote=new Vote(0, login_user.getUser_id(), work_id, vote_time);
					boolean isOK=vdi.insertNewVote(vote);
					if(isOK){
						
						System.out.println("ͶƱ�ɹ���");
						String info="votesuccess";
						String page="WorkDetail.do";
						request.getRequestDispatcher("Remark_result.jsp?page="+page+"&&info="+info+"&&work_id="+work_id).forward(request, response);
					}
				}else{
					
					String info="isvoted";
					String page="WorkDetail.do";
					request.getRequestDispatcher("Remark_result.jsp?page="+page+"&&info="+info+"&&work_id="+work_id).forward(request, response);
					System.out.println("�ظ�ͶƱ");
				}
			}
			//���û�е�¼������ʾ��¼
			else{
				String info="unlogged";
				String page="Index.do";
				request.getRequestDispatcher("Result.jsp?page="+page+"&&info="+info).forward(request, response);
				System.out.println("û��¼");
			}
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
