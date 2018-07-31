import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/formatdata"}
)
public class HelloAppEngine extends HttpServlet {

  /**
	 * 
	 */
	private static final long serialVersionUID = -326588183982128028L;

@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
    String[] data = request.getParameterValues("data");
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
    StringBuilder sb = new StringBuilder();
    for(int i=0; i < data.length; i++) {
       String[] splitData = data[i].split("\r\n");
       for(int j=0; j < splitData.length; j++) {
    	   String trimmed = splitData[j].trim();
    	   if(trimmed.length() > 0)
    		   sb.append("'" + splitData[j] + "',");
        }
    }
    sb.deleteCharAt(sb.lastIndexOf(","));
    response.getWriter().print(sb.toString());
  }
}