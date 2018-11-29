package pl.otogra.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.otogra.model.Game;
import pl.otogra.model.Review;
import pl.otogra.model.User;
import pl.otogra.service.ReviewService;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/addr")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getUserPrincipal()!=null) {
			//String
			//request.setAttribute("id", gameId);
			//System.out.println(request.getParameter("id"));
			//request.getRequestDispatcher("/game").forward(request, response);
			String gameId=request.getParameter("id");
			response.sendRedirect(request.getContextPath()+"/game?id="+gameId);
		}else {
			response.sendError(403);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User loggedUser=(User) request.getSession().getAttribute("user");
		PrintWriter out= response.getWriter();
		if(loggedUser !=null) {
			ReviewService service= new ReviewService();
			long gameId=Long.parseLong(request.getParameter("gameId"));
			long userId=loggedUser.getId();
			List<Review> reviews=service.getReviewsByGameId(gameId);
			if(hasUserReview(userId, reviews)) {
			int score=Integer.parseInt(request.getParameter("rating"));
			String comment= request.getParameter("comment");
			service.addReview(userId, gameId, score, comment);
			response.sendRedirect(request.getContextPath()+"/game?id="+gameId);
			}else {
				/* out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                 out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                 out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
                 out.println("<script language=JavaScript>");
                 out.println("$(document).ready(function(){");
                 out.println("swal('welcome','successful!','success');");
                 out.println("});");
                 out.println("</script>");
				
				RequestDispatcher rd= request.getRequestDispatcher("game.jsp");
				rd.include(request, response);
				*/

				
				response.sendRedirect(request.getContextPath()+"/game?id="+gameId);
				
			}
		}

	}
	private boolean hasUserReview(long userId,List<Review> reviews) {
		for(int i=0;i<reviews.size();i++) {
			if(reviews.get(i).getUserId()==userId) {
				return false;
			}
		}
		return true;
	}

}
