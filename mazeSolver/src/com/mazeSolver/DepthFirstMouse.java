package com.mazeSolver;
import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstMouse extends Mouse{

	private static final int BLIND=0;
	private static final int CHECKED=1;
	
	private Stack<Pair<Pos, Integer>> path = new Stack<Pair<Pos, Integer>>();
	
	public DepthFirstMouse(Maze m) {
		super(m);
	}

	public void run() {				
		if(depthFirst()){		
			System.out.println(toString()+"Solved\n");
		}else{
			System.out.println(toString()+"No Solution\n");
		}
	}

	public ArrayList<Pos> getMoves(){		
		ArrayList<Pos> moves = super.getMoves();
		moves.removeAll(memory);		
		return moves;
	}
	
	
	public boolean depthFirst(){
		rememberPos();				
		
		ArrayList<Pos> moves = getMoves();		
		for(int i=0; i<moves.size(); i++){
			path.add(new Pair<Pos, Integer>(moves.get(i), new Integer(BLIND)));
		}
				
		while(!path.isEmpty()){						
			Pair<Pos, Integer> p = path.peek();						
			p.second = new Integer(CHECKED);
			
			setPos(p.first);
			rememberPos();
						
			if(atGoal()){				
				return true;
			}
							
			ArrayList<Pos> m = getMoves();
			if(m.size()==0){				
				while(!path.isEmpty() && path.peek().second.intValue() == CHECKED){
					path.pop();
				}				
			}
			
			moves = getMoves();		
			for(int i=0; i<moves.size(); i++){
				path.add(new Pair<Pos, Integer>(moves.get(i), new Integer(BLIND)));
			}
		}		
		return false;
	}

	
	protected String plotTrail(String s){
		StringBuilder str = new StringBuilder(s);
		
		while(!path.isEmpty()){
			Pair<Pos, Integer> p = path.pop();
			if(p.second.intValue()==CHECKED){				
				int offset = p.first.i * maze.getMazeWidth() + p.first.i + p.first.j;
				str.setCharAt(offset, MOUSE_CHAR);				
			}
		}			
		return str.toString();
	}
	
	public String toString(){
		String s = super.toString();
		return plotTrail(s);
	}
}