package eg.edu.alexu.csd.oop.db;



public class Testing {
	public static void main(String[] args) throws Exception {
		Engine eng = new Engine() ; 
		System.out.println(eng.createDatabase("heller", false));
		//Object [][] ans = eng.executeQuery("select * from Students");
//		System.out.println(Arrays.asList(ans));
//		print(ans, 1, 3);
//		System.out.println(ans != null);
		
	//	System.out.println("-------------------------------------");
	//	System.out.println(eng.createDatabase("tarek", true));
		//System.out.println(eng.executeStructureQuery("create table info (id int)"));
		//System.out.println(eng.executeUpdateQuery("insert into Students values (7, 'Shehab', 15)"));
		System.out.println(eng.executeUpdateQuery("update Students set id = 8, name = ahmed hany where id > 4"));
	}
	
	
	
	
	public static void print(Object[][] a , int end, int end2){
		System.out.println("--------------");
		for(int i = 0 ; i < end ; i++){
			for(int j = 0 ; j < end2 ; j++){
				System.out.println(a[i][j]);
			}
			System.out.println("");
		}
		System.out.println("---------------------------");
	}
}
