package lastSeen.DataBase.dbObjects;

import lastSeen.commonObjects.PersonalInfo;

/**
 * Created by kabessa on 21/11/2015.
 */
public class Contact {
    private int id = -1;
    private PersonalInfo personalInfo;
    private String relation;

    public Contact(){}

    public Contact(int id,PersonalInfo info, String relation){
        this.id = id;
        this.personalInfo = info;
        this.relation = relation;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public PersonalInfo getPersonalInfo(){
        return this.personalInfo;
    }

    public void setPersonalInfo(PersonalInfo info){
        this.personalInfo = info;
    }

    public String getRelation(){
        return relation;
    }

    public void setRelation(String relation){
        this.relation = relation;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("PersonalInfo : ").append(getPersonalInfo().toString())
                .append(", relation: ").append(relation);
        return sb.toString();
    }
}
