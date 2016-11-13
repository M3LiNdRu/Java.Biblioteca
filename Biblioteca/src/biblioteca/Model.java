/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import biblioteca.models.Coleccio;
import biblioteca.models.Genere;
import biblioteca.models.Idioma;
import biblioteca.models.Llibre;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sun.security.ssl.Debug;
/**
 *
 * @author Roger
 */
public class Model {
    
    private Connect con;
    private ResultSet res;
    
    public Model() {
        this.con = new Connect();
    }
    
    /*In this method only prepare the query*/
    public int insertLlibre(Llibre l) {
        
        String values = "value1,value2,..."; 
        
        return this.insert("Llibre", values);
    }
    /*In this method only prepare the query*/
    public int insertIdioma(Idioma i) {
        String values = "NULL,'" + i.getNom() + "','" + i.getReferencia() + "'";
        return this.insert("Idioma", values);
    }
    /*In this method only prepare the query*/
    public int insertGenere(Genere g) {
        
        String values = "NULL,'" + g.getNom() + "','" + g.getDescripcio() + "'";
        return this.insert("Genere", values);
    }
    /*In this method only prepare the query*/
    public int insertCollecio(Coleccio c) {
        String values = "NULL,'" + c.getNom() + "','" + c.getDescripcio() + "'";
        values += ",'" + c.getNvolums() + "'";
        return this.insert("Coleccio", values);
    }
    
    public List<String> getObjectsByName(String table) {
        List<String> objectNames = new ArrayList<String>();
        String query = "SELECT Nom" + " FROM " + table;
        this.con.connect();
        try {
            this.res = this.con.getStatement().executeQuery(query);
            while (this.res.next()) {
               objectNames.add(this.res.getString("Nom"));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        this.con.disconnect();
        return objectNames;
    } 
    /*INSERT INTO table_name
        VALUES (value1,value2,value3,...);*/
    private int insert(String table, String values) {
        String query = "INSERT INTO ";
        query += table + " VALUES (" + values + ");";
        int resul = 0;
        
        this.con.connect();
        try {
            resul = this.con.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.getMessage();
        }
        this.con.disconnect();
        
        return resul;
    }
    private Object select(String select, String table, String where) {
        String query = "SELECT " + select + " FROM " + table;
        if (!where.isEmpty()) query += " WHERE " + where;
        this.con.connect();
        try {
            this.res = this.con.getStatement().executeQuery(query);
            while (this.res.next()) {
               System.out.println(this.res.getString("Nom"));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        this.con.disconnect();
        return this.res;
    }
    
    
    private class Connect {
        
        private Connection con;
        private String db_name = "biblio_casa";
        private String login = "root";
        private String pass = "michelin";
        private Statement stmt;
        
        private Connect() {
            
        }
        
        public Statement getStatement() {
            try {
                this.stmt = con.createStatement();
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
            return stmt;
        }
        public void connect() {
            
            try {
                
		Class.forName("com.mysql.jdbc.Driver");
                this.con = DriverManager.
                        getConnection("jdbc:mysql://localhost:3306/" +
                        this.db_name,this.login, this.pass);
                
            } catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
            } catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
            }
            
            if (this.con != null) System.out.println("You made it, "
                    + "take control your database now!");
            else System.out.println("Failed to make connection!");
            
        }
        public void disconnect() {
            try {
                this.con.close(); 
            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
            }
            System.out.println("Connection closed.");
        }
        
    }
}


