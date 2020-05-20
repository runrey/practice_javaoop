package kz.aitu.oop.practice.practice5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main{
	public static ArrayList<Stones> necklace;
	public static double totalWeight = 0;
	public static int totalCost = 0;

	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Connect link = new Connect("localhost", "3306", "root", "", "stones");
		necklace = new ArrayList<>();
		ResultSet query = link.getStmt().executeQuery("SELECT * FROM stones");
		
		while(query.next())  
		{
			String type = (query.getInt(2)==1) ? "precious" : "semi-precious";
			System.out.println(query.getInt(1)+"  "+type+"  "+query.getString(3)+"  "+query.getDouble(4)+"  "+query.getInt(5)); 
			
			if(type.equals("precious")) 
			{
				PreciousStones p = new PreciousStones(query.getString(3), query.getDouble(4), query.getInt(5));
				necklace.add(p);
			}
				
			if(type.equals("semi-precious"))
			{
				SemiPreciousStones sp = new SemiPreciousStones(query.getString(3), query.getDouble(4), query.getInt(5));
				necklace.add(sp);
			}
		}
		
		totalWeight = calcTotalW(necklace);
		totalCost = calcTotalC(necklace);
		System.out.println(toString(query));
		link.closeCon();
	}
	
	public static double calcTotalW (ArrayList<Stones> al){
		double total = 0;
		for(int i = 0; i < al.size(); i++) {
			total += al.get(i).getWeight();
		}
		return total;
	}
	
	public static int calcTotalC (ArrayList<Stones> al){
		int total = 0;
		for(int i = 0; i < al.size(); i++) {
			total += al.get(i).getCost();
		}
		return total;
	}
	
	public static String toString(ResultSet rs) {	
		return "Total weight is: " + totalWeight + " carats and total cost is: " + totalCost + " KZT. " + necklace.size() + " stones.";
	}
}
