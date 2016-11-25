package Class1.Modelo;

import java.util.ArrayList;

public class Simplex {

    static ArrayList<Object> Datos = new ArrayList<>();
    static ArrayList<Fraccion> importante = new ArrayList<Fraccion>();
    static ArrayList<Fraccion[][]> BaseDatos = new ArrayList<>();
    public static String tipo; 
    
    /*public static void main(String[] args) {
        //int[][] matriz = {{1, -5, -7, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 0, 6}, {0, 2, 3, 0, 1, 0, 19}, {0, 1, 1, 0, 0, 1, 8}};
        //int[][] matriz = {{1, -8, -4, 0, 0, 0, 0}, {0, 4, 5, 1, 0, 0, 150}, {0, 3, 0, 0, 1, 0, 45}, {0, 0, 2, 0, 0, 1, 45}};
        //int[][] matriz = {{1,-40,-60,0,0,0,0}, {0,2,1,1,0,0,70}, {0,1,1,0,1,0,40}, {0,1,3,0,0,1,90}};
        //REVISAR int[][] matriz = {{1, -3, -2, 0, 0, 0, 0}, {0, 2, 1, 1, 0, 0, 18}, {0, 2, 3, 0, 1, 0, 42}, {0, 3, 1, 0, 0, 1, 24}};
        //int[][] matriz = {{1,-50,-80,0,0,0}, {0,1,2,1,0,120}, {0,1,1,0,1,90}};
        //int[][] matriz = {{1,-200,-240,0,0,0}, {0,12,6,1,0,120}, {0,4,8,0,1,64}};
        //int[][] matriz = {{1, 3, -8, 0, 0, 0}, {0, 4, 1, 1, 0, 13}, {0, 2, 3, 0, 1, 6}};

        String objetivo = "maximizacion";
        Fraccion[][] matrizFraccion = ConvertidorFraccion(matriz);
        

        
        System.out.println("MATRIZ ORIGINAL - OBJETIVO: " + objetivo);

        BaseDatos=Simplex(matrizFraccion, objetivo);

        System.out.println("--------------------");
        for (int i = 0; i < BaseDatos.size(); i++) {
        imprimir(BaseDatos.get(i));
        System.out.println();
        }
                
        

    }
*/

    public static Fraccion[][] ConvertidorFraccion(int[][] matriz) {
        Fraccion[][] mFraccion = new Fraccion[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                mFraccion[i][j] = new Fraccion(matriz[i][j]);
            }
        }
        return mFraccion;
    }

    public static void imprimir(Fraccion[][] matriz) {
        for (int x = 0; x < matriz.length; x++) {
            System.out.print("|");
            for (int y = 0; y < matriz[x].length; y++) {
                System.out.print(matriz[x][y]);
                if (y != matriz[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("| ");
        }
    }

    public static ArrayList<Object> Pivote(Fraccion[][] matriz, String objetivo) {
        ArrayList<Object> arreglo = new ArrayList<>();
        Fraccion pivote = new Fraccion(0);
        int posicion = 0;
        //IDENTIFICACION DE COLUMNA
        if (objetivo.equalsIgnoreCase("Maximizacion")) {
            for (int i = 1; i < matriz[0].length; i++) {
                double n = (double) matriz[0][i].num / matriz[0][i].denom;
                double m = (double) pivote.num / pivote.denom;
                if (n <= m) {
                    pivote = matriz[0][i];
                    posicion = i;
                }
            }
        } else {
            for (int i = 1; i < matriz[0].length; i++) {
                double n = (double) matriz[0][i].num / matriz[0][i].denom;
                double m = (double) pivote.num / pivote.denom;

                if (n >= m) {
                    pivote = matriz[0][i];
                    posicion = i;
                }
            }
        }

        Fraccion x = new Fraccion();
        int posicion2 = 0;
        ArrayList<Fraccion> Piv = new ArrayList<>();
        Piv.add(new Fraccion(0));
        System.out.println();
        for (int i = 1; i < matriz.length; i++) {
            double n = (double) matriz[i][posicion].num;
            double m = (double) matriz[i][posicion].denom;

            if (matriz[i][posicion].num != 0) {
                x = x.cociente(matriz[i][matriz[0].length - 1], matriz[i][posicion]);
                Piv.add(x);
            } else {
                Piv.add(new Fraccion(0));
            }
        }

        Fraccion a = new Fraccion();
        for (int i = 0; i < Piv.size(); i++) {
            if (Piv.get(i).num != 0) {
                a = Piv.get(i);
                break;
            }
        }

        for (int i = 0; i < Piv.size(); i++) {
            if (Piv.get(i).num != 0) {
                double n = Piv.get(i).num / Piv.get(i).denom;
                double m = a.num / a.denom;
                if (n <= m) {
                    a = Piv.get(i);
                    posicion2 = i;
                }
            }
        }
        int posicionPivoteFinal = posicion2;
        Fraccion resultado = matriz[posicionPivoteFinal][posicion];
        arreglo.add(posicion);
        arreglo.add(posicionPivoteFinal);
        arreglo.add(resultado);
        return arreglo;
    }

    public static Fraccion[][] ConvertidorPivote(ArrayList<Object> Pivote, Fraccion[][] matriz) {
        
        ArrayList<Object> piv = Pivote;

        int fila = (int) piv.get(1);

        Fraccion pivot = (Fraccion) piv.get(2);
        pivot = pivot.inversa(pivot);

        for (int i = 1; i < matriz[fila].length; i++) {
            matriz[fila][i] = matriz[fila][i].producto(matriz[fila][i], pivot);
        }
        return matriz;
    }

    public static Fraccion[][] VariablesEntrantes(ArrayList<Object> Pivote, Fraccion[][] matriz, String objetivo) {
        int fila = (int) Pivote.get(1);
        int columna = (int) Pivote.get(0);
        Fraccion f = new Fraccion(-1);
        if (objetivo.equalsIgnoreCase("maximizacion")) {
            matriz[fila][0] = importante.get(columna).producto(importante.get(columna), f);
            return matriz;
        } else {
            matriz[fila][0] = importante.get(columna);
            return matriz;
        }

    }

    public static ArrayList<Fraccion> guardarprimerafila(Fraccion[][] matriz) {
        ArrayList<Fraccion> primerafila = new ArrayList<>();
        for (int i = 0; i < matriz[0].length; i++) {
            primerafila.add(matriz[0][i]);
        }
        return primerafila;
    }

    public static Fraccion[][] OperacionesFilas(ArrayList<Object> Pivote, Fraccion[][] matriz, int filaOperar) {
        int fila = (int) Pivote.get(1);
        int columna = (int) Pivote.get(0);
        Fraccion multiplicador = new Fraccion();

        ArrayList<Fraccion> filaPivote = new ArrayList<>();
        for (int i = 0; i < matriz[0].length; i++) {
            filaPivote.add(matriz[fila][i]);
        }

        if (matriz[filaOperar][columna].num != 0 && fila != filaOperar) {
            multiplicador = matriz[filaOperar][columna].producto(matriz[filaOperar][columna], new Fraccion(-1));

            for (int i = 1; i < matriz[0].length; i++) {
                matriz[fila][i] = matriz[fila][i].producto(matriz[fila][i], multiplicador);
            }

            for (int i = 1; i < matriz[0].length; i++) {
                matriz[filaOperar][i] = matriz[filaOperar][i].suma(matriz[filaOperar][i], matriz[fila][i]);
            }

            for (int i = 0; i < matriz[0].length; i++) {
                matriz[fila][i] = filaPivote.get(i);
            }
        }
        return matriz;
    }

    public static boolean Continuar(Fraccion[][] matriz, String Objetivo) {
        if (Objetivo.equalsIgnoreCase("maximizacion")) {
            for (int i = 1; i < matriz[0].length - 1; i++) {
                if (matriz[0][i].num < 0) {
                    return true;
                }
            }
        } else {
            for (int i = 1; i < matriz[0].length - 1; i++) {
                if (matriz[0][i].num > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Fraccion[][] Simplificador(Fraccion[][] matriz) {
        Fraccion[][] Final = matriz;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                Final[i][j] = matriz[i][j].simplificar();
            }
        }
        return Final;
    }

    public static ArrayList<Fraccion[][]> Simplex(Fraccion[][] matrizFraccion, String Objetivo) {
        importante = guardarprimerafila(matrizFraccion);
        ArrayList<Fraccion[][]> DatosSimplex = new ArrayList<>();

        DatosSimplex.add(clonar(matrizFraccion));
        if (Verificador(matrizFraccion, Objetivo)) {
            while (Continuar(matrizFraccion, Objetivo)) {
                Datos = Pivote(matrizFraccion, Objetivo);
                ConvertidorPivote(Datos, matrizFraccion);
                VariablesEntrantes(Datos, matrizFraccion, Objetivo);

                for (int i = 0; i < matrizFraccion.length; i++) {
                    OperacionesFilas(Datos, matrizFraccion, i);
                }
                Simplificador(matrizFraccion);
                DatosSimplex.add(clonar(matrizFraccion));
            }
        } else {
            System.out.println();
            System.out.println("NO TIENE SOLUCION");
        }

        return DatosSimplex;
    }

    public static boolean Verificador(Fraccion[][] matriz, String objetivo) {

        if (objetivo.equalsIgnoreCase("Maximizacion")) {
            for (int i = 1; i < matriz[0].length; i++) {
                if (matriz[0][i].num < 0) {
                    return true;
                }
            }
        } else {
            for (int i = 1; i < matriz[0].length; i++) {
                if (matriz[0][i].num > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void guardarMatriz(Fraccion[][] matriz) {
        Fraccion[][] aux = new Fraccion[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                aux[i][j] = matriz[i][j];
            }
        }
        BaseDatos.add(aux);
    }
    
    public static Fraccion[][] clonar(Fraccion[][] in){
        Fraccion [][] retorno = new Fraccion[in.length][];
            for (int i = 0; i < in.length; i++) {
            retorno[i] = in[i].clone();
        }
        return retorno;
    } 
    
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