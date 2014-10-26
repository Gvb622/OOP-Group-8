/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadoffire;


/**
 *
 * @author OOPgroup8
 */
public class Model {
    public int width, height;
    int cell[][];

    /**
     * Constructor create the grid
     */
    public Model() {
        this(30,30);
    }

    
    /**
     * Constructor create the grid
     * @param width
     * @param height 
     */
    public Model(int width, int height) {
        this.width = width;
        this.height = height;
        //Reset the field
        resetGrid();
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
    
    public void resetGrid(){
        //Create new grid with current size which
        // 0 - empty - on boundary
        // 1 - tree - inside
        // 2 - burning tree - in middle
        cell = new int[width+2][height+2];
        for(int i = 0; i < cell.length; i++){
            for(int j=0; j<cell[0].length; j++){
                if(i==0 || j==0 || i==cell.length-1 || j==cell[0].length-1 ){
                    cell[i][j] = 0;
                }else{
                    cell[i][j] = 1;
                }
            }          
        cell[width/2][height/2] = 2;
        }
        
    }
    
    /**
     * print grid 
     */
    public void showGraph(){
        for(int i = 0; i < cell.length; i++){
           for(int j = 0; j < cell[0].length; j++){
              System.out.printf("%2d ", cell[i][j]);
           }
           System.out.println();
        }
    }
    
    

}

