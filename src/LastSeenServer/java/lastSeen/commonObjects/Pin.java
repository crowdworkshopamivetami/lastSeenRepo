package lastSeen.commonObjects;

/**
 * Created by yoavsusan on 11/24/2015.
 */
public abstract class Pin {

    private int id = -1;
    private double longitude;
    private double latitude;
    private String timeStamp;
    private String description;

    public Pin() {}

    public Pin(int id, double longitude, double latitude, String timeStamp, String description) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.timeStamp = timeStamp;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(this.getId())
                .append(", longitude: ").append(this.getLongitude())
                .append(", latitude: ").append(this.getLatitude())
                .append(", timeStamp: ").append(this.getTimeStamp())
                .append(", description: ").append(this.getDescription());

        return sb.toString();
    }
}