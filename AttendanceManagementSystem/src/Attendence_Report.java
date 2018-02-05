
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.SynchronousQueue;

public class Attendence_Report {
	
	public static void main (String[] arr){
			MainPage();
			System.out.println("Input Username and Password  Hint : ADMIN,123");
			Scanner input = new Scanner (System.in);
			int errorPassword = 0;
			while(errorPassword<3){
				System.out.print("USER NAME: ");
				String name = input.nextLine();
				System.out.print("PASSWORD: ");
				String passWord = input.nextLine();
					//check the user-name and password are correct
				if ((name.equals("ADMIN"))&&(passWord.equals("123"))){
					while(true){				
						System.out.print("Enter Your Selection: ");
						int menuSelectinon = input.nextInt();
						//switch cases for several methods to user input
						switch(menuSelectinon){
							case 1:
								setStudentFile();
								break;
							case 2:
								viewStudentFile();
								break;
							case 3:
								setLecturerFile();
								break;
							case 4:
								viewLecturerFile();
								break;
							case 5:
								updateStudentFile();
								break;
							case 6:
								updateLecturerFile();
								break;
							case 7:
								markAttendence();
								break;
							case 8:
								viewAttendenceReport();
								break;
							case 9:
								exitprogramm();
							default:
								System.out.println("Invaild Input Enter between 1-6");
								break;
						}	
					}		
					}else{
						System.out.println("Incorrect UserName of Password \n PLEASE TRY AGAIN");
						errorPassword++;
				}
			}
		}
	public static void MainPage(){
	
		    System.out.println("		WELCOME TO Asia Pacific University (APU)     ");
		    System.out.println("===============================================================");
			System.out.println("		Enter 1 - Add New Students Details	 \n  ");
			System.out.println("		Enter 2 - View the Student Details	 \n  ");
			System.out.println("		Enter 3 - Add New Lecture Details	 \n  ");
			System.out.println("		Enter 4 - View the Lecture Details	 \n  ");
			System.out.println("		Enter 5 - Student Details Modification\n");
			System.out.println("		Enter 6 - Lecture Details Modification\n");
			System.out.println("		Enter 7 - Add New Attendence Details \n ");
			System.out.println("		Enter 8 - Genarate the Attendance Report\n");
			System.out.println("		Enter 9 - Exit the Program");
			System.out.println("===============================================================");
 }

	// This Method to add  new students details
		public static void setStudentFile() {
			try {
			Scanner input = new Scanner(System.in);
				 // Get the User Inputs
			System.out.print("Enter Student ID: ");
			String studentId = input.next();
			System.out.print("Enter Last name: ");
			String lastName = input.next();
			System.out.print("Enter First Name: ");
			String firstName = input.next();
			System.out.print("Enter Unit ID: ");
			String unitId = input.next();

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
				System.out.println("Successfully added the new Student Details.");
			} catch (IOException error) {
				System.out.println("File is not found");
			}
		}
		
	//This Method is to read the studentDetails file
		public static void viewStudentFile() {

			try {
				BufferedReader studentDetailsFile = new BufferedReader(new FileReader("studentdetails.txt"));
				String lines;
				System.out.println("Student No\tLast Name\tFirst Name\tUnit ID");
					// Read line by line and view the details
				while ((lines = studentDetailsFile.readLine()) != null) { 
					System.out.println(lines);
				}
				studentDetailsFile.close();
			} catch (IOException error) {
				System.out.println("File is not found");
				}		
		}
		
	//This Method is created to add  new lecture details to the lecture.txt
	public static void setLecturerFile() {
		try {
			Scanner input = new Scanner(System.in);
			 	// Get the User Inputs
			System.out.print("Enter Unit ID: ");
			String unitId = input.nextLine();
			System.out.print("Enter Unit Name: ");
			String unitName = input.nextLine();
			System.out.print("Enter Room No: ");
			String roomNo = input.nextLine();
			System.out.print("Enter Room Name: ");
			String roomName = input.nextLine();
			System.out.print("Enter Lecturer Name: ");
			String lecturerName = input.nextLine();
			System.out.print("Room Capacity: ");
			String roomCapacity = input.next();
			System.out.print("No of Students Enrolled: ");
			String noOfStudentEnrolled = input.next();
							
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
			System.out.println("Successfully added the new Lecture Details.");
		} catch (IOException error) {
			System.out.println("File is not found");
			}
	}
	
	//This Method is to read the lecture.txt
		public static void viewLecturerFile() {
			try {
				BufferedReader lecturerFile = new BufferedReader(new FileReader("lecturer.txt"));
				String lines;
				System.out.println("Unit ID\tUnit Name\tRoom No\tRoom Name\tLecturer Name\tRoom Capacity\tNoOfStudentEnrolled");
					// Read line by line and display
				while ((lines = lecturerFile.readLine()) != null) {
					System.out.println(lines);
				}
					lecturerFile.close();
			} catch (IOException error) {
				System.out.println("File is not found");
				}
		}

 	//This Method is created to edit student details to the studentdetails.txt
		public static void updateStudentFile() {
			try {
				// Get the User Inputs
				Scanner Input = new Scanner(System.in);
				System.out.print("Enter Student ID: ");
				String studentId = Input.next();
				System.out.print("Enter Last name: ");
				String lastName = Input.next();
				System.out.print("Enter First Name: ");
				String firstName = Input.next();
				System.out.print("Enter Unit ID: ");
				String unitId = Input.next();
		
			//Open studentsdetails.txt
				FileInputStream studentFile = new FileInputStream("studentdetails.txt");
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
				System.out.println("Successfully Edited the Student Entry.");
			}catch (Exception e) {
				System.err.println("Sorry Edit was Unsucessful.");
				}
		}
 	
		//This Method is to edit lecture details
		public static void updateLecturerFile() {
	 	
			Scanner input = new Scanner(System.in);
			// Get the User Inputs
			System.out.print("Enter Unit ID: ");
			String unitId = input.nextLine();
			System.out.print("Enter Unit Name: ");
			String unitName = input.nextLine();
			System.out.print("Enter Room No: ");
			String roomNo = input.nextLine();
			System.out.print("Enter Room Name: ");
			String roomName = input.nextLine();
			System.out.print("Enter Lecturer Name: ");
			String lectureName = input.nextLine();
			System.out.print("Room Capacity: ");
			String roomCapacity = input.next();
			System.out.print("No of Students Enrolled: ");
			String noOfStudentEnrolled = input.next();
	 		
				try {
					//Open lecturer.txt file
				FileInputStream lecturerFile = new FileInputStream("lecturer.txt");
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
					System.out.println("Successfully Edited the Lecture Entry.");
				}catch (Exception e) {
					System.err.println("Sorry Edit was Unsucessful.");
				}
			}
	
		//This Method is to Add Attendance Details	
		public static void markAttendence() {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			try {
				Scanner input = new Scanner(System.in);
				// Get the User Inputs
				System.out.print("Enter Room No: ");
				String roomNo = input.nextLine();
				System.out.print("Enter Student ID: ");
				String studentId = input.next();
				System.out.print("Enter Unit ID: ");
				String unitId = input.next();
				System.out.print("Enter Lecturer Name: ");
				String lecturerName = input.next();
				System.out.print("Enter Week No: ");
				String weekNo = input.next();
				
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
				System.out.println("Successfully added the new Attendence Details.");
			} catch (IOException error) {
				System.out.println("File is not found");
				}
		}
	// This Method is Generate Attendance Report and View
		public static void viewAttendenceReport() {
				Scanner input = new Scanner(System.in);
				 	// Get the User Inputs
				System.out.print("Enter Unit ID: ");
				String unitId = input.nextLine();
				System.out.print("Enter Week No: ");
				String week = input.next();
				System.out.print("Enter Date: ");
				String date = input.next();
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
		// This Method to exit the programm
		public static void exitprogramm() {
			System.exit(0);
		}
}




 

