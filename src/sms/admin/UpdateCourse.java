package sms.admin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import sms.dbinfo.DBConnection;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdateCourse extends JFrame implements ActionListener,KeyListener
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCourse frame = new UpdateCourse();
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
	JComboBox cmbcourse;
	JButton btnupdate;
	private JTextField txtfee;
	private JTextField txtduration;
	
	public UpdateCourse() {
		setTitle("UpdateCourse");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(132, 255, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 cmbcourse = new JComboBox();
		 
		 cmbcourse.addActionListener(this);
		 
		cmbcourse.setModel(new DefaultComboBoxModel(new String[] {"SelectCourseName"}));
		
		filledCombo();//to fill the combo
		
		cmbcourse.setBounds(6, 39, 168, 27);
		contentPane.add(cmbcourse);
		
		JLabel lblNewLabel = new JLabel("Fees");
		lblNewLabel.setBounds(6, 97, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Duration");
		lblNewLabel_1.setBounds(6, 125, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		txtfee = new JTextField();
		txtfee.setBounds(79, 97, 113, 16);
		contentPane.add(txtfee);
		txtfee.setColumns(10);
		
		txtduration = new JTextField();
		txtduration.setBounds(79, 125, 113, 16);
		contentPane.add(txtduration);
		txtduration.setColumns(10);
		btnupdate=new JButton("Update");
		btnupdate.addActionListener(this);
		btnupdate.setBounds(55, 176, 117, 29);
		contentPane.add(btnupdate);
		
		
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
				cmbcourse.addItem(rs.getString("course_name"));
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		String cname=(String)cmbcourse.getSelectedItem();//to fetch the data from the combo box 
		
		if(e.getSource()==cmbcourse)
		{		
	
		
		Connection con=DBConnection.createConnection();
		
	String sql="select * from course_details where course_name=?";
	PreparedStatement ps=null;
	ResultSet rs=null;
	try {
ps=con.prepareStatement(sql);
		
	ps.setString(1,cname);
	rs=ps.executeQuery();
	rs.next();  // execute move the cursor in the table
	String fees=rs.getString("course_fees");
	String duration=rs.getString("course_duration");
	System.out.println(fees+duration);
txtfee.setText(fees);
txtduration.setText(duration);
		
	}
	catch(SQLException se)
	{
		se.printStackTrace();
		}
	
	
	
	 finally {
			
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null )
					ps.close();
				if (con!=null)
				con.close();
			}
			catch(SQLException se)
			{
				
			}}
		
		}//if close for combobox code
	
	
	
	
        if(e.getSource()==btnupdate)
        		{
        	updateCourse();
        		}
        
       
	}
        
	
	public void updateCourse()
	{
		//System.out.println("button clicked");
		
		String fee=txtfee.getText();
		String duration=txtduration.getText();
		String cname=(String)cmbcourse.getSelectedItem();//to fetch the data from the combo box 
		
		//System.out.println(cname);
		
		
		
		if (fee.isBlank()||duration.isBlank()||cname.equals("SelectCourseName"))
		{
			JOptionPane.showMessageDialog(this,"Data Required");
		}
		else
		{
		Connection con=DBConnection.createConnection();
		String updateQuery="update course_details set course_fees=?,course_duration=? where course_name=?";
			
		PreparedStatement ps=null;
		
		try {
			
			ps=con.prepareStatement(updateQuery);
			ps.setInt(1,Integer.parseInt(fee));
			ps.setString(2, duration);
			ps.setString(3, cname);
			
			
			//ps.executeUpdate();
			
			int status=ps.executeUpdate();
			
			if (status>0) {
				
				JOptionPane.showMessageDialog(this,cname +"details updated Successfully!!!!");
			}
			
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		 finally {
				
			}try {
//				if(rs!=null)
//					rs.close();
				if(ps!=null )
					ps.close();
				if (con!=null)
				con.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		
		
		
		}
			
		}
		
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		updateCourse();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
		
			

