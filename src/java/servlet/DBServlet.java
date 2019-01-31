/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import klase.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DBServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Statement stmt = null;
        Connection con = null;
        System.out.println("Usao sam");
        try {
          con = DB.getInstance().getConnection();
          if (con == null) return;
            System.out.println("Konektovao sam se");

          stmt = con.createStatement();
         String query = "CREATE TABLE APP.STUDENTI ("
                  + "ID_S  INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                  + "PREZIME VARCHAR(30) NOT NULL,"
                  + "IME VARCHAR(30) NOT NULL,"
                  + "BROJINDEKSA INTEGER NOT NULL,"                  
                  + "GODINAINDEKSA INTEGER NOT NULL, SMER INTEGER NOT NULL)";

            System.out.println("Pre query");
          stmt.executeUpdate(query);
            System.out.println("Posle query");
          query = "INSERT INTO APP.STUDENTI (PREZIME, IME, BROJINDEKSA, GODINAINDEKSA, SMER) VALUES ";
          stmt.executeUpdate(query + "('Petrovic', 'Ana', 307, 15, 1)");
          stmt.executeUpdate(query + "('Nenadovic', 'Milan', 97, 13, 2)");
          stmt.executeUpdate(query + "('Nesic', 'Nadica', 34, 16, 3)");
          stmt.executeUpdate(query + "('Markovic', 'Marko', 55, 18, 3)");
          stmt.executeUpdate(query + "('Petkovic', 'Zoran', 109, 17, 3)");
          stmt.executeUpdate(query + "('Savic', 'Nenad', 12, 18, 1)");    
          stmt.executeUpdate(query + "('Aleksic', 'Milica', 34, 14, 2)");    
          stmt.executeUpdate(query + "('Ivanovic', 'Ana', 37, 18, 2)");    
            System.out.println("Execute");          
          stmt.close();
            System.out.println("Kraj");
          response.sendRedirect("pocetna.html");
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        
        }
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


}