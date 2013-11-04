package com.mazeSolver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	
	public static void main(String[] args){		
	
		String[] fileNames = {"example_input.txt", "input.txt", "small.txt", "medium_input2.txt", "large_input.txt", "unsolveable.txt"};
		
		try {			
			for(int i=0; i<fileNames.length; i++){
				BufferedReader br = new BufferedReader(new FileReader(fileNames[i]));
				
				Maze maze = new Maze(br);
				
				//Mouse mouse = new randomMouse(maze);
				Mouse mouse = new DepthFirstMouse(maze);
				//Mouse mouse = new DeadEndMouse(maze);
				
				//mouse.run();						
				Thread t = new Thread(mouse);
				t.start();		
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
	}
}
