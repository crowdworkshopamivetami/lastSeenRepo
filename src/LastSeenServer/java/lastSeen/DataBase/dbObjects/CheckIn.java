package lastSeen.DataBase.dbObjects;

import lastSeen.commonObjects.Pin;

/**
 * Created by yoavsusan on 11/24/2015.
 */
public class CheckIn extends Pin {

    private int userId = -1;

    public CheckIn() {}

    public CheckIn(int id, double longitude, double latitude, String timeStamp, String description, int userId) {
        super(id, longitude, latitude, timeStamp, description);
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(", userId: ").append(this.getUserId());
        return sb.toString();
    }
}
