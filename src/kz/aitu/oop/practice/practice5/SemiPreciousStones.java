package kz.aitu.oop.practice.practice5;

public class SemiPreciousStones extends Stones
{
	public SemiPreciousStones(String n, double w, int c) 
	{
		super(n, w, c);
	}
	
	@Override
	public String toString()
	{
		return this.getName() + " is semi-precious stone";
	}
}
