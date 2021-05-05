package FootbollTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
String commands = scanner.nextLine();
List<Team> teams = new ArrayList<>();
while (!commands.equals("END")){
    String[] tokans = commands.split(";");
    switch (tokans[0]){
        case "Team":
            String teamName = tokans[1];
            try {
                Team team = new Team(teamName);
                teams.add(team);
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            break;
        case "Add":
            try{
                Player player = new Player(tokans[2], Integer.parseInt(tokans[3],
                        Integer.parseInt(tokans[4],
                                Integer.parseInt(tokans[5], Integer.parseInt(tokans[6], Integer.parseInt(tokans[7]))))));
                try {
                    teams.get(teams.indexOf(tokans[1])).addPlayer(player);
                } catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            break;
        case "Remove":
            try {
                teams.get(teams.indexOf(tokans[1])).removePlayer(tokans[2]);
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
            break;
        case "Rating":
            try {
               String teamN = tokans[1];
                for (Team team: teams) {
                    if (team.getName().equals(teamN)){
                        System.out.println(team.getRating(teamN));
                    }
                }
            } catch (IllegalArgumentException illegalArgumentException){
                System.out.println(illegalArgumentException.getMessage());
            }
            break;
    }
    commands = scanner.nextLine();
}

    }
}
