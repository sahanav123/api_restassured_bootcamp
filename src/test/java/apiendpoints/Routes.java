package apiendpoints;

public class Routes {
	

	public static String CREATE_USER = "/createusers";
	public static String GET_USER_BY_ID = "/user/{userId}";
	public static String GET_USER_BY_USERNAME = "/users/username/{userFirstName}";
    public static  String UPDATE_USER_BY_PUT= "/updateuser/{userId}";
	public static  String UPDATE_USER_BY_PATCH= "/updateuserfields/{userId}";
	public static  String DELETE_USER_BY_USERID= "/deleteuser/{userId}";
	public static  String DELETE_USER_BY_USERNAME= "/deleteuser/username/{userFirstName}";

}
