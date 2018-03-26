package pers.qiuyuzu.util;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;



public class CreateLineChart {
	public String[] data;
	public String lineName;
 	public CreateLineChart(String lineName,String[] data) {
 		this.lineName = lineName;
 		this.data = data;
	}
	public JFreeChart GetLineChart(){	
		
		DefaultCategoryDataset mDataset1 = new DefaultCategoryDataset();
		for (int i = 0; i < data.length; i++) {
			mDataset1.addValue(Integer.parseInt(data[i]), lineName, i+1+"");//第一个参数是y轴值，二个是折线名，三个是x轴
		}	
		CategoryDataset mDataset = mDataset1;
		JFreeChart mChart = ChartFactory.createLineChart(
				lineName,//标题
				"time",//横坐标标题
				"voltage",//纵坐标标题
				mDataset,//数据集
				PlotOrientation.VERTICAL,
				true, 
				true, 
				false);  
		CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
		mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
		mPlot.setRangeGridlinePaint(Color.BLUE);//背景底部横虚线
		mPlot.setOutlinePaint(Color.RED);//边界线
	    return mChart;
	}
}
