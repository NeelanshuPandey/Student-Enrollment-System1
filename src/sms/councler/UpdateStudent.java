package sms.councler;

import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sms.dbinfo.DBConnection;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class UpdateStudent extends JFrame implements ActionListener,KeyListener
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
					UpdateStudent frame = new UpdateStudent();
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
	JComboBox studentcomboBox;
	JTextArea txtaddress;
	JButton btnupdate;
	private JTextField txtphone;
	private JTextField txtemail;
	
	public UpdateStudent() {
		setFont(new Font("Dialog", Font.BOLD, 25));
		setTitle("UpdateStudent");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 245, 253));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 studentcomboBox = new JComboBox();
		 //studentcomboBox.addActionListener(this);
		 studentcomboBox.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		 studentcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Select roll_number"}));
		filledCombo();
		studentcomboBox.addActionListener(this);
		
		studentcomboBox.setBackground(new Color(221, 255, 100));
		studentcomboBox.setBounds(54, 20, 181, 27);
		contentPane.add(studentcomboBox);
		
		JLabel phone = new JLabel("Phone");
		phone.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		phone.setBounds(18, 85, 61, 16);
		contentPane.add(phone);
		
		JLabel lblNewLabel_1 = new JLabel("E-Mail");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_1.setBounds(18, 113, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_2.setBounds(18, 141, 82, 16);
		contentPane.add(lblNewLabel_2);
		
		txtphone = new JTextField();
		txtphone.setBounds(105, 80, 130, 26);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(105, 108, 130, 26);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
	  txtaddress = new JTextArea();
		txtaddress.setBounds(115, 141, 120, 39);
		contentPane.add(txtaddress);
		
		 btnupdate = new JButton("AddStudent");
		btnupdate.addActionListener(this);
		btnupdate.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnupdate.setBounds(58, 199, 117, 29);
		contentPane.add(btnupdate);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		updatestudent();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	String cname=(String)studentcomboBox.getSelectedItem();//to fetch the data from the combo box 
		
		if(e.getSource()==studentcomboBox)
		{		
	
		
		Connection con=DBConnection.createConnection();
		
	String sql="select * from Student_detail where roll_number=?";
	PreparedStatement ps=null;
	ResultSet rs=null;
	try {
ps=con.prepareStatement(sql);
		
	ps.setString(1,cname);
	rs=ps.executeQuery();
	rs.next();  // execute move the cursor in the table
	String phone=rs.getString("phone");
	String email=rs.getString("email");
	String Address=rs.getString("address");
	System.out.println(phone+email+Address);
txtphone.setText(phone);
txtemail.setText(email);
txtaddress.setText(Address);		
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
			if(e.getSource()==btnupdate) {
				 updatestudent();
			}
	}

public void updatestudent()
{
	//System.out.println("button clicked");
	
	String phone=txtphone.getText();
	String email=txtemail.getText();
	String Address=txtaddress.getText();
	String roll=(String)studentcomboBox.getSelectedItem();//to fetch the data from the combo box 
	
	//System.out.println(roll);
	
	
	
	if (phone.isBlank()||email.isBlank()||Address.isBlank()||roll.equals("Select roll_number"))
	{
		JOptionPane.showMessageDialog(this,"Data Required");
	}
	else
	{
	Connection con=DBConnection.createConnection();
	String updateQuery="update Student_detail set phone=?,email=?,address=? where roll_number=?";
		
	PreparedStatement ps=null;
	
	try {
		
		ps=con.prepareStatement(updateQuery);
		ps.setString(1,phone);
		ps.setString(2, email);
		ps.setString(3, Address);
		ps.setInt(4, Integer.parseInt(roll));
		
		
		//ps.executeUpdate();
		
		int status=ps.executeUpdate();
		
		if (status>0) {
			
			JOptionPane.showMessageDialog(this,roll +"details updated Successfully!!!!");
		}
		
		
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	
	 finally {
			
		}try {
//		if(rs!=null)
//				rs.close();
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

public void filledCombo()
{
	
	Connection con=DBConnection.createConnection();
	 String selectQuery="select  roll_number from Student_detail";
	 
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
			studentcomboBox.addItem(rs.getString("roll_number"));
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
	
	
}}