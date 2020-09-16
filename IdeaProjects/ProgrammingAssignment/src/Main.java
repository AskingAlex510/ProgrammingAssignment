import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        boolean systemStatus = true;

        System.out.println("enter 'help' for command list, enter 'exit' to quit");
        Scanner scanner = new Scanner(System.in);
        while (systemStatus == true) {

            String input = scanner.nextLine();

            switch (input) {
                case "exit":
                    systemStatus = false;
                    break;

                case "help":
                    System.out.println("++Prefixes++" + '\n' +
                            "lead -- list leads" + '\n' +
                            "interact -- list interactions" + '\n' +
                            "++Affixes++" + '\n' +
                            "-e -- enter new list item" + '\n' +
                            "-u update list" + '\n' +
                            "-d -- delete from list" + '\n' +
                            "exit -- stop program");
                    break;

                case "lead": //view lead
                    lead.list();
                    break;

                case "lead -e": //enter new lead
                    lead.enter();
                    break;

                case "lead -u": //update lead

                case "lead -d": //delete lead
                    lead.delete();
                    break;

                case "interact": //view list of interactions
                    interaction.list();
                    break;

                case "interact -e": //enter interactions
                    interaction.enter();
                    break;

                case "interact -u": //update interaction

                case "interact -d": //delete interaction
                    interaction.delete();
                    break;

                case "report -a": //report by age

                case "report -p": //report by potential

                case "report -i": //report by number of interactions

            }
        }
    }
}

