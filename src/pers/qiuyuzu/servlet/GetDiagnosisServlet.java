package pers.qiuyuzu.servlet;
import java.io.File;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import pers.qiuyuzu.util.IOtxt; 
public class GetDiagnosisServlet extends HttpServlet {
	 private static final long serialVersionUID = 6792396567928634227L; 
	    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {  
	        response.setContentType("text/plain; charset=UTF-8");  
	        request.setCharacterEncoding("UTF-8");  
	        String time = request.getParameter("time");
	        System.out.println(time);
	        PrintWriter printWriter = response.getWriter(); 
			// 项目目录
			String rootPath = this.getServletContext().getRealPath("/data");
	        String diagnosisFilePath = rootPath + File.separator + time + "diagnosis";
	        System.out.println(diagnosisFilePath);
	        //if()
	        String diagnosis = IOtxt.readDiagnosis(diagnosisFilePath);
	        printWriter.print(diagnosis);  
	        printWriter.flush();  
	        printWriter.close();  
	    }
}
