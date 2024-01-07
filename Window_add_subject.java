package software;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class Window_add_subject extends JFrame implements ActionListener{
	
	JLabel title = new JLabel("Title: ");
	
	JButton add_subject = new JButton("Add");

	JTextField sub_title = new JTextField();
	
	String name = "";

	
	Window_add_subject(String name){
		
		this.name = name;

		title.setBounds(15,10,100,50);
		title.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		title.setForeground(Color.black);
		
		add_subject.setBounds(50, 60, 120, 40);
		add_subject.addActionListener(this);
		add_subject.setFocusable(false);
		add_subject.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		add_subject.setBackground(Color.cyan);
		
		sub_title.setBounds(65, 10, 150, 40);
		sub_title.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
		sub_title.setBackground(Color.LIGHT_GRAY);
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setSize(300,150);
		
		this.add(title);
		this.add(add_subject);
		this.add(sub_title);

		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == add_subject) {
			String title_data = sub_title.getText();
			
			int ind = 0;
			for(String[] index : Main.student_data) {
				if(index[0].contains(name)) {
					if(index[6].contains("x")) {
						String[] myString = index;
						myString[6] = title_data;
						Main.student_data.set(ind, myString);
					}else {
						String[] myString = index;
						myString[6] = index[6] + "\\" + title_data;
						
						Main.student_data.set(ind, myString);
					}
				}
				ind++;
			}
			Main.write_student();
		}
	}
}