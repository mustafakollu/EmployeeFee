import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Program {											//this class has print function and calculate fee function
	public void programWork(String arguman1,String arguman2) {

		ArrayList<Monitoring> array_monitoring= new ArrayList<>();		//create new monitoring array
		ArrayList<Personnel> array_personnel= new ArrayList<>();		//create new personnel array
		
		Monitoring.readFile(arguman2, array_monitoring,0);				//read argument 1
		Personnel.readFile(arguman1, array_personnel);					//read argument 0
		
		for(Personnel personnel1:array_personnel) {						//this for loop for access Personnel class's element
			
			if(personnel1.getPositionOfPersonnel().equals("OFFICER")) {	//this if condition for check to equals personnel's position
				int j=0;
				for(Monitoring m1:array_monitoring) {			//this for loop for access Monitoring class's element
					if(j==0&&personnel1.getRegistrationNumber().equals(m1.getRegistrationNumber())){//this if condition for check to equals personnel's registration number
						{
							int l=calculateOfficer(personnel1.getPositionOfPersonnel(),m1.getWeek1(),m1.getWeek2(),m1.getWeek3(),m1.getWeek4(),personnel1.getYearOfStart(),0);
							//this run calculate fee function
							Officer officer = new Officer(personnel1.getName(),personnel1.getSurname(),personnel1.getRegistrationNumber(),personnel1.getPositionOfPersonnel(),personnel1.getYearOfStart(),l);
							//this equalize Officer's class constructor
							j++;
							show(personnel1.getName(),personnel1.getSurname(),personnel1.getRegistrationNumber(),personnel1.getPositionOfPersonnel(),personnel1.getYearOfStart(),l);
							//this run print function for officer
						}
					}
				}
			}
			
			if(personnel1.getPositionOfPersonnel().equals("SECURITY")) {	//this if condition for check to equals personnel's position
				int j=0;
				for(Monitoring m1:array_monitoring) {		//this for loop for access Monitoring class's element
					if(j==0&&personnel1.getRegistrationNumber().equals(m1.getRegistrationNumber())){//this if condition for check to equals personnel's registration number
						{
							int l=calculateSecurity(personnel1.getPositionOfPersonnel(),m1.getWeek1(),m1.getWeek2(),m1.getWeek3(),m1.getWeek4(),personnel1.getYearOfStart(),0);
							//this run calculate fee function
							Security security = new Security(personnel1.getName(),personnel1.getSurname(),personnel1.getRegistrationNumber(),personnel1.getPositionOfPersonnel(),personnel1.getYearOfStart(),l);
							//this equalize Security's class constructor
							j++;
							show(personnel1.getName(),personnel1.getSurname(),personnel1.getRegistrationNumber(),personnel1.getPositionOfPersonnel(),personnel1.getYearOfStart(),l);
							//this run print function for security
						}
					}
				}
			}
			
			if(personnel1.getPositionOfPersonnel().equals("CHIEF")||personnel1.getPositionOfPersonnel().equals("WORKER")||personnel1.getPositionOfPersonnel().equals("PARTTIME_EMPLOYEE")) {
				
				int j=0;
				for(Monitoring m1:array_monitoring) {		//this for loop for access Monitoring class's element
					if(j==0&&personnel1.getRegistrationNumber().equals(m1.getRegistrationNumber())){//this if condition for check to equals personnel's registration number
						{
							int l=calculateEmployee(personnel1.getPositionOfPersonnel(),m1.getWeek1(),m1.getWeek2(),m1.getWeek3(),m1.getWeek4(),personnel1.getYearOfStart(),0);
							//this run calculate fee function
							Employee employee = new Employee(personnel1.getName(),personnel1.getSurname(),personnel1.getRegistrationNumber(),personnel1.getPositionOfPersonnel(),personnel1.getYearOfStart(),l);
							//this equalize Employee's class constructor
							j++;
							show(personnel1.getName(),personnel1.getSurname(),personnel1.getRegistrationNumber(),personnel1.getPositionOfPersonnel(),personnel1.getYearOfStart(),l);
							//this run print function for Employee
						}
					}
				}
			}
			
			if(personnel1.getPositionOfPersonnel().equals("FACULTY_MEMBER")||personnel1.getPositionOfPersonnel().equals("RESEARCH_ASSISTANT")) {
				
				int j=0;
				for(Monitoring m1:array_monitoring) {		//this for loop for access Monitoring class's element
					if(j==0&&personnel1.getRegistrationNumber().equals(m1.getRegistrationNumber())){//this if condition for check to equals personnel's registration number
						{
							int l=calculateAcademician(personnel1.getPositionOfPersonnel(),m1.getWeek1(),m1.getWeek2(),m1.getWeek3(),m1.getWeek4(),personnel1.getYearOfStart(),0);
							//this run calculate fee function
							Academician academician = new Academician(personnel1.getName(),personnel1.getSurname(),personnel1.getRegistrationNumber(),personnel1.getPositionOfPersonnel(),personnel1.getYearOfStart(),l);
							//this equalize Academician's class constructor
							j++;
							show(personnel1.getName(),personnel1.getSurname(),personnel1.getRegistrationNumber(),personnel1.getPositionOfPersonnel(),personnel1.getYearOfStart(),l);
							//this run print function for Academician
						}
					}
				}
			}
		}
	}
	
	public void show(String name,String surname,String registrationNumber,String position,int year,int salary) {
							//this print output and write registration number.txt
		 try {
		      File myObj = new File(registrationNumber+".txt");//create new output file txt format
		      if (myObj.createNewFile()) {
		      } 
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 
		 try {
		      FileWriter myWriter = new FileWriter(registrationNumber+".txt");
		      myWriter.write("Name : "+name+"\n");								//this is write function
		      myWriter.write("Surname : "+surname+"\n");
		      myWriter.write("Registration Number : "+registrationNumber+"\n");
		      myWriter.write("Position : "+position+"\n");
		      myWriter.write("Year of Start : "+year+"\n");
		      myWriter.write("Total Salary : "+salary+".00 TL");
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	
	
	
public int calculateEmployee(String position,int week1,int week2,int week3,int week4,int year,int totalFee) {
								//this calculate Employee's fee function
		totalFee=0;
		totalFee+=(2020-year)*20*8/10;
		
		if(position.equals("CHIEF")) {		//this calculate chief'S fee
			totalFee+=20*125;
			if(week1>40) {
				int i = week1-40;
				if(i>=8) {
					totalFee+=8*15;
				}
				else {
					totalFee+=i*15;
				}
			}
			if(week2>40) {
				int i = week2-40;
				if(i>=8) {
					totalFee+=8*15;
				}
				else {
					totalFee+=i*15;
				}
			}
			if(week3>40) {
				int i = week3-40;
				if(i>=8) {
					totalFee+=8*15;
				}
				else {
					totalFee+=i*15;
				}
				
			}
			if(week4>40) {
				int i = week4-40;
				if(i>=8) {
					totalFee+=8*15;
				}
				else {
					totalFee+=i*15;
				}
			}
		}
		if(position.equals("WORKER")) {		//this calculate worker's fee
			totalFee+=20*105;
			if(week1>40) {
				int i = week1-40;
				if(i>=10) {
					totalFee+=10*11;
				}
				else {
					totalFee+=i*11;
				}
			}
			if(week2>40) {
				int i = week2-40;
				if(i>=10) {
					totalFee+=10*11;
				}
				else {
					totalFee+=i*11;
				}
			}
			if(week3>40) {
				int i = week3-40;
				if(i>=10) {
					totalFee+=10*11;
				}
				else {
					totalFee+=i*11;
				}
				
			}
			if(week4>40) {
				int i = week4-40;
				if(i>=10) {
					totalFee+=10*11;
				}
				else {
					totalFee+=i*10;
				}
			}
		}
		if(position.equals("PARTTIME_EMPLOYEE")) {		//this calculate part time employee's fee
			if(week1>=10) {
				if(week1>=20) {
					totalFee+=20*18;
					
				}
				else {
					totalFee+=week1*18;
				}
			}
			if(week2>=10) {
				if(week2>=20) {
					totalFee+=20*18;
					
				}
				else {
					totalFee+=week2*18;
				}
			}
			if(week3>=10) {
				if(week3>=20) {
					totalFee+=20*18;
					
				}
				else {
					totalFee+=week3*18;
				}
			}
			if(week4>=10) {
				if(week4>=20) {
					totalFee+=20*18;
					
				}
				else {
					totalFee+=week4*18;
				}
			}
		}
		
	return totalFee;
}
	public int calculateSecurity(String position,int week1,int week2,int week3,int week4,int year,int totalFee) {
											//this calculate security's fee function
		totalFee=0;
		totalFee+=(2020-year)*20*8/10;
		if(week1>30) {
			if(week1>=54) {
				totalFee+=10*54+10*6+5*6;
				
			}
			else {
				totalFee+=week1*10+10*6+5*6;
			}
		}
		if(week2>30) {
			if(week2>=54) {
				totalFee+=10*54+10*6+5*6;
				
			}
			else {
				totalFee+=week2*10+10*6+5*6;
			}
		}
		if(week3>30) {
			if(week3>=54) {
				totalFee+=10*54+10*6+5*6;
				
			}
			else {
				totalFee+=week3*10+10*6+5*6;
			}
		}
		if(week4>30) {
			if(week4>=54) {
				totalFee+=10*54+10*6+5*6;
				
			}
			else {
				totalFee+=week4*10+10*6+5*6;
			}
		}
		
	return totalFee;
}
	
	public int calculateAcademician(String position,int week1,int week2,int week3,int week4,int year,int totalFee) {
													//this calculate academician's fee function
		if(position.equals("FACULTY_MEMBER")) {		//this calculate faculty member's fee
			totalFee=2600;
			totalFee+=totalFee*135/100;
			totalFee+=(2020-year)*20*8/10;
			
			if(week1>40) {
				int i = week1-40;
				if(i>=8) {
					totalFee+=8*20;
				}
				else {
					totalFee+=i*20;
				}
			}
			if(week2>40) {
				int i = week2-40;
				if(i>=8) {
					totalFee+=8*20;
				}
				else {
					totalFee+=i*20;
				}
			}
			if(week3>40) {
				int i = week3-40;
				if(i>=8) {
					totalFee+=8*20;
				}
				else {
					totalFee+=i*20;
				}
			}
			if(week4>40) {
				int i = week4-40;
				if(i>=8) {
					totalFee+=8*20;
				}
				else {
					totalFee+=i*20;
				}
			}
		}
		if(position.equals("RESEARCH_ASSISTANT")) {		//this calculate research assistant's fee
			totalFee=2600;
			totalFee+=totalFee*105/100;
			totalFee+=(2020-year)*20*8/10;
			
		}
		return totalFee;
	}
	public int calculateOfficer(String position,int week1,int week2,int week3,int week4,int year,int totalFee) {
											//this calculate officer's fee function
			totalFee=2600;
			totalFee+=totalFee*65/100;
			totalFee+=(2020-year)*20*8/10;
			
			if(week1>40) {
				int i = week1-40;
				if(i>=10) {
					totalFee+=10*20;
				}
				else {
					totalFee+=i*20;
				}
			}
			if(week2>40) {
				int i = week2-40;
				if(i>=10) {
					totalFee+=10*20;
				}
				else {
					totalFee+=i*20;
				}
			}
			if(week3>40) {
				int i = week3-40;
				if(i>=10) {
					totalFee+=10*20;
				}
				else {
					totalFee+=i*20;
				}
			}
			if(week4>40) {
				int i = week4-40;
				if(i>=10) {
					totalFee+=10*20;
				}
				else {
					totalFee+=i*20;
				}
			}
		return totalFee;
	}
	
	
}
