package db.aplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DBIntegrityException;

public class ProgramQuatro {
	public static void main(String[] args) {
       Connection conn = null;
       PreparedStatement ps = null;
       
       try{
    	   conn = DB.getConnection();
    	   ps = conn.prepareStatement
    			   ("DELETE FROM department"
    			   +"WHERE"
    			   + "id = ?");
    	   ps.setInt(1, 5);
    	   int rowAffected = ps.executeUpdate();
    	   System.out.println("Rows Affected " + rowAffected);
    	   
       }catch(SQLException | DBIntegrityException e){
    	   throw new DBIntegrityException(e.getMessage());
       }finally {
    	   DB.closeStatement(ps);
    	   DB.closeConnection();
       }
	}
}
