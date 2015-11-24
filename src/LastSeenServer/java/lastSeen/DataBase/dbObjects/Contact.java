package lastSeen.DataBase.dbObjects;

import lastSeen.commonObjects.PersonalInfo;

/**
 * Created by kabessa on 21/11/2015.
 */
public class Contact extends PersonalInfo {
    private int id = -1;
    private String relation;

    public Contact(){}

    public Contact(String firstName, String lastName, String phoneNumber, String email, String relation){
        super(firstName, lastName, phoneNumber, email);
        this.relation = relation;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getRelation(){
        return relation;
    }

    public void setRelation(String relation){
        this.relation = relation;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(", relation: ").append(relation);
        return sb.toString();
    }
}
