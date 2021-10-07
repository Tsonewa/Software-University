package TrafficLights;

public class TrafficLight {
    private Colors color;

    public TrafficLight(Colors color){
        this.color = color;
    }
    // if it is currently red, it changes to green, if it is green it changes to yellow
    public void update() {
        switch (this.color) {
            case RED:
                this.color = Colors.GREEN;
                break;
            case YELLOW:
                this.color = Colors.RED;
                break;
            case GREEN:
                this.color = Colors.YELLOW;
                break;
        }
    }
        @Override
        public String toString() {
            return this.color.toString();
        }
    }