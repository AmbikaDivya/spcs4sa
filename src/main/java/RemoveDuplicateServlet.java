

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveDuplicateServlet
 */
@WebServlet("/removeduplicates")
public class RemoveDuplicateServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] data = request.getParameterValues("data");
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    List<String> dupData = new ArrayList<String>();
	    HashSet<String> dupFreedDataSet = new HashSet<String>();
	    for(int i=0; i < data.length; i++) {
	       String[] splitData = data[i].split("\r\n");
	       for(int j=0; j < splitData.length; j++) {
	    	   String trimmed = splitData[j].trim();
	    	   if((trimmed.length() > 0)) {
	    		   if(dupFreedDataSet.isEmpty()) {
	    			   dupFreedDataSet.add(trimmed);
	    		   }else {
	    			   if(dupFreedDataSet.contains(trimmed)) {
	    				   dupData.add(trimmed);
	    			   }else {
	    				   dupFreedDataSet.add(trimmed);
	    			   }
	    		   }
	    	   }
	        }
	    }
	    response.getWriter().println("Unique set of Data provided below :");
	    response.getWriter().println("Total number of Unique data is :" + dupFreedDataSet.size());
	    response.getWriter().println("");
	    for(String dupFreedData : dupFreedDataSet) {
	    	response.getWriter().println(dupFreedData);
	    }
	    response.getWriter().println("");
	    response.getWriter().println("");
	    response.getWriter().println("Duplicate set of Data provided below :");
	    response.getWriter().println("Total number of duplicate data is :" + dupData.size());
	    response.getWriter().println("");
	    for(String dupdData : dupData) {
	    	response.getWriter().println(dupdData);
	    }
	}

}
