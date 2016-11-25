package Class1.Modelo;
public class prueba {
      
      public void imprimirMatriz(int [][] matriz){
            for (int x=0; x < matriz.length; x++) {
                 System.out.print("|");
                 for (int y=0; y < matriz[x].length; y++) {
                      System.out.print (matriz[x][y]);
                      if (y!=matriz[x].length-1) System.out.print("\t");
                      }
                      System.out.println("|");
            }    
        }  
      
     
      public static void main(String[] args) {
      
     double inverso=0;
     inverso=Math.pow(3, -1);
     System.out.println(inverso);
      prueba p=new prueba();
      int [] [] mat={{1,-5,-7,0,0,0,0},{0,1,0,1,0,0,6},{0,2,3,0,1,0,19},{0,1,1,0,0,1,8}};
      p.imprimirMatriz(mat);
      
      Fraccion [][] mataxu=new Fraccion[mat.length][mat[0].length];
      for (int i = 0; i < mataxu.length; i++) {
              for (int j = 0; j < mataxu[0].length; j++) {
               mataxu[i][j]=new Fraccion(mat[i][j]);
          }    
        }
         // System.out.println("paso");
         // Fraccion f=new Fraccion();
         // Fraccion f1=new Fraccion(3);
         // f=mataxu[2][2].inversa(mataxu[2][2]);
         // f=f.producto(f1, f);
          //for (int i = 0; i < mataxu.length; i++) {
            //  f=f.producto(mataxu[2][i],f);
             // System.out.println(f);
         // }
      //v.numeroInverso(3);
      
      //System.out.println(f.toString());
      //f=f.inversa(f);
      //System.out.println(f.toString());
    }
}

