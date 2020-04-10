package com.udhipe.simpleapplication.utility;

public class ConstantManager {
/*    public static final String BASE_URL = "http://35.185.235.231/api/";*/
    public static final String BASE_URL = "https://api.authskull.site/dev-iam/";
    final public static String[] accountTypeList = new String[]{"Agent Reguler", "Agent Premium",
            "Agent Startup", "Reseller", "Merketer"};
    final public static int MINIMUM_CHARACTER_USERNAME = 3;
    final public static int MINIMUM_CHARACTER_PASSWORD = 8;
    final public static String EMPTY = "";
    final public static String USERNAME = "username";
    final public static String PASSWORD = "password";
    final public static String CONFIRM_PASSWORD = "confirmpassword";
    final public static String ACCOUNT_TYPE = "accounttype";
    final public static String ACCOUNT = "account";
    final public static String INFO_EMPTY_USERNAME = "F" + USERNAME + EMPTY;
    final public static String INFO_MINIMUM_USERNAME = "F" + USERNAME + MINIMUM_CHARACTER_USERNAME;
    final public static String INFO_EMPTY_PASSWORD = "F" + PASSWORD + EMPTY;
    final public static String INFO_MINIMUM_PASSWORD = "F" + PASSWORD + MINIMUM_CHARACTER_PASSWORD;
    final public static String INFO_EMPTY_CONFIRM_PASSWORD = "F" + CONFIRM_PASSWORD + EMPTY;
    final public static String INFO_PASSWORD_MISSMATCH = "F" + CONFIRM_PASSWORD + "miss";
    final public static String INFO_EMPTY_ACCOUNT_TYPE = "F" + ACCOUNT_TYPE + EMPTY;
    final public static String SUCCESS_CREATE_ACCOUNT = "T" + ACCOUNT;
    final public static String FAIL_CREATE_ACCOUNT = "F" + ACCOUNT;
    final public static int AGENT_REGULER = 2;
    final public static int AGENT_PREMIUM = 3;
    final public static int AGENT_STARTUP = 4;
    final public static int RESELLER = 5;
    final public static int MARKETER = 6;
}
