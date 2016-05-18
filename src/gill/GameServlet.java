package gill;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;





/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
 
    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public GameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		File file = new File("C:/Animal.xml"); 
		String  responseClient= request.getParameter("responseClient");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();			
			Document document = docBuilder.parse(file);                    
			NodeList animalNodeList = document.getElementsByTagName("view");			
			traverseXMLNodes(request,response,responseClient,animalNodeList);	
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Animal.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public void traverseXMLNodes(HttpServletRequest request, HttpServletResponse response,String responseClient,NodeList animalNodeList ){
		Node node;
		
		if(responseClient == null || responseClient == String.valueOf(0)){
			node = animalNodeList.item(0);
		}
		else{
			node = animalNodeList.item(Integer.parseInt(responseClient));
		}
		Element truthy = null;
		Element falsy = null;
		if(node.getNodeType() == Node.ELEMENT_NODE){					
			Element specificAnimal= (Element) node;
			NodeList childList = specificAnimal.getChildNodes();
			Node animalNode = childList.item(1);
			
			if(animalNode.getNodeType() == Node.ELEMENT_NODE){    
				Element queContent = (Element) animalNode;
				 request.setAttribute("queContent", queContent);
			
			}
			
			for(int i=2; i<childList.getLength(); i++){					
				Node answerNode = childList.item(i);						
				if(answerNode.getNodeType() == Node.ELEMENT_NODE){
					if(truthy==null){
						
						truthy = (Element) answerNode;
						
					}
					else{
						
						falsy = (Element) answerNode;
					}
					request.setAttribute("truthy", truthy);
					request.setAttribute("falsy", falsy);
		
				}
			}
		}
	}

}
