package FootbollTeamGenerator;

public class Player {

    private String name;

    private static int endurance;
    private static int sprint;
    private static int dribble;
    private static int passing;
    private static int shooting;


    public Player(String name, int endurance) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setShooting(int shooting) {
        if (!isValid(shooting)){
            throw new IllegalArgumentException(shooting + " should be between 0 and 100.");
        }
        Player.shooting = shooting;
    }

    private void setPassing(int passing) {
        if (!isValid(passing)){
            throw new IllegalArgumentException(passing + " should be between 0 and 100.");
        }
        Player.passing = passing;
    }

    private void setDribble(int dribble) {
        if (!isValid(dribble)){
            throw new IllegalArgumentException(dribble + " should be between 0 and 100.");
        }
        Player.dribble = dribble;
    }

    private void setSprint(int sprint) {
        if (!isValid(sprint)){
            throw new IllegalArgumentException(sprint + " should be between 0 and 100.");
        }
        Player.sprint = sprint;
    }
    private boolean isValid(int val){
        return val < 100 && val > 0;
    }

    private void setEndurance(int endurance) {
        if (!isValid(endurance)){
            throw new IllegalArgumentException(endurance + " should be between 0 and 100.");
        }
        Player.endurance = endurance;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
    public String getName() {
        return name;
    }

    private static int getDribble() {
        return dribble;
    }

    private static int getEndurance() {
        return endurance;
    }

    private static int getPassing() {
        return passing;
    }

    private static int getShooting() {
        return shooting;
    }

    private static int getSprint() {
        return sprint;
    }

    public static double overallSkillLevel(){
        return (double) (getDribble() * getEndurance() * getPassing() * getShooting() * getSprint()) / 2;
  }
}
