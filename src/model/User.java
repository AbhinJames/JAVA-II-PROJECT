package model;

import db.UserDBUtil;

public class User {
	String fname;
	String lname;
	String email;
	String pass;
	
	public User(String fname, String lname, String email, String pass){
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
		
	}
	
	
	public User(String email, String pass){
		this.email = email;
		this.pass = pass;
	}
	
	
	
	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}


	public boolean login(UserDBUtil userdb) {
		
		
		try {
			
			User tempUser = userdb.findUser(this.email);
			
			if(tempUser != null) {
				if(this.pass.equals(tempUser.getPass())) {		
					this.fname = tempUser.getFname();
					this.lname = tempUser.getLname();
					this.pass = null;	
					return true;
				}
			}		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return false;
	}
	
	
	

	public boolean createUser(UserDBUtil userdb) {
		try {
			 userdb.insertUser(this);
			 return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "My name is " + this.fname + " " + this.lname + "\n";
	}	
}
