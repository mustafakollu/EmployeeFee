import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Personnel {				//this class hold personnel's elements
	private String name;
	private String surname;
	private String registrationNumber;			// elements of personnel class
	private String positionOfPersonnel;
	private int yearOfStart;
	private int totalSalary;
	
	public Personnel(String name, String surname, String registrationNumber, String positionOfPersonnel,int yearOfStart) {
		super();								//this constructor for reading
		this.name = name;
		this.surname = surname;
		this.registrationNumber = registrationNumber;
		this.positionOfPersonnel = positionOfPersonnel;
		this.yearOfStart = yearOfStart;
	}
	
	
	public Personnel(String name, String surname, String registrationNumber, String positionOfPersonnel,int yearOfStart, int totalSalary) {
		super();								//this constructor for inheritance
		this.name = name;
		this.surname = surname;
		this.registrationNumber = registrationNumber;
		this.positionOfPersonnel = positionOfPersonnel;
		this.yearOfStart = yearOfStart;
		this.totalSalary = totalSalary;
	}

												
	public int getTotalSalary() {							// getter/setter function
		return totalSalary;
	}


	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getRegistrationNumber() {
		return registrationNumber;
	}


	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}


	public String getPositionOfPersonnel() {
		return positionOfPersonnel;
	}


	public void setPositionOfPersonnel(String positionOfPersonnel) {
		this.positionOfPersonnel = positionOfPersonnel;
	}


	public int getYearOfStart() {
		return yearOfStart;
	}


	public void setYearOfStart(int yearOfStart) {
		this.yearOfStart = yearOfStart;
	}


	public static String[] readFile(String path, ArrayList<Personnel> array_personnel){
        try{					//this function read personnel list
            int i=0;
            int length= Files.readAllLines(Paths.get(path)).size();
            String[] results=new String[length];
            for (String line: Files.readAllLines(Paths.get(path))){

                String[] arr1=line.split("\t");
                String[] arr2=arr1[0].split(" ");
                array_personnel.add(new Personnel(arr2[0],arr2[1],arr1[1],arr1[2],Integer.parseInt(arr1[3])));
                
            }

            return  results;
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
}
}
