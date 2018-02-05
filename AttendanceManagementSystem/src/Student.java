import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Student {
	// This Method is Generate Attendance Report and View
		public static void viewAttendenceReport() {

			// Get the User Inputs
			String unitId = JOptionPane.showInputDialog(null, "Enter Unit ID", "Unit ID", JOptionPane.QUESTION_MESSAGE);
			String week = JOptionPane.showInputDialog(null, "Enter Week No", " Week No", JOptionPane.QUESTION_MESSAGE);
			String date = JOptionPane.showInputDialog(null, "Enter Date", "Date", JOptionPane.QUESTION_MESSAGE);
			
			int roomCapacity=0;
			int noOfStudentEnrolled=0;
			int count=0;
			String newLine = System.getProperty("line.separator");//add new line
			String report=""; // created string variable to to concat
			try {
				//Read the lecturer.txt
				BufferedReader lecturerFile = new BufferedReader(new FileReader("lecturer.txt"));
				String lines;
				//Read line by line
				while ((lines = lecturerFile.readLine()) != null) {
					StringTokenizer st = new StringTokenizer(lines, "\t"); 
					if (st.hasMoreElements()){
						String id =st.nextElement().toString();
						if(unitId.equals(id)){								
							String unitName= st.nextElement().toString();
							String roomNo= st.nextElement().toString();
							String roomName = st.nextElement().toString();
							String lecName =st.nextElement().toString();
							roomCapacity = Integer.parseInt(st.nextElement().toString());
							noOfStudentEnrolled = Integer.parseInt(st.nextElement().toString());
							report +="\nAttendance Report" + newLine;
							report +="===============================" + newLine;
							report +="Unit         :   " + id + newLine;
							report +="Unit Name    :   " + unitName + newLine;
							report +="Room         :   " + roomNo + newLine;
							report +="Room         :   " + roomName + newLine;
							report +="Lecturer     :   " + lecName + newLine;
							report +="Week         :   " + week + newLine;
							report +="Date         :   " + date + newLine;

							break;
						}
					}
				}
				lecturerFile.close();
			} catch (IOException error) {
				System.out.println("File is not found");
			}

			try {
				//Read the studentdetails.text
				BufferedReader studentFile = new BufferedReader(new FileReader("studentdetails.txt"));
				String lines;
				report +="\nStudent No\tLast Name\tFirst Name\tPresent" + newLine;
				//Read line by line
				while ((lines = studentFile.readLine()) != null) {
					StringTokenizer st = new StringTokenizer(lines, "\t"); //break string to tokens
					if (st.hasMoreElements()){
						String studentID= st.nextElement().toString();
						String lastName= st.nextElement().toString();
						String firstName = st.nextElement().toString();
						String unitID =st.nextElement().toString();

						if(unitId.equals(unitID)){				
							try {
								//Read the Attendencelog.txt
								BufferedReader attendenceFile = new BufferedReader(new FileReader("Attendencelog.txt"));
								String line;
								boolean b = false;
								//Read line by line
								while ((line = attendenceFile.readLine()) != null) {
									StringTokenizer st2 = new StringTokenizer(line, "\t"); //break string to tokens
									if (st2.hasMoreElements()){
										String roomNo= st2.nextElement().toString();
										String studentId= st2.nextElement().toString();
										String iD= st2.nextElement().toString(); 
										String lecName =st2.nextElement().toString();
										String date2 =st2.nextElement().toString();
										String week2 =st2.nextElement().toString();

										if(unitId.equals(iD)){								
											if((date.equals(date2))&&(week.equals(week2))&& (studentID.equals(studentId))){
												b=true;
												break;
											}
										}
									}}
								if(b){
									report +="" + studentID + "\t\t" + lastName + "\t\t" + firstName + "\t\t Y " + newLine;
									count++;
								}else{
									report +="" + studentID + "\t\t" + lastName + "\t\t" + firstName + "\t\t N" + newLine;
								}

								attendenceFile.close();
							} catch (IOException error) {
								System.out.println("File is not found");
							}
						}
					}
				}
				report +="\nLecturer confirmed attendance: Yes/No" + newLine;
				report +="Students Enrolled            :\t"+noOfStudentEnrolled + newLine;
				report +="Attendance                   :\t"+count + newLine;
				report +="Room capacity                :\t"+roomCapacity + newLine;
				report +="Percentage occupancy         :\t"+(int)(count/(roomCapacity*0.01))+" %\n" + newLine;
				studentFile.close();

				System.out.println(report);//Display the report

			} catch (IOException error) {
				System.out.println("File is not found");
			}
		}


}
JOptionPane.showInputDialog(null, "", "", JOptionPane.QUESTION_MESSAGE);
JOptionPane.showMessageDialog(null, "Successfully added the new Lecture Details.", null, JOptionPane.PLAIN_MESSAGE);