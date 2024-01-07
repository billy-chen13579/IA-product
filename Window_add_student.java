package software;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Window_add_student  extends JFrame implements ActionListener{
	
	JLabel stu_name = new JLabel("Name:");
	JLabel class_time = new JLabel("Class Time:");
	JLabel from_text = new JLabel("From");
	JLabel to_text = new JLabel("To");
	
	JTextField name_field = new JTextField();
	JTextField subject_field = new JTextField();
	
	JButton add_subject = new JButton("Add Subject:");
	JButton add = new JButton("ADD");
	
	String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
	String[] day_hour = {"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
	String[] day_min = {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
	
	JComboBox day_in_week = new JComboBox(days);
	JComboBox from_hour = new JComboBox(day_hour);
	JComboBox to_hour = new JComboBox(day_hour);
	JComboBox from_min = new JComboBox(day_min);
	JComboBox to_min = new JComboBox(day_min);
	
	DefaultListModel<String> subject_list = new DefaultListModel<>();
	JList<String> sub_list = new JList<>(subject_list);
	
	ArrayList<String> subj_list = new ArrayList<String>();
	
	Window_add_student(){
		
		//List
//		subject_list.addElement("Physics");
//		subject_list.addElement("Math");
//		subject_list.addElement("College Physics");
		
		sub_list.setBounds(300,260,150,100);
		sub_list.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
		sub_list.setBackground(Color.LIGHT_GRAY);
		
		//Label
		stu_name.setBounds(15,10,100,50);
		stu_name.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		stu_name.setForeground(Color.black);
		
		class_time.setBounds(15,60,100,50);
		class_time.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		class_time.setForeground(Color.black);
		
		from_text.setBounds(150,100,50,50);
		from_text.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		from_text.setForeground(Color.black);
		
		to_text.setBounds(300,100,50,50);
		to_text.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		to_text.setForeground(Color.black);
		
		//Textfield
		name_field.setBounds(90, 15, 150, 50);
		name_field.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
		name_field.setBackground(Color.LIGHT_GRAY);
		
		subject_field.setBounds(150, 270, 120, 50);
		subject_field.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
		subject_field.setBackground(Color.LIGHT_GRAY);
		
		//Button
		add_subject.setBounds(20, 270, 110, 50);
		add_subject.addActionListener(this);
		add_subject.setFocusable(false);
		add_subject.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		add_subject.setBackground(Color.cyan);
		
		add.setBounds(300, 15, 100, 50);
		add.addActionListener(this);
		add.setFocusable(false);
		add.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 18));
		add.setBackground(Color.cyan);
		
		//Combo
		day_in_week.setBounds(30, 110, 100, 50);
		day_in_week.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 16));
		
		from_hour.setBounds(170, 150, 80, 40);
		from_hour.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		
		to_hour.setBounds(330, 150, 80, 40);
		to_hour.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		
		from_min.setBounds(170, 200, 80, 40);
		from_min.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		
		to_min.setBounds(330, 200, 80, 40);
		to_min.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,450);
		
		this.add(stu_name);
		this.add(class_time);
		this.add(from_text);
		this.add(to_text);
		
		this.add(name_field);
		this.add(subject_field);
		
		this.add(day_in_week);
		this.add(from_hour);
		this.add(to_hour);
		this.add(from_min);
		this.add(to_min);
		
		this.add(add_subject);
		this.add(add);
	
		this.add(sub_list);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == add) {
			
			String name_data = name_field.getText();
			
			String class_day_data = (String) day_in_week.getSelectedItem();
			String from_hour_data = (String) from_hour.getSelectedItem();
			String from_min_data = (String) from_min.getSelectedItem();
			String to_hour_data = (String) to_hour.getSelectedItem();
			String to_min_data = (String) to_min.getSelectedItem();
			
			String student_subject = "";
			
			int y = 0;	
			for(String inde : subj_list) {
				if(y==0) {
					student_subject = student_subject + inde;
				}else {
					student_subject = student_subject + "\\" + inde;
				}
				y++;
			}
			
			if(Main.checkduplicate(class_day_data, from_hour_data, from_min_data, to_hour_data, to_min_data)) {
				JFrame f = new JFrame();
				JOptionPane.showMessageDialog(f,"Class time overlapped");
			}else {
				if(!name_data.isEmpty()) {
					String[] student_storing = {name_data, class_day_data, from_hour_data,from_min_data,
							to_hour_data,to_min_data,student_subject,"x","x","x","x","x","x"};
					Main.student_data.add(student_storing);
					
					String[] class_storing = {name_data, "x","x","x","x","x","x"};
					Main.class_data.add(class_storing);
					
					
					Main.write_student();
					Main.write_class();
				}else {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"Not enough information");
				}
			}
		}
		if(e.getSource() == add_subject) {
			String subject_data = subject_field.getText();
			subj_list.add(subject_data);
			subject_list.addElement(subject_data);
		}

	}

	}


