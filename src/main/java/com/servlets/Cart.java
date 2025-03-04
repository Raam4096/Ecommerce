package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String  name=request.getParameter("pname");
		  int price =Integer.parseInt(request.getParameter("price"));
		  try{
			  Connection con=Dbcon.getCon();
			  String query="insert into cart values(?,?)";
			  PreparedStatement ps=con.prepareStatement(query);
			  ps.setString(1, name);
			  ps.setInt(2, price);
			  int res=ps.executeUpdate();
			  if(res>0) {
				  
			  }
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		
	}

}
