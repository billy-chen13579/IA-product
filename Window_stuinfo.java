package software;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;


public class Window_stuinfo extends JFrame implements ActionListener{
	
	JLabel stu_name = new JLabel();
	JLabel class_time = new JLabel("Class Time(commom & tempt): ");
	JLabel stu_subject = new JLabel("Subject: ");
	
	JButton delete_time = new JButton("Delete");
	JButton add_subject = new JButton("Add Subject");
	JButton delete_subject = new JButton("Delete Subject");
	
	
	DefaultListModel<String> class_list = new DefaultListModel<>();
	JList<String> cl_list = new JList<>(class_list);
	
	DefaultListModel<String> subject_list = new DefaultListModel<>();
	JList<String> sub_list = new JList<>(subject_list);
	
	ArrayList<String> common_day = new ArrayList<String>();
	ArrayList<String> common_from_h = new ArrayList<String>();
	ArrayList<String> common_from_m = new ArrayList<String>();
	ArrayList<String> common_to_h = new ArrayList<String>();
	ArrayList<String> common_to_m = new ArrayList<String>();
	ArrayList<String> common_sub = new ArrayList<String>();
	
	String name;
	
	Window_stuinfo(String[] student_info_data){
		
		this.name = student_info_data[0];
		
		if(!student_info_data[1].contains("x")) {
			
			if(student_info_data[1].contains("\\")) {
				String[] student_common_day = student_info_data[1].split("\\\\");
				String[] student_common_from_h = student_info_data[2].split("\\\\");
				String[] student_common_from_m = student_info_data[3].split("\\\\");
				String[] student_common_to_h = student_info_data[4].split("\\\\");
				String[] student_common_to_m = student_info_data[5].split("\\\\");
				
				if(student_info_data[6].contains("\\")) {
					String[] student_subject_list = student_info_data[6].split("\\\\");
					for(int i=0; i<student_subject_list.length; i++) {
						common_sub.add(student_subject_list[i]);
					}
				}else {
					common_sub.add(student_info_data[6]);
				}
				
				for(int i=0; i<student_common_day.length; i++) {
					common_day.add(student_common_day[i]);
					common_from_h.add(student_common_from_h[i]);
					common_from_m.add(student_common_from_m[i]);
					common_to_h.add(student_common_to_h[i]);
					common_to_m.add(student_common_to_m[i]);
				}
				
			}else {
				String student_common_day = student_info_data[1];
				String student_common_from_h = student_info_data[2];
				String student_common_from_m = student_info_data[3];
				String student_common_to_h = student_info_data[4];
				String student_common_to_m = student_info_data[5];
				
				if(student_info_data[6].contains("\\")) {
					String[] student_subject_list = student_info_data[6].split("\\\\");
					for(int i=0; i<student_subject_list.length; i++) {
						common_sub.add(student_subject_list[i]);
					}
				}else {
					common_sub.add(student_info_data[6]);
				}
				
				common_day.add(student_common_day);
				common_from_h.add(student_common_from_h);
				common_from_m.add(student_common_from_m);
				common_to_h.add(student_common_to_h);
				common_to_m.add(student_common_to_m);
			}	
		}
		if(!student_info_data[7].contains("x")) {
			if(student_info_data[7].contains("\\")) {
				String[] student_common_day = student_info_data[7].split("\\\\");
				String[] student_common_from_h = student_info_data[8].split("\\\\");
				String[] student_common_from_m = student_info_data[9].split("\\\\");
				String[] student_common_to_h = student_info_data[10].split("\\\\");
				String[] student_common_to_m = student_info_data[11].split("\\\\");
				
//				System.out.println("Hellow");
				for(int i=0; i<student_common_day.length; i++) {
					common_day.add(student_common_day[i]);
					common_from_h.add(student_common_from_h[i]);
					common_from_m.add(student_common_from_m[i]);
					common_to_h.add(student_common_to_h[i]);
					common_to_m.add(student_common_to_m[i]);
				}
				
			}else {
				if(!student_info_data[7].isEmpty()) {
					String student_common_day = student_info_data[7];
					String student_common_from_h = student_info_data[8];
					String student_common_from_m = student_info_data[9];
					String student_common_to_h = student_info_data[10];
					String student_common_to_m = student_info_data[11];
					
					common_day.add(student_common_day);
					common_from_h.add(student_common_from_h);
					common_from_m.add(student_common_from_m);
					common_to_h.add(student_common_to_h);
					common_to_m.add(student_common_to_m);
					System.out.println("Hell");
				}
			}	
		}
		
		
		
		//label
		
		
		
		stu_name.setText(student_info_data[0]);
		stu_name.setBounds(15,5,150,60);
		stu_name.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
		stu_name.setForeground(Color.black);

		class_time.setBounds(15,40,300,50);
		class_time.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
		class_time.setForeground(Color.black);
		
		stu_subject.setBounds(15,200,100,50);
		stu_subject.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
		stu_subject.setForeground(Color.black);
		
		//button
		delete_time.setBounds(230, 100, 80, 40);
		delete_time.addActionListener(this);
		delete_time.setFocusable(false);
		delete_time.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 18));
		delete_time.setBackground(Color.cyan);
		
		add_subject.setBounds(260, 210, 120, 40);
		add_subject.addActionListener(this);
		add_subject.setFocusable(false);
		add_subject.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		add_subject.setBackground(Color.cyan);
		
		delete_subject.setBounds(260, 255, 130, 40);
		delete_subject.addActionListener(this);
		delete_subject.setFocusable(false);
		delete_subject.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		delete_subject.setBackground(Color.cyan);
		
		//list
		for(int i=0; i<common_day.size();i++) {
			String time = common_day.get(i)+"-"+common_from_h.get(i)+":"+common_from_m.get(i)+"~"+
					common_to_h.get(i)+":"+common_to_m.get(i);
			time = time.replace(" ", "");
			class_list.addElement(time);

		}
		if(student_info_data[6].contains("\\")) {
			String[] sub_add = student_info_data[6].split("\\\\");
			for(int i=0; i<sub_add.length; i++) {
				subject_list.addElement(sub_add[i]);
			}
			
		}else {
			subject_list.addElement(student_info_data[6]);
		}
		
//		class_list.addElement("Mon 11PM~12PM");
//		class_list.addElement("TUE 1PM~2PM");
//		class_list.addElement("11/28 2PM~3PM");
		
		cl_list.setBounds(15,80,200,100);
		cl_list.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
		cl_list.setBackground(Color.LIGHT_GRAY);
		
//		subject_list.addElement("Physics");
//		subject_list.addElement("Math");
//		subject_list.addElement("College Physics");
		
		sub_list.setBounds(100,200,150,100);
		sub_list.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
		sub_list.setBackground(Color.LIGHT_GRAY);
		
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setSize(400,350);
		
		this.add(stu_name);
		this.add(class_time);
		this.add(stu_subject);
		
		this.add(delete_time);
		this.add(add_subject);
		this.add(delete_subject);
		
		this.add(sub_list);
		this.add(cl_list);
		
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == add_subject) {
			new Window_add_subject(name);
		}
		if(e.getSource() == delete_time) {
			if(cl_list.getSelectedIndex()!=-1) {
				String time_select = cl_list.getSelectedValue();
				String[] time_list = time_select.split("-");
				
				String day_new = "";
				String fromh_new = "";
				String fromm_new = "";
				String toh_new = "";
				String tom_new = "";
				
				int ind = 0;
				for(String[] index : Main.student_data) {
					if(index[0].contains(name)) {
						String[] myString = index;
						
						if(myString[1].contains("\\")) {
							String[] myday = myString[1].split("\\\\");
							String[] myfromh = myString[2].split("\\\\");
							String[] myfromm = myString[3].split("\\\\");
							String[] mytoh = myString[4].split("\\\\");
							String[] mytom = myString[5].split("\\\\");
						
							
							int count = 0;
							for(int i=0; i<myday.length; i++) {
								if(myday[i].contains(time_list[0])) {
									
								}else {
									if(count == 0) {
										day_new = myday[i];
										fromh_new = myfromh[i];
										fromm_new = myfromm[i];
										toh_new = mytoh[i];
										tom_new = mytom[i];
										count++;
									}else {
										day_new = day_new + "\\" + myday[i];
										fromh_new += "\\" +  myfromh[i];
										fromm_new += "\\" + myfromm[i];
										toh_new += "\\" + mytoh[i];
										tom_new += "\\" + mytom[i];
									}
								}
							}
							
							
						}else {
							day_new = "x";
							fromh_new = "x";
							fromm_new = "x";
							toh_new = "x";
							tom_new = "x";
						}
						
						String[] return_list = {myString[0],day_new, fromh_new, fromm_new,
								toh_new, tom_new, myString[6], myString[7], myString[8], myString[9], myString[10],
								myString[11],myString[12]};
						Main.student_data.set(ind, return_list);
					}
					ind++;
				}
				Main.write_student();
			}
			
		}
		if(e.getSource() == delete_subject) {
			if(sub_list.getSelectedIndex()!=-1) {
				String sub_select = sub_list.getSelectedValue();
				String sub_return = "";
				
				int ind = 0;
				for(String[] index : Main.student_data) {
					if(index[0].contains(name)) {
						String[] myString = index;
						
						if(myString[6].contains("\\")) {
							String[] mysub = myString[6].split("\\\\");
//							System.out.println(Arrays.deepToString(mysub));

							int count = 0;
							for(int i=0; i<mysub.length; i++) {
								if(mysub[i].contains(sub_select)) {
//									System.out.println(sub_select);
								}else {
									if(count == 0) {
										sub_return = mysub[i];
										count++;
//										System.out.println(count);
									}else {
										sub_return = sub_return + "\\" + mysub[i];
									}
								}
							}
							
							
						}else {
							sub_return = "x";
						}
						
						String[] return_list = {myString[0],myString[1], myString[2], myString[3],
								myString[4], myString[5], sub_return, myString[7], myString[8], myString[9], myString[10],
								myString[11],myString[12]};
						Main.student_data.set(ind, return_list);
					}
					ind++;
				}
				Main.write_student();
				
			}
			
		}
	}
}
