package CovidTracker.testVariables;

public class SharedValues {

    private static  String firstName;
    private static  String lastName;
    private static  String email;
    private static  CharSequence charSequence;


    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        SharedValues.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        SharedValues.lastName = lastName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        SharedValues.email = email;
    }

    public static CharSequence getCharSequence() {
        return charSequence;
    }

    public static void setCharSequence(CharSequence charSequence) {
        SharedValues.charSequence = charSequence;
    }




}
