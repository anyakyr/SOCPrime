package businessobjects;

import lombok.Data;
import lombok.ToString;
import utility.PropertyReader;


@Data
@ToString
public class User {

    private String password;
    private String errorMessage;
    private String autoEmail;
    private String email;

    public User(String fileLocation) {
        PropertyReader propertyReader = new PropertyReader(fileLocation);
        this.email = propertyReader.getValue("email");
        this.password = propertyReader.getValue("password");
        this.errorMessage = propertyReader.getValue("errorMessage");
        this.autoEmail = propertyReader.getValue("email");

        //Generate random email.
        String emailDef = propertyReader.getValue("email");
        if (emailDef != null) {
            this.autoEmail = emailDef.substring(0, emailDef.indexOf("@")) + "-" + String.valueOf(System.currentTimeMillis()) + emailDef.substring(emailDef.indexOf("@"));
        }
    }

    public User() {
    }

    public void getRandomEmail(String fileLocation){
        PropertyReader propertyReader = new PropertyReader(fileLocation);
        String emailDef = propertyReader.getValue("email");
        if (emailDef != null) {
            this.autoEmail = emailDef.substring(0, emailDef.indexOf("@")) + "-" + String.valueOf(System.currentTimeMillis()) + emailDef.substring(emailDef.indexOf("@"));
        }
    }


    public String getEmailSecure() {
        String[] splitEmail = getEmail().split("@");
        return splitEmail[0].substring(0, 3) + "***" + "@" + splitEmail[1];
    }
}