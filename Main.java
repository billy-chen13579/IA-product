package software;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
	
	static String class_data_file = "class_data.csv";
	static String student_file = "Student.csv";
	
	static String line = "";
	
	static BufferedReader reader_stu = null;
	static BufferedReader reader_class = null;
	
	static BufferedWriter writer_stu = null;
	static BufferedWriter writer_class = null;
	
	public static ArrayList<String[]> student_data = new ArrayList<String[]>();
	public static ArrayList<String[]> class_data = new ArrayList<String[]>();
	
	public static ArrayList<String[]> todayclass = new ArrayList<String[]>();
	
	public static void sortToday_class() {
//		String[] class_title = {class_name, ": "+class_from_hour+":"+class_from_min+"~"+
//				class_to_hour+":"+class_to_min, class_time};
		int x = todayclass.size();
		String[][] sort_list = new String[x][6];
		
		int intd = 0;
		for(String[] index:todayclass) {
			String student_name = index[0];
			String[] student_time = index[1].split("~");
			String[] time_period = new String[4];
			for(int i=0; i<student_time.length; i++) {
				String[] new_string = student_time[i].split(":");
				if(i == 0) {
					time_period[0] = new_string[1].trim();
					time_period[1] = new_string[2].trim();
				}else {
					time_period[2] = new_string[0].trim();
					time_period[3] = new_string[1].trim();
				}
			}
			String[] my_string = {time_period[0],time_period[1],time_period[2],time_period[3],index[0],index[2]};
			sort_list[intd] = my_string;
			intd++;
			
			
		}
		for(int i=0; i<sort_list.length-1; i++) {
			for(int j=0; j<sort_list.length-1-i; j++) {
				if(Integer.valueOf(sort_list[j][0]) > Integer.valueOf(sort_list[j+1][0])){
					String[] tempt = sort_list[j];
					sort_list[j] = sort_list[j+1];
					sort_list[j+1] = tempt;
				}
				if(Integer.valueOf(sort_list[j][0]) == Integer.valueOf(sort_list[j+1][0])){
					if(Integer.valueOf(sort_list[j][1]) < Integer.valueOf(sort_list[j+1][1])){
						String[] tempt = sort_list[j];
						sort_list[j] = sort_list[j+1];
						sort_list[j+1] = tempt;
					}
				}
			}
		}
//		System.out.println(Arrays.deepToString(sort_list));
		
		todayclass.clear();
		for(int j=0; j<sort_list.length; j++) {
				String[] class_title = {sort_list[j][4], ": "+sort_list[j][0]+":"+sort_list[j][1]+"~"+
						sort_list[j][2]+":"+sort_list[j][3], sort_list[j][5]};
				todayclass.add(class_title);
			}
		
	}
	
	public static void getToday_class() {
		LocalDate myObj = LocalDate.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MM/dd");
		String formattedDate = myObj.format(myFormatObj);
		
		String[] today_time = formattedDate.split(",");
		
		try {
			for(String[] index:student_data) {
				if(index[1].contains("\\")) {
					String[] class_time = index[1].split("\\\\");
					for(int i=0; i<class_time.length; i++) {
						class_time[i] = class_time[i].replace(" ", "");
						if(class_time[i].contains(today_time[0].replace(" ", ""))) {
							String[] class_from_hour = index[2].split("\\\\");
							String[] class_from_min = index[3].split("\\\\");
							String[] class_to_hour = index[4].split("\\\\");
							String[] class_to_min = index[5].split("\\\\");
							String class_name = index[0];
							String[] class_title = {class_name, ": "+class_from_hour[i]+":"+class_from_min[i]+"~"+
													class_to_hour[i]+":"+class_to_min[i], class_time[i]};
							
							todayclass.add(class_title);
						}
					}
				}else {
					
					String class_time = index[1].trim();
//					System.out.println(class_time);
					
					if(class_time.contains(today_time[0].replace(" ", ""))) {
//						System.out.println(class_time);
						String class_from_hour = index[2];
						String class_from_min = index[3];
						String class_to_hour = index[4];
						String class_to_min = index[5];
						String class_name = index[0];
						String[] class_title = {class_name, ": "+class_from_hour+":"+class_from_min+"~"+
												class_to_hour+":"+class_to_min, class_time};
						
						todayclass.add(class_title);
					}
				}
				
				//tempt class
				if(index[7].contains("\\")) {
					String[] class_time = index[7].split("\\\\");
					for(int i=0; i<class_time.length; i++) {
						class_time[i] = class_time[i].replace(" ", "");
						if(class_time[i].contains(today_time[1].replace(" ", ""))) {
							String[] class_from_hour = index[8].split("\\\\");
							String[] class_from_min = index[9].split("\\\\");
							String[] class_to_hour = index[10].split("\\\\");
							String[] class_to_min = index[11].split("\\\\");
							String class_name = index[0];
							String[] class_title = {class_name, ": "+class_from_hour[i]+":"+class_from_min[i]+"~"+
													class_to_hour[i]+":"+class_to_min[i], class_time[i]};
							
							todayclass.add(class_title);
						}
					}
				}else {
					String class_time = index[7].replace(" ", "");
					if(class_time.contains(today_time[1].replace(" ", ""))) {
						String class_from_hour = index[8];
						String class_from_min = index[9];
						String class_to_hour = index[10];
						String class_to_min = index[11];
						String class_name = index[0];
						String[] class_title = {class_name, ": "+class_from_hour+":"+class_from_min+"~"+
												class_to_hour+":"+class_to_min, class_time};
						
						todayclass.add(class_title);
					}
				}
			}
		}catch(Exception e) {
//			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		try {
			read_student();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			read_class();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getToday_class();
		sortToday_class();
		updateTempt();
		
		new Dashboard(); 

	}
	
	public static void read_student() throws IOException {
		try {
			reader_stu = new BufferedReader(new FileReader(student_file));
			while((line = reader_stu.readLine())!= null) {
				String[] row = line.split(",");
				
				student_data.add(row);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				reader_stu.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void read_class() throws IOException {
		try {
			reader_class = new BufferedReader(new FileReader(class_data_file));
			while((line = reader_class.readLine())!= null) {
				String[] row = line.split(",");
				
				class_data.add(row);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				reader_class.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void write_student() {
		try {
			writer_stu = new BufferedWriter(new FileWriter(student_file));
			for(String[] index:student_data) {
				String storage = Arrays.deepToString(index);
				
				if(!storage.isEmpty()) {
					storage = storage.replace("[", "");
					storage = storage.replace("  ", "");
					storage = storage.replace("]", "");
					
					writer_stu.append(storage);
					writer_stu.append('\n');
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				writer_stu.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void write_class() {
		try {
			writer_class = new BufferedWriter(new FileWriter(class_data_file));
			for(String[] index:class_data) {
				String storage = Arrays.deepToString(index);
				if(!storage.isEmpty()) {
					storage = storage.replace("[", "");
					storage = storage.replace("  ", "");
					storage = storage.replace("]", "");
					
					writer_class.append(storage);
					writer_class.append("\n");
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				writer_class.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static boolean checkduplicate(String day, String from_h, String from_m, String to_h, String to_m) {
		boolean ans = false;
		
		for(String[] index: student_data) {
			if(index[1].contains("\\")) {
				String[] day_check = index[1].split("\\\\");
				String[] fromh_check = index[2].split("\\\\");
				String[] fromm_check = index[3].split("\\\\");
				String[] toh_check = index[4].split("\\\\");
				String[] tom_check = index[5].split("\\\\");
				for(int i=0; i<day_check.length; i++) {
					if(day_check[i].contains(day)) { //same day
						if(Integer.valueOf(from_h.trim()) == Integer.valueOf(fromh_check[i].trim())) { //same starting hour
							if(Integer.valueOf(fromh_check[i].trim()) == Integer.valueOf(toh_check[i].trim())) {
								if(Integer.valueOf(tom_check[i].trim()) > Integer.valueOf(from_m.trim())) {
									ans = true;
								}
							if(Integer.valueOf(from_h.trim()) == Integer.valueOf(to_h.trim())){
								if(Integer.valueOf(to_m.trim()) > Integer.valueOf(fromm_check[i].trim())) {
									ans = true;
								}
							}
							if(Integer.valueOf(to_h.trim()) > Integer.valueOf(from_h.trim())) {
								ans = true;
							}
							if(Integer.valueOf(toh_check[i].trim()) > Integer.valueOf(fromh_check[i].trim())) {
								ans = true;
							}
						}
						if(Integer.valueOf(from_h.trim()) == Integer.valueOf(toh_check[i].trim())) {
							if(Integer.valueOf(tom_check[i].trim()) > Integer.valueOf(from_m.trim())) {
								ans = true;
							}
						}
						if(Integer.valueOf(to_h.trim()) == Integer.valueOf(fromh_check[i].trim())) {
							if(Integer.valueOf(to_m.trim()) > Integer.valueOf(fromm_check[i].trim())) {
								ans = true;
							}
						}
					}
				}
			}
	
		}else {
			String day_check = index[1];
			String fromh_check = index[2];
			String fromm_check = index[3];
			String toh_check = index[4];
			String tom_check = index[5];
				if(day_check.contains(day)) { //same day
//					System.out.println(1);
//					System.out.println(to_h);
//					System.out.println(from_h);
					if(Integer.valueOf(from_h.trim()) == Integer.valueOf(fromh_check.trim())) { //same starting hour
						System.out.println(2);
						if(Integer.valueOf(fromh_check.trim()) == Integer.valueOf(toh_check.trim())) {
							if(Integer.valueOf(tom_check.trim()) > Integer.valueOf(from_m.trim())) {
								ans = true;
							}
						}
						if(Integer.valueOf(from_h.trim()) == Integer.valueOf(to_h.trim())){
							if(Integer.valueOf(to_m.trim()) > Integer.valueOf(fromm_check.trim())) {
								ans = true;
							}
						}
						System.out.println(to_h);
						System.out.println(from_h);
						if(Integer.valueOf(to_h.trim()) > Integer.valueOf(from_h.trim())) {
							System.out.println(3);
							ans = true;
						}
						if(Integer.valueOf(toh_check.trim()) > Integer.valueOf(fromh_check.trim())) {
							System.out.println(4);
							ans = true;
						}
					
					if(Integer.valueOf(from_h.trim()) == Integer.valueOf(toh_check.trim())) {
						if(Integer.valueOf(tom_check.trim()) > Integer.valueOf(from_m.trim())) {
							ans = true;
						}
					}
					if(Integer.valueOf(to_h.trim()) == Integer.valueOf(fromh_check.trim())) {
						if(Integer.valueOf(to_m.trim()) > Integer.valueOf(fromm_check.trim())) {
							ans = true;
						}
					}
				}
			}
		}
		
	}

	return ans;}

	
	public static void updateTempt() {
		
		LocalDate myObj = LocalDate.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MM/dd");
		String formattedDate = myObj.format(myFormatObj);
		
		String[] today_time = formattedDate.split(",");
		String[] date_num = today_time[1].split("/");
		
		int inde = 0;
		int setter = 0;
		for(String[] index:student_data) {
			if(index[7].contains("x")) {
				
			}else {
				if(index[7].contains("\\")) {
					String[] student_date = index[7].split("\\\\");
					String[] student_fromh = index[8].split("\\\\");
					String[] student_fromm = index[9].split("\\\\");
					String[] student_toh = index[10].split("\\\\");
					String[] student_tom = index[11].split("\\\\");
					
					String return_date = "";
					String return_fromh = ""; 
					String return_fromm = "";
					String return_toh = "";
					String return_tom = "";
					
					for(int i=0; i<student_date.length;i++) {
						String[] new_date = student_date[i].split("/");
						if(Integer.valueOf(new_date[0].trim()) < Integer.valueOf(date_num[0].trim())) {
							continue;
						}else if(Integer.valueOf(new_date[0].trim()) == Integer.valueOf(date_num[0].trim())) {
							if(Integer.valueOf(new_date[1].trim()) < Integer.valueOf(date_num[1].trim())) {
								continue;
							}
						}else if(Integer.valueOf(date_num[0].trim()) == 1 && Integer.valueOf(new_date[0].trim()) == 12){
								continue;
						}else {
							if(setter == 0) {
								
								return_date += student_date[i];
								return_fromh += student_fromh[i];
								return_fromm += student_fromm[i];
								return_toh += student_toh[i];
								return_tom += student_tom[i];
								setter++;
							}else {
								
								return_date += "\\" + student_date[i];
								return_fromh += "\\" + student_fromh[i];
								return_fromm += "\\" + student_fromm[i];
								return_toh += "\\" + student_toh[i];
								return_tom += "\\" + student_tom[i];
							}
						}
					}
					if(return_date == "") {
						String[] return_list = {index[0],index[1],index[2],index[3],index[4],index[5],
								index[6],"x","x","x","x","x","x"};
						student_data.set(inde,return_list);
						Main.write_student();
					}else {
						String[] return_list = {index[0],index[1],index[2],index[3],index[4],index[5],
								index[6],return_date,return_fromh,return_fromm,return_toh,return_tom,index[12]};
						student_data.set(inde,return_list);
						Main.write_student();
					}
				}else {
					String student_date = index[7];
					String student_fromh = index[8];
					String student_fromm = index[9];
					String student_toh = index[10];
					String student_tom = index[11];
					
					String return_date = "";
					String return_fromh = "";
					String return_fromm = "";
					String return_toh = "";
					String return_tom = "";
					

					String[] new_date = student_date.split("/");

					if(Integer.valueOf(new_date[0].trim()) < Integer.valueOf(date_num[0].trim())) {
							System.out.print("month");
					}else if(Integer.valueOf(new_date[0].trim()) == Integer.valueOf(date_num[1].trim())) {
							if(Integer.valueOf(new_date[1].trim()) < Integer.valueOf(date_num[1].trim())) {
								System.out.print("date");
							}
					}else if(Integer.valueOf(date_num[0].trim()) == 1 && Integer.valueOf(new_date[0].trim()) == 12){
						System.out.print("year");
					}else {
								return_date += student_date;
								return_fromh += student_fromh;
								return_fromm += student_fromm;
								return_toh += student_toh;
								return_tom += student_tom;
							}
					if(return_date == "") {
							String[] return_list = {index[0],index[1],index[2],index[3],index[4],index[5],
									index[6],"x","x","x","x","x","x"};
							System.out.println(Arrays.deepToString(return_list));
							student_data.set(inde,return_list);
							Main.write_student();
					}
				}
			}
			
		inde++;}
		}
	
} 
