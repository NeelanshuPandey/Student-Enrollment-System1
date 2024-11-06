package sms.councler;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import sms.admin.Add_Students;
import sms.admin.Admin;
import sms.admin.Delete_Course;
import sms.admin.UpdateCourse;
import sms.common.AllCourses;
import sms.common.AllFeedback;
import sms.common.AllStudent;
import sms.common.LoginFrame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Counselor extends JFrame implements ActionListener,WindowListener
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
					Counselor frame = new Counselor();
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
	public Counselor() 
	{
		this.addWindowListener(this);
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Counselor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu menu_student = new JMenu("Student");
		menu_student.addActionListener(this);
		menu_student.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		menuBar.add(menu_student);
		
		JMenuItem mi_enroll = new JMenuItem("Enroll");
		mi_enroll.addActionListener(this);
		mi_enroll.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		menu_student.add(mi_enroll);
		
		JMenuItem mi_edit = new JMenuItem("Edit");
		mi_edit.addActionListener(this);
		mi_edit.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		menu_student.add(mi_edit);
		
		JMenuItem mi_remove = new JMenuItem("Remove");
		mi_remove.addActionListener(this);
		mi_remove.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		menu_student.add(mi_remove);
		
		
		JMenuItem mi_feedback = new JMenuItem("Add Feedback");
		mi_feedback.addActionListener(this);
		mi_feedback.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
		menu_student.add(mi_feedback);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));

		
		JMenu Menu_Report = new JMenu("Report");
		Menu_Report.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		menuBar.add(Menu_Report);
		
		JMenuItem mi_Allcourse = new JMenuItem("All Course");
		mi_Allcourse.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		mi_Allcourse.addActionListener(this);
		Menu_Report.add(mi_Allcourse);
		
		JMenuItem mi_allstudent = new JMenuItem("All Student");
		mi_allstudent.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		mi_allstudent.addActionListener(this);
		Menu_Report.add(mi_allstudent);
		
		JMenuItem mi_allfeedback = new JMenuItem("All FeedBack");
		mi_allfeedback.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		mi_allfeedback.addActionListener(this);
		Menu_Report.add(mi_allfeedback);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		LoginFrame login=new LoginFrame();
		login.setVisible(true);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String ItemText=e.getActionCommand();
//		
//		if (ItemText.equalsIgnoreCase("Update")) {
//			UpdateCourse course=new UpdateCourse();
//			course.setVisible(true);
//		}
//		if (ItemText.equalsIgnoreCase("delete")) {
//			Delete_Course course=new Delete_Course();
//			course.setVisible(true);
//		}
		if(ItemText.equalsIgnoreCase("Enroll")) {
			Add_Students course=new Add_Students();
			course.setVisible(true);
			
			
		}
		if(ItemText.equalsIgnoreCase("Edit")) {
			UpdateStudent course=new UpdateStudent();
			course.setVisible(true);}
		
		
		if(ItemText.equalsIgnoreCase("Remove"))
		{
			Delete_Student course=new Delete_Student();
			course.setVisible(true);}
		
		 
		
	
	
	
	if(ItemText.equalsIgnoreCase("All Course"))
	{
		AllCourses course=new AllCourses();
		course.setVisible(true);
		
	}

	if(ItemText.equalsIgnoreCase("All Student"))
	{
		AllStudent course=new AllStudent();
    	course.setVisible(true);
	
	}
	
	if(ItemText.equalsIgnoreCase("Add Feedback"))
	{
		FeedBack course=new FeedBack();
    	course.setVisible(true);
	
	}
	if(ItemText.equalsIgnoreCase("All FeedBack"))
	{
		AllFeedback course=new AllFeedback();
    	course.setVisible(true);
	
	}
	

		
		
		
	}

}
