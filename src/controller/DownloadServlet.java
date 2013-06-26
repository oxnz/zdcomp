package controller;

import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void download(String path, HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			@SuppressWarnings("deprecation")
			File file = new File(request.getRealPath("/") + "/" + path);
			String filename = file.getName();
			InputStream is = new BufferedInputStream(new FileInputStream(file));
			byte[] buffer = new byte[is.available()];
			is.read(buffer);
			is.close();
			
			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("UTF-8")));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream os = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-strea");
			os.write(buffer);
			os.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String path = request.getParameter("address").trim();
			System.out.println("Paht:" + path);
			download(path, request, response);
		} catch (Exception ex) {
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
