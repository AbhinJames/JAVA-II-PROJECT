package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.Post;
import model.User;

public class PostDBUtil {
	private DataSource datasource;

	public PostDBUtil(DataSource datasource) {
		this.datasource = datasource;
	}

	public void insertPost(Post post) throws Exception {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		String postContent = post.getPostContent();
		System.out.println(postContent+"postdb");

		
		String userEmail = post.getUserEmail();
		System.out.println(userEmail);
		try {

			conn = this.datasource.getConnection();

			String sql = String.format(
					"INSERT INTO post(content,email) VALUES('%s','%s')",
					postContent,userEmail);

			stmt = conn.createStatement();

			stmt.executeUpdate(sql);

		} finally {
			// TODO: handle finally clause
			close(conn, stmt, pstmt, res);
		}
	}

	public void updatePost(Post post) throws Exception {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

	
		String postContent = post.getPostContent();

		
		int postID = post.getPostID();

		
		String userEmail = post.getUserEmail();

		try {

			conn = this.datasource.getConnection();

			String sql = String.format("UPDATE post " + " SET  content=%s WHERE postId=%d",
					postContent, postID);

			stmt = conn.createStatement();

			stmt.executeUpdate(sql);

		} finally {
			// TODO: handle finally clause
			close(conn, stmt, pstmt, res);
		}
	}

	public void likePost(Post post, User user) throws Exception {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		try {
			conn = this.datasource.getConnection();

			String sql = String.format("SELECT * FROM likes WHERE postID = %d AND userID = %s", post.getPostID(),
					user.getEmail());

			pstmt = conn.prepareStatement(sql);

			res = pstmt.executeQuery();

			if (res.next()) {

				if (res.getBoolean("liked"))
					return;
				else {
					String updateLiked = String.format("UPDATE likes SET likesCounter=%b where postID=%d and userID=%s ", true,
							post.getPostID(), user.getEmail(), user.getEmail());

					pstmt = conn.prepareStatement(updateLiked);

					res = pstmt.executeQuery();
				}
			}

			String insertLike = String.format("INSERT INTO likes likesCounter, postID, userID VALUES (%b,%d,%s)", true,post.getPostID(),
					user.getEmail());

			pstmt = conn.prepareStatement(insertLike);

			res = pstmt.executeQuery();

		} finally {
			// TODO: handle finally clause
			close(conn, stmt, pstmt, res);
		}
	}
	
	public void unlikePost(Post post, User user) throws Exception {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		try {
			conn = this.datasource.getConnection();

			String updateLiked = String.format("UPDATE likes SET likesCounter=%b where postID=%d and userID=%s ", false,
					post.getPostID(), user.getEmail(), user.getEmail());

			pstmt = conn.prepareStatement(updateLiked);

			res = pstmt.executeQuery();

			

		} finally {
			// TODO: handle finally clause
			close(conn, stmt, pstmt, res);
		}
	}
	
	
	

	public void deletePost(Post post) throws Exception {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		try {

			conn = this.datasource.getConnection();

			String sql = "DELETE FROM post WHERE postId= ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post.getPostID());

			pstmt.executeUpdate(sql);

		} finally {
			// TODO: handle finally clause
			close(conn, stmt, pstmt, res);
		}
	}

	public ArrayList<Post> getAllPosts() throws Exception {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		ArrayList<Post> tempPosts = new ArrayList<Post>();

		try {

			conn = this.datasource.getConnection();

			String sql = String.format("SELECT * FROM post");

			pstmt = conn.prepareStatement(sql);

			res = pstmt.executeQuery();
			while (res.next() != false) {
				int postID = res.getInt("postId");
				String postContent = res.getString("content");
				String userEmail = res.getString("email");
				int likes = res.getInt("likes");
				tempPosts.add(new Post(postID,postContent,userEmail,likes));
			}

			return tempPosts;

		} finally {
			// TODO: handle finally clause
			close(conn, stmt, pstmt, res);
		}
	}

	public ArrayList<Post> getAllPostsByUser(String userEmail) throws Exception {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		ArrayList<Post> tempPosts = new ArrayList<Post>();

		try {

			conn = this.datasource.getConnection();

			String sql = "SELECT * FROM post WHERE email= ?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userEmail);

			res = pstmt.executeQuery();
			while (res.next() != false) {
				int postID = res.getInt("postID");
				String postContent = res.getString("content");
				String email = res.getString("email");
				int likes = res.getInt("likes");
				tempPosts.add(new Post(postID,postContent, email,likes));
			}

			return tempPosts;

		} finally {
			// TODO: handle finally clause
			close(conn, stmt, pstmt, res);
		}
	}

	private void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet res) {

		try {

			if (conn != null) {
				conn.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}

			if (res != null) {
				res.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}