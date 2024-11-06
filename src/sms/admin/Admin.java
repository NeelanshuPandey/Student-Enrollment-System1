package sms.admin;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import sms.common.AllCourses;
import sms.common.AllFeedback;
import sms.common.AllStudent;
import sms.common.LoginFrame;
import sms.councler.Delete_Student;
import sms.councler.UpdateStudent;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class Admin extends JFrame implements ActionListener,WindowListener
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
					Admin frame = new Admin();
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
	public Admin() {
		
	this.addWindowListener(this);	//this refer to admin frame class object
		
		//and is the source
		
		setResizable(false);
	setExtendedState(Frame.MAXIMIZED_BOTH);
	setTitle("Admin");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 450, 472);
	
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	JMenu menu_course = new JMenu("Course");
	menu_course.addActionListener(this);
	menu_course.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
	menuBar.add(menu_course);
	
	JMenuItem mi_addcourse = new JMenuItem("Add");
	mi_addcourse.setIcon(new ImageIcon(Admin.class.getResource("/sms/images/icons8-add-16.png")));
	mi_addcourse.addActionListener(this);
	mi_addcourse.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 19));
	menu_course.add(mi_addcourse);
	
	JMenuItem mi_updatecourse = new JMenuItem("Update");
	mi_updatecourse.setIcon(new ImageIcon(Admin.class.getResource("/sms/images/edit.png")));
	mi_updatecourse.addActionListener(this);
	mi_updatecourse.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
	menu_course.add(mi_updatecourse);
	
	JMenuItem mi_deletecourse = new JMenuItem("Delete");
	mi_deletecourse.addActionListener(this);
	mi_deletecourse.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 17));
	menu_course.add(mi_deletecourse);
	
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
	
	JMenuItem mntmNewMenuItem_2 = new JMenuItem("All Student");
	mntmNewMenuItem_2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
	mntmNewMenuItem_2.addActionListener(this);
	Menu_Report.add(mntmNewMenuItem_2);
	
	
	JMenuItem mi_allfeedback = new JMenuItem("All FeedBack");
	mi_allfeedback.setFont(new Font("Lucida Grande", Font.BOLD, 14));
	mi_allfeedback.addActionListener(this);
	Menu_Report.add(mi_allfeedback);
	
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
}
	
//	setContentPane(contentPane);
//	contentPane.setLayout(null);
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("munu cliked");
		String ItemText=e.getActionCommand();//it returns the text writtem on a menu
		//System.out.println(ItemText);
		if (ItemText.equalsIgnoreCase("Add")) {
			AddCourse course=new AddCourse();
			course.setVisible(true);
		}
		if (ItemText.equalsIgnoreCase("Update")) {
			UpdateCourse course=new UpdateCourse();
			course.setVisible(true);
		}
		if (ItemText.equalsIgnoreCase("delete")) {
			Delete_Course course=new Delete_Course();
			course.setVisible(true);
		}
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

	if(ItemText.equalsIgnoreCase("All FeedBack"))
	{
		AllFeedback course=new AllFeedback();
    	course.setVisible(true);
	
	}
	

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
		
	}}
		
