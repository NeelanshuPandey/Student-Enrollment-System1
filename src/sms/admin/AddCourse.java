package sms.admin;

import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sms.dbinfo.DBConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Color;

public class AddCourse extends JFrame implements ActionListener,KeyListener
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtfee;
	private JTextField txtduration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourse frame = new AddCourse();
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
	public AddCourse() {
		setTitle("ADDCOURSE\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(252, 72, 53));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel.setBounds(6, 20, 72, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FEES");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(6, 60, 72, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DURATION");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel_2.setBounds(6, 108, 89, 16);
		contentPane.add(lblNewLabel_2);
		
		txtname = new JTextField();
		txtname.addKeyListener(this);
		txtname.setBounds(107, 16, 130, 26);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtfee = new JTextField();
		txtfee.addKeyListener(this);
		txtfee.setBounds(107, 56, 130, 26);
		contentPane.add(txtfee);
		txtfee.setColumns(10);
		
		txtduration = new JTextField();
		txtduration.setBounds(107, 104, 130, 26);
		contentPane.add(txtduration);
		txtduration.setColumns(10);
		
		JButton Button = new JButton("SUBMIT");
		Button.addActionListener(this);
		Button.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		Button.setBounds(120, 168, 117, 29);
		contentPane.add(Button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addCourse();
	
	}
		public void addCourse()
		{
			String name=txtname.getText();
			String fee=txtfee.getText();
			String dur=txtduration.getText();
		
			
		
			
			
			if(name.isBlank()||fee.isBlank()||dur.isBlank())
			{
				JOptionPane.showMessageDialog(this,"data require","Mandatory Field Error",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				Connection con=DBConnection.createConnection();
				String insertQuery="insert into course_details(course_name, course_fees, course_duration) values(?,?,?)";
				// ?is known as place holder
				PreparedStatement ps=null;
			try {
				// prepared statement can communicate with DB tables
				ps=con.prepareStatement(insertQuery);// passes to RDBMS-->query compile->gets stored into buffer and the buffer address
				//address is assigned to ps 
				ps.setString(1, name);
				ps.setInt(2,Integer.parseInt(fee));
				ps.setString(3,dur);
				 System.out.println();
				int row= ps.executeUpdate();
				if(row>0) {
					JOptionPane.showMessageDialog(this,"Course Added successfully");
					
					txtname.setText("");
					txtfee.setText("");
					txtduration.setText("");
				}
			}
				catch(SQLException se){
					
					se.printStackTrace();
					int errorCode=se.getErrorCode();
					
					if(errorCode==1062)
						JOptionPane.showMessageDialog(this,name+"course Already Exist!!!");
					
					
					
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
				
//				System.out.println(name);
//				System.out.println(fee);
//				System.out.println(dur);
			
			
			
	
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
			char c=e.getKeyChar();
			
			
			if(e.getSource()==txtname)
			{
		    	if(!(Character.isAlphabetic(c)||c==KeyEvent.VK_BACK_SPACE   ))
			    {
				    e.consume();
				    JOptionPane.showMessageDialog(this, "only Alphabets allowed");
			    }
				
				
			}
			
			if(e.getSource()==txtfee)
			{
				
			    	if(!(Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE   ))
				    {
					    e.consume();
					    JOptionPane.showMessageDialog(this, "only Digits allowed");
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

