package lastSeen.DataBase.dbObjects;

/**
 * Created by Barak on 27/11/2015.
 */
public class SharingEmail {
    private int id;
    private String email;
    SharingEmail(){}
    SharingEmail(int id, String email){
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
