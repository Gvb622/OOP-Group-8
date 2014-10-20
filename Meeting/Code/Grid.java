package fireproject;

public class Grid extends FireProject { 
  static int grid [][];
  Burning burn;
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
  public void start(int x,int y){
    grid[x+1][y+1]=2;
  }
  public void search(){
    for(int i=1;i<grid.length-1;i++){
      for(int j=1;j<grid[0].length-1;j++){
        if(grid[i][j]==2 && burn.burn[i][j]==false){
          grid[i][j]=0;
          spread("north",i,j);    spread("south",i,j);  
          spread("west",i,j);     spread("east",i,j); 
        }
      }
    }
  }
  public void spread(String s,int x,int y){
    if(s.equals("north") && grid[x][y-1]==1 && random(probBurning)==true){
      grid[x][y-1]=2; burn.burn[x][y-1]=true;}
    if(s.equals("south") && grid[x][y+1]==1 && random(probBurning)==true){
      grid[x][y+1]=2; burn.burn[x][y+1]=true;}
    if(s.equals("west") && grid[x-1][y]==1 && random(probBurning)==true){
      grid[x-1][y]=2;burn.burn[x-1][y]=true;}
    if(s.equals("east") && grid[x+1][y]==1 && random(probBurning)==true){
      grid[x+1][y]=2;burn.burn[x+1][y]=true;}
  }
  public boolean finish(){
    for(int i=0;i<grid.length;i++){
      for(int j=0;j<grid[0].length;j++){
        if(grid[i][j]==2)
          return false;
      }
    } return true;
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
  public void showGraph(){
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++){
        System.out.printf("%2d ", grid[i][j]);
      }
      System.out.println();
    }
  }
}
