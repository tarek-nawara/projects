package eg.edu.alexu.csd.oop.db;



public class Main {
	public static void main(String[] args) throws Exception {
		
		
		Engine eng = new Engine();
		
		System.out.println(eng.executeStructureQuery("create database testdb"));
		
		System.out.println(eng.executeStructureQuery("   CREATE   TABLE   table_name1   (     column_name1 varchar   ,   column_name2 int   ,  column_name3    varchar    )  "));
	}
}
