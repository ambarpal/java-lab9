package com.Pizza.utils;
import java.util.Vector;
import com.Pizza.models.User;

public class UserPool {
	public static Vector<User> users = new Vector<>();
	public static synchronized void addUser(String name, String contact, String address, Integer uid){
		User u = new User(name, contact, address, uid, "");
		users.add(u);
	}
	public static User getUser(Integer uid){
		for (User u : users){
			if (u.getUid().equals(uid)) return u;
		}
		return null;
	}
}
