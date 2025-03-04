package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class home
 */
@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection con= Dbcon.getCon();
			String query="select * from products";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			PrintWriter pw=response.getWriter();
			response.setContentType("text/html");
			pw.write("<html>");
			pw.write("<head>");
			pw.write("<style>");
			pw.write("ul{"
					+ "display:flex;"
					+ "list-style-type:none;"
					+ "margin:2px;"
					+ "padding:2px;"
					+ "}");
			pw.write("li{"
					+ "margin-left:10px;"
					+ "}");
			pw.write("a{"
					+ "margin-left:10px;"
					+ "}");
			pw.write("</style>");
			pw.write("</head>");
			pw.write("<body>");
			pw.write("<div >");
			pw.write("<ul>");
			pw.write("<li>Home</li>");
			pw.write("<li>Cart</li>");
			pw.write("</ul>");
			pw.write("</div>");
			pw.write("<div style='display:flex;justify-content:space-around;margin-top:20px'>");
			while(rs.next()) {
			pw.write("<table style='border:2px solid red ; padding:10px;'>");
			pw.write("<tr>");
			pw.write("<div>");
			pw.write("<td style='text-align:center'>"+
					"<img src='"+rs.getString(3)+"' alt='no image' width=150px height=150px>"
					+"</td>"+"</tr>"+"<tr>"
					+"<td style='text-align:left '>"
					+ "product name :"+rs.getString(1)+"<br>"
					+ "Product price :"+rs.getString(2)+"<br>"
					
					+"<a href='cart'><button>add to cart</button></a>"
					+"<a href=''><button>buy now</button></a>"
					
					+ "</td></div>");
			pw.write("</tr>");
			pw.write("</table>");
			}
			pw.write("</div>");
			pw.write("</body>");
			pw.write("</html>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	

}
