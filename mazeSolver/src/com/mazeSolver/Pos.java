package com.mazeSolver;

public class Pos {

	public int i=0;
	public int j=0;
	
	public Pos(){}
	
	public Pos(int i, int j){
		this.i=i;
		this.j=j;
	}
	
	public void up(){i--;}	
	public void down(){i++;}
	
	public void left(){j--;}
	public void right(){j++;}
	
	public boolean equals(Object o){
		Pos p = (Pos)o;
		return (i == p.i) && (j == p.j);
	}
		
	public Object clone() {
	  Pos p = new Pos() ;
	  p.i = i;
	  p.j = j;
	  return p;
	}
	
	public String toString(){return "("+i+","+j+")";}
}
