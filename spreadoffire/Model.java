package spreadoffire;
import java.util.*;
import java.awt.Color;

/**
 *
 * @author OOPgroup8
 */
public class Model {
    
    public int width, height;
    public double probBurning, probTree;
    private Cell cell[][];
    private boolean cellCheck[][];

    /**
     * Constructor create the grid
     */
    public Model() {
        this(30,30,0.5,1);
    }
    
    /**
     * Constructor, create the field
     * @param width
     * @param height
     */
    public Model(int width, int height){
        this(width,height,0.5,1);
    }
    
    /**
     * Constructor create the grid
     * @param width
     * @param height 
     * @param probB
     * @param probT
     */
    public Model(int width, int height, double probB, double probT) {
        this.width = width;
        this.height = height;
        this.probBurning = probB;
        this.probTree = probT;
        //Reset the field
        resetGrid();
    }
    
    /**
     * Set the burning probability
     * @param probBurning
     */
    public void setProbBurning(double probB) {
        this.probBurning = probB;
    }
    
    /**
     * Set the density of forest
     * @param probT
     */
    public void setProbTree(double probT) {
        this.probTree = probT;
    }
    
    /**
     * set size of grid
     * @param width
     * @param height 
     */
    public void setSize(int width,int height){
        this.width=width;
        this.height=height;
        //Reset the field after set
        resetGrid();
    }
    
    /**
     * Get the RGB Color of cell at x,y
     * @param x
     * @param y
     * @return RGB Color
     */
    public Color getColor(int x,int y){
        try{
            return cell[x][y].getColor();
        }
        catch(Exception e){
            //If x,y out of bound, treat as empty
            return Color.WHITE;
        }
    }
    
    /**
     * Get the state of cell at x,y
     * @param x
     * @param y
     * @return Cell state
     */
    private int get(int x,int y){
        try{
            return cell[x][y].get();
        }
        catch(Exception e){
            //If x,y out of bound, treat as empty
            return Cell.YELLOW;
        }
    }
    
    /**
     * Reset the field
     */
    public void resetGrid(){
        //Create new grid with current size which
        // 0 - empty - on boundary
        // 1 - tree - inside
        // 2 - burning tree - in middle
        cell = new Cell[width+2][height+2];        
        cellCheck=new boolean[width+2][height+2]; resetCheck();
        for(int i = 0; i < cell.length; i++){
            for(int j=0; j<cell[0].length; j++){
                if(i==0 || j==0 || i==cell.length-1 || j==cell[0].length-1 ){
                    cell[i][j] = new Cell(Cell.YELLOW);
                }else{
                    cell[i][j] = new Cell(Cell.GREEN);
                }
            } 
        }
        // Set middle for the starting point
        cell[width/2][height/2] = new Cell(Cell.RED);
        
        //Update the field
        //update();
    }
        
    /**
     * reset the cell for check
     */
    public  void resetCheck(){
       for(int i=0;i<cellCheck.length;i++){
           for(int j=0;j<cellCheck[0].length;j++){
               cellCheck[i][j]=false;
           }
       }
    }     
    
    /**
     * Spread the fire from x,y 
     * @param s
     * @param x
     * @param y
     */
    public void spread(String s,int x, int y){               
        if(s.equals("north")  && get(x,y-1) == Cell.GREEN && random(probBurning)==true){       
                cell[x][y-1].set(Cell.RED); cellCheck[x][y-1] = true;
        }
        if(s.equals("south") && get(x,y+1) == Cell.GREEN && random(probBurning)==true){  
                cell[x][y+1].set(Cell.RED); cellCheck[x][y+1] = true;  
        }
        if(s.equals("west") && get(x-1,y) == Cell.GREEN && random(probBurning)==true){
                cell[x-1][y].set(Cell.RED); cellCheck[x-1][y] = true;      
        }
        if(s.equals("east") && get(x+1,y) == Cell.GREEN && random(probBurning)==true){
                cell[x+1][y].set(Cell.RED); cellCheck[x+1][y] = true;              
        }  
        update();   
    }
    
       /**
     * Search for the fire 
     */
    public void checkBurn(){
        //update();
        try {
            Thread.sleep(100);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        for(int i = 0; i < cell.length-1; i++){
            for(int j=0; j<cell[0].length-1; j++){
                if(get(i,j) == Cell.RED && cellCheck[i][j] == false){
                    cell[i][j].set(Cell.YELLOW);
                    spread("north",i,j);    spread("south",i,j);  
                    spread("west",i,j);     spread("east",i,j);     
                }
            }
        }
    }             
         
     /**
     * Check if there is no burning finish (no 2 anymore)
     */
    public boolean finish(){
        for(int i=0;i<cell.length;i++){
            for(int j=0;j<cell[0].length;j++){
                if(get(i,j) == Cell.RED)
                    return false;
            }
        } return true;
    }
    
    /**
     * random a number
     * @return boolean of random number
     */
     public boolean random(double a){
        double rnd = Math.random();
        if(rnd<a)
            return true;
        return false;
    }

    /**
     * print grid 
     */
    public void showGraph(){
        for(int i = 0; i < cell.length; i++){
           for(int j = 0; j < cell[0].length; j++){
              System.out.printf("%2s ","");
              if(cell[i][j].get()==Cell.GREEN)System.out.print(1);
                else if(cell[i][j].get()==Cell.RED)System.out.print(2);
                else if(cell[i][j].get()==Cell.YELLOW)System.out.print(0);
           }
           System.out.println();
        }
    } 
}

