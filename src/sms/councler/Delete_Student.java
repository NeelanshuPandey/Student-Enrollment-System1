package sms.councler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sms.dbinfo.DBConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Delete_Student extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Student frame = new Delete_Student();
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
	public Delete_Student() {
		setTitle("Delete_Student\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(93, 250, 106));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textlabel = new JLabel("Roll_no");
		textlabel.setBounds(19, 42, 61, 16);
		contentPane.add(textlabel);
		
		txtroll = new JTextField();
		txtroll.setBounds(102, 37, 130, 26);
		contentPane.add(txtroll);
		txtroll.setColumns(10);
		
		JButton btndelete = new JButton("DELETE");
		btndelete.addActionListener(this);
		
		btndelete.setBounds(62, 120, 117, 29);
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
		
		String Roll=txtroll.getText();
		if (Roll.isBlank())
		{
			JOptionPane.showMessageDialog(this,"Please Enter a course NAme");
		}
		else
		{
		int choice=	JOptionPane.showConfirmDialog(this,"Are you sure to delete"+Roll+"course");
		//System.out.println(choice);
		
		if(choice==0)
		{
			Connection con=DBConnection.createConnection();
			PreparedStatement ps=null;
			
			String deleteQuery="delete from Student_detail where roll_number=?";
			
			try
			{
				ps=con.prepareStatement(deleteQuery);
				ps.setString(1,Roll);
				System.out.print(ps);
				
				int status=ps.executeUpdate();
				if(status>0)
				{
					JOptionPane.showMessageDialog(this,Roll+" Course deleted successfully");
					txtroll.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(this,Roll+"course does not exist");
					txtroll.setText("");
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
