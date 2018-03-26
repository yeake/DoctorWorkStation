package pers.qiuyuzu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.qiuyuzu.util.CONST;
import pers.qiuyuzu.util.IOtxt;

/**
 * Servlet implementation class TimeListServlet
 */
public class TimeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimeListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 传过来的用户
		String user = request.getParameter("user");
		request.setAttribute("user", user);
		// 用户具体的文件路径
		CONST.FilePath = this.getServletContext().getRealPath("/data/");
		String filePath = CONST.FilePath;
		System.out.println("用户具体的文件路径" + filePath);
		// 时间序列
		//List<String> timeList = FileUtil.getTimeList(filePath);
		String[] timeList = IOtxt.listFile(filePath);
		request.setAttribute("timeList", timeList);
		request.getRequestDispatcher("/TimeListUIServlet").forward(
				request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
