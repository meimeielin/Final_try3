import java.util.ArrayList;

public class User {
    private ArrayList<String> userID;
    private ArrayList<String> password;

    public User() {
        userID = new ArrayList<String>();
        password = new ArrayList<String>();
    }

    public void add(String ID, String pw) throws PasswordError, UserError {
        if (userID.contains(ID)) {
            throw new UserError("The userID has existed.");
        }
        if (ID.isEmpty()) {
            throw new UserError("The userID can't be empty.");
        } else if (ID.length() != 9) {
            throw new UserError("The userID should be 9 letters.");
        }
        if (pw.length() != 4) {
            throw new PasswordError("The password should be 4 letters.");
        }
        userID.add(ID);
        password.add(pw);
    }

    public void checkUserExist(String ID) throws UserError {
        if (ID == null || ID.isEmpty()) {
            throw new UserError("The userID can't be empty.");
        } else {
        	if(ID.length() != 9) {
        		throw new UserError("The userID is not valid.");
        	}
            if (!userID.contains(ID)) {
                throw new UserError("The userID doesn't exist.");
            }
        }
    }

    public void checkPassword(String ID, String PW) throws PasswordError {
        if (PW == null || PW.isEmpty()) {
            throw new PasswordError("The password can't be empty.");
        }
        int idIndex = userID.indexOf(ID);
        if (idIndex != -1) {
            if (!password.get(idIndex).equals(PW)) {
                throw new PasswordError("The password is wrong.");
            }
        } else {
            throw new PasswordError("The userID doesn't exist.");
        }
    }
}

class UserError extends Exception {
    public UserError(String Error) {
        super(Error);
    }
}

class PasswordError extends Exception {
    public PasswordError(String Error) {
        super(Error);
    }
}
