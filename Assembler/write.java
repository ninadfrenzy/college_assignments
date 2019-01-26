import java.util.*;
import java.io.*;

public class write
{
	public static void main(String[] args) throws Exception
	{
		FileWriter fw = new FileWriter("/home/administrator/Desktop/TEB_212Ninad/Assembler/op.txt");
		BufferedWriter wr = new BufferedWriter(fw);
		wr.write("masdsdasdklasdsdasdasda\n");
		
		wr.close();
		fw.close();
	}
}