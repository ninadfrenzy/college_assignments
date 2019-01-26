import java.util.*;
import java.io.*;



public class PassTwo
{
	public static void main(String args[]) throws Exception
	{
		File intermediate_code = new File("op.txt");
		BufferedReader br = new BufferedReader(new FileReader(intermediate_code));
		BufferedWriter bw = new BufferedWriter(new FileWriter("final_mc_code.txt"));
		String l = "";
		while((l = br.readLine()) != null)
		{
			String fc = "";
			//System.out.println(l);
			fc = parse_line(l);
			bw.write(fc + "\n");

		} 
		bw.close();
		br.close();
	}
	public static String parse_line(String line)throws Exception
	{
		
		BufferedReader lt = new BufferedReader(new FileReader("literal_table.txt"));
		String[] split_line = line.split(" ");
		//System.out.println(split_line.length);
		for(int i = 1;i<split_line.length;i++)
		{
			
			if(split_line[i].charAt(0) == 'S')
			{	
				//System.out.println(split_line[i]);
				String token = split_line[i];
				//System.out.println(token);
				String code = getval(token); 
				if(code.length()!=0)
				{
					split_line[i] = code;
				}

			}
			if(split_line[i].charAt(0) == 'L')
			{	String line1 = "";
				String search_key = split_line[i];
				while((line1 = lt.readLine()) != null)
				{
					String[] spl = line1.split(" ");
					for(int j = 0;j<spl.length;j++)
					{
						if(spl[j].equals(search_key))
						{
							split_line[i] = spl[2];
						}
					}
				}
			}

		}
		return String.join(" ",split_line) ;
	}
	public static String getval(String key)throws Exception
	{
		BufferedReader st = new BufferedReader(new FileReader("symbol_table.txt"));
		String s = "";
		while((s= st.readLine()) != null)
		{
			String[] strip = s.split(" ");
			for(int i = 0;i<strip.length;i++)
			{
				if(strip[i].equals(key))
					return strip[2];
			}
		}
		return "";

	}
}