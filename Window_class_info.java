package software;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window_class_info extends JFrame implements ActionListener{
	
	JLabel page_title = new JLabel();
	JLabel content_area = new JLabel("Content Area: ");
	JLabel absence = new JLabel("Absence");
	JLabel homework = new JLabel("Homework: ");
	JLabel notes = new JLabel("Notes for class: ");
	
	JCheckBox checkbox = new JCheckBox();
	
	String stu_subject = "";
	JComboBox subject_combo;
	
	JTextArea homework_field = new JTextArea();
	JTextArea notes_field = new JTextArea();
	
	JButton submit = new JButton("Submit");
	
	String stu_name = "";
	
	String[] info_storage = new String[3];
	
	Window_class_info(String select, String[] info_storage){
		String[] selected_title = select.split(": ");
		stu_name = info_storage[0];
		
		this.info_storage = info_storage;
		
		System.out.println(select);
		System.out.println(Arrays.deepToString(info_storage));
	
		
		//label
		page_title.setText(select);
		page_title.setBounds(15,10,200,50);
		page_title.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		page_title.setForeground(Color.black);
		
		content_area.setBounds(15,50,150,50);
		content_area.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		content_area.setForeground(Color.black);
		
		absence.setBounds(50,100,100,50);
		absence.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		absence.setForeground(Color.black);
		
		homework.setBounds(15,150,150,50);
		homework.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		homework.setForeground(Color.black);
		
		notes.setBounds(15,220,150,50);
		notes.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		notes.setForeground(Color.black);
		
		//checkbox
		checkbox.setBounds(15,110,30,30);
		checkbox.setFocusable(false);
		
		//combo
		for(String[] index : Main.student_data) {
			if(index[0]==info_storage[0]) {
				stu_subject = index[6];
			}
		}
		if(stu_subject.contains("\\")) {
			String[] stud_subject = stu_subject.split("\\\\");
			
			subject_combo = new JComboBox(stud_subject);
		}else {
			String[] stud_subject = {stu_subject};
			subject_combo = new JComboBox(stud_subject);
		}

		subject_combo.setBounds(150, 55, 200, 50);
		subject_combo.setFont(new Font("Comic Sans", Font.PLAIN, 16));
		
		//textfield
		homework_field.setBounds(170, 150, 170, 70);
		homework_field.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
		homework_field.setBackground(Color.LIGHT_GRAY);
		
		notes_field.setBounds(170, 225, 170, 70);
		notes_field.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
		notes_field.setBackground(Color.LIGHT_GRAY);
		
		//Button
		submit.setBounds(240, 15, 100, 40);
		submit.addActionListener(this);
		submit.setFocusable(false);
		submit.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		submit.setBackground(Color.cyan);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setSize(400,350);
		
		this.add(page_title);
		this.add(content_area);
		this.add(absence);
		this.add(homework);
		this.add(notes);
		
		this.add(homework_field);
		this.add(notes_field);
		
		this.add(subject_combo);
		
		this.add(checkbox);

	
		this.add(submit);
		
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == submit) {
			
			String content_data = (String) subject_combo.getSelectedItem();
			String absence_data = "x";
			
			String homework_data = homework_field.getText();
			String notes_data = notes_field.getText();
			
			LocalDate myObj = LocalDate.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd");
			String formattedDate = myObj.format(myFormatObj);
			
			String time_day = formattedDate;
			String time_period = info_storage[2].replace(": ","");
			

			
			if(checkbox.isSelected() == false) {

				int ind = 0;
				for(String[] index : Main.class_data) {
					if(index[0].contains(stu_name)){

						
						if(index[1].contains("x")) {

							String[] classinfo = {stu_name, time_day, time_period,content_data,
									absence_data,homework_data,notes_data};
							Main.class_data.set(ind,classinfo);
							
						}else {

							String[] classinfo = {stu_name, index[1]+"\\"+time_day, index[2]+
									"\\"+time_period,index[3]+"\\"+content_data,index[4]+"\\"+
									absence_data,index[5]+"\\"+homework_data,index[6]+"\\"+notes_data};
							Main.class_data.set(ind,classinfo);

						}

					}
					ind++;
				}
				Main.write_class();
			}
			
			
		}
		
	}
}
