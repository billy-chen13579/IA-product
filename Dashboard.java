package software;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class Dashboard extends JFrame implements ActionListener{
	
	JLabel student_title = new JLabel("Student: ");
	JLabel Today_class = new JLabel("Today's Class:");
	
	JButton add_student = new JButton("Add Student");
	JButton stu_dashboard = new JButton("Check Student Dashboard");
	JButton class_info = new JButton("Edit Class Info");
	JButton check_time = new JButton("Check All time");
	
	DefaultListModel<String> student_list = new DefaultListModel<>();
	JList<String> stu_list = new JList<>(student_list);
	
	DefaultListModel<String> class_list = new DefaultListModel<>();
	JList<String> cl_list = new JList<>(class_list);
	
	ArrayList<String[]> class_info_storage = new ArrayList<String[]>();
	
	Dashboard(){
		
//		int num_student = Main.student_data.size();
//		for(int i=0; i<num_student; i++) {
//			
//		}
		
		for(String[] index:Main.student_data) {
			student_list.addElement(index[0]);
		}
		
//		//list
//		student_list.addElement("Billy");
//		student_list.addElement("Adam");
//		student_list.addElement("Jack");
		
		stu_list.setBounds(20,85,150,300);
		stu_list.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
		stu_list.setBackground(Color.LIGHT_GRAY);
		
		
		
		for(String[] index:Main.todayclass) {
			String class_name = index[0] + index[1];
			class_info_storage.add(index);
			class_list.addElement(class_name);
		}
//		
//		class_list.addElement("Billy: 1PM~2PM");
//		class_list.addElement("Adam: 3PM~4PM");
//		class_list.addElement("Jack: 5PM~6PM");
		
		cl_list.setBounds(200,85,250,300);
		cl_list.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
		cl_list.setBackground(Color.LIGHT_GRAY);
		
		
		
		//Label
		student_title.setBounds(15,15,130,50);
		student_title.setFont(new Font(Font.DIALOG, Font.BOLD, 23));
		student_title.setForeground(Color.black);
		
		Today_class.setBounds(280, 15, 200, 50);
		Today_class.setFont(new Font(Font.DIALOG, Font.BOLD, 23));
		Today_class.setForeground(Color.black);
		
		//Button
		add_student.setBounds(130, 20, 130, 50);
		add_student.addActionListener(this);
		add_student.setFocusable(false);
		add_student.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 18));
		add_student.setBackground(Color.cyan);
		
		stu_dashboard.setBounds(20, 400, 180, 50);
		stu_dashboard.addActionListener(this);
		stu_dashboard.setFocusable(false);
		stu_dashboard.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 12));
		stu_dashboard.setBackground(Color.cyan);
		
		class_info.setBounds(200, 400, 130, 50);
		class_info.addActionListener(this);
		class_info.setFocusable(false);
		class_info.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 12));
		class_info.setBackground(Color.cyan);
		
		check_time.setBounds(330, 400, 130, 50);
		check_time.addActionListener(this);
		check_time.setFocusable(false);
		check_time.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 12));
		check_time.setBackground(Color.cyan);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		
		this.add(student_title);
		this.add(Today_class);
		
		this.add(add_student);
		this.add(stu_dashboard);
		this.add(class_info);
		this.add(check_time);
		
		this.add(stu_list);
		this.add(cl_list);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == add_student) {
			Window_add_student click_add_stu = new Window_add_student();
		}
		if(e.getSource() == check_time) {
			Window_check_all check_all_time = new Window_check_all();
		}
		if(e.getSource() == stu_dashboard) {
			
			if(stu_list.getSelectedIndex()!=-1) {
				String student_select = stu_list.getSelectedValue();
						
				Window_student_dashboard click_student = new Window_student_dashboard(student_select);
			}
			

		}
		if(e.getSource() == class_info) {
			if(cl_list.getSelectedIndex()!=-1) {
				String class_select = cl_list.getSelectedValue();
				
				String[] selected_title = class_select.split(": ");
				for(String[] index: class_info_storage) {
					if(index[0].contains(selected_title[0])) {
						Window_class_info click_today_class = new Window_class_info(class_select, index);
					}
				}
			}
			
			
		}
	}
}


