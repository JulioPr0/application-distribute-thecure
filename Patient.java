import java.util.*;

public class Patient extends Person {
    private String email;
    private String counselling;

    public Patient(String dateBirth, String fullName, String email, String counselling) {
        super(dateBirth, fullName);
        this.email = email;
        this.counselling = counselling;
    }

    public String getEmail() {
        return email;
    }

    public String getCounselling() {
        return counselling;
    }
}
