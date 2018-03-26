package pers.qiuyuzu.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.JFreeChart;

import pers.qiuyuzu.util.CreateLineChart;
import pers.qiuyuzu.util.IOtxt;





/**
 * Servlet implementation class Record
 */
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecordServlet() {
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
		// 传过来的时间
		String time = request.getParameter("time");
		request.setAttribute("time", time);
		System.out.println("传过来的time:" + time);
		// 项目目录
		String rootPath = this.getServletContext().getRealPath("/data");
		// 用户生理信息
		String userFilePath = rootPath + File.separator+ time;
		System.out.println("userFilePath" + userFilePath);
		String record[] = IOtxt.readRecord(userFilePath);

		String userResp = record[0];
		String userHr   = record[1];
		String userSpo2 = record[2];
		String userPr   = record[3];
		String userSBP  = record[4];
		String userDBP  = record[5];
		String userTEMP = record[6];

		request.setAttribute("userResp", userResp);
		request.setAttribute("userHr", userHr);
		request.setAttribute("userSpo2", userSpo2);
		request.setAttribute("userPr", userPr);
		request.setAttribute("userSBP", userSBP);
		request.setAttribute("userDBP", userDBP);
		request.setAttribute("userTEMP", userTEMP);

		System.out.println("************");
		// 用户ECG信息
		String ecgFilePath = rootPath + File.separator + time + "ECG";
		System.out.println("ecgfilePath:" + ecgFilePath);
		//ECG ECG[] = new JsonUtil().findECG(ecgFilePath);
		Double[] ECG = IOtxt.readECG(ecgFilePath);
		String ECGString[] = new String[ECG.length];
		int j = 0;
		for (int i = 0; i < ECG.length; i++) {
			ECGString[i] = String.valueOf(ECG[i].intValue());
			System.out.println("ECG" + i + ":" + ECG[i]);
		}
		// 生成ECG折线图
		JFreeChart mECGChart = new CreateLineChart("ECG", ECGString)
				.GetLineChart();
		request.setAttribute("mECGChart", mECGChart);
		// 跳转到record.jsp
		request.getRequestDispatcher("/record.jsp").forward(request, response);

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
