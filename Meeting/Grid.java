package fireproject;

public class Grid extends FireProject { 
  static int grid [][];
  double probBurning;
  double probTree;
  
  public Grid(){
  
  }
  public void setprobBurning(double a){
        probBurning=a;
    } 
    public void setprobTree(double a){
        probTree=a;
    }
    public void reset(){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
                   grid[i][j]=0;
                }else{
                    if(random(probTree)){
                        grid[i][j] = 1;
                    }else{grid[i][j]=0;}
                }
            }
        }     
    }
    public boolean random(double a){
        double rnd = Math.random();
        if(rnd<a)
            return true;
        return false;
    }
}
