package generalinfo;

public class logins {
	private String userName;
	private String password;
	
	public logins() {
		userName = "";
		password = "";
	}
	
	public logins(String userName, String password) {
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
