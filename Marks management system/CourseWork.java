import java.util.*;
class CourseWork{
	static String[] stuId=new String[0];
	static String[] stuName=new String[0];
	static int[] dbmsMarks=new int[0];
	static int[] pfMarks=new int[0];
	public static final String ANSI_YELLOW = "\u001B[33m";
	
	//define method for main menu
	public static void mainMenu(){
		int choice;
		Scanner input=new Scanner(System.in);
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("|                  WELCOME TO CMJD MARKS MANAGEMENT SYSTEM                 |");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("\t\t[1]  Add New Student");
		System.out.println("\t\t[2]  Add New Student With Marks");
		System.out.println("\t\t[3]  Add Marks");
		System.out.println("\t\t[4]  Update Student Details");
		System.out.println("\t\t[5]  Update Marks");
		System.out.println("\t\t[6]  Delete Students");
		System.out.println("\t\t[7]  Print Student Details");
		System.out.println("\t\t[8]  Exit");
		System.out.println();
		System.out.print("\n\t\tEnter an option to continue : ");
		int option =input.nextInt();
		
		if (option > 0){
			choice = option;
		}else{
			choice = -(option);
		}
		
		clearConsole();
		switch (choice)
		{
			case 1:
				addNewStudent();
				break;
			case 2:
				addNewStudentWithMarks();
				break;
			case 3:
				addMarks();
				break;
			case 4:
				updateStudentDetails();
				break;
			case 5:
				updateMarks();
				break;
			case 6:
				deleteStudent();
				break;
			case 7:
				printStudentDetails();
				break;
			case 8:
				exit();
				break;
			default:
				System.out.println("\n\n\n\t\t Error input!");
				System.out.print("\n\t\t Loading Main Menu");
				delay();
				clearConsole();
				mainMenu();
				break;
			}
	}
	
	//define method for print student details	
	public static void printStudentDetails(){
		Scanner input=new Scanner(System.in);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("|                      PRINT STUDENT DETAILS                       |");
		System.out.println("--------------------------------------------------------------------\n");
		
			
		System.out.print("Input Students id : ");		
		String id=input.nextLine();
		int index=searchIndex(stuId,id);
		if (index>=0){
			System.out.println("Student Name : "+stuName[index]);
			if (pfMarks.length<index){
				System.out.println("Marks yet to be Added.");
			}else{
				int tot=pfMarks[index]+dbmsMarks[index];
				double avg=tot/2.0;
				System.out.println("*----------------------------------*---------*");
				System.out.printf("|Programing Fundamentals Marks     |    %5d|",pfMarks[index]);
				System.out.printf("\n|Database Management System Marks  |    %5d|",dbmsMarks[index]);
				System.out.printf("\n|Total Marks                       |    %5d|",tot);
				System.out.printf("\n|Average Marks                     |    %3.2f|\n",avg);
				System.out.println("*----------------------------------*---------*");
			}
				
		}else{
			System.out.println("Invalid Student ID.");
		}
		System.out.print("Do you want to print another student's details? (Y/N) : ");
		String option=input.nextLine();
				
			if (option.equals("Y")||option.equals("y")){
				clearConsole();
				printStudentDetails();
			}else{
				clearConsole();
				mainMenu();
			}
		
	}
	
	//define method for delete student
	public static void deleteStudent(){
		Scanner input=new Scanner(System.in);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("|                      DELETE STUDENT DETAILS                       |");
		System.out.println("--------------------------------------------------------------------\n");
		
			
		System.out.print("Input Students id : ");		
		String stId=input.nextLine();
		int index=searchIndex(stuId,stId);
		if(index>=0){
			for(int i=index;i<stuId.length-1; i++){
				stuId[i]=stuId[i+1];
				stuName[i]=stuName[i+1];
				dbmsMarks[i]=dbmsMarks[i+1];
				pfMarks[i]=pfMarks[i+1];
			}
			String[] tempStuId=new String[stuId.length-1];
			String[] tempStuName=new String[stuName.length-1];
			int[] tempDbmsMarks=new int[dbmsMarks.length-1];
			int[] tempPfMarks=new int[pfMarks.length-1];
			for(int i=0;i<tempStuId.length; i++){
				tempStuId[i]=stuId[i];
				tempStuName[i]=stuName[i];
				tempDbmsMarks[i]=dbmsMarks[i];
				tempPfMarks[i]=pfMarks[i];
			}
			stuId=tempStuId;
			stuName=tempStuName;
			dbmsMarks=tempDbmsMarks;
			pfMarks=tempPfMarks;
			System.out.println("\nStudent has been deleted successfully.");
		}else{
			System.out.println("Invalid Student ID.");
		}
		System.out.print("\nDo you want to delete another student? (Y/N) : ");
		String option=input.nextLine();
				
			if (option.equals("Y")||option.equals("y")){
				clearConsole();
				deleteStudent();
			}else{
				clearConsole();
				mainMenu();
			}
	}
	
	//define method for update marks
	public static void updateMarks(){
		Scanner input=new Scanner(System.in);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("|                      UPDATE MARKS                                 |");
		System.out.println("--------------------------------------------------------------------\n");
		
		System.out.print("Enter Student ID : ");
		String id = input.nextLine();
		
		int index=searchIndex(stuId,id);
		if (index!=-1){
			System.out.println("Student Name : "+stuName[index]);
				if (index<pfMarks.length){
					System.out.println("\nProgramming Fundamentals Marks : "+pfMarks[index]);
					System.out.println("Database Management System Marks : "+dbmsMarks[index]);
					
					System.out.print("\nEnter new Programming Fundamentals Marks : ");
					int programMarks=input.nextInt();
					pfMarks[index]=programMarks;
					
					System.out.print("Enter new Database Management System Marks : ");
					int databaseMarks=input.nextInt();
					dbmsMarks[index]=databaseMarks;
					System.out.println("Student marks has been updated Successfully..");
				}else{
					System.out.println("This student's marks yet to be added..");
				}	
			
		}else{
			System.out.println("Invalid Student ID....");
		}
		System.out.print("Do you want to update another student marks? (Y/N) : ");
		String option=input.nextLine();
				
			if (option.equals("Y")||option.equals("y")){
				clearConsole();
				updateMarks();
			}else{
				clearConsole();
				mainMenu();
			}
	}
	
	//define method for update student details
	public static void updateStudentDetails(){
		Scanner input=new Scanner(System.in);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("|                      UPDATE STUDENT DETAILS                       |");
		System.out.println("--------------------------------------------------------------------\n");
		
		System.out.print("Enter Student ID : ");
		String id = input.nextLine();
		int nameIndex=searchIndex(stuId,id);
				if (nameIndex>=0){
					System.out.println("Student Name : "+stuName[nameIndex]);
					System.out.println();
					System.out.print("Enter the new student name : ");
					String name=input.nextLine();
					stuName[nameIndex]=name;
					System.out.println("Student details has been updated Successfully..");
				}else{
					System.out.println("Invalid Student ID.");
				}
		System.out.print("Do you want to update another student details? (Y/N) : ");
		String option=input.nextLine();
				
			if (option.equals("Y")||option.equals("y")){
				clearConsole();
				updateStudentDetails();
			}else{
				clearConsole();
				mainMenu();
			}
	}
	
	//define method for add marks		
	public static void addMarks(){
		Scanner input=new Scanner(System.in); 
		System.out.println("--------------------------------------------------------------------");
		System.out.println("|                             ADD MARKS                            |");
		System.out.println("--------------------------------------------------------------------\n");
		
		System.out.print("Enter Student ID : ");
		String id=input.nextLine();
		int index=searchIndex(stuId,id);
				if (index<0){
					System.out.println("Invalid Student ID.");
				}else{
					System.out.println("Student Name : "+stuName[index]);
					
						if (index>pfMarks.length && index>dbmsMarks.length){
							System.out.println("This student's marks have been already added.\nIf you want to update the marks, please use [4] Update marks option.");
						}else{
							do{
								System.out.print("Programming fundamentals Marks : ");
								int programMarks=input.nextInt();
									if (checkValidMarks(programMarks)){
										System.out.println("Invalid marks.Please Enter correct marks.");
										System.out.println();
									}else{
										pfMarks=extendIntArray(pfMarks,programMarks);
										break;
									}
							} while (true);
				
							do{ 
								System.out.print("Database Management System Marks : ");
								int dataBaseMarks=input.nextInt();
								input.nextLine();
									if (checkValidMarks(dataBaseMarks)){
										System.out.println("Invalid marks.Please Enter correct marks.");
										System.out.println();
									}else{
										dbmsMarks=extendIntArray(dbmsMarks,dataBaseMarks);
										break;
									}
							} while (true);
						}
					}
		System.out.print("Do you want to add another student's Marks? (Y/N) : ");
		String option=input.nextLine();
				
			if (option.equals("Y")||option.equals("y")){
				clearConsole();
				addMarks();
			}else{
				clearConsole();
				mainMenu();
			}
	}
	
	//define method for add student with marks
	public static void addNewStudentWithMarks(){
		Scanner input=new Scanner(System.in); 
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("|                             ADD NEW STUDENT WITH MARKS                            |");
		System.out.println("-------------------------------------------------------------------------------------\n");
		
		do
		{
			System.out.print("Enter Student ID Number : ");
			String id=input.nextLine();
			if (searchElement(stuId,id)){
				System.out.println("Student ID is Already Added.........");
				System.out.println();
			}else{
				stuId=extendStringArray(stuId,id);
				break;
			}
		} while (true);
		
		System.out.print("Enter Student Name : ");
		String name=input.nextLine();
		stuName=extendStringArray(stuName,name);
		System.out.println();
		do{
			System.out.print("Programming fundamentals Marks : ");
			int programMarks=input.nextInt();
				if (checkValidMarks(programMarks)){
					System.out.println("Invalid marks.Please Enter correct marks.");
					System.out.println();
				}else{
					pfMarks=extendIntArray(pfMarks,programMarks);
					break;
				}
		} while (true);
				
		do{ 
			System.out.print("Database Management System Marks : ");
			int dataBaseMarks=input.nextInt();
			input.nextLine();
				if (checkValidMarks(dataBaseMarks)){
					System.out.println("Invalid marks.Please Enter correct marks.");
					System.out.println();
				}else{
					dbmsMarks=extendIntArray(dbmsMarks,dataBaseMarks);
					break;
				}
		} while (true);
		System.out.println();
		
		System.out.print("Student added successfully...Do you want to continue..(Y/N) : ");
		String option=input.nextLine();
			if (option.equals("Y")||option.equals("y")){
				clearConsole();
				addNewStudentWithMarks();
			}else{
				clearConsole();
				mainMenu();
			}
	}
	
	//define method for main add student without marks	
    public static void addNewStudent(){
		Scanner input=new Scanner(System.in); 
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("|                                ADD NEW STUDENT                                     |");
		System.out.println("-------------------------------------------------------------------------------------\n");
		
		do
		{
			System.out.print("Enter Student ID Number : ");
			String id=input.nextLine();
			if (searchElement(stuId,id)){
				System.out.println("Student ID is Already Added.........");
				System.out.println();
			}else{
				stuId=extendStringArray(stuId,id);
				break;
			}	
		} while (true);
		
		System.out.print("Enter Student Name : ");
		String name=input.nextLine();
		stuName=extendStringArray(stuName,name);
		System.out.println();
		
		System.out.print("Student added successfully...Do you want to continue..(Y/N) : ");
		String option=input.nextLine();
				
			if (option.equals("Y")||option.equals("y")){
				clearConsole();
				addNewStudent();
			}else{
				clearConsole();
				mainMenu();
			}
	}
	
	//define method for extend String array
	public static String[] extendStringArray(String[] xr,String value){
		String[] temp= new String[xr.length+1];
		for(int i=0; i<xr.length; i++){
			temp[i]=xr[i];
		}
		temp[temp.length-1]=value;
		return temp;
	}
	
	//define method for extend int array
	public static int[] extendIntArray(int[] xr,int value){
		int[] temp= new int[xr.length+1];
		for(int i=0; i<xr.length; i++){
			temp[i]=xr[i];
		}
		temp[temp.length-1]=value;
		return temp;
	}
	
	//define method for search element in a array
	public static boolean searchElement(String[] a,String key){
		for (int i = 0; i < a.length; i++){
			if (a[i].equalsIgnoreCase(key)){
				return true;
			}
		}
		return false;
	}
	
	//define method for check marks are valid or not
	public static boolean checkValidMarks(int marks){
		if (marks<0||marks>100){
			return true;
		}
		return false;
	}
	
	//define method for search index is valid or not
	public static int searchIndex(String[] a, String key){
		int index=-1;
		for (int i = 0; i < a.length; i++){
			if(a[i].equals(key)){
				index=i;
			}
		}
		return index;		
	}
	
	//define method for clear console		
	public final static void clearConsole() { 
		try {
			final String os = System.getProperty("os.name"); 
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J"); 
				System.out.flush();
			}
		} catch (final Exception e) {
		e.printStackTrace();}
 
	}
	
	//define method for screen delay
	public static void delay(){
		int count = 1;
			try{
				while( true ){
					Thread.sleep( 100 );
					for( int i = 0; i < count; i++ ){
						System.out.print( "." );
					}
					count++;
					if( count >= 10 ) break;
				}
			}catch( Exception e ){
				e.printStackTrace();
			}
		}
	
	//define method for login
	public static void login() {
		Scanner input = new Scanner(System.in);
		String userName="CMJD";
		String passWord="1234";
		System.out.print("\n\t***********************************************************");
		System.out.print("\n\t          WELCOME TO CMJD MARKS MANAGEMENT SYSTEM          ");
		System.out.print("\n\t***********************************************************");
		System.out.print("\n\t\tEnter Username : ");
		String user = input.next();

		System.out.print("\t\tEnter Password : ");
		String pass = input.next();
		
		if (user.equals(userName) && pass.equals(passWord)) {

			System.out.print("\n\n\t\tAccess Granted! Welcome!");
			delay();
			clearConsole();
			mainMenu();
		}else if (user.equals(userName)) {
			System.out.print("\n\n\t\tInvalid Password!");
			delay();
			clearConsole();
			login();
		} else if (pass.equals(passWord)) {
			System.out.print("\n\n\t\tInvalid Username!");
			delay();
			clearConsole();
			login();
		} else {
			System.out.print("\n\n\t\tInvalid Username & Password!");
			delay();
			clearConsole();
			login();
		}
	}
	
	//define method for exit application
	public static void exit(){
		System.out.println("\n\n\n\t\t*+*+*+*+*+*+*+*+  THANK YOU...! +*+*+*+*+*+*+*+*+*+*");
		System.out.println("\n\t\t\t\tCourse Work\n\t\t    Module 1 – Programming Fundamentals\n\t\t    Comprehensive Mater Java Programmer");
		System.out.println("\n\t\t********Developed by Harshani Chathurangika*******");
		System.out.print("\n\t\t----------------------------------------------------");
		System.out.print("\n\n\t\t\t     Loading Main Menu");
		
			delay();
			clearConsole();
			login();
	}

	public static void main(String args[]){
		login();
	}
}

	
