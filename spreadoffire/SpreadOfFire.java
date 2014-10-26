/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the width of the grid: ");  
        width = in.nextInt();
        
        System.out.print("Enter the height of the grid: ");  
        height = in.nextInt();
        
        Model grid = new Model(width,height);       
        grid.showGraph();
    }
    
}
