package NB18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Maze {
	
	int row,col;
	public enum Cell{WALL,OPEN,VISITED};
	private Position currentP,goal;
	private Stack<Position> visited;
	Cell[][] mazeMatrix;
	
	
	public Maze(){
		try{
			System.out.println(new File(".").getAbsolutePath());
			visited = new Stack<>();
			BufferedReader in = new BufferedReader(new FileReader("/Users/milanlanguric/Desktop/Algoritmer & datastrukturer/Övningsuppgifter & NB/NB lösningar/F6/src/NB18/Labyrint.txt"));
			row = Integer.parseInt(in.readLine())+2;
			col = Integer.parseInt(in.readLine())+2;
			mazeMatrix = new Cell[row][col];
			for(int j=0;j<col;j++){
				mazeMatrix[0][j] = Cell.WALL;
				mazeMatrix[row-1][j] = Cell.WALL;
			}
			for(int i=1;i<row-1;i++){
				mazeMatrix[i][0] = Cell.WALL;
				mazeMatrix[i][col-1] = Cell.WALL;
			}
			for(int i=1;i<row-1;i++){
				String s = in.readLine();
				for(int j=1;j<col-1;j++){
					mazeMatrix[i][j]=Cell.OPEN;
					if(s.charAt(j-1)=='*')
						mazeMatrix[i][j]=Cell.WALL;
					else if(s.charAt(j-1)=='g'){
						goal = new Position(i,j);
					}
					else if(s.charAt(j-1)=='s'){
						currentP = new Position(i,j);
						System.out.println(currentP.row + "," + currentP.column);
					}
				}
			}
			in.close();
		}catch(IOException e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
	
	private class Position{
		int row,column;
		public Position(int r, int c){
			row=r;
			column=c;
		}
		
		public boolean equals(Position p){
			return (row==p.row&&column==p.column);
		}
	}
	
	public boolean solve(){
		return solve(currentP);
	}
	private boolean solve(Position p){
		if (p.equals(goal))
			return true;
		else{

			visited.push(p);

			while (!visited.isEmpty()){

				currentP = visited.peek();
				if (currentP.equals(goal)) {
					mazeMatrix[goal.row][goal.column] = Cell.VISITED;
					return true;
				}

				mazeMatrix[currentP.row][currentP.column] = Cell.VISITED;
				int north = currentP.row-1;
				int south = currentP.row+1;
				int west = currentP.column-1;
				int east = currentP.column+1;

				if (north>=1){
					if (mazeMatrix[north][currentP.column] == Cell.OPEN){
						visited.push(new Position(north,currentP.column));
					}
				}
				if (south < row-1){
					if (mazeMatrix[south][currentP.column] == Cell.OPEN){
						visited.push(new Position(south,currentP.column));
					}
				}
				if (west >= 1){
					if (mazeMatrix[currentP.row][west] == Cell.OPEN){
						visited.push(new Position(currentP.row, west));
					}
				}
				if (east < col-1){
					if (mazeMatrix[currentP.row][east] ==  Cell.OPEN){
						visited.push(new Position(currentP.row, east));
					}
				}

				if (currentP.equals(visited.peek())){
					visited.pop();
					currentP = visited.peek();
				}
			}

			return false;

		}

	}
	
	public void print(){
		for(int i=1;i<row-1;i++){
			for(int j=1;j<col-1;j++)
				System.out.print(mazeMatrix[i][j].ordinal());
			System.out.println();
		}
	}

}
