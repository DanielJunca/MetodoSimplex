package Class1.Modelo;

public class Fraccion {

    int num;
    int denom;

    public Fraccion() {
        num = 0;
        denom = 1;
    }

    //Constructor para fracciones enteras
    public Fraccion(int num) {
        this.num = num;
        denom = 1;
    }

    //Constructor general
    public Fraccion(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }

    public static Fraccion inversa(Fraccion a) {
        if (a.num >= 0) {
            return new Fraccion(a.denom, a.num);
        } else {
            return new Fraccion(-a.denom, -a.num);
        }
    }

    public static Fraccion producto(Fraccion a, Fraccion b) {

        Fraccion c = new Fraccion();

        c.num = a.num * b.num;

        c.denom = a.denom * b.denom;

        return c;
    }

    public static Fraccion cociente(Fraccion a, Fraccion b) {

        /* Para calcular el cociente se obtiene la fraccion producto de la primera
     fraccion,  por la inversa de la segunda fraccion */
        return producto(a, inversa(b));
    }

    public static Fraccion suma(Fraccion a, Fraccion b) {

        /* Se devuelve una fraccion y los argumentos son fracciones */
 /* Se inicializa primero la fraccion que va a contener el resultado */
        Fraccion c = new Fraccion();

        c.num = (a.num * b.denom) + (a.denom * b.num);

        c.denom = a.denom * b.denom;

        return c;
    }

    private int mcd() {

        /* El mcd de numerador y denominador es una funcion privada de la clase
     fraccion que se obtiene por el metodo de Euler y que nos sirve para la
     simplificacion de fracciones */
        int u = Math.abs(num); //Se usa valor absoluto por si hay negativos
        int v = Math.abs(denom);

        if (v == 0) {
            return u;
        }

        int r;

        /* "r" va a ser el resto de cada division */
        while (v != 0) {

            r = u % v;
            u = v;
            v = r;
        }

        return u;
    }

    public Fraccion simplificar() {

        /* Se devuelve una nueva fraccion con sus terminos divididos por el
     mcd de numerador y denominador */
        return new Fraccion(num / mcd(), denom / mcd());
    }

         public String toString(){
     
  /* Se devuelve una cadena con el numerador y denominador y en medio
     el signo "/" de division */ 
         
         if(denom==1) return " "+num;
         
         else return num+"/"+denom;
     }
     

}
