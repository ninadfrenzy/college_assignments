import java.util.*;
import java.io.*;

class PassOne 
{
	static int location_counter = 0;
	static int lt_counter = 0;
	static int st_counter = 0;
	static HashMap<String, Integer> LIT_TAB = new HashMap<>();
	static HashMap<String, String> LIT_TAB_LINK = new HashMap<>();

	static HashMap<String, Integer> SYM_TAB = new HashMap<>();
	static HashMap<String, String> SYM_TAB_LINK = new HashMap<>();

	static String [][] MOT = {
					{"STOP","ADD","SUB","MULT","MOVER","MOVEM","COMP","BC","DIV","READ","PRINT",},
					{"00","01","02","03","04","05","06","07","08","09","10"}
				  };
	static String [][] REG_TAB = {
					{"AREG","BREG","CREG","DREG"},
					{"1","2","3","4"}
				  };
	static String [][] CONDITION_TABLE = {
					{"LT","LE","EQ","GT","GE","ANY"},
					{"1","2","3","4","5","6"}
				  };
	public static void main(String[] args) throws Exception
	{
		

		
		for(int i = 0;i<MOT[0].length;i++)
		{
			System.out.println(MOT[0][i]+"\t\t\t"+MOT[1][i]);
		}
		System.out.println("---------------------------------------------------------------------");
		for(int i = 0;i<REG_TAB[0].length;i++)
		{
			System.out.println(REG_TAB[0][i]+"\t\t\t"+REG_TAB[1][i]);
		}
		System.out.println("---------------------------------------------------------------------");
		for(int i = 0;i<CONDITION_TABLE[0].length;i++)
		{
			System.out.println(CONDITION_TABLE[0][i]+"\t\t\t"+CONDITION_TABLE[1][i]);
		}

		try
		{
					File input_code = new File("input_code.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(input_code));
		FileWriter fw = new FileWriter("/home/administrator/Desktop/TEB_212Ninad/Assembler/op.txt");
		BufferedWriter wr = new BufferedWriter(fw);
		String line = "";
		
		while((line = reader.readLine()) != null)
		{
			System.out.println(line);
			String ic = parse_line(line);
			System.out.println(ic);
			if(ic.length()!=0 )
			{
				wr.write(ic + "\n");
			}
			
			
			
		}
		
		wr.close();
		fw.close();
		reader.close();
		}
		catch(Exception e)
		{

		}
		show_and_write_tables();
	}

	public static String parse_line(String line)
	{
		String ic = "";
		String[] split_line = line.split(" ");
		if(split_line.length>4)
		{
			System.out.println("length exceeded invalid statement");

		}
		else
		{
			if(split_line[0].equals("START"))
			{
				location_counter = Integer.parseInt(split_line[1]);
				return ic;
			}
			else if(split_line[0].equals("END"))
			{
				assign_literals();
				return "";
			}
			else if(split_line[0].equals("ORIGIN"))
			{
				location_counter = Integer.parseInt(split_line[1]);
				return "";
			}
			else if(split_line[0].equals("LTORG"))
			{
				assign_literals();
				return "";
			}
			else if(split_line[1].equals("EQU"))
			{
				int rhs_loc = fetch_loc(split_line[2]);
				assign_symtab(split_line[0],rhs_loc);
				location_counter = location_counter + 1;
				return "";
			}
			else
			{
				for(int i = 0;i<split_line.length;i++)
				{
					String code = get_opcode(split_line[i]);
					if(!code.equals("-"))
					{
						ic = ic.concat(" "+code);
					}
					else
					{
					//label + literal + symbol
						if(split_line[i].charAt(0)=='=')
						{
							code = add_to_littab(split_line[i]);
							ic = ic.concat(" " + code);
						}
						else
						{
							code = add_to_symtab(split_line[i]);
							ic = ic.concat(" "+code);
						}
					}
				}
				location_counter = location_counter + 1;
				return ic;

			}
		}
		return "";
	}
	public  static void assign_symtab(String key , int value)
	{
		SYM_TAB.put(key,value);

	}
	public  static int fetch_loc(String key)
	{
		if (SYM_TAB.containsKey(key))  
        	{ 
            	Integer a = SYM_TAB.get(key); 
            	return a;
        	} 
        	return 0;
	}
	public  static String add_to_littab(String key)
	{
		
		String code = "L" + Integer.toString(lt_counter);
		LIT_TAB_LINK.put(code,key);
		lt_counter = lt_counter + 1;

		return code;
	}
	public static void assign_literals()
	{
		LIT_TAB_LINK.forEach((k, v) -> {
            LIT_TAB.put(v,location_counter);
            location_counter=location_counter+1;
        });
	}
	public static String add_to_symtab(String key)
	{
		if(SYM_TAB.containsKey(key))
		{
			return "";
		}
		else
		{
			
			String code = "S"+Integer.toString(st_counter);
			SYM_TAB_LINK.put(code,key);
			SYM_TAB.put(key,location_counter);
			st_counter = st_counter + 1;
			return code;
		}
	}
	public static String get_opcode(String key)
	{
		for(int i = 0;i<MOT[0].length;i++)
		{
			if(MOT[0][i].equals(key))
			{
				return MOT[1][i];
			}
		}
		for(int i = 0;i<REG_TAB[0].length;i++)
		{
			if(REG_TAB[0][i].equals(key))
			{
				return REG_TAB[1][i];
			}
		}
		for(int i = 0;i<CONDITION_TABLE[0].length;i++)
		{
			if(CONDITION_TABLE[0][i].equals(key))
			{
				return CONDITION_TABLE[1][i];
			}
		}
		return "-";
	}

	public static void show_and_write_tables() 
	{
		try
		{
			FileWriter symtab = new FileWriter("symbol_table.txt");
		BufferedWriter bws = new BufferedWriter(symtab);
		FileWriter littab = new FileWriter("literal_table.txt");
		BufferedWriter bwl = new BufferedWriter(littab);
		// LIT_TAB.forEach((key,value)->{
		// 	System.out.println(key + "\t\t\t" + value + "\n");
		// 	try{
		// 		bwl.write(key+" "+Integer.toString(value)+"\n");
		// 	}
		// 	catch(Exception e)
		// 	{

		// 	}
		// });
		System.out.println("------------------------------------------------------------------------------");
		LIT_TAB_LINK.forEach((key,value)->{
			System.out.println(key + "\t\t\t" + value + "\n");
			try
			{
				bwl.write(key+" "+value+" "+Integer.toString(LIT_TAB.get(value))+"\n");
			}
			catch(Exception e)
			{

			}
		});
		System.out.println("------------------------------------------------------------------------------");
		// SYM_TAB.forEach((key,value)->{
		// 	System.out.println(key + "\t\t\t" + value + "\n");
		// 	try
		// 	{
		// 		bws.write(key+" "+Integer.toString(value)+"\n");
		// 	}
		// 	catch(Exception e)
		// 	{

		// 	}
		// });
		System.out.println("------------------------------------------------------------------------------");
		SYM_TAB_LINK.forEach((key,value)->{
			System.out.println(key + "\t\t\t" + value + "\n");
			try
			{
				bws.write(key+" "+value+" "+Integer.toString(SYM_TAB.get(value))+"\n");

			}
			catch(Exception e)
			{
				
			}
		});

		bws.close();
		bwl.close();
		symtab.close();
		littab.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
