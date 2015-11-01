package com.Pizza.utils;
import java.util.ArrayList;
import java.util.Vector;
import com.Pizza.models.User;

public class UserPool {
//	public static Vector<User> users = new Vector<>();
	public static ArrayList<User> users = new ArrayList<>();
	public static int numUsers = 0;
	public static void addUser(String name, String contact, String address, Integer uid){
		System.out.println("Adding user " + uid);
		User u = new User(name, contact, address, uid, "");
		users.add(u);
		numUsers++;
		System.out.println("Total Users: " + numUsers);
	}
	public static User getUser(Integer uid){
		System.out.println("Searching for " + uid);
		for (User u : users){
			if (u.getUid().equals(uid)){
				System.out.println("User Found");
				return u;
			}
		}
		return null;
	}
}
