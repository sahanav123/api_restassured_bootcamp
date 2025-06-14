package apipayload;

public class User {

	String userFirstName;
	String userLastName;
	int UserContactNumber;
	String UserEmailId;
    UserAddress userAddress;
    
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public int getUserContactNumber() {
		return UserContactNumber;
	}
	public void setUserContactNumber(int userContactNumber) {
		UserContactNumber = userContactNumber;
	}
	public String getUserEmailId() {
		return UserEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		UserEmailId = userEmailId;
	}
	public UserAddress getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
	
	
}
