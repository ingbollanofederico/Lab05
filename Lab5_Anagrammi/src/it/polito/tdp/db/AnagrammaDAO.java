package it.polito.tdp.db;

import java.sql.SQLException;
import java.sql.*;

import it.polito.tdp.model.Anagramma;

public class AnagrammaDAO {
	
	public boolean isCorrect(Anagramma a){
		
		String sql="SELECT DISTINCT nome " + 
				"FROM parola " + 
				"WHERE nome= ?";
		boolean trovato = false;
		String anagramma=a.getAnagramma();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				trovato=true;
			}
			
			conn.close();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
			
		return trovato;
		
	}

}
