package sms.admin;

import java.awt.EventQueue;
import java.awt.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sms.dbinfo.DBConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Delete_Course extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Course frame = new Delete_Course();
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
	public Delete_Course() {
		setResizable(false);
		setTitle("DeleteCourse");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Course Name");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel.setBounds(6, 6, 144, 16);
		contentPane.add(lblNewLabel);
		
		textname = new JTextField();
		textname.setBounds(162, 1, 130, 26);
		contentPane.add(textname);
		textname.setColumns(10);
		
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(this);
		
		btndelete.setBounds(89, 145, 117, 29);
		contentPane.add(btndelete);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		deleteCourse();
		
		
	}
	public void deleteCourse()
	{
		//System.out.println("button clicked");
		
		String name=textname.getText();
		if (name.isBlank())
		{
			JOptionPane.showMessageDialog(this,"Please Enter a course NAme");
		}
		else
		{
		int choice=	JOptionPane.showConfirmDialog(this,"Are you sure to delete"+name +"course");
		//System.out.println(choice);
		
		if(choice==0)
		{
			Connection con=DBConnection.createConnection();
			PreparedStatement ps=null;
			
			String deleteQuery="delete from course_details where course_name=?";
			
			try
			{
				ps=con.prepareStatement(deleteQuery);
				ps.setString(1,name);
				System.out.print(ps);
				
				int status=ps.executeUpdate();
				if(status>0)
				{
					JOptionPane.showMessageDialog(this,name+" Course deleted successfully");
					textname.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(this,name+"course does not exist");
					textname.setText("");
				}
			}
			catch(SQLException se){
				
				se.printStackTrace();
			}
			finally {
				
			}try {
				if(ps!=null )
					ps.close();
				if (con!=null)
				con.close();
			}
			catch(SQLException se)
			{
				
			}
		}
			
			
		}
		
		}
	

}
