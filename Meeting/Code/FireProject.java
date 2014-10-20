import java.util.*;

public class FireProject{
  static Grid grid;
  
  public static void main (String [] args){
    text();
  }
  
  public static void text(){
    System.out.println("Set the size of the forest (grid) : ");
    System.out.print("X = ");     Scanner a = new Scanner(System.in);     int x1 = a.nextInt(); 
    System.out.print("Y = ");     Scanner b = new Scanner(System.in);     int y1 = b.nextInt(); 
    
    System.out.println("Set the probability of a tree in a cell catching fire : (0-1) ");
    Scanner c = new Scanner(System.in);     double z = c.nextDouble();
    
    System.out.println("Set the probability of a tree in a cell to spawn : (0-1) ");
    Scanner d = new Scanner(System.in);    double v = d.nextDouble();
    
    System.out.println("Set the starting point : ") ;              
    System.out.print("X = ");     Scanner e = new Scanner(System.in);     int x2 = d.nextInt(); 
    System.out.print("Y = ");     Scanner f = new Scanner(System.in);     int y2 = e.nextInt(); 
    
    grid = new Grid(x1,y1,z,v);     grid.start(x2, y2);   
    
    System.out.println("Initial grid");     grid.showGraph();
    
    int step=1;
    while(!grid.finish()){
      grid.search();
      System.out.println("Step "+step);
      grid.showGraph();
      step++;
      grid.burn.reset();
    }
    System.out.println("Total step = "+ (step-1));
  }
}
