package pl.otogra.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/image/*")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String imagePath="D:\\workspaceEE\\Otogra\\WebContent\\images";

    public ImageServlet() {
        super();
        
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imagePathUrl=request.getPathInfo();
		String imageUrl=imagePath+File.separator+imagePathUrl;
		File image= new File(imageUrl);
		String contentType= getServletContext().getMimeType(image.getName());
		
		
		response.reset();
		response.setContentType(contentType);
		response.setHeader("Content-Length", String.valueOf(image.length()));
		
		Files.copy(image.toPath(), response.getOutputStream());
		
	}


}
