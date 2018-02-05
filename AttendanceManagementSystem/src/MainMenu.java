import javax.swing.*;

public class MainMenu {

	// Declare and initialize all the necessary objects and variables
	static Admin a;
	static Lecturer l;
	static Student s; 
	static int i;
	//Declare and initialize an array 
	//	static VehicleReg [] VehicleList = new VehicleReg[10]; 	


	static void MainOption(String[] args) {
		int option = 0;  //Declare and initialize option


		do{
			String[] userChoice = new String[] {"1", "2", "3", "4"}; //Declare and initialize array for user's choice in main menu
			//Display main menu and prompt user to choose the option
			option = JOptionPane.showOptionDialog(null, "1.  Add new Vehicle records"
					+ "\n2.  Edit existing driver record"
					+ "\n3.  List all vehicles¡¯ records"
					+ "\n4.  Exit"
					+ "\n\nEnter your choice [1..4]", "Main Menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, userChoice, userChoice[0]);

		

		}while (option != 3); //Loop can be terminated when "4" a.k.a option 3 is detected
	}

	public static void main(String[] args) {
		//Prompt user to enter their informations

		int errorPassword = 0;
		while(errorPassword<3){
			String name = JOptionPane.showInputDialog(null, "Please input Username\n(Hint : ADMIN)", "Username", JOptionPane.QUESTION_MESSAGE);
			String passWord = JOptionPane.showInputDialog(null, "Please input Passwor\n(Hint : ADMIN's p/w = 123)", "Password", JOptionPane.QUESTION_MESSAGE);

			//check the user-name and password are correct
			if ((name.equals("ADMIN"))&&(passWord.equals("123"))){
				while(true){				
					a.OptionList();	

				}		
			}else{

				//Display the result 
				JOptionPane.showMessageDialog(null, "Incorrect UserName of Password \\n PLEASE TRY AGAIN", null, JOptionPane.PLAIN_MESSAGE);
				errorPassword++;
			}
		}
	}
}