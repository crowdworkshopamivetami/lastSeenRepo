package lastSeen.DataBase.dbObjects;


/**
 * Created by Barak on 24/11/2015.
 */

import lastSeen.commonObjects.PersonalInfo;

import java.util.List;

public class MissingPerson {
    private int id = -1;
    private String firstName;
    private String lastName;
    private String age;
    private String height;
    private String weight;
    private List<Sighting> sightings;
    private String gender;
    private String additionalDetails;
    private String picUrl;
    private String nationality;
    private String ethnicity;
    private int registeredUserId;

    public MissingPerson(){}

    public MissingPerson(int id, String firstName, String lastName, String age, String height, String weight, List<Sighting> sightings,
                         String gender, String additionalDetails, String picUrl, String nationality, String ethnicity, int registeredUserId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.sightings = sightings;
        this.gender = gender;
        this.additionalDetails = additionalDetails;
        this.picUrl = picUrl;
        this.nationality = nationality;
        this.ethnicity = ethnicity;
        this.registeredUserId = registeredUserId;
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirstName(){return firstName;}

    public void setFirstName(String firstName){this.firstName  = firstName;}

    public String getLastName(){return lastName;}

    public void setLastName(String lastName){this.lastName = lastName;}

    public String getAge(){return  age;}

    public void setAge(String age){this.age = age;}

    public String getHeight(){return height;}

    public  void setHeight(String height){this.height = height;}

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public List<Sighting> getSightings() {
        return sightings;
    }

    public void setSightings(List<Sighting> sightings) {
        this.sightings = sightings;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getRegisteredUserId() {
        return registeredUserId;
    }

    public void setRegisteredUserId(int registeredUserId) {
        this.registeredUserId = registeredUserId;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id)
                .append(", firstName: ").append(firstName)
                .append(", lastName: ").append(lastName)
                .append(", age: ").append(age)
                .append(", height: ").append(height)
                .append(", weight: ").append(weight)
                .append(", sightings: ");
        for (Sighting sighting : sightings)
                sb.append(sighting.toString());
        sb.append(", gender: ").append(gender)
                .append(", additionalDetails: ").append(additionalDetails)
                .append(", picUrl: ").append(picUrl)
                .append(", nationality: ").append(nationality)
                .append(", ethnicity").append(ethnicity)
                .append(", registeredUserId").append(registeredUserId);
        return sb.toString();
    }
}




