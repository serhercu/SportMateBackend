package com.app.util;

public class ErrorCodes {

	// Auth
	public static final int EMAIL_ALREADY_EXISTS = 1000;
	public static final int USER_ALREADY_EXISTS = 1001;
	
	public static final int USER_NOT_EXISTS = 2000;
	public static final int WRONG_PASSWORD = 2001;
	
	
	// Game
	public static final int JOIN_PLAYER_ERROR = 3000;
	public static final int LEAVE_PLAYER_ERROR = 3001;
	public static final int CANCEL_PLAYER_ERROR = 3002;
	public static final int FINISHED_GAMES_ERROR = 3003;
	public static final int PLAYER_GAMES_ERROR = 3004;
	
	// Friends
	public static final int REPLY_FRIEND_REQUEST_ERROR = 4000;
	
	// Center
	public static final int CENTER_NOT_FOUND = 5000;
	public static final int CENTER_PLAYER_NOT_FOLLOWING = 5001;
	
	private ErrorCodes() {
		
	}
}
