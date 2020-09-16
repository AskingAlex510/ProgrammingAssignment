import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class interaction {
    private static int baseID = -1;

    private static ArrayList<String> id = new ArrayList<String>(); //format inter_xxx, x representing a unique number
    private static ArrayList<String> date = new ArrayList<>();
    private static ArrayList<String> lead = new ArrayList<>();
    private static ArrayList<String> via = new ArrayList<>(); //email, phone, etc.
    private static ArrayList<String> vibe = new ArrayList<>(); //positive, negative, neutral

    public static void enter() throws IOException {
        //generate id
        baseID = baseID + 1;
        if(baseID < 10){
            id.add("inter_00" + baseID);
        }
        else if(100 > baseID && baseID >= 10){
            id.add("inter_0" + baseID);
        }
        else{
            id.add("inter_" + baseID);
        }

        System.out.println("Enter a new interaction. Please provide all input in lowercase, with no spaces or special characters.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Date:");
        String input0 = scanner.nextLine();
        date.add(input0);

        System.out.println("Lead:");
        lead.add(scanner.nextLine());

        System.out.println("Communication Method:");
        via.add(scanner.nextLine());

        System.out.println("Vibe Check:");
        vibe.add(scanner.nextLine());

        //create .csv file
        File file = new File("interactions.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("ID,Name,BirthYear,Sex,Phone,Email,Address");
        bw.newLine();
        for(int i = 0; i < id.size(); i++){
            bw.write(id.get(i)+","+date.get(i)+","+lead.get(i)+","+via.get(i)+","+vibe.get(i));
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
    public static void list(){
        System.out.println(id);
        System.out.println(date);
        System.out.println(lead);
        System.out.println(via);
        System.out.println(vibe);
    }
    public static void delete(){
        System.out.println("Enter the full ID of the interaction you wish to delete.");
        Scanner scanner = new Scanner(System.in);
        String inter = scanner.nextLine();
        //takes the last of the three digits, this will have to be changed to account for larger digits at some point
        String No = inter.substring(6,7);
        //instanceID refers to the location of the lead
        int instanceID = Integer.parseInt(No);
        //sets all values at the given position to null
        id.set(instanceID, null);
        date.set(instanceID, null);
        lead.set(instanceID, null);
        via.set(instanceID, null);
        vibe.set(instanceID, null);
    }

}
