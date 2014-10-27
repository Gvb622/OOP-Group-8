package spreadoffire;

import java.util.Scanner;

/**
 *
 * @author OOPgroup8
 */
public class SpreadOfFire {
    
    static int width, height;
    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        TUI();
    }
    
    public static void TUI(){
        System.out.println("Set the size of the forest (grid) : ");
        System.out.print("Width = ");     Scanner a = new Scanner(System.in);     int width = a.nextInt(); 
        System.out.print("Height = ");     Scanner b = new Scanner(System.in);     int height = b.nextInt(); 
        
        System.out.println("Set the probability of a tree in a cell catching fire : (0-1) ");
        Scanner c = new Scanner(System.in);     double probB = c.nextDouble();
        
        System.out.println("Set the density of forest : (0-1) ");
        Scanner d = new Scanner(System.in);    double probT = d.nextDouble();
        
        //System.out.println("Set the starting point : ") ;              
        //System.out.print("X = ");     Scanner e = new Scanner(System.in);     int x2 = d.nextInt(); 
        //System.out.print("Y = ");     Scanner f = new Scanner(System.in);     int y2 = e.nextInt(); 
        
        Model grid = new Model(width,height,probB,probT);     //grid.start(x2, y2);   
        
        System.out.println("Initial grid");     grid.showGraph();
        
        int step=1;
        while(!grid.finish()){
            grid.checkBurn();
            System.out.println("Step "+step);
            grid.showGraph();
            step++;
            grid.resetCheck();
        }
        System.out.println("Total step = "+ (step-1));
    }
}