package Anketa;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Anketa extends JFrame {
	private static Map data = new LinkedHashMap<String, Object>(); // создадим коллекцию вида Связанный хэш словарь
																// для хранения данных в виде переменная-значение
	private static byte[] array; // создадим байтовую колллекцию для подщета символов в одной анкете
	private static int i = 1;
	private static String filename; // имя анкеты, доступное для всех методов класса анкета
	public static void main(String[] args) {
		GridLayout experimentLayout = new GridLayout();
		JFrame frame = new JFrame("Anketa");
		frame.setLayout(new GridLayout(1,3)); // потоковая раскладка объектов на панели JFrame
		JPanel panel = new JPanel();
		
		JLabel surname_label = new JLabel("Surname"); // создадим лейблы для полей и выборов
		JLabel name_label = new JLabel("Name");
		JLabel fathers_name_label = new JLabel("2nd Name");
		JLabel birthday_label= new JLabel("Birthday");
		JLabel languages_label = new JLabel("Language:");
		JLabel sex_label = new JLabel("Sex");
		JLabel saved_data_label = new JLabel("The Data you have entered:");
		
		
		JTextField surname_field = new JTextField(12);
		JTextField name_field = new JTextField(10);  // создадим текстовые поля для ввода ФИО
		JTextField fathers_name_field = new JTextField(10);

		

		String[] years = new String[2018-1950];
		for(int i=0; i<years.length ; i++){ // создадим через циклы варианты выбора даты, месяца и года рождения
			int a=i;
			a=a+1950;
			String b = Integer.toString(a);
			years[i]=b;
		}
		String[] dates = new String[31];
		for (int i=0; i<dates.length; i++ ) {
			int a=i+1;  
			String b = Integer.toString(a);
			dates[i]=b;
		}
		String[] months = {"January", "February", "March" , "April" , "May", "June" , "July", "August", "September" , "October" , "November" , "December"};
		String[] sex= {"Male" , "Female"};
		
		JComboBox sex_combo_box =new JComboBox(sex);
		JComboBox days_combo = new JComboBox(dates);
		JComboBox months_combo = new JComboBox(months);
		JComboBox years_combo = new JComboBox(years);
		JCheckBox DE = new JCheckBox("Deutsch");
		JCheckBox ENG = new JCheckBox("English");
		panel.add(surname_label);
		panel.add(surname_field); // добавим все объекты на панель
		panel.add(name_label);
		panel.add(name_field);
		panel.add(fathers_name_label);
		panel.add(fathers_name_field);
		panel.add(sex_label);
		panel.add(sex_combo_box);
		panel.add(birthday_label);
		panel.add(days_combo);
		panel.add(months_combo);
		panel.add(years_combo);
		panel.add(languages_label);
		panel.add(DE);
		panel.add(ENG);
		
		JTextField[] textflds = new JTextField[3];
			textflds[0]=surname_field;
			textflds[1]=name_field;       // добавим все текстовые поля в один список полей для одновременного обнуления 
			textflds[2]=fathers_name_field;
		JComboBox[] fieldBoxs = new JComboBox[4];
			fieldBoxs[0] = sex_combo_box;
		    fieldBoxs[1] = days_combo;
		    fieldBoxs[2] = months_combo;
		    fieldBoxs[3] = years_combo;
		    
		JTextArea OutputTextArea = new JTextArea(50,50); // текстовое поле для вывода информации из файла
		    try { 
	            StringBuilder con = new StringBuilder();
	            for (int i = 0; i < fieldBoxs.length; i++) 

	                   {
	                    Object Value = fieldBoxs[i].getSelectedItem();
	                    con.append(" ");
	            con.append(Value);
	            con.append("\r\n");
	           }}catch (Throwable t) {}
		
		JButton SaveButton = new JButton("Save");
		 SaveButton.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	data.put(surname_label.getText(), surname_field.getText());
	            	data.put(name_label.getText(), name_field.getText());
	            	data.put(fathers_name_label.getText(), fathers_name_field.getText());
	            	data.put(sex_label.getText(), sex_combo_box.getSelectedItem());
	            	data.put(birthday_label.getText(), days_combo.getSelectedItem()+"."+months_combo.getSelectedItem()+"."+years_combo.getSelectedItem()+"" );
	            	if(ENG.isSelected()) {
	            		data.put(languages_label.getName(), ENG.getText());
	            	}
	            	if(DE.isSelected()) {
	            		data.put(languages_label.getName(), DE.getText());
	            	}
	            	saveToFile3(data);
	            	Set<Map.Entry<String, Integer>> set = data.entrySet();
	            	for (Map.Entry<String, Integer> data : set) {
	            	    System.out.print(data.getKey() + ": ");
	            	    System.out.println(data.getValue());
	            	}

	            	panel.add(saved_data_label);
	            	panel.add(OutputTextArea);
	            	OutputTextArea.setText(readFromFile3());
	            	
	               
	        }

				private void saveToFile3(Map data) {
					// TODO Auto-generated method stub
					try{
						Set<Map.Entry<String, String>> set = data.entrySet();
						String fileName="Anketa Person" + i + ".txt";
						FileWriter fw = new FileWriter(fileName , true);
						BufferedWriter bw = new BufferedWriter(fw);
						for (Map.Entry<String, String> data2 : set) {
		            	    bw.write(data2.getKey() + "---");
		            	    
		            	    bw.write(data2.getValue());
		            	    bw.newLine();
		            	}
						bw.newLine(); 
						bw.flush();
					}catch(IOException e) {
			        	System.out.println("Input error");
			        }
				}});
		 JButton NextPersonButton = new JButton("Next Person");
		 NextPersonButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0; i<=2; i++){
					textflds[i].setText("");}
				for(int i=0; i<=3; i++)
					fieldBoxs[i].setSelectedIndex(0);
				i++;
			}
		 });
	        panel.add(SaveButton);
	        panel.add(NextPersonButton);
	        
		frame.add(panel);

		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setIconImage(new ImageIcon("images/dku_logo.png").getImage());
		frame.getRootPane().setWindowDecorationStyle(2);
		frame.setSize(630, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	static void saveToFile2(Object object) {
		try{
			String fileName="Anketa Person" + i + ".txt";
			FileWriter fw = new FileWriter(fileName , true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String s = object.toString();
			bw.write(s);
			bw.newLine(); 
			bw.flush();
			
		}catch(IOException e) {
        	System.out.println("Input error");
        }
		
		}
	

	
	
		static String readFromFile3() {
			FileInputStream in;
			String fileName="Anketa Person" + i + ".txt";
			String text=null;
			try {
				in = new FileInputStream(fileName);
	        array = new byte[in.available()];
	        in.read(array);
	        text = new String(array);
	        String text2= new String(array);
	        int textlength = 0;
	        for(char ch : text2.toCharArray()) {
	            if(!Character.isWhitespace(ch)) {
	                textlength++;
	            }}
	        }
	        
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(IOException e){
				System.out.println("Error during file transaction! ");}
			
			return text;
		}
		

	}
