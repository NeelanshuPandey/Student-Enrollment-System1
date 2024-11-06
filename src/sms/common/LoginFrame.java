package sms.common;

import java.awt.EventQueue;
import  java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sms.admin.Add_Students;
import sms.admin.Admin;
import sms.councler.Counselor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class LoginFrame extends JFrame  implements ActionListener,KeyListener
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textuserpass;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdadmin,rdcounselor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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

	public LoginFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 255, 104));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserId");
		lblNewLabel.setBounds(6, 22, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(6, 69, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		textuserpass = new JTextField();
		textuserpass.setBounds(131, 17, 130, 26);
		contentPane.add(textuserpass);
		textuserpass.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(131, 62, 131, 31);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(83, 188, 117, 29);
		contentPane.add(btnNewButton);
		btnNewButton.addKeyListener(this);//registering key listener
		
		
		rdadmin = new JRadioButton("Admin");
		rdadmin.setBounds(31, 119, 141, 23);
		contentPane.add(rdadmin);
		
		
		rdcounselor = new JRadioButton("Counselor");
		buttonGroup.add(rdcounselor);
		rdcounselor.setBounds(184, 119, 141, 23);
		contentPane.add(rdcounselor);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/sms/images/icons8-user-20.png")));
		lblNewLabel_2.setBounds(58, 22, 29, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(LoginFrame.class.getResource("/sms/images/icons8-password-16.png")));
		lblNewLabel_3.setBounds(79, 69, 16, 16);
		contentPane.add(lblNewLabel_3);
	}
		
		public void actionPerformed(ActionEvent e)
		{
			login();
			
//			String ItemText=e.getActionCommand();
//			
//			if(ItemText.equalsIgnoreCase("Admin")) {
//				Add_Students course=new Add_Students();
//				course.setVisible(true);
//			}
			
			
			
		}
		public void login()
		{
			String userid=textuserpass.getText();
			char[]password=passwordField.getPassword();
			
			String userpass=String.valueOf(password);
			
			String userRole="";
			
			if(rdadmin.isSelected())
				userRole=rdadmin.getText();
			
			if(rdcounselor.isSelected())
				userRole=rdcounselor.getText();
			
			if(userid.isBlank()||userpass.isBlank()||userRole.isBlank())
			{
				JOptionPane.showMessageDialog(this,"ID/Password/role Required","Mandatory Field Error",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if(userid.equalsIgnoreCase("precursor")&&userpass.equals("Lucknow")&&userRole.equals("Admin"))
				{
					//System.out.println("AdminFrame");
					Admin a=new Admin();
					a.setVisible(true);
					this.dispose();//LoginFrame object(this  dispose-->window
					
				}
				else if(userid.equalsIgnoreCase("Neelanshu")&&userpass.equals("Neelanshu")&&userRole.equals("Counselor"))
				{
					//System.out.println("Counselor");
					
					Counselor c=new Counselor();
					c.setVisible(true);
					this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(this,"Invalid credential","Login Error",JOptionPane.ERROR_MESSAGE);
				
				}
					
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			
			int code=e.getKeyCode();
			System.out.println(code);
			
			if(code==10)
				login();
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

