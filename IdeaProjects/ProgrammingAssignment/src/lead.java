import java.io.*;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class lead {

    private static int baseID = -1;

    private static ArrayList<String> id = new ArrayList<String>(); //format lead_xxx, x representing a unique number
    private static ArrayList<String> name = new ArrayList<String>();
    private static ArrayList<Integer> birthYear = new ArrayList<Integer>();
    private static ArrayList<String> sex = new ArrayList<String>(); //true = female, false = male
    private static ArrayList<String> phone = new ArrayList<String>();
    private static ArrayList<String> email = new ArrayList<String>();
    private static ArrayList<String> address = new ArrayList<String>();

    public static void enter() throws IOException{
        //generate id
        baseID = baseID + 1;
        if (baseID < 10) {
            id.add("lead_00" + baseID);
        } else if (100 > baseID && baseID >= 10) {
            id.add("lead_0" + baseID);
        } else {
            id.add("lead_" + baseID);
        }

        //prompt user for and begin accepting input
        System.out.println("Enter a new lead. Please provide all input in lowercase, with no spaces or special characters.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name:");
        name.add(scanner.nextLine());

        System.out.println("Birth Year:");
        birthYear.add(scanner.nextInt());

        System.out.println("Sex:");

        //Without this line, the system will attempt to take both 'sex' and 'phone' at the same time
        String buffer = scanner.nextLine();

        sex.add(scanner.nextLine());

        System.out.println("Phone:");
        phone.add(scanner.nextLine());

        System.out.println("Email:");
        email.add(scanner.nextLine());

        System.out.println("Address:");
        address.add(scanner.nextLine());

        //create .csv file
        File file = new File("leads.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("ID,Name,BirthYear,Sex,Phone,Email,Address");
        bw.newLine();
        for(int i = 0; i < id.size(); i++){
            bw.write(id.get(i)+","+name.get(i)+","+birthYear.get(i)+","+sex.get(i)+","+phone.get(i)+","+email.get(i)+","+address.get(i));
            bw.newLine();
        }
        bw.close();
        fw.close();
    }

    public static void list(){
        System.out.println(id);
        System.out.println(name);
        System.out.println(birthYear);
        System.out.println(sex);
        System.out.println(email);
        System.out.println(address);
    }
    public static void delete(){
        System.out.println("Enter the full ID of the lead you wish to delete.");
        Scanner scanner = new Scanner(System.in);
        String lead = scanner.nextLine();
        //takes the last of the three digits, this will have to be changed to account for larger digits at some point
        String No = lead.substring(6,7);
        //instanceID refers to the location of the lead
        int instanceID = Integer.parseInt(No);
        //sets all values at the given position to null
        id.set(instanceID, null);
        name.set(instanceID, null);
        birthYear.set(instanceID, null);
        sex.set(instanceID, null);
        email.set(instanceID, null);
        address.set(instanceID, null);

        //delete from  .csv file
        //BufferedReader reader = new BufferedReader(new FileReader(file(false)));
    }
}