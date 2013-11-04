package com.mazeSolver;

import java.util.ArrayList;

public class DeadEndMouse extends Mouse{

	protected ArrayList<Pos> dead = new ArrayList<Pos>();
	
	public DeadEndMouse(Maze m) {
		super(m);		
	}

	public ArrayList<Pos> getMoves(){		
		ArrayList<Pos> moves = super.getMoves();
		moves.removeAll(memory);		
		return moves;
	}
	
	@Override
	public void run() {
		for(int i=1; i<maze.getMazeHeight()-1; i++){
			for(int j=1; j<maze.getMazeWidth()-1; j++){
				pos = new Pos(i, j);				
				ArrayList<Pos> m = getMoves();				
				while(m.size()==1){			
					if(atGoal() || atStart()){
						break;
					}
					maze.setWall(pos.i, pos.j);
					pos = m.get(0);					
					m=getMoves();
				}
			}
		}
		System.out.println(this);		
	}

	public String toString(){
		String s = super.toString();
		return plotTrail(s);
	}
	
}
