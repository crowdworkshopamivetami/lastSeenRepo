package lastSeen.DataBase.dbObjects;

import lastSeen.commonObjects.PersonalInfo;
import lastSeen.commonObjects.Pin;

/**
 * Created by yoavsusan on 11/24/2015.
 */
public class Sighting extends Pin {

    private PersonalInfo info;

    public Sighting() {}

    public Sighting (int id, double longitude, double latitude, String timeStamp, String description, PersonalInfo info) {
        super(id, longitude, latitude, timeStamp, description);
        this.info = info;
    }

    public PersonalInfo getInfo() {
        return info;
    }

    public void setInfo(PersonalInfo info) {
        this.info = info;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(", info: ").append(this.getInfo().toString());
        return sb.toString();
    }
}
