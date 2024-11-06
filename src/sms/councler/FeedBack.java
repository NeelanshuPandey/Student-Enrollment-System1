package sms.councler;

import java.awt.EventQueue;
import java.sql.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import sms.dbinfo.DBConnection;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
public class FeedBack extends JFrame  implements ActionListener,KeyListener
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedBack frame = new FeedBack();
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
	JComboBox comboBox;
	JTextArea txtarea;
	JDateChooser dc;
	JButton btnsubmit;
	public FeedBack() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(239, 113, 99));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);  
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(6, 18, 61, 16);
		contentPane.add(lblNewLabel);
		
		txtname = new JTextField();
		txtname.setBounds(109, 13, 130, 26);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Course");
		lblNewLabel_1.setBounds(6, 61, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		 comboBox = new JComboBox();
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select_Course"}));
		// comboBox.addActionListener(this);
		 //filledCombo();
		 
		comboBox.setBounds(109, 57, 144, 27);
		contentPane.add(comboBox);
		filledCombo();
		
		 dc = new JDateChooser();
		dc.setDateFormatString("yyyy-MM-dd");
		dc.setBounds(102, 203, 158, 26);
		contentPane.add(dc);
		
		JLabel lblNewLabel_2 = new JLabel("FeedBack");
		lblNewLabel_2.setBounds(6, 111, 80, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setBounds(6, 203, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		 txtarea = new JTextArea();
		txtarea.setBounds(109, 111, 130, 42);
		contentPane.add(txtarea);
		
		  btnsubmit = new JButton("SUBMIT");
		//btnsubmit.
		
		btnsubmit.addActionListener(this);
		btnsubmit.setBounds(50, 241, 117, 29);
		contentPane.add(btnsubmit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Button clicked");
		addFeedback();
		
		
		
    
		
		
		
		
			
		
		
	}
	
	public void addFeedback()
	{
		
	Date d=	dc.getDate();//return java.util.Date class object
		System.out.println(d);
		
		// conversion of util date int sql date
		
	long dt=	d.getTime();
		System.out.println(dt);
		
		java.sql.Date sd=new java.sql.Date(dt);//fully qualified class name
		System.out.println(sd);
		
		String cname=(String)comboBox.getSelectedItem();
		String name=txtname.getText();
		String fd=txtarea.getText();
		
		
		Connection con=DBConnection.createConnection();
		PreparedStatement ps=null;
		
		String insertQuery="insert into feedback(name,course,feedback_text,date)values(?,?,?,?)";
		
		try {
			ps=con.prepareStatement(insertQuery);
			ps.setString(1,name);
			ps.setString(2,cname);
			ps.setString(3,fd);
			ps.setDate(4,sd);
			
			
			int status=ps.executeUpdate();		
			if(status>0) {
				
				JOptionPane.showMessageDialog(this, "feedback is successfully");
				
			}
		}
		catch(SQLException se   ) {
			se.printStackTrace();
		}
		
//		
//		//String insertQuery="insert into feedback(name,course,feedback_text,date)values(????)";
//		
//		String cname=(String)comboBox.getSelectedItem();//to fetch the data from the combo box 
//		
//		
//		
//		Connection con=DBConnection.createConnection();
	
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public void filledCombo()
	{
		
		Connection con=DBConnection.createConnection();
		 String selectQuery="select course_name from course_details";
		 
		 PreparedStatement ps=null;// execute the query
		 
		 ResultSet rs=null;// hold the result of the query
		 
		 try
		 {
			 ps=con.prepareStatement(selectQuery);//to pass the query to dbms
			 //passes to rdms --> query-->compiled query->
			 // ps hold the query of compiles query
			rs= ps.executeQuery();
			
			while(rs.next())
			{
				comboBox.addItem(rs.getString("course_name"));
			}
			
		 }
		 catch(SQLException se) {
			 
			 
			 se.printStackTrace();
		 }
		 
		 finally {
				
			}try {
				if(rs!=null)
					rs.close();
				if(ps!=null )
					ps.close();
				if (con!=null)
				con.close();
			}
			catch(SQLException se)
			{
				
			}
		
		
	}
	//@Override
	
	
	

	}

