public class Burning{
    boolean burn[][];
    
    public Burning(int x,int y){
        burn = new boolean [x+2][y+2];
        reset();
    }    
    public  void reset(){
        for(int i=0;i<burn.length;i++){
            for(int j=0;j<burn[0].length;j++){
                burn[i][j]=false;
            }
        }
    }
}
