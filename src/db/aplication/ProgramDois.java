package db.aplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DBException;

public class ProgramDois {
	
	public static void main(String[] args) {
          SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
		  Connection conn = null;
          PreparedStatement ps = null;
          ResultSet rs = null;
          
          try{
        	conn = DB.getConnection();
        	ps = conn.prepareStatement
        			("INSERT INTO seller "
        		    + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
        		    + "values(?, ?, ?, ?, ?)"
        			 , Statement.RETURN_GENERATED_KEYS);
        	ps.setString(1, "Anna Clara BR");
        	ps.setString(2, "anna.clarabr@outlook.com");
        	ps.setDate(3, new java.sql.Date(simple.parse("10/03/2021").getTime()));
        	ps.setDouble(4, 12000);
        	ps.setInt(5, 4);
            int rowAffected = ps.executeUpdate();
            if(rowAffected > 0){
            	rs = ps.getGeneratedKeys();
            	while(rs.next()){
            		int id = rs.getInt(1);
            		System.out.println("id: " + id);
            	}
            }else {
            	System.out.println("No Rown Affected! ");
            }
            
          }catch(SQLException | ParseException e) {
        	  throw new DBException(e.getMessage());
          }finally {
        	  DB.closeResultSet(rs);
        	  DB.closeStatement(ps);
        	  DB.getConnection();
          }
	}
}
