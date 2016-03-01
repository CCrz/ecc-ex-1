import java.util.*;

public class ExcerciseOne{
public static void main(String args[]){		
		int rw=0, cl=0;
	
		StrTable strTable	=	new StrTable();
		
		Scanner in	=	new Scanner(System.in);
		
		//Request row and column if not provided in cli
		if(args.length==0){		
			while(rw<=0){
				System.out.println("Please enter a number >0 for the Row:");
				rw	=	in.nextInt();
			}
			while(cl<=0){
				System.out.println("Please enter a number >0 for the Column:");
				cl	=	in.nextInt();
			}
		}
		else{
			rw	=	Integer.parseInt(args[0]);
			cl	=	Integer.parseInt(args[1]);
		}
		
		System.out.println("Row:"+rw);System.out.println("Column:"+cl);
		
		
		String table[][]	=	strTable.CreateStrTable(rw, cl);
		strTable.DisplayStrTable(table);

	//MENU LOOP
		int opt = 777;
		while(opt!=0){
			
			while(opt<0||opt>4){
				System.out.println();
				System.out.println();
				System.out.println("[MENU]:");
				System.out.println("1-->search");
				System.out.println("2-->edit");
				System.out.println("3-->print");
				System.out.println("4-->reset");
				System.out.println("0-->exit");
				opt	=	in.nextInt();
			}
			switch(opt){
				case 1:
					System.out.print("Search query:");
					String key	=	"";
					in.nextLine();
					key	=	in.nextLine();
					int indices[][]	=	strTable.SearchStrTable(table,	key);
						
					System.out.println();
					System.out.println("[Occurence]\t[Row]\t[Column]");
					int occu=0;	
					for(int[] columns: indices){
							occu++;							
							System.out.print(occu+"\t\t");
							for(int index: columns){
								System.out.print(index+"\t");
							}	
							System.out.println();
					}
					System.out.println("Total occurences:\t"+occu);
					opt=777;
				break;
				
				case 2:
					System.out.println("Please enter the following in order:");
					System.out.println("1.]row");	
					System.out.println("2.]column");
					System.out.println("3.]new string value");
					table	=	strTable.EditStrTable(table,	in.nextInt(),	in.nextInt(),	in.next());
					
					strTable.DisplayStrTable(table);
					opt=777;					
				break;

				case 3:
					strTable.DisplayStrTable(table);
					opt=777;
				break;

				case 4:
					//INPUT NEW DIMENSIONS
					rw=0;	cl=0;
					while(rw<=0){
						System.out.println("Please enter a number >0 for the Row:");
						rw	=	in.nextInt();
					}
					while(cl<=0){
						System.out.println("Please enter a number >0 for the Column:");
						cl	=	in.nextInt();
					}
					//CREATE TABLE
					table	=	strTable.CreateStrTable(rw,	cl);
					strTable.DisplayStrTable(table);
					opt=777;
				break;

				case 0:
				break;
			}
			
		}
	//MENU LOOP --end--
		
	}
	
	public int IntSetter(Scanner in = new Scanner(System.in)){
		int num=0;
		try{
		}
		catch()
		
		return num;
	}
	

	
	
	
}
