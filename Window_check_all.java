package software;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Window_check_all extends JFrame implements ActionListener{
	
	DefaultListModel<String> class_list = new DefaultListModel<>();
	JList<String> cl_list = new JList<>(class_list);
	
	Window_check_all(){
		
		cl_list.setBounds(10,10,400,500);
		cl_list.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
		cl_list.setBackground(Color.LIGHT_GRAY);
		
		for(String[] index: Main.student_data) {
			ArrayList<String> common_day = new ArrayList<String>();
			ArrayList<String> common_from_h = new ArrayList<String>();
			ArrayList<String> common_from_m = new ArrayList<String>();
			ArrayList<String> common_to_h = new ArrayList<String>();
			ArrayList<String> common_to_m = new ArrayList<String>();

			if(!index[1].contains("x")) {
				
				if(index[1].contains("\\")) {
					String[] student_common_day = index[1].split("\\\\");
					String[] student_common_from_h = index[2].split("\\\\");
					String[] student_common_from_m = index[3].split("\\\\");
					String[] student_common_to_h = index[4].split("\\\\");
					String[] student_common_to_m = index[5].split("\\\\");
					for(int i=0; i<student_common_day.length; i++) {
						common_day.add(student_common_day[i]);
						common_from_h.add(student_common_from_h[i]);
						common_from_m.add(student_common_from_m[i]);
						common_to_h.add(student_common_to_h[i]);
						common_to_m.add(student_common_to_m[i]);
					}

					}
					
				else {
					String student_common_day = index[1];
					String student_common_from_h = index[2];
					String student_common_from_m = index[3];
					String student_common_to_h = index[4];
					String student_common_to_m = index[5];
					
					
					common_day.add(student_common_day);
					common_from_h.add(student_common_from_h);
					common_from_m.add(student_common_from_m);
					common_to_h.add(student_common_to_h);
					common_to_m.add(student_common_to_m);
				}
			}
			
			if(!index[7].contains("x")) {
				if(index[7].contains("\\")) {
					String[] student_common_day = index[7].split("\\\\");
					String[] student_common_from_h = index[8].split("\\\\");
					String[] student_common_from_m = index[9].split("\\\\");
					String[] student_common_to_h = index[10].split("\\\\");
					String[] student_common_to_m = index[11].split("\\\\");
					
					System.out.println("Hellow");
					for(int i=0; i<student_common_day.length; i++) {
						common_day.add(student_common_day[i]);
						common_from_h.add(student_common_from_h[i]);
						common_from_m.add(student_common_from_m[i]);
						common_to_h.add(student_common_to_h[i]);
						common_to_m.add(student_common_to_m[i]);
					}
					
				}else {
					
						String student_common_day = index[7];
						String student_common_from_h = index[8];
						String student_common_from_m = index[9];
						String student_common_to_h = index[10];
						String student_common_to_m = index[11];
						
						common_day.add(student_common_day);
						common_from_h.add(student_common_from_h);
						common_from_m.add(student_common_from_m);
						common_to_h.add(student_common_to_h);
						common_to_m.add(student_common_to_m);
//						System.out.println("Hell");
					
				}	
			}
			String[] return_list = new String[common_day.size()];
			for(int i=0; i<common_day.size();i++) {
				String time =common_day.get(i)+"-"+common_from_h.get(i)+":"+common_from_m.get(i)+"~"+
						common_to_h.get(i)+":"+common_to_m.get(i);
				time = time.replace(" ", "");
				return_list[i] = time;
			}
			String return_string = index[0]+":   " + Arrays.deepToString(return_list);
			return_string = return_string.replace("[", "");
			return_string = return_string.replace("]", "");
			
			class_list.addElement(return_string);
		}


		
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setSize(430,550);
		
		this.add(cl_list);
		
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	

	}
}


