package pl.otogra.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import pl.otogra.model.User;
import pl.otogra.service.GameService;

/**
 * Servlet implementation class AddGameController
 */
@WebServlet("/add")
@MultipartConfig
public class AddGameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/new.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("inputTitle");
		String description = request.getParameter("inputDescription");
		int price = Integer.parseInt(request.getParameter("inputPrice"));
		int year = Integer.parseInt(request.getParameter("inputYear"));
		Part file = request.getPart("inputPhoto");
		String photoName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
		User authorizedUser = (User) request.getSession().getAttribute("user");
		if (request.getUserPrincipal() != null) {
			String filePath = "D:\\workspaceEE\\Otogra\\WebContent\\images";
			String path = filePath + File.separator + photoName;
			GameService service = new GameService();
			service.addGame(title, description, year, price, photoName, authorizedUser);
			file.write(path);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			response.sendError(403);
		}
	}

}
