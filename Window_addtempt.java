package software;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Window_addtempt extends JFrame implements ActionListener{
	
	JLabel from_text = new JLabel("From");
	JLabel to_text = new JLabel("To");
	JLabel day_text = new JLabel("Day:");
	
	
	String[] day_hour = {"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
	String[] day_min = {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
	
	JComboBox from_hour = new JComboBox(day_hour);
	JComboBox to_hour = new JComboBox(day_hour);
	JComboBox from_min = new JComboBox(day_min);
	JComboBox to_min = new JComboBox(day_min);
	
	JTextField date = new JTextField();
	
	JButton add_class = new JButton("ADD");
	
	String name = "";
	
	Window_addtempt(String name){
		this.name = name;
		
		//textfield
		date.setText("MM/dd");
		date.setBounds(60, 15, 170, 50);
		date.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
		date.setBackground(Color.LIGHT_GRAY);
		
		//label
		day_text.setBounds(15,15,50,50);
		day_text.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		day_text.setForeground(Color.black);
		
		from_text.setBounds(50,50,50,50);
		from_text.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		from_text.setForeground(Color.black);
		
		to_text.setBounds(150,50,50,50);
		to_text.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		to_text.setForeground(Color.black);
		
		//combo
		
		from_hour.setBounds(70, 90, 80, 40);
		from_hour.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		
		to_hour.setBounds(170, 90, 80, 40);
		to_hour.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		
		from_min.setBounds(70, 140, 80, 40);
		from_min.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		
		to_min.setBounds(170, 140, 80, 40);
		to_min.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		
		//button
		add_class.setBounds(30, 200, 100, 40);
		add_class.addActionListener(this);
		add_class.setFocusable(false);
		add_class.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 16));
		add_class.setBackground(Color.cyan);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setSize(300,300);
		
		this.add(day_text);
		this.add(from_text);
		this.add(to_text);
		
		this.add(date);
		
		this.add(from_hour);
		this.add(to_hour);
		this.add(from_min);
		this.add(to_min);
		
		this.add(add_class);
		
	
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == add_class) {
			
			String date_data = (String) date.getText();
			String from_hour_data = (String) from_hour.getSelectedItem();
			String from_min_data = (String) from_min.getSelectedItem();
			String to_hour_data = (String) to_hour.getSelectedItem();
			String to_min_data = (String) to_min.getSelectedItem();
			
//			JFrame f = new JFrame();
//			JOptionPane.showMessageDialog(f,"Overlapped with: Mon 1PM~2PM");
			
			int ind = 0;
			for(String[] index : Main.student_data) {
				if(index[0].contains(name)) {
					
					if(index[7].contains("x")) {
						
						String[] myString = {index[0],index[1],index[2],index[3],index[4],index[5],index[6],
								date_data,from_hour_data,from_min_data,to_hour_data,to_min_data,index[12]};
						Main.student_data.set(ind, myString);
					
					}else {
						
						String[] myString = {index[0],index[1],index[2],index[3],index[4],index[5],index[6],
								index[7]+"\\"+date_data,index[8]+"\\"+from_hour_data,index[9]+"\\"+from_min_data,
								index[10]+"\\"+to_hour_data,index[11]+"\\"+to_min_data,index[12]};
						Main.student_data.set(ind, myString);
					}
				}
				ind++;
			
		}
			Main.write_student();

	}
}}
