package generalinfo;

public class Logins {
	private String userName;
	private String password;
	
	public Logins() {
		userName = "";
		password = "";
	}
	
	public Logins(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "logins [userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}
