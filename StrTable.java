import java.util.*;

public class StrTable{
	Ascii ascii = new Ascii(); 
	
	public String[][] CreateStrTable(int rw, int cl){
	//Initiate 2-dimensional String array (table)
		String table[][]	=	new String[rw][cl];
		
		return PopulateStrTable(table, ascii.ListAscii());
	}
	
	public String[][] PopulateStrTable(String[][] table, char[] asc){
	//Populate table with each cell containing 3 random ASCII characters
		for(int x=0;x<table.length;x++){

			for(int y=0;y<table[0].length;y++){

				String cell	=	new String();

				for(int z=0;z<3;z++){
					Random rand	=	new Random();
					cell+=asc[rand.nextInt((222-33))+33];
					//cell+=asc[33+(int)(Math.random()*(222-33))];
				}

				table[x][y]=cell;
			}
		}
		
		return table;
	}
	
	public void DisplayStrTable(String[][] table){
	//Display table
		for(String[] row: table){

			for(String i: row){
				System.out.print(i+"\t");
			}

			System.out.println();
		}
	}

	public int[][] SearchStrTable(String[][] table, String key){
		int occu=0;
		int temp[][];
		
		//First rundown on table
		//iterate rows
		for(int x=0;x<table.length;x++){
			//iterate columns
			for(int y=0;y<table[0].length;y++){
				//dont proceed to search cell if search str length is <= to current cell value length
				if(key.length()<=table[x][y].length()){
		
					//COUNT NUMBER OF OCCURENCES
					//iterate through cell str starting from search str length-1
					for(int z_end=key.length(), z_start=0;z_end-1<table[x][y].length();z_end++,z_start++){
						//Debug://System.out.println("Substring["+z_start+"-"+z_end+"]:["+table[x][y].substring(z_start,z_end)+"]");
						//check for occurence
						if(table[x][y].substring(z_start,z_end).equals(key)){
							occu++;
						}
						
					}
					
					
				
				}
			}
		}

		//INITIATE INDICES ARRAY
		int indices[][]	=	new int[occu][2];
		
		if(occu>0){
			
			occu=0;

			//Second rundown on table
			//iterate rows
			for(int x=0;x<table.length;x++){
				//iterate columns
				for(int y=0;y<table[0].length;y++){
					//dont proceed to search cell if search str length is <= to current cell value length
					if(key.length()<=table[x][y].length()){

						//STORE INDICES OF OCCURING CELL
						//iterate through cell str starting from search str length-1
						for(int z_end=key.length(), z_start=0;z_end-1<table[x][y].length();z_end++,z_start++){
							//check for occurence
							if(table[x][y].substring(z_start,z_end).equals(key)){
								indices[occu][0]=x;
								indices[occu][1]=y;
								occu++;
							}

						}



					}
				}
			}
			
		}
		
		return indices;
	}

	public String[][] EditStrTable(String[][] table, int rw, int col, String newval){
		table[rw][col]	=	newval;
		
		return table;
	}

}
