package upg7;

import java.util.Stack;

public class Puzzle {

    private Stack<State> states;
    private enum Cell{
        BLOCK1, BLOCK2, BLOCK3, BLOCK4, OCCUPIED, OPEN
    };
    private enum Block{BLOCK1,BLOCK2,BLOCK3,BLOCK4};
    private Cell puzzle[][];
    private static final int ROW = 5;
    private static final int COL = 5;

    /**
     * */
    public Puzzle(){
        this.puzzle = new Cell[ROW][COL];
        states = new Stack<>();
        initPuzzle();
    }

    /**
     * */
    private void initPuzzle(){
        for (int i = 0; i< ROW; i++){
            for (int j=0; j< COL; j++){
                if (i == 0 && j == 2){//Places box
                    puzzle[i][j] = Cell.OCCUPIED;
                } else puzzle[i][j] = Cell.OPEN;
            }
        }
    }

    /**
     * Wrapper method to solve
     * */
    public void solve(){
        solve(new State(puzzle,0,0));
    }

    /**
     *Solves puzzle
     * */
    private void solve(State state){

        int row = 0,col = 0;
        int nrSolutions = 0;

        states.push(state);
        while (!states.isEmpty()){
            boolean blockPlaced = true;

            if (row == ROW-1 && col == COL-1){
                nrSolutions++;
                System.out.println("Solution " +nrSolutions +":\n" +printBoard(state.puzzle));
                states.pop();
                state = states.peek();
                col = state.col;
                row = state.row;
            }

            //Cheks if cell is open and if valid position for block, then place block
            if (state.puzzle[row][col] == Cell.OPEN){
                if (isValidPositionBlock1(state.puzzle,row,col) && !state.block1tried){
                    placeBlock(state.puzzle,row,col,Block.BLOCK1);
                    state.block1tried = true;
                    states.push(new State(state.puzzle,row,col));
                    placeBlock(state.puzzle,row,col,Block.BLOCK1);
                }else if(isValidPositionBlock2(state.puzzle,row,col)&& !state.block2tried){
                    placeBlock(state.puzzle,row,col,Block.BLOCK2);
                    state.block2tried = true;
                    states.push(new State(state.puzzle,row,col));
                    placeBlock(state.puzzle,row,col,Block.BLOCK2);
                }else if (isValidPositionBlock3(state.puzzle,row,col) && !state.block3tried){
                    placeBlock(state.puzzle,row,col,Block.BLOCK3);
                    state.block3tried = true;
                    states.push(new State(state.puzzle,row,col));
                    placeBlock(state.puzzle,row,col,Block.BLOCK3);
                }else if (isValidPositionBlock4(state.puzzle,row,col) && !state.block4tried){
                    placeBlock(state.puzzle,row,col,Block.BLOCK4);
                    state.block4tried = true;
                    states.push(new State(state.puzzle,row,col));
                    placeBlock(state.puzzle,row,col,Block.BLOCK4);
                }else blockPlaced = false;

                if (!blockPlaced){
                    states.pop();

                    if (!states.isEmpty()){
                        col = states.peek().col;
                        row = states.peek().row;
                    }
                } else{
                    if (col == COL-1){
                        col = 0;
                        row++;
                    } else{
                        col++;
                    }
                }
                if (!states.isEmpty())
                    state = states.peek();
            } else {
                if (col == COL-1){
                    col = 0;
                    row++;
                } else{
                    col++;
                }
            }
        }
        System.out.println("No more solutions!");
    }

    /**
     * */
    public static String printBoard(Cell puzzle[][]){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< ROW; i++){
            for (int j=0; j< COL; j++){
                sb.append(puzzle[i][j].ordinal());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Places block on board
     * */
    private void placeBlock(Cell puzzle[][], int row, int col, Block block){
        if (block == Block.BLOCK1){
            puzzle[row][col] = puzzle[row][col]==Cell.BLOCK1?Cell.OPEN:Cell.BLOCK1;
            puzzle[row+1][col] = puzzle[row+1][col]==Cell.BLOCK1?Cell.OPEN:Cell.BLOCK1;
            puzzle[row+1][col-1] = puzzle[row+1][col-1]==Cell.BLOCK1?Cell.OPEN:Cell.BLOCK1;
        }
        if (block == Block.BLOCK2){
            puzzle[row][col] = puzzle[row][col]==Cell.BLOCK2?Cell.OPEN:Cell.BLOCK2;
            puzzle[row+1][col] = puzzle[row+1][col]==Cell.BLOCK2?Cell.OPEN:Cell.BLOCK2;
            puzzle[row+1][col+1] = puzzle[row+1][col+1]==Cell.BLOCK2?Cell.OPEN:Cell.BLOCK2;
        }
        if (block== Block.BLOCK3){
            puzzle[row][col] = puzzle[row][col]==Cell.BLOCK3?Cell.OPEN:Cell.BLOCK3;
            puzzle[row][col+1] = puzzle[row][col+1]==Cell.BLOCK3?Cell.OPEN:Cell.BLOCK3;
            puzzle[row+1][col+1] = puzzle[row+1][col+1]==Cell.BLOCK3?Cell.OPEN:Cell.BLOCK3;
        }
        if (block == Block.BLOCK4){
            puzzle[row][col] = puzzle[row][col]==Cell.BLOCK4?Cell.OPEN:Cell.BLOCK4;
            puzzle[row][col+1] = puzzle[row][col+1]==Cell.BLOCK4?Cell.OPEN:Cell.BLOCK4;;
            puzzle[row+1][col] = puzzle[row+1][col]==Cell.BLOCK4?Cell.OPEN:Cell.BLOCK4;;
        }
    }

    /**
     * */
    private boolean isValidPositionBlock1(Cell puzzle[][], int row, int col){
        if (col == 0 || row == ROW-1) return false;
        return puzzle[row][col] == Cell.OPEN && puzzle[row+1][col] == Cell.OPEN && puzzle[row +1][col-1] == Cell.OPEN;
    }
    private boolean isValidPositionBlock2(Cell puzzle[][], int row, int col){
        if (col == COL-1 || row == ROW-1) return false;
        return puzzle[row][col] == Cell.OPEN && puzzle[row+1][col] == Cell.OPEN && puzzle[row+1][col+1] == Cell.OPEN;
    }
    private boolean isValidPositionBlock3(Cell puzzle[][], int row, int col){
        if (col== COL -1 || row == ROW-1) return false;
        return puzzle[row][col] == Cell.OPEN && puzzle[row][col+1] == Cell.OPEN && puzzle[row +1][col+1] == Cell.OPEN;
    }
    private boolean isValidPositionBlock4(Cell puzzle[][], int row, int col){
        if (col == COL-1 || row == ROW-1) return false;
        return puzzle[row][col] == Cell.OPEN && puzzle[row][col+1] == Cell.OPEN && puzzle[row+1][col] == Cell.OPEN;
    }


    /**
     * */
    private static class State{
        Cell puzzle[][];
        int row;
        int col;
        boolean block1tried;
        boolean block2tried;
        boolean block3tried;
        boolean block4tried;

        public State(Cell puzzle[][], int row, int col){
            this.puzzle = new Cell[ROW][COL];
            this.row = row;
            this.col = col;
            for (int i = 0; i< ROW; i++){
                for (int j=0; j< COL; j++){
                    this.puzzle[i][j] = puzzle[i][j];
                }
            }
        }

        @Override
        public String toString(){
            return printBoard(puzzle);
        }
    }

}
