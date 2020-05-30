package base;

public class Content {
    private String location;
    private String direction;
    private int distance;

    public Content(String location, String direction, int distance) {
        this.location = location;
        this.direction = direction;
        this.distance = distance;
    }

    public Content() {
        this.location = "";
        this.direction = "";
        this.distance = 0;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {

        if (location.isEmpty())
            return "No content use command !content add \"location\" \"direction (n,s,e,w)\" # for water travel";

        return String.format("Content located at: %s head %s about %d water", location, direction, distance);
    }
}
