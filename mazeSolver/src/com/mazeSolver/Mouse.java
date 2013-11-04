package com.mazeSolver;

import java.util.ArrayList;


public abstract class Mouse implements Runnable{

	protected static char MOUSE_CHAR = 'X';
	
	protected Maze maze = null;
	
	protected Pos pos=null;
	
	protected ArrayList<Pos> memory = new ArrayList<Pos>();
	
	public Mouse(Maze m){
		maze = m;
		setPos(maze.getStart());
	}
	
	public boolean atGoal(){
		return pos.equals(maze.getEnd());
	}
	
	public boolean atStart(){
		return pos.equals(maze.getStart());
	}
	
	public void setPos(Pos p){
		pos = (Pos) p.clone();			
	}
	
	public void rememberPos(){		
		memory.add((Pos)pos.clone());
	}
			
	public ArrayList<Pos> getMoves(){		
		ArrayList<Pos> moves = new ArrayList<Pos>();
		
		Pos testMove = (Pos)pos.clone();		
		testMove.up();
		if( maze.validPos(testMove) ){
			moves.add(testMove);
		}
		
		testMove = (Pos)pos.clone();		
		testMove.down();
		if( maze.validPos(testMove) ){
			moves.add(testMove);
		}
		
		testMove = (Pos)pos.clone();		
		testMove.left();
		if( maze.validPos(testMove) ){
			moves.add(testMove);
		}
		
		testMove = (Pos)pos.clone();		
		testMove.right();
		if( maze.validPos(testMove) ){
			moves.add(testMove);
		}
		
		return moves;
	}
	
	protected String plotTrail(String s){
		StringBuilder str = new StringBuilder(s);
		
		for(int i=0; i<memory.size(); i++){
			Pos pos = memory.get(i);
			int offset = pos.i * maze.getMazeWidth() + pos.i + pos.j;
			str.setCharAt(offset, MOUSE_CHAR);
		}		
		return str.toString();
	}
		
	public String toString(){
		String s = maze.toString();		
		int offset = pos.i * maze.getMazeWidth() + pos.i + pos.j;
				
		StringBuilder str = new StringBuilder(s);
		str.setCharAt(offset, MOUSE_CHAR);
		
		return str.toString();
	}
}