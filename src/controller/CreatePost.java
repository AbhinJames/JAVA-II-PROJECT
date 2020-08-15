package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import db.PostDBUtil;
import db.UserDBUtil;
import model.Post;
import model.User;

/**
 * Servlet implementation class PostsController
 */
@WebServlet("/CreatePost")
public class CreatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreatePost() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Resource(name = "jdbc/abhinstestschema")
	private DataSource datasource;
	private PostDBUtil postsdb;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
			postsdb = new PostDBUtil(datasource);
		
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		//System.out.println(user);

		
		String postContent = request.getParameter("postContent");
		System.out.println(postContent);
	
		String userEmail = user.getEmail();
		System.out.println(userEmail);
		
		Post tempPost = new Post(postContent, userEmail);
		System.out.println("under temppost");

		boolean created = tempPost.createPost(postsdb);

		if (created) {
            ArrayList<Post> allPostsList = tempPost.getAllPosts(postsdb);
            ArrayList<Post> myPostsList = tempPost.getAllPostsByUser(postsdb);
            session.setAttribute("myPostsList", myPostsList);
            session.setAttribute("allPostsList", allPostsList);
			response.sendRedirect("home.jsp");
		} else {
			RequestDispatcher dispatch = request.getRequestDispatcher("profile.jsp");
			request.setAttribute("rerror", true);
			dispatch.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}