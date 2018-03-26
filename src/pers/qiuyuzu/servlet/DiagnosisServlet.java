package pers.qiuyuzu.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.qiuyuzu.util.IOtxt;


/**
 * Servlet implementation class DiagnosisServlet
 */
public class DiagnosisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiagnosisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 传过来的时间
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String time = request.getParameter("time");
		System.out.println("传过来的time:" + time);
		// 传过来的用户
		String diagnosis = new String(request.getParameter("diagnosis")); 
		System.out.println("诊断结果:"+diagnosis);
		// 项目目录
		String rootPath = this.getServletContext().getRealPath("/data");
		// 用户生理信息
		String diagnosisFilePath = rootPath + File.separator + time + "diagnosis";
		IOtxt.writeDiagnosis(diagnosisFilePath, diagnosis);
		response.sendRedirect(request.getContextPath()+"/TimeListServlet");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
