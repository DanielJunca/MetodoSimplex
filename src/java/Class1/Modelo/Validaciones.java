package Class1.Modelo;
import java.util.ArrayList;

public class Validaciones {
   public static String tipo; 

    public int [][] CrearMatriz(int filas , int columnas,int Parametro1fila, 
    String[]FO,String[] Res,String[] Result,String tipo){
        
      int fo []=stringint(FO);
      int res[]=stringint(Res);
      int result[]=stringint(Result);
      int auxfo=0;
      int auxres=0;
      int auxresult=0;
      int [][] tablainicial=new int[filas][columnas];
      
      for (int i = 0; i < filas; i++) {
          for (int j = 0; j < columnas; j++) {
             if(i==0 && j==0){
                 tablainicial[i][j]=1;
             }else if(i==0 && j>0 && j<columnas-Parametro1fila){
                 tablainicial[i][j]=fo[auxfo]*-1;
                 auxfo++;
             }else if(j>0 && j<columnas-Parametro1fila){
               tablainicial[i][j]=res[auxres];
               auxres++;
             }else if(i>0){
              tablainicial[i][i+(fo.length)]=1;   
             }
             if(i>0 && j==columnas-1){
              tablainicial[i][j]=result[auxresult];
              auxresult++;
             }
          }
      }
     return tablainicial;
  }
  
    public int [] stringint(String[] vector){
        int [] vectornuevo=new int[vector.length];
        for (int i = 0; i < vectornuevo.length; i++) {
          vectornuevo[i]=Integer.parseInt(vector[i]);
        }
      return vectornuevo;
  }
  
    public int [] maxomin(int[] vec,String tipo){
    if(tipo.equalsIgnoreCase("Minimizacion")){
        for (int i = 0; i < vec.length; i++) {
            vec[i]=vec[i]*-1;
        }
    }  
    return vec;  
  } 
   
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
       
}

      
      