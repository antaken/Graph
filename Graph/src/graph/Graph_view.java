package graph;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph_view extends Frame implements ActionListener,WindowListener{
	private Button button1 = new Button("BarChart");
	private Button button2 = new Button("LineChart");
	
	
	public Graph_view(int a) {
		addWindowListener(this);
		setTitle("Graph");
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		add(button1);
		add(button2);
	    button1.addActionListener(this);
		button2.addActionListener(this);
        
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		int id,ton;
		String name,year;
		ResultSet rs;
		MySQL mysql = new MySQL();
		rs = mysql.selectAll();

		try {
			while(rs.next()){
			    id = rs.getInt("id");
			    name = rs.getString("name");
			    year = rs.getString("year");
			    ton = rs.getInt("ton");
			    
			    data.addValue(ton, name, year);
			}  
			} catch (SQLException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
		
		if(a==1) {
		
		    JFreeChart chart = 
		      ChartFactory.createLineChart("Import Volume",
		                                   "Year",
		                                   "Ton",
		                                   data,
		                                   PlotOrientation.VERTICAL,
		                                   true,
		                                   false,
		                                   false);
	
		    ChartPanel cpanel = new ChartPanel(chart);
		    add(cpanel, BorderLayout.CENTER);
		}
		if(a==2) {
			
		    JFreeChart chart = 
		      ChartFactory.createBarChart("Import Volume",
		                                   "Year",
		                                   "Ton",
		                                   data,
		                                   PlotOrientation.VERTICAL,
		                                   true,
		                                   false,
		                                   false);
	
		    ChartPanel cpanel = new ChartPanel(chart);
		    add(cpanel, BorderLayout.CENTER);
		}
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1) {
			dispose();
			Graph_view graph = new Graph_view(1);
			graph.setBounds(5,5,720	,500);
		  	graph.setVisible(true);
		}else if(e.getSource() == button2) {
			dispose();
			Graph_view graph = new Graph_view(2);
			graph.setBounds(5,5,720,500);
			graph.setVisible(true);
		}
		
	}                                                                                                                                                             

}
