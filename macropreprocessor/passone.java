import java.util.*;
import java.io.*;



class macro_name_table{
	int index;
	String name;
	int param_count;

	macro_name_table(int i,String n,int p){
		index = i;
		name = n;
		param_count = p;
	}
	void display(){
		System.out.println("index: "+Integer.toString(index)+"\n"+"name: "+name+"\n"+"param_count: "+Integer.toString(param_count));
	}
}

public class passone{

	public static void main(String args[])throws Exception{
	 HashMap<Integer, String[]> MDT = new HashMap<>();

		try{
				String line = "";
		 		List<macro_name_table> MNT = new ArrayList<>();
		 		int mnt_index = 1;
			File input_code = new File("input_code.txt");
			BufferedReader reader = new BufferedReader(new FileReader(input_code)); 
		

		
			while((line = reader.readLine())!=null){
				String[] split = line.split(" ");
				String[] params = split[2].split(",");
				if(split[0].equals("MACRO")){
					
					macro_name_table listing = new macro_name_table(mnt_index,split[1],params.length);
					MNT.add(listing);
					listing.display();
				if(split[0].equals("MEND")){

				}
				else{


				}

				}
			}

		}
		catch(Exception e){

		}
	}
}