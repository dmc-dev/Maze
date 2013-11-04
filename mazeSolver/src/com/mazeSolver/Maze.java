package com.mazeSolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Maze {
	
	private int[][] maze = null;
	
	private int max_i=0, max_j=0;
	private Pos start;
	private Pos end;

	private static final char mazeChars[]={' ', '#'}; 
	
	public Maze(){}
	
	public Maze(BufferedReader br){
		try {		
			StringTokenizer st = new StringTokenizer(br.readLine());			
			max_i = Integer.parseInt(st.nextToken());
			max_j = Integer.parseInt(st.nextToken());
			maze = new int[max_i][max_j];
			
			st = new StringTokenizer(br.readLine());			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			start = new Pos(i,j);
			
			
			st = new StringTokenizer(br.readLine());			
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			end = new Pos(i,j);
			
			String line=null;
			i=0;			
			while((line = br.readLine())!= null){				
				st = new StringTokenizer(line);
				j=0;
				while(st.hasMoreElements()){					
					maze[i][j]=Integer.parseInt(st.nextToken());
					j++;
				}				
				i++;			
			}
			
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}
	
	public Object clone() {
		Maze m = new Maze() ;				
		m.max_i=max_i;
		m.max_j=max_j;
		m.start=(Pos) start.clone();
		m.end=(Pos) end.clone();
		m.maze = new int[max_i][max_j];
		
		for(int i=0; i<max_i; i++)
			for(int j=0; j<max_j; j++)
				m.maze[i][j] = maze[i][j];
				
		return m;
	}
	
	public boolean validPos(Pos p){
		return maze[p.i][p.j]==0;
	}
	
	public String toString(){
		StringBuilder s =  new StringBuilder();
		for(int i=0; i<max_i; i++){
			for(int j=0; j<max_j; j++){
				s.append(mazeChars[maze[i][j]]);
			}
			s.append("\n");
		}
		
		int offset = start.i * getMazeWidth() + start.i + start.j;
		s.setCharAt(offset, 'S');
		
		offset = end.i * getMazeWidth() + end.i + end.j;
		s.setCharAt(offset, 'E');
		
		return s.toString();
	}
	
	public Pos getStart(){
		return start;
	}
	
	public Pos getEnd(){
		return end;
	}
	
	public int getMazeHeight(){return max_i;}
	public int getMazeWidth(){return max_j;}
	
	public void setWall(int i, int j){
		maze[i][j]=1;
	}
}