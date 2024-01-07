package software;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class Window_student_dashboard  extends JFrame implements ActionListener{
	
	JLabel stu_name = new JLabel();
	JLabel past_class = new JLabel("Past 10 classes:");
	JLabel search_class = new JLabel("Search for last class with specific subject");
	
	JButton stu_info = new JButton("Info");
	JButton add_common = new JButton("Add Common Class Time");
	JButton add_tempt = new JButton("Add Temporary Class Time");
	JButton search = new JButton("Search");
	JButton delete = new JButton("Delete Student");
	JButton check_class = new JButton("Check class info");
	
	String stu_subject = "";
	JComboBox subject_combo;
	
	DefaultListModel<String> past_class_list = new DefaultListModel<>();
	JList<String> past_cl_list = new JList<>(past_class_list);
	
	String name = "";

	
	Window_student_dashboard(String selected){
		
		name = selected.trim();
		
		//label
		stu_name.setText(name);
		stu_name.setBounds(150,10,150,50);
		stu_name.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		stu_name.setForeground(Color.black);
		
		past_class.setBounds(15,40, 150,50);
		past_class.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		past_class.setForeground(Color.black);
		
		search_class.setBounds(280,200, 280,50);
		search_class.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
		search_class.setForeground(Color.black);
		
		//button
		stu_info.setBounds(350, 10, 50, 40);
		stu_info.addActionListener(this);
		stu_info.setFocusable(false);
		stu_info.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 18));
		stu_info.setBackground(Color.cyan);
		
		add_common.setBounds(300, 100, 250, 40);
		add_common.addActionListener(this);
		add_common.setFocusable(false);
		add_common.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		add_common.setBackground(Color.cyan);
		
		add_tempt.setBounds(300, 150, 250, 40);
		add_tempt.addActionListener(this);
		add_tempt.setFocusable(false);
		add_tempt.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		add_tempt.setBackground(Color.cyan);
		
		search.setBounds(290, 243, 80, 40);
		search.addActionListener(this);
		search.setFocusable(false);
		search.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		search.setBackground(Color.cyan);
		
		delete.setBounds(400, 400, 150, 40);
		delete.addActionListener(this);
		delete.setFocusable(false);
		delete.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		delete.setBackground(Color.cyan);
		
		check_class.setBounds(50, 420, 150, 40);
		check_class.addActionListener(this);
		check_class.setFocusable(false);
		check_class.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		check_class.setBackground(Color.cyan);
		
		//combo
		for(String[] index : Main.student_data) {
			if(index[0].contains(name)) {
				if(stu_subject != "n") {
					stu_subject = index[6];
			}
		}}
		if(stu_subject.contains("\\")) {
			String[] stud_subject = stu_subject.split("\\\\");
			
			subject_combo = new JComboBox(stud_subject);
		}else {
			String[] stud_subject = {stu_subject};
			subject_combo = new JComboBox(stud_subject);
		}
		
		subject_combo.setBounds(375, 240, 150, 50);
		subject_combo.setFont(new Font("Comic Sans", Font.PLAIN, 16));
		
		
		
		//list
			for(String[] index:Main.class_data) {
				if(index[0].contains(name)) {
					if(!index[1].contains("x")) {
						if(index[1].contains("\\")) {
							String[] past_classdata_date = index[1].split("\\\\");
							String[] past_classdata_period = index[2].split("\\\\");
							String[] past_classdata_subject = index[3].split("\\\\");
							
							for(int i = 0; i<past_classdata_date.length; i++) {
								String class_element = past_classdata_date[i] + "-" + past_classdata_subject[i];
								past_class_list.addElement(class_element);
							}
								
						}else {
							String class_element = index[1] + " " + index[3];
							past_class_list.addElement(class_element);
						}
					}
				}
			}
		
		

		
//		past_class_list.addElement("11/18 Physics");
//		past_class_list.addElement("11/24 Math");
//		past_class_list.addElement("11/29 College Physics");
		
		past_cl_list.setBounds(15,90,250,330);
		past_cl_list.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
		past_cl_list.setBackground(Color.LIGHT_GRAY);
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setSize(600,500);
		
		this.add(stu_name);
		this.add(past_class);
		this.add(search_class);
		
		this.add(stu_info);
		this.add(add_common);
		this.add(add_tempt);
		this.add(search);
		this.add(delete);
		this.add(check_class);
		
		this.add(subject_combo);
		
		this.add(past_cl_list);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == stu_info) {
			for(String[] index : Main.student_data) {
				if(index[0].contains(name)) {					
					new Window_stuinfo(index);				
						}

				}
			
		}
		if(e.getSource() == add_common) {
			new Window_addcommon(name);
		}
		if(e.getSource() == add_tempt) {
			new Window_addtempt(name);
		}
		if(e.getSource() == search) {
			
			String subject_chosen = (String) subject_combo.getSelectedItem();
			
			for(String[] index:Main.class_data) {
				if(index[0].contains(name)) {
					if(index[1].contains("\\")) {
						String[] past_classdata_date = index[1].split("\\\\");
						String[] past_classdata_period = index[2].split("\\\\");
						String[] past_classdata_subject = index[3].split("\\\\");
						String[] past_classdata_hw = index[5].split("\\\\");
						String[] past_classdata_notes = index[6].split("\\\\");
						
						for(int i=past_classdata_date.length-1; i>=0; i--) {
							if(subject_chosen.trim().contains(past_classdata_subject[i].trim())) {
								String[] past_class_info = {past_classdata_date[i], past_classdata_period[i],
										past_classdata_subject[i], past_classdata_hw[i], past_classdata_notes[i]};
								new Window_search(past_class_info);
								break;
							}
						}
						
					}else {
						String past_classdata_date = index[1];
						String past_classdata_period = index[2];
						String past_classdata_subject = index[3];
						String past_classdata_hw = index[5];
						String past_classdata_notes = index[6];

						String[] past_class_info = {past_classdata_date, past_classdata_period,
										past_classdata_subject, past_classdata_hw, past_classdata_notes};
						new Window_search(past_class_info);
					
						}
						
					}
				}
			
		}
		if(e.getSource() == delete) {
			new Window_delete(name);
		}
		if(e.getSource() == check_class) {
			if(past_cl_list.getSelectedIndex()!=-1) {
				String selected_class = past_cl_list.getSelectedValue();
				
				String[] selected_class_list = selected_class.split("-");
				
				for(String[] index:Main.class_data) {
					if(index[0].contains(name)) {
						if(index[1].contains("\\")) {
							String[] past_classdata_date = index[1].split("\\\\");
							String[] past_classdata_period = index[2].split("\\\\");
							String[] past_classdata_subject = index[3].split("\\\\");
							String[] past_classdata_hw = index[5].split("\\\\");
							String[] past_classdata_notes = index[6].split("\\\\");
							
							for(int i=0; i<past_classdata_date.length; i++) {
								if(selected_class_list[0].trim().contains(past_classdata_date[i].trim())) {
									String[] past_class_info = {past_classdata_date[i], past_classdata_period[i],
											past_classdata_subject[i], past_classdata_hw[i], past_classdata_notes[i]};
									new Window_checkclass(past_class_info);
								}
							}
							
						}else {
							String past_classdata_date = index[1];
							String past_classdata_period = index[2];
							String past_classdata_subject = index[3];
							String past_classdata_hw = index[5];
							String past_classdata_notes = index[6];

							String[] past_class_info = {past_classdata_date, past_classdata_period,
											past_classdata_subject, past_classdata_hw, past_classdata_notes};
							new Window_checkclass(past_class_info);
						
							}
							
						}
					}
			}
			
			


		}

	}
}
