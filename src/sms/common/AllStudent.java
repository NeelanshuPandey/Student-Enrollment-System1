package sms.common;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import sms.dbinfo.DBConnection;

import javax.swing.JTable;
import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JScrollPane;
public class AllStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllStudent frame = new AllStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	
	public void fillTable()
	{
		Connection con=DBConnection.createConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM Student_detail;";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			
			TableModel tm=DbUtils.resultSetToTableModel(rs);
			table.setModel(tm);
			
			
			
			
		}
		catch(SQLException se)
		{
		se.printStackTrace();
	}
	}
	
	
	public AllStudent() {
		setTitle("All Student");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 43, 517, 360);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table = new JTable();
		table.setBounds(80, 70,304,274);
		//contentPane.add(table);
		
		
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		fillTable();//to display data from database table
		
		 TableColumnModel tcm=table.getColumnModel();
		   tcm.getColumn(0).setHeaderValue("roll number");
		   tcm.getColumn(1).setHeaderValue("name");
		   tcm.getColumn(2).setHeaderValue("email");
		   tcm.getColumn(3).setHeaderValue("course");
		   tcm.getColumn(4).setHeaderValue("address");
		   tcm.getColumn(5).setHeaderValue("phone");
		scrollPane.setViewportView(table);
		
		//fillTable();
		 
	}
	}
//roll_number, name, email, course, address, phone
