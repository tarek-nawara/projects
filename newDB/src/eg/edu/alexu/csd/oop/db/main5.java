package eg.edu.alexu.csd.oop.db;

import java.sql.SQLException;


public class main5 {
	public static void main(String[] args) throws SQLException {
		Engine e = new Engine() ; 
		System.out.println(e.createDatabase("a7a", true));
		
		System.out.println(e.executeStructureQuery("create table test(id int, name varchar)"));
		System.out.println(e.executeUpdateQuery("insert into test values(15, 'tarek')"));
		System.out.println(e.executeUpdateQuery("insert into test values(9, 'sherif')"));
		System.out.println(e.executeUpdateQuery("update test set id=5 where id >9"));
		System.out.println(e.executeUpdateQuery("delete from test where name      > 15"));
		System.out.println(e.createDatabase("a7A", false));
		System.out.println(e.executeStructureQuery("create table x(id int)"));
		System.out.println(e.executeStructureQuery("drop database A7a"));
		
//		System.out.println(e.createDatabase("heller", false));
//		System.out.println(e.executeStructureQuery("create table test(id int, name varchar)"));
//		System.out.println(e.executeUpdateQuery("insert into test values (5, ahmed)"));
	}
}
