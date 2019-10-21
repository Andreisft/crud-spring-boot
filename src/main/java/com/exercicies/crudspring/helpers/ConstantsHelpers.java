package com.exercicies.crudspring.helpers;

public final class ConstantsHelpers {
	
	private static final String SUCESS = " successfully";
	
	public static final String SUCCESSFULLY_CREATE = sucessMessage("inserted");
	public static final String SUCCESSFULLY_REMOVE = sucessMessage("removed");
	public static final String SUCCESSFULLY_UPDATE = sucessMessage("uptaded");
	
	private static final String GENERIC_FAILED = "Unable to ";
	
	public static final String CREATE_GENERIC_ERROR = failedMessageGeneric("insert");
	public static final String REMOVE_GENERIC_ERROR = failedMessageGeneric("remove");
	public static final String UPDATE_GENERIC_ERROR = failedMessageGeneric("update");
	
	public static final String EMPTY_LIST = "Empty List!";
	
	private static String sucessMessage(String action) {
		return action + SUCESS;
	}
	
	private static String failedMessageGeneric(String action) {
		return GENERIC_FAILED + action;
	}
	
}
