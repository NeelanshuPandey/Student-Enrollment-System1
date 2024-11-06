package sms.common;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import sms.dbinfo.DBConnection;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.sql.*
;
import javax.swing.border.LineBorder;public class AllFeedback extends JFrame {

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
					AllFeedback frame = new AllFeedback();
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
		
		String sql="select  name,feedback_text,date from feedback";
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
	public AllFeedback() {
		setTitle("AllCourses");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(231, 255, 148));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 36, 305,197);
		contentPane.add(scrollPane);
		
		table = new JTable();
		 JTableHeader header=table.getTableHeader();
		 header.setBackground(Color.CYAN);
		 header.setForeground(Color.LIGHT_GRAY);
		 header.setForeground(new Color(100,100,240));
		 
		 header.setFont(new Font("Comic Sans Ms",Font.BOLD,15));
		 
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		fillTable();//to display data from database table
		
		 TableColumnModel tcm=table.getColumnModel();
		   tcm.getColumn(0).setHeaderValue("Name");
		   tcm.getColumn(1).setHeaderValue("feedback");
		   tcm.getColumn(2).setHeaderValue("Date");
		
		
		scrollPane.setViewportView(table);
	}
	
}
