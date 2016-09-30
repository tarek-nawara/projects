package eg.edu.alexu.csd.oop.db;



public class TestsChains {
	public static void main(String[] args) throws Exception {
		ExpressionChain eChain = ExpressionChain.getInstance() ;
		ISelectChain sChain = ISelectChain.getInstance() ;
		String cmd1 = "CREATE DATABASE SchoolDatabase" ;
		String cmd9 = "CREATE DATABASE SchoolDatabase2" ;
		String cmd10 = "CREATE DATABASE SchoolDatabase3" ;
		//String cmd2 = "CREATE TABLE Students (int id, varchar name, int grade, int birth)" ;
		String cmd2 = "create table Students (id int, name varchar, grade int, birth int)" ;
		String cmd11 = "create table Teachers (id int, name varchar, Degree int, birth int)" ;
		String cmd3 = "insert into Students(1, 'Sherif Hamdy', 19, 1995)";
		String cmd4 = "INSERT INTO Students (2, 'Ahmed Hamdy', 40, 1998)";
		String cmd5 = "INSERT INTO Students (3, 'Tarek Hamdy', 100, 2000)";
		String cmd12 = "INSERT INTO Teachers (1, 'Khaled Nagy', 0, 1400)";
		String cmd6 = "SELECT * FROM Students" ;
		String cmd7 = "SELECT id FROM Students" ;
		String cmd8 = "SELECT name FROM Students WHERE grade > 50";
		String cmd13 = "drop table Teachers" ;
		
		Expression solver = eChain.getMatcher(cmd1) ;
		solver.interpret(cmd1) ;
		solver.interpret(cmd9);
		solver.interpret(cmd10) ;
		
		solver = eChain.getMatcher(cmd2) ;
		solver.interpret(cmd2) ;
		solver.interpret(cmd11) ;
		
		solver = eChain.getMatcher(cmd3) ;
		solver.interpret(cmd3) ;
	
		
		solver = eChain.getMatcher(cmd4) ;
		solver.interpret(cmd4) ;
		
		solver = eChain.getMatcher(cmd5) ;
		solver.interpret(cmd5) ;
		
		solver = eChain.getMatcher(cmd12) ;
		solver.interpret(cmd12);
		
		solver = eChain.getMatcher(cmd13) ;
		solver.interpret(cmd13) ;
		
		ISelect solver2 = sChain.getMatcher(cmd6) ;
		Object [][] answer = solver2.interpret(cmd6) ;
		
		solver2 = sChain.getMatcher(cmd7) ;
		Object [][] answer2 = solver2.interpret(cmd7) ;
		
		solver2 = sChain.getMatcher(cmd8) ;
		Object [][] answer3 = solver2.interpret(cmd8) ;
		
		print(answer, 3, 4);
		print(answer2 , 3, 1);
		print(answer3 , 1, 1);
		
	}
	public static void print(Object[][] a , int end, int end2){
		for(int i = 0 ; i < end ; i++){
			for(int j = 0 ; j < end2 ; j++){
				System.out.println(a[i][j]);
			}
			System.out.println("");
		}
		System.out.println("---------------------------");
	}
}
