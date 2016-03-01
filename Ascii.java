public class Ascii{
		public char[] ListAscii(){
		char asc[]= new char[222];
		
		//Populate array of ascii char
		for(int dec=33; dec<255; dec++){
			char ascii =	(char)dec;
			if(ascii!=' '){
				asc[dec-33] = ascii;
			}else{
				continue;
			}
			
		}
		/*
		//Display array of ascii char
		for(char ch: asc){				
			System.out.print(ch+", ");
		}
		*/
		
		return asc;
	}
}