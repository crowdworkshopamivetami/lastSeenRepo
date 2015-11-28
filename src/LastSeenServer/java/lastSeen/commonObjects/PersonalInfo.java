package lastSeen.commonObjects;

/**
 * Created by kabessa on 21/11/2015.
 */
public class PersonalInfo {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public PersonalInfo(){}

    public PersonalInfo(String firstName, String lastName, String phoneNumber, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("firstName: ").append(firstName)
                .append(", lastName: ").append(lastName)
                .append(", phoneNumber: ").append(phoneNumber)
                .append(", email: ").append(email);

        return sb.toString();
    }

}
