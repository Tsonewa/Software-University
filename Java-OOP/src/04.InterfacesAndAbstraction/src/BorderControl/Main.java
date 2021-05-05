package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Identified> identifableCitizens = new ArrayList<>();

 String citizenData = scanner.nextLine();

 while (!citizenData.equals("End")){

     String[] tokans = citizenData.split("\\s+");

     if(tokans.length == 3){
         Citizen citizen = new Citizen(tokans[0], Integer.parseInt(tokans[1]), tokans[2]);
         identifableCitizens.add(citizen);
     }else {
         Robot robot = new Robot(tokans[0], tokans[1]);
         identifableCitizens.add(robot);
     }

     citizenData = scanner.nextLine();
 }

 String postfix = scanner.nextLine();

        for (Identified p: identifableCitizens) {
            if(p.getId().endsWith(postfix)){
                System.out.println(p.getId());
            }
        }
    }

}
