package model;

import db.PostDBUtil;

public class Post {
	int postID;
	String postContent;
	String userEmail;
	int likes;



	public Post(int postID, String postContent, String userEmail,int likes) {
		this.postContent = postContent;
		this.userEmail = userEmail;
		this.likes = likes;
		
	}
	public Post(String postContent, String userEmail) {
		this.postContent = postContent;
		this.userEmail = userEmail;
	}


	public String getPostContent() {
		return postContent;
	}

	public int getPostID() {
		return postID;
	}
	
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}



	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}



	public String getUserEmail() {
		return userEmail;
	}

	public void setUserName(String userEmail) {
		this.userEmail = userEmail;
	}

	public boolean createPost(PostDBUtil postsdb) {
		try {
			 postsdb.insertPost(this);
			 return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletePost() {
		return true;
	}

	public boolean editPost() {
		return true;
	}

	public int likePost() {
		return 0;
	}

}