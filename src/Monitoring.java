import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Monitoring {						//this class hold monitoring's elements
	private String registrationNumber;
	private int week1;							//this elements of monitoring class
	private int week2;
	private int week3;
	private int week4;
	
	
	public Monitoring(String registrationNumber, int week1, int week2, int week3, int week4) {
		super();										//this constructor for reading
		this.registrationNumber = registrationNumber;
		this.week1 = week1;
		this.week2 = week2;
		this.week3 = week3;
		this.week4 = week4;
	}

	public String getRegistrationNumber() {				//Getter/Setter Functions
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getWeek1() {
		return week1;
	}

	public void setWeek1(int week1) {
		this.week1 = week1;
	}

	public int getWeek2() {
		return week2;
	}

	public void setWeek2(int week2) {
		this.week2 = week2;
	}

	public int getWeek3() {
		return week3;
	}

	public void setWeek3(int week3) {
		this.week3 = week3;
	}


	public int getWeek4() {
		return week4;
	}

	public void setWeek4(int week4) {
		this.week4 = week4;
	}

	public static void readFile(String path, ArrayList<Monitoring> array_monitoring,Integer a){
        try{							//This function monitoring list
            int i=0;
            int length= Files.readAllLines(Paths.get(path)).size();
            String[] results=new String[length];
            for (String line: Files.readAllLines(Paths.get(path))){
                String[] arr=line.split("\t");
                array_monitoring.add(new Monitoring(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4])));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
