import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Lecturer {
	// This Method is to Add Attendance Details	
	public static void markAttendence() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		try {

			// Get the User Inputs

			String roomNo = JOptionPane.showInputDialog(null, "Enter Room No", "Room No.", JOptionPane.QUESTION_MESSAGE);
			String studentId = JOptionPane.showInputDialog(null, "Enter Student ID", "Student ID", JOptionPane.QUESTION_MESSAGE);
			String unitId = JOptionPane.showInputDialog(null, "Enter Unit ID", "Unit ID", JOptionPane.QUESTION_MESSAGE);
			String lecturerName = JOptionPane.showInputDialog(null, "Enter Lecturer Name", "Name", JOptionPane.QUESTION_MESSAGE);
			String weekNo = JOptionPane.showInputDialog(null, "Enter Week No", "Week No.", JOptionPane.QUESTION_MESSAGE);

			//Convert the date to string
			String nowdate = dateFormat.format(date);
			File attendenceFile = new File("Attendencelog.txt");
			attendenceFile.createNewFile();
			// Write the given inputs to the lecturer.txt file
			FileWriter fileWriter = new FileWriter(attendenceFile, true); 
			BufferedWriter bufferedWrite = new BufferedWriter(fileWriter);
			// Input Data is written in the Attendancelog file
			bufferedWrite.write(roomNo + "\t" + studentId + "\t" + unitId + "\t" + lecturerName + "\t" + nowdate
					+ "\t" + weekNo+"\t"+System.getProperty("line.separator" ));

			bufferedWrite.flush();// Write the data which is already given
			bufferedWrite.close();
			JOptionPane.showMessageDialog(null, "Successfully added the new Attendence Details.", null, JOptionPane.PLAIN_MESSAGE);
		} catch (IOException error) {
			JOptionPane.showMessageDialog(null, "File is not found", null, JOptionPane.PLAIN_MESSAGE);
		}
	}

	}