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
	
	//返回随机颜色(Color对象)
	private static Color getRandomColor(int minColor,int maxColor){
		Random random=new Random();
		//保存minColor最大不会超过255
		if(minColor>255){
			minColor=255;
		}
		//保存maxColor最大不会超过255
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
		//关闭浏览器缓冲区
		response.setHeader("ragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		//设置图形验证码的长宽
		int width=90,height=20;
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
		Graphics g=image.getGraphics();
		Random random=new Random();
		g.setColor(getRandomColor(180,250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman",Font.ITALIC,height));
		g.setColor(getRandomColor(120,180));
		
		//保存最后随机生成的验证码
		StringBuilder validationCode=new StringBuilder();
		String[] fontNames={"Times New Roman","Book antiqua","Arial"};
		//随机生成3-5个验证码
		for(int i=0;i<3+random.nextInt(3);i++){
			//随机设置当前验证码的字符字体
			g.setFont(new Font(fontNames[random.nextInt(3)],Font.ITALIC,height));
			//随机获得当前验证码的字符
			char codeChar=codeChars.charAt(random.nextInt(charsLength));
			validationCode.append(codeChar);
			//随机设置当前验证码字符的颜色
			g.setColor(getRandomColor(10,100));
			//在图形上输出验证码字符
			g.drawString(String.valueOf(codeChar), 16*i+random.nextInt(7), height-random.nextInt(6));
		}
		//获得HttpSession对象
		HttpSession session=request.getSession();
		//session 5分钟失效
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
