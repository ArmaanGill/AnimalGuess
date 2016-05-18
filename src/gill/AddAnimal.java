package gill;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlElement;

/**
 * Servlet implementation class AddAnimal
 */
@WebServlet("/AddAnimal")
public class AddAnimal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnimal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AddAnimal.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  animalName= request.getParameter("name");
		String  animalDescription= request.getParameter("description");
		
		String writeObject = animalName+ "---" +animalDescription;
		FileOutputStream fos1 = new FileOutputStream("D:/AddAnimal.xml");
		java.beans.XMLEncoder xe1 = new java.beans.XMLEncoder(fos1);
		xe1.writeObject(writeObject);
		xe1.flush();
		xe1.close();
		request.setAttribute("error","Your animal "+animalName
				+ " will be updated by admin. !!!!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AddAnimal.jsp");
		dispatcher.forward(request, response);
	}

}
