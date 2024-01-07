package software;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window_checkclass extends JFrame implements ActionListener{
	
	JLabel content_area = new JLabel("Content Area: ");
	JLabel homework = new JLabel("Homework: ");
	JLabel time = new JLabel("Time: ");
	JLabel notes = new JLabel("Notes: ");
	
	JLabel content_info = new JLabel();
	JLabel homework_info = new JLabel();
	JLabel time_info = new JLabel();
	
	JTextArea notes_info = new JTextArea();
	
	Window_checkclass(String[] class_info_data){
		
		content_area.setBounds(15,15,150,50);
		content_area.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		content_area.setForeground(Color.black);
		
		homework.setBounds(15,65,150,50);
		homework.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		homework.setForeground(Color.black);
		
		time.setBounds(15,115,150,50);
		time.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		time.setForeground(Color.black);
		
		notes.setBounds(15,165,150,50);
		notes.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		notes.setForeground(Color.black);
		
		content_info.setText(class_info_data[2]);
		content_info.setBounds(160,15,150,50);
		content_info.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		content_info.setForeground(Color.black);
		
		homework_info.setText(class_info_data[3]);
		homework_info.setBounds(130,65,150,50);
		homework_info.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
		homework_info.setForeground(Color.black);
		
		time_info.setText(class_info_data[0]);
		time_info.setBounds(110,115,230,50);
		time_info.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		time_info.setForeground(Color.black);
		
		notes_info.setText(class_info_data[4]);
		notes_info.setBounds(110,165,200,70);
		notes_info.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
		notes_info.setBackground(Color.LIGHT_GRAY);
		
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setSize(400,300);
		
		this.add(content_area);
		this.add(homework);
		this.add(time);
		this.add(notes);
		
		this.add(content_info);
		this.add(homework_info);
		this.add(time_info);
		this.add(notes_info);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	

	}
}

