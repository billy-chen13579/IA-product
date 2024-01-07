package software;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window_delete extends JFrame implements ActionListener{
	
	JLabel message1 = new JLabel();
	JLabel message2 = new JLabel();
	JButton yes = new JButton("Yes");
	JButton no = new JButton("No");
	
	String name = "";
	
	Window_delete(String name){
		
		this.name = name;
		
		message1.setText("Are you sure you want");
		message1.setBounds(15,15,200,50);
		message1.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		message1.setForeground(Color.black);
		
		message2.setText("to delete student?");
		message2.setBounds(25,45,200,50);
		message2.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		message2.setForeground(Color.black);
		
		yes.setBounds(40, 90, 50, 40);
		yes.addActionListener(this);
		yes.setFocusable(false);
		yes.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		yes.setBackground(Color.cyan);
		
		no.setBounds(100, 90, 50, 40);
		no.addActionListener(this);
		no.setFocusable(false);
		no.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 14));
		no.setBackground(Color.cyan);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setSize(260,200);
		
		this.add(message1);
		this.add(message2);
		this.add(yes);
		this.add(no);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource() == yes) {
			
			int ind = 0;
			int remove = 0;
			for(String[] index : Main.student_data) {
				if(index[0].contains(name)) {
					remove = ind;
				}
				ind++;
			}

			Main.student_data.remove(remove);
			Main.class_data.remove(remove);
			
			Main.write_student();
			Main.write_class();
		}

	}
}
