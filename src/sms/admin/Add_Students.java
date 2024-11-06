package sms.admin;

import java.awt.EventQueue;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sms.dbinfo.DBConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
public class Add_Students extends JFrame  implements ActionListener,KeyListener
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textname;
	private JTextField textphone;
	private JTextField txtemail;
	private JTextField textcourse;
	private JTextField textaddcourse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Students frame = new Add_Students();
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
	public Add_Students() {
		setTitle("Add_Students");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(189, 255, 71));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel name = new JLabel("NAME");
		name.setBounds(6, 16, 61, 16);
		contentPane.add(name);
		
		JLabel phone = new JLabel("Phone");
		phone.setBounds(6, 52, 61, 16);
		contentPane.add(phone);
		
		JLabel email = new JLabel("E-Mail");
		email.setBounds(6, 80, 61, 16);
		contentPane.add(email);
		
		JLabel course = new JLabel("Course");
		course.setBounds(6, 118, 61, 16);
		contentPane.add(course);
		
		JLabel addcourse = new JLabel("AddCourse");
		addcourse.setBounds(6, 156, 77, 16);
		contentPane.add(addcourse);
		
		textname = new JTextField();
		textname.addKeyListener(this);
		textname.setBounds(108, 11, 130, 26);
		contentPane.add(textname);
		textname.setColumns(10);
		
		textphone = new JTextField();
		textphone.setBounds(108, 39, 130, 26);
		contentPane.add(textphone);
		textphone.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(108, 77, 130, 24);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		textcourse = new JTextField();
		textcourse.setBounds(108, 113, 130, 26);
		contentPane.add(textcourse);
		textcourse.setColumns(10);
		
		textaddcourse = new JTextField();
		textaddcourse.setBounds(108, 151, 130, 26);
		contentPane.add(textaddcourse);
		textaddcourse.setColumns(10);
		
		JButton button = new JButton("Submit");
		button.addActionListener(this);
		button.setBounds(67, 202, 117, 29);
		contentPane.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
addStudent();
		
		}
		public void addStudent()
		{
			String name=textname.getText();
			String email=txtemail.getText();
			String phonenumber=textphone.getText();
			String course=textcourse.getText();
			String address=textaddcourse.getText();
			
		
			
			
			if(name.isBlank()||email.isBlank()||phonenumber.isBlank()||course.isBlank()||address.isBlank())
			{
				JOptionPane.showMessageDialog(this,"data require","Mandatory Field Error",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				Connection con=DBConnection.createConnection();
				String insertQuery="insert into student_detail(Name, email, Course, address,phone) values(?,?,?,?,?)";
				// ?is known as place holder
				PreparedStatement ps=null;
			try {
				// prepared statement can communicate with DB tables
				ps=con.prepareStatement(insertQuery);// passes to RDBMS-->query compile->gets stored into buffer and the buffer address
				//address is assigned to ps 
				ps.setString(1, name);
				//ps.setInt(2,Integer.parseInt(fee));
				ps.setString(2,email);
				
				ps.setString(3,course);
				ps.setString(4, address);
				ps.setString(5, phonenumber);
				 System.out.println(ps);
				int row= ps.executeUpdate();
				if(row>0) {
					JOptionPane.showMessageDialog(this,"student Added successfully");
					
					textname.setText("");
					txtemail.setText("");
					textphone.setText("");
					textcourse.setText("");
					textaddcourse.setText("");
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			}
			
			
			}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
		
char c=e.getKeyChar();
		
		
		if(e.getSource()==textname)
		{
	    	if(!(Character.isAlphabetic(c)||c==KeyEvent.VK_BACK_SPACE   ))
		    {
			    e.consume();
			    JOptionPane.showMessageDialog(this, "only Alphabets allowed");
		    }
			
			
		}
		
		

		if(e.getSource()==textphone)
		{
			
		    	if(!(Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE   ))
			    {
				    e.consume();
				    JOptionPane.showMessageDialog(this, "only Digits allowed");
			    }
		}  	
		
		
		if(e.getSource()==textcourse)
		{
	    	if(!(Character.isAlphabetic(c)||c==KeyEvent.VK_BACK_SPACE   ))
		    {
			   e.consume();
			    JOptionPane.showMessageDialog(this, "only Alphabets allowed");
		    }
			
			
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
