import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Admin {
	static int selection1 = 0; //Declare and initialize option

	public static void OptionList(){
		//Declare and initialize option
		int menuSelection = 0;  

		String[] userChoice = new String[] {"1", "2", "3", "4", "5", "6", "7"}; //Declare and initialize array for user's choice in main menu
		//Display main menu and prompt user to choose the option
		menuSelection = JOptionPane.showOptionDialog(null, "WELCOME TO Asia Pacific University (APU)    \r\n" + 
				"		===============================================================\r\n" + 
				"		Enter 1 - Register the Lecturer/ Students	 \\n  \r\n" + 
				"		Enter 2 - View all the Lecturer / Students	 \\n  \r\n" + 
				"		Enter 3 - Search specific Lecturer / Student record	 \\n \r\n" + 
				"		Enter 4 - Delete the record of Lecturer / students	 \\n \r\n" + 
				"		Enter 5 - Modify the detail of Lecturer / students	\\n\r\n" + 
				"		Enter 6 - Update/ modify the attendance of student	\\n\r\n" + 
				"		Enter 7 - Exit the Program\r\n" + 
				"		===============================================================\r\n" + 
				"	", "Main Menu(Admin Menu)",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, userChoice, userChoice[0]);

		//IF-else cases for several methods to user input
		if (menuSelection == 0) { //Option 1
			ChoosingTarget();
			if (selection1 == 0)
				setLecturerFile();
			else
				setStudentFile();
		}
		else if (menuSelection == 1) { //Option 2
			ChoosingTarget();
			if (selection1 == 0)
				viewLecturerFile();
			else
				viewStudentFile();
		}
		else if (menuSelection == 2) { //Option 3
			ChoosingTarget();
			if (selection1 == 0)
				searchLecturer();
			else
				searchStudent();
		}
		else if (menuSelection == 3) { //Option 4
			if (selection1 == 0)
				deleteLecturerFile();
			else
				deleteStudentFile();
		}
		else if (menuSelection == 4) { //Option 5
			ChoosingTarget();
			if (selection1 == 0)
				updateLecturerFile();
			else
				updateStudentFile();
		}
		/*else if (menuSelection == 4) { //Option 6
			updateAttendance();

		}*/
		else
			System.exit(0); //This Method to exit the programm

	}

	public static void ChoosingTarget(){

		String[] choice1 = new String[] {"Lecturer", "Student"}; //Declare and initialize array for user's choice in main menu
		//Display main menu and prompt user to choose the option
		selection1 = JOptionPane.showOptionDialog(null, "Please Select", "Main Menu(Admin Menu)",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, choice1, choice1[0]);

	}

	//This Method is created to add  new lecture details to the lecture.txt
	public static void setLecturerFile() {
		try {

			// Get the User Inputs
			String unitId = JOptionPane.showInputDialog(null, "Enter Unit ID", "", JOptionPane.QUESTION_MESSAGE);
			String unitName = JOptionPane.showInputDialog(null, "Enter Unit Name", "", JOptionPane.QUESTION_MESSAGE);
			String roomNo = JOptionPane.showInputDialog(null, "Enter Room No", "", JOptionPane.QUESTION_MESSAGE);		
			String roomName = JOptionPane.showInputDialog(null, "Enter Room Name", "", JOptionPane.QUESTION_MESSAGE);
			String lecturerName = JOptionPane.showInputDialog(null, "Enter Lecturer Name", "", JOptionPane.QUESTION_MESSAGE);
			String roomCapacity = JOptionPane.showInputDialog(null, "Enter Room Capacity", "", JOptionPane.QUESTION_MESSAGE);
			String noOfStudentEnrolled = JOptionPane.showInputDialog(null, "No of Students Enrolled", "", JOptionPane.QUESTION_MESSAGE);

			File lecturerFile = new File("lecturer.txt");
			lecturerFile.createNewFile();
			// Write the input data in the file
			FileWriter fileWrite = new FileWriter(lecturerFile, true); 
			BufferedWriter bufferedWrite = new BufferedWriter(fileWrite);
			// Input Data is written in the Lecturer Details file
			bufferedWrite.write("\n" + unitId + "\t\t" + unitName + "\t\t" + roomNo + "\t\t" + roomName + "\t\t" + lecturerName
					+ "\t\t" + roomCapacity + "\t\t" + noOfStudentEnrolled+"\t\t"+System.getProperty("line.separator" ));

			bufferedWrite.flush();// Write the data which is already given
			bufferedWrite.close();
			JOptionPane.showMessageDialog(null, "Successfully added the new Lecture Details.", null, JOptionPane.PLAIN_MESSAGE);
		} catch (IOException error) {
			JOptionPane.showMessageDialog(null, "File is not found", null, JOptionPane.PLAIN_MESSAGE);
		}
	}

	// This Method to add  new students details
	public static void setStudentFile() {
		try {

			// Get the User Inputs
			String studentId = JOptionPane.showInputDialog(null, "Enter Student ID", "", JOptionPane.QUESTION_MESSAGE);
			String lastName = JOptionPane.showInputDialog(null, "Enter Last name", "", JOptionPane.QUESTION_MESSAGE);
			String firstName = JOptionPane.showInputDialog(null, "Enter First Name", "", JOptionPane.QUESTION_MESSAGE);		
			String unitId = JOptionPane.showInputDialog(null, "Enter Unit ID", "", JOptionPane.QUESTION_MESSAGE);

			// Creating the studentdetails.txt file
			File studentDetailsFile = new File("studentdetails.txt");
			studentDetailsFile.createNewFile();
			// Write the user input data in the file
			FileWriter studentdetails = new FileWriter(studentDetailsFile, true); 
			BufferedWriter bufferedWrite = new BufferedWriter(studentdetails);
			// Input Data is written in the Student Details file
			bufferedWrite.write("\n" + studentId + "\t" + lastName + "\t" + firstName+ "\t" + unitId+"\t\t"+System.getProperty("line.separator" ));
			bufferedWrite.flush();// Write the data which is already given
			bufferedWrite.close();
			JOptionPane.showMessageDialog(null, "Successfully added the new Student Details.", null, JOptionPane.PLAIN_MESSAGE);
		} catch (IOException error) {
			JOptionPane.showMessageDialog(null, "File is not found", null, JOptionPane.PLAIN_MESSAGE);
		}
	}

	//This Method is to read the lecture.txt
	public static void viewLecturerFile() {

		try {
			BufferedReader lecturerFile = new BufferedReader(new FileReader("lecturer.txt"));
			String lines;
			String details = "";

			// Read line by line and view the details
			while ((lines = lecturerFile.readLine()) != null) {
				details = details + lines+"\n";
			}

			//Declare and initialize the result title and table
			String tableTitle = "\t\t\tLecturer Listing\n";
			String detailTable = "Unit ID\t\tUnit Name\t\tRoom No\t\tRoom Name\t\tLecturer Name\t\tRoom Capacity\t\tNoOfStudentEnrolled\n";
			//Center the title depending on the size of table
			StringBuilder builder = new StringBuilder();
			for(int i=0;i<detailTable.length()*1.75;i++){

				builder.append(" ");
			}
			lecturerFile.close();

			//Display the result title and table
			JOptionPane.showMessageDialog(null, new JTextArea(tableTitle.format(tableTitle,builder.toString()) 
					+ detailTable + details), null, JOptionPane.PLAIN_MESSAGE);

		} catch (IOException error) {
			JOptionPane.showMessageDialog(null, "File is not found", null, JOptionPane.PLAIN_MESSAGE);
		}
	}

	//This Method is to read the studentDetails file
	public static void viewStudentFile() {

		try {
			BufferedReader studentDetailsFile = new BufferedReader(new FileReader("studentdetails.txt"));
			String lines;
			String details = null;

			// Read line by line and view the details
			while ((lines = studentDetailsFile.readLine()) != null) {
				details = details + lines +"\n";
			}

			//Declare and initialize the result title and table
			String tableTitle = "\t  Student Listing\n";
			String detailTable = "Student No\tLast Name\tFirst Name\tUnit ID\n";
			//Center the title depending on the size of table
			StringBuilder builder = new StringBuilder();
			for(int i=0;i<detailTable.length()*1.75;i++){

				builder.append(" ");
			}
			studentDetailsFile.close();
			//Display the result title and table
			JOptionPane.showMessageDialog(null, new JTextArea(tableTitle.format(tableTitle,builder.toString()) 
					+ detailTable + details), null, JOptionPane.PLAIN_MESSAGE);

		} catch (IOException error) {
			JOptionPane.showMessageDialog(null, "File is not found", null, JOptionPane.PLAIN_MESSAGE);
		}		
	}

	//This Method is to edit lecture details
	public static void updateLecturerFile() {

		// Get the User Inputs
		String unitId = JOptionPane.showInputDialog(null, "Enter Unit ID", null, JOptionPane.QUESTION_MESSAGE);
		String unitName = JOptionPane.showInputDialog(null, "Enter Unit Name:", null, JOptionPane.QUESTION_MESSAGE);
		String roomNo = JOptionPane.showInputDialog(null, "Enter Room No", null, JOptionPane.QUESTION_MESSAGE);
		String roomName = JOptionPane.showInputDialog(null, "Enter Room Name", null, JOptionPane.QUESTION_MESSAGE);
		String lectureName = JOptionPane.showInputDialog(null, "Enter Lecturer Name", null, JOptionPane.QUESTION_MESSAGE);
		String roomCapacity = JOptionPane.showInputDialog(null, "Room Capacity", null, JOptionPane.QUESTION_MESSAGE);
		String noOfStudentEnrolled = JOptionPane.showInputDialog(null, "No of Students Enrolled", null, JOptionPane.QUESTION_MESSAGE);

		try {
			//Open lecturer.txt file
			FileInputStream lecturerFile = new FileInputStream("lecturer.txt");
			@SuppressWarnings("resource")
			BufferedReader lecturer = new BufferedReader(new InputStreamReader(lecturerFile));
			String lines;
			StringBuilder strBuilder = new StringBuilder();
			//Read line by line in the file
			while ((lines = lecturer.readLine()) != null) {
				//created an array 
				String words[] = lines.split(";\\t");
				if (words.length > 0) {
					//Assign unitId to word[0]
					if (words[0].contains(unitId)) {
						if (unitName != null)
							words[1] = unitName;
						if (roomNo != null)
							words[2] = roomNo;
						if (roomName != null)
							words[3] = roomName;
						if (lectureName != null)
							words[4] = lectureName;
						if (roomCapacity != null)
							words[5] = roomCapacity;
						if (noOfStudentEnrolled != null)
							words[6] = noOfStudentEnrolled;
						String newLine = words[0] + "\t" + words[1] + "\t" + words[2] + "\t" + words[3]
								+ "\t"+ words[4] + "\t" + words[5] + "\t" + words[6];
						strBuilder.append(newLine);
						strBuilder.append("\n");
					} else {
						strBuilder.append(lines);
						strBuilder.append("\n");
					}
				}
			}
			FileWriter fileWriter = new FileWriter("lecturer.txt");
			BufferedWriter lecturerDetails = new BufferedWriter(fileWriter);
			lecturerDetails.write(strBuilder.toString());
			lecturerDetails.close();
			JOptionPane.showMessageDialog(null, "Successfully Edited the Lecture Entry.", null, JOptionPane.PLAIN_MESSAGE);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Sorry Edit was Unsucessful.", null, JOptionPane.ERROR_MESSAGE);
		}
	}

	//This Method is created to edit student details to the studentdetails.txt
	public static void updateStudentFile() {
		try {
			// Get the User Inputs
			String studentId = JOptionPane.showInputDialog(null, "Enter Student ID", null, JOptionPane.QUESTION_MESSAGE);
			String lastName = JOptionPane.showInputDialog(null, "Enter Last name", null, JOptionPane.QUESTION_MESSAGE);
			String firstName = JOptionPane.showInputDialog(null, "Enter First Name", null, JOptionPane.QUESTION_MESSAGE);
			String unitId = JOptionPane.showInputDialog(null, "Enter Unit ID", null, JOptionPane.QUESTION_MESSAGE);

			//Open studentsdetails.txt
			FileInputStream studentFile = new FileInputStream("studentdetails.txt");
			@SuppressWarnings("resource")
			BufferedReader student = new BufferedReader(new InputStreamReader(studentFile));
			String lines;
			StringBuilder stringBuilder = new StringBuilder();
			//Read line by line
			while ((lines = student.readLine()) != null) {
				//created an array 
				String words[] = lines.split("\\t");
				if (words.length > 0) {
					//words [0] is student number
					if (words[0].contains(studentId)) {
						if (lastName != null){
							words[1] = lastName;
						}
						if (firstName != null){
							words[2] = firstName;
						}
						if (unitId != null){
							words[3] = unitId;
						}
						String newLine = words[0] + "\t" + words[1] + "\t" + words[2] + "\t" + words[3];
						stringBuilder.append(newLine); //Write the input data to file
						stringBuilder.append("\n");
					} else {
						stringBuilder.append(lines);
						stringBuilder.append("\n");
					}
				}
			}

			FileWriter fileWriter = new FileWriter("studentdetails.txt");
			BufferedWriter studentDetails = new BufferedWriter(fileWriter);
			studentDetails.write(stringBuilder.toString());
			studentDetails.close();
			JOptionPane.showMessageDialog(null, "Successfully Edited the Student Entry.", null, JOptionPane.PLAIN_MESSAGE);		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Sorry Edit was Unsucessful.", null, JOptionPane.ERROR_MESSAGE);
		}
	}

	//This Method to search specific Lecturer record in lecture.txt
	public static void searchLecturer() {

		//Prompt user to enter name
		String lectureName = JOptionPane.showInputDialog(null, "Please input lecture's name", "Search For Lecturer", JOptionPane.QUESTION_MESSAGE);

		//Look for the lecturer's detail with name as the key
		try {
			@SuppressWarnings("resource")
			BufferedReader lecturerFile = new BufferedReader(new FileReader("lecturer.txt"));
			String lines;
			// Read line by line and view the details
			while ((lines = lecturerFile.readLine()) != null) {
				if(lines.toLowerCase().indexOf(lectureName.toLowerCase()) != -1){
					//Declare and initialize the result title and table
					String tableTitle = "\t\t\t\t\tLecturer Listing\n";
					String detailTable = "Unit ID\t\tUnit Name\t\tRoom No\t\tRoom Name\t\tLecturer Name\t\tRoom Capacity\t\tNoOfStudentEnrolled\n";
					//Center the title depending on the size of table
					StringBuilder builder = new StringBuilder();
					for(int i=0;i<detailTable.length() * 1.75;i++){

						builder.append(" ");
					}
					//Display the result title and table
					JOptionPane.showMessageDialog(null, new JTextArea(tableTitle.format(tableTitle,builder.toString()) 
							+ detailTable + lines), null, JOptionPane.PLAIN_MESSAGE);
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//This Method to search specific Student record in studentdetails.txt
	public static void searchStudent() {

		//Prompt user to enter name
		String studentName = JOptionPane.showInputDialog(null, "Please input student's name", "Search For Student", JOptionPane.QUESTION_MESSAGE);

		//Look for the student's detail with name as the key
		try {

			BufferedReader studentDetailsFile = new BufferedReader(new FileReader("studentdetails.txt"));
			String lines;
			// Read line by line and view the details
			while ((lines = studentDetailsFile.readLine()) != null) {
				if(lines.toLowerCase().indexOf(studentName.toLowerCase()) != -1){
					//Declare and initialize the result title and table
					String tableTitle = "\t  Student Listing\n";
					String detailTable = "Student No\tLast Name\tFirst Name\tUnit ID\n";
					//Center the title depending on the size of table
					StringBuilder builder = new StringBuilder();
					for(int i=0;i<detailTable.length()*1.75;i++){

						builder.append(" ");
					}
					//Display the result title and table
					JOptionPane.showMessageDialog(null, new JTextArea(tableTitle.format(tableTitle,builder.toString()) 
							+ detailTable + lines), null, JOptionPane.PLAIN_MESSAGE);
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Delete Lecturer file 
	public static void deleteLecturerFile() {
		//Prompt user to enter name
		String lectureName = JOptionPane.showInputDialog(null, "Please input lecture's name", "Search For Lecturer", JOptionPane.QUESTION_MESSAGE);

		//Look for the lecturer's detail with name as the key
		try {
			@SuppressWarnings("resource")
			BufferedReader lecturerFile = new BufferedReader(new FileReader("lecturer.txt"));
			String lines;
			// Read line by line and view the details
			while ((lines = lecturerFile.readLine()) != null) {
				if(lines.toLowerCase().indexOf(lectureName.toLowerCase()) != -1){
					//Declare and initialize the result title and table
					String tableTitle = "\t\t\t\t\t\tLecturer Listing\n";
					String detailTable = "Unit ID\t\tUnit Name\t\tRoom No\t\tRoom Name\t\tLecturer Name\t\tRoom Capacity\t\tNoOfStudentEnrolled\n";
					//Center the title depending on the size of table
					StringBuilder builder = new StringBuilder();
					for(int i=0;i<detailTable.length() * 1.75;i++){

						builder.append(" ");
					}
					//Display the comfirmation dialog to delete lines
					
					   int reply = JOptionPane.showInternalConfirmDialog(null,new JTextArea(tableTitle.format(tableTitle,builder.toString()) 
								+ detailTable + lines), "Comfirm Delete?", JOptionPane.YES_NO_OPTION);
			            if (reply == JOptionPane.YES_OPTION)
			               lines = null;
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Delete Student file 
	public static void deleteStudentFile() {

	}
}