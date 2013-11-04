package com.mazeSolver;

import java.util.ArrayList;
import java.util.Random;

public class randomMouse extends Mouse{

	private Random random = new Random();
	
	public randomMouse(Maze m) {
		super(m);		
	}

	public void makeRandomMove(){		
		ArrayList<Pos> moves = getMoves();			
		Pos m = moves.get(random.nextInt(moves.size()));
		this.setPos(m);
	}
	
		
	public void run() {	
		while(!atGoal()){
			makeRandomMove();
			if(!memory.contains(pos)){
				rememberPos();	
			}			
		}
		System.out.println(this.toString()+"\n\n");
	}
	
	public String toString(){
		String s = super.toString();
		return plotTrail(s);
	}
}
