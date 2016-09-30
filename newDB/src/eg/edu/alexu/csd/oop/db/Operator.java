package eg.edu.alexu.csd.oop.db;

import java.sql.SQLException;

public interface Operator {
	
	public Operator match(String symbol);
	
	public void setNextInChain(Operator next);
	public boolean compare(Row row, Table table, String column, Object comparedValue) throws SQLException;

}
