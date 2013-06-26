package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ValidationServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String codeChars="%#23456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	/**
	 * Constructor of the object.
	 */
	public ValidationServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	//���������ɫ(Color����)
	private static Color getRandomColor(int minColor,int maxColor){
		Random random=new Random();
		//����minColor��󲻻ᳬ��255
		if(minColor>255){
			minColor=255;
		}
		//����maxColor��󲻻ᳬ��255
		if(maxColor>255){
			maxColor=255;
		}
		int red=minColor+random.nextInt(maxColor-minColor);
		int green=minColor+random.nextInt(maxColor-minColor);
		int blue=minColor+random.nextInt(maxColor-minColor);
		Color color=new Color(red,green,blue);		
		return color;
	}
	
	//Service method
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html;charset=utf-8");
		int charsLength=codeChars.length();
		//�ر������������
		response.setHeader("ragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		//����ͼ����֤��ĳ���
		int width=90,height=20;
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
		Graphics g=image.getGraphics();
		Random random=new Random();
		g.setColor(getRandomColor(180,250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman",Font.ITALIC,height));
		g.setColor(getRandomColor(120,180));
		
		//�������������ɵ���֤��
		StringBuilder validationCode=new StringBuilder();
		String[] fontNames={"Times New Roman","Book antiqua","Arial"};
		//�������3-5����֤��
		for(int i=0;i<3+random.nextInt(3);i++){
			//������õ�ǰ��֤����ַ�����
			g.setFont(new Font(fontNames[random.nextInt(3)],Font.ITALIC,height));
			//�����õ�ǰ��֤����ַ�
			char codeChar=codeChars.charAt(random.nextInt(charsLength));
			validationCode.append(codeChar);
			//������õ�ǰ��֤���ַ�����ɫ
			g.setColor(getRandomColor(10,100));
			//��ͼ���������֤���ַ�
			g.drawString(String.valueOf(codeChar), 16*i+random.nextInt(7), height-random.nextInt(6));
		}
		//���HttpSession����
		HttpSession session=request.getSession();
		//session 5����ʧЧ
		session.setMaxInactiveInterval(6*60);
		session.setAttribute("validation", validationCode.toString());
		g.dispose();
		OutputStream os=response.getOutputStream();
		ImageIO.write(image, "JPEG", os);
			
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
