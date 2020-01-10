package cs143;


import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;






public class MazeSolver {
	
	Stack<Integer> s = new Stack<Integer>();
	
	private char[][] printMaze;
	private char[][] solveMaze;
	private int M;
	private int N;
	private boolean[][] unvisited = new boolean[31][46]; 
	private boolean[][] badEnd = new boolean[31][46];
	private char[] dir = {'8','9','6','3','2','1','4','7'};
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private char map;
	
	Integer i = new Integer(0,0);
	
	public class Integer {

	    private int x;
	    private int y;

	    public Integer(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

		/**
		 * @return the x
		 */
		public int getX() {
			return x;
		}

		/**
		 * @return the y
		 */
		public int getY() {
			return y;
		}

		/**
		 * @param x the x to set
		 */
		public void setX(int x) {
			this.x = x;
		}

		/**
		 * @param y the y to set
		 */
		public void setY(int y) {
			this.y = y;
		}
		
		
	}
	
	public MazeSolver() {
		super();
		
	}
	
	private void setVisited(boolean b)  
    { 
        for (int i = 0; i < unvisited.length; i++)  
        { 
            for (int j = 0; j < unvisited[i].length; j++) 
            { 
                unvisited[i][j] = b; 
            } 
        } 
  
    } 
	
	private void setBadEnd(boolean b)  
    { 
        for (int i = 0; i < badEnd.length; i++)  
        { 
            for (int j = 0; j < badEnd[i].length; j++) 
            { 
                badEnd[i][j] = b; 
            } 
        } 
  
    } 
	
	
	
	private boolean solveMaze(boolean printUpdates)
	{		
		// Constructors
		
		Direction d = Direction.Down;
		Integer curr = new Integer(startX, startY);
		
		// When stack is empty, return false. Maze is not saved successfully
		while(!s.isEmpty())
		{
			
			int t = 0;	// Show the location of dir array
			boolean moved = false; // Check if moved
			
			
			
			// Check all directions until the current moves.
			do {
					
					// Get a direction from Direction class
					Direction direction = d.getEnumfromChar(dir[t]);
				
					//System.out.println(rightY);
					int rightX = curr.getX() + d.Right.getDeltaY();
					int rightY = curr.getY() + d.Right.getDeltaX();
					int leftX = curr.getX() + d.Left.getDeltaY();
					int leftY = curr.getY() + d.Left.getDeltaX();
					int upX = curr.getX() + d.Up.getDeltaY();
					int upY = curr.getY() + d.Up.getDeltaX();
					int downX = curr.getX() + d.Down.getDeltaY();
					int downY = curr.getY() + d.Down.getDeltaX();
					int ldX = curr.getX() + d.LeftDown.getDeltaY();
					int ldY = curr.getY() + d.LeftDown.getDeltaX();
					int luX = curr.getX() + d.LeftUp.getDeltaY();
					int luY = curr.getY() + d.LeftUp.getDeltaX();
					int rdX = curr.getX() + d.RightDown.getDeltaY();
					int rdY = curr.getY() + d.RightDown.getDeltaX();
					int ruX = curr.getX() + d.RightUp.getDeltaY();
					int ruY = curr.getY() + d.RightUp.getDeltaX();
					
					
					
					// If current is in a goal, maze is solved! Return true 
					if (curr.getX() == endX && curr.getY() == endY - 1)
					{
						//System.out.printf("%d, %d%n", s.top().getX(), s.top().getY());
						//printMaze(solveMaze);
						
						return true;
						
					}
					
					else if (t == 0 && solveMaze[upX][upY] == ' ' && badEnd[upX][upY]  && unvisited[upX][upY] )
					{
						
							
						
							moved = true;
							solveMaze[upX][upY] = '*';
							curr.setX(upX);
							curr.setY(upY);
							
							curr = new Integer(upX, upY);
							s.push(curr);
							unvisited[upX][upY] = false;
							//printMaze(solveMaze);
							
						
					}else if (t == 1 && solveMaze[ruX][ruY] == ' ' && badEnd[ruX][ruY]&& unvisited[ruX][ruY])
					{
						moved = true;
						solveMaze[ruX][ruY] = '*';
						curr.setX(ruX);
						curr.setY(ruY);
						
						curr = new Integer(ruX, ruY);
						s.push(curr);
						unvisited[ruX][ruY] = false;
						
					}else if (t == 2 && solveMaze[rightX][rightY] == ' '&& badEnd[rightX][rightY] && unvisited[rightX][rightY])
					{
						
							//
						
							moved = true;
							solveMaze[rightX][rightY] = '*';
							curr.setX(rightX);
							curr.setY(rightY);
							
							curr = new Integer(rightX, rightY);
							s.push(curr);
							unvisited[rightX][rightY] = false;
							//System.out.printf("%d, %d%n", s.top().getX(), s.top().getY());
							//printMaze(solveMaze);
							
						
					}else if (t == 3 && solveMaze[rdX][rdY] == ' ' && badEnd[rdX][rdY] && unvisited[rdX][rdY])
					{
						moved = true;
						solveMaze[rdX][rdY] = '*';
						curr.setX(rdX);
						curr.setY(rdY);
						
						curr = new Integer(rdX, rdY);
						s.push(curr);
						unvisited[rdX][rdY] = false;
						
					}else if(t == 4 && solveMaze[downX][downY] == ' ' && badEnd[downX][downY] && unvisited[downX][downY])
					{
						
							//
						
							moved = true;
							solveMaze[downX][downY] = '*';
							curr.setX(downX);
							curr.setY(downY);
							
							curr = new Integer(downX, downY);
							s.push(curr);
							unvisited[downX][downY] = false;
							//System.out.printf("%d, %d%n", s.top().getX(), s.top().getY());
							//printMaze(solveMaze);
							
						
					}else if (t == 5 && solveMaze[ldX][ldY] == ' ' && badEnd[ldX][ldY] && unvisited[ldX][ldY])
					{
						moved = true;
						solveMaze[ldX][ldY] = '*';
						curr.setX(ldX);
						curr.setY(ldY);
						
						curr = new Integer(ldX, ldY);
						s.push(curr);
						unvisited[ldX][ldY] = false;
						
					}else if (t == 6 && solveMaze[leftX][leftY] == ' ' && badEnd[leftX][leftY] && unvisited[leftX][leftY])
					{
						
						
						
						moved = true;
						solveMaze[leftX][leftY] = '*';
						curr.setX(leftX);
						curr.setY(leftY);
						
						curr = new Integer(leftX, leftY);
						s.push(curr);
						unvisited[leftX][leftY] = false;
						//System.out.printf("%d, %d%n", s.top().getX(), s.top().getY());
						//printMaze(solveMaze);
						
					
					}else if (t == 7 && solveMaze[luX][luY] == ' ' && badEnd[luX][luY] && unvisited[luX][luY])
					{
						moved = true;
						solveMaze[luX][luY] = '*';
						curr.setX(luX);
						curr.setY(luY);
						
						curr = new Integer(luX, luY);
						s.push(curr);
						unvisited[luX][luY] = false;
					}
					// Stack! Cannot go ahead, backtrack
					else if (solveMaze[downX][downY] != ' ' && solveMaze[rightX][rightY] != ' ' && solveMaze[leftX][leftY] != ' ' && solveMaze[upX][upY] != ' ')
					{
						// Delete current position from stack and go back to previous one
						s.pop();
						// Mark the location not to come back again
						badEnd[curr.getX()][curr.getY()] = false;
						curr.setX(s.top().getX());
						curr.setY(s.top().getY());
						
						moved = true;
						//System.out.printf("%d, %d%n", s.top().getX(), s.top().getY());
						//printMaze(solveMaze);
						
					}
			
					
					
					clearScreen();
					
				} while( t++ < 7 && !moved);	// End the do loop either if current is moved or checked all direction
		
		
			
		}
		
		return false;
		
	}
	public boolean solve(boolean printUpdates)
	{
		
		//Stack<Integer> s = new Stack<Integer>();
		Integer curr = new Integer(startX, startY);
		
				// Set start position
				curr.setX(startX);
				curr.setY(startY);
				
				// Push initial position in a stack
				s.push(curr);
				
				setVisited(true);
				setBadEnd(true);
				
				
		
		
		return  solveMaze(printUpdates);
	}
	
	
	public boolean solve()
	{
		
		return solveMaze(false);
	}
	
	public void printFinalMaze()
	{
		for (int i = 0; i < solveMaze.length; i++)
		{
			System.out.println(solveMaze[i]);
			
			
		}
		
	}	
	private void printMaze(char [][] maze)
	{
		for (int i = 0; i < maze.length; i++)
		{
			
				System.out.println(maze[i]);
			
			
		}
	}
	 
	public static void clearScreen() 
	{  
		try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
		

	}  
	public boolean loadMaze(String filename)
	{
		// if you want to load different mazes you may need to reset some things
		BufferedReader br = null;
		FileReader fr = null;
        ArrayList<String> lines = new  ArrayList<String>();
		try {

			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String line;
			br = new BufferedReader(new FileReader(filename));

			while ((line = br.readLine()) != null) 
			{
				lines.add(line);				
			}
			printMaze = new char[lines.size()][];
			solveMaze = new char[lines.size()][];
			for(int i = 0; i < lines.size() ; i++)
			{
				printMaze[i] = new char[lines.get(i).length()];
				solveMaze[i] = new char[lines.get(i).length()];
				
				for(int j = 0; j < lines.get(i).length() ; j++)
				{
					solveMaze[i][j] = lines.get(i).charAt(j);
					printMaze[i][j] = lines.get(i).charAt(j);
					
					
					//hint you may want to check for something here
				    // what two things do you need to have...
					if (solveMaze[i][j] == 'S')
					{
						startX = i;
						startY = j;
					}
					if (solveMaze[i][j] == 'F')
					{
						endX = i;
						endY = j;
					}
					
					
					
				}			
			}			

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

			  return false;

			}
			
			N = lines.size();
			M = lines.get(0).length();

		}

		return true;
	}
	
	
	

	

}
