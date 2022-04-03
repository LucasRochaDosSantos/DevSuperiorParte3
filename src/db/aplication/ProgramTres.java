package db.aplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DBException;

public class ProgramTres {
	public static void main(String[] args) {
     Connection conn = null;
     PreparedStatement ps = null;
     
     try{
    	 conn = DB.getConnection();
    	 ps = conn.prepareStatement
    			 ("UPDATE seller "
    			 +"SET BaseSalary = BaseSalary + ? "
    			 + "WHERE "
    			 + "(DepartmentId = ?)");
    	 ps.setDouble(1, 500);
    	 ps.setInt(2, 4);
    	 ps.executeUpdate();
     }
     catch(SQLException e)
     {
    	 throw new DBException(e.getMessage());
     }finally {
    	 DB.closeStatement(ps);
    	 DB.closeConnection();
     }
	}
}
