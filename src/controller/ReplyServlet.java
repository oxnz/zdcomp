package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReplyDaoImpl;
import dao.RemarkDaoImpl;
import entity.Reply;
import entity.User;

public class ReplyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ReplyServlet() {
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
			HttpSession session=request.getSession(false);
			if(session.getAttribute("login_user")!=null){
				User login_user=(User)session.getAttribute("login_user");
				//String content=new String(request.getParameter("content").getBytes("ISO-8859-1"),"utf-8");
				String content=request.getParameter("content");
				String input_validation=request.getParameter("security").trim();
				String correct_validation=session.getAttribute("validation").toString().trim();
				int work_id=Integer.parseInt(request.getParameter("work_id").trim());
				//
				boolean isNull=(input_validation==null)||(content.equals(""));
				if(!isNull){
					//
					if(input_validation.equalsIgnoreCase(correct_validation)){
						//
						RemarkDaoImpl vdi=new RemarkDaoImpl();
						if(!(login_user.getUser_type()==2&&!(vdi.selectIsRemarked(login_user.getUser_id(), work_id)))){
							ReplyDaoImpl rdi=new ReplyDaoImpl();
							int reply_type=0;
							String nickname=login_user.getNickname();
							
							java.text.DateFormat df=java.text.DateFormat.getDateTimeInstance();
							Date now=new Date();
							String time=df.format(now);
							//
							if(login_user.getUser_type()==1){
								reply_type=1;
							}
							//
							else if(login_user.getUser_type()==2){
								reply_type=2;
							}
							Reply reply=new Reply(0,nickname,work_id,content,reply_type,time);
							boolean isOK=rdi.insertNewReply(reply);
							if(isOK){
								String page="WorkDetail.do";
								String info="replysuccess";
								request.getRequestDispatcher("Remark_result.jsp?page="+page+"&&info="+info+"&&work_id="+work_id).forward(request, response);
							}
						}
						//
						else{
							
							String page="WorkDetail.do";
							String info="remarkbeforereply";
							request.getRequestDispatcher("Remark_result.jsp?page="+page+"&&info="+info+"&&work_id="+work_id).forward(request, response);
						}
					}
					//�����֤�����
					else{
						
						String page="WorkDetail.do";
						String info="validationwrong";
						request.getRequestDispatcher("Remark_result.jsp?page="+page+"&&info="+info+"&&work_id="+work_id).forward(request, response);
					}
				}
				//�������Ϊ��
				else{
					String page="WorkDetail.do";
					String info="nullinput";
					request.getRequestDispatcher("Remark_result.jsp?page="+page+"&&info="+info+"&&work_id="+work_id).forward(request, response);
				}
			}
			//���û�е�¼������ʾ���
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
