package application;

/**
 * The Login class is used to store the login data for a given system user
 */
public class Login {

	private String userId;
	private String password;
	
	public Login() {
		this.userId = "";
		this.password = "";
	}
	
	public Login(String newUserId, String newPassword) {
		this.userId = newUserId;
		this.password = newPassword;
	}
	
	// checks if a supplied user id and password match the login instance values
	public boolean authenticate(String checkUserId, String checkPassword) {
		
		if(this.userId.equals(checkUserId) && this.password.equals(checkPassword)){
			return true;
		}
		return false;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
