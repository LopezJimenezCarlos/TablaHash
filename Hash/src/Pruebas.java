
public class Pruebas {



    public static void main(String[] args) {
      //Ejemplo de uso de la clase Hash

        Hash<String> hash = new Hash<>(7, 0.8f);

        hash.insertar(1, "Hola");
        System.out.println( hash.get(1));
        hash.insertar(2, "Hola");
        hash.insertar(3, "Cruel");
        hash.insertar(4, "33");
        hash.insertar(5, "movil");
        hash.insertar(6, "pantalla");
        hash.insertar(7, "34");
        hash.insertar(8, "39");



      /*  System.out.println("Tabla Hash:");
        System.out.println("En la clave 1 esta: "+hash.get(1));
        System.out.println("En la clave 2 esta: "+hash.get(2));
        System.out.println("En la clave 3 esta: "+hash.get(3));
        System.out.println("En la clave 4 esta: "+hash.get(4));
        System.out.println("En la clave 5 esta: "+hash.get(5));
        System.out.println("En la clave 6 esta: "+hash.get(6));
        System.out.println("En la clave 7 esta: "+hash.get(7));
        System.out.println("En la clave 8 esta: "+hash.get(8));
        System.out.println("En la clave 9 esta: "+hash.get(9));
        System.out.println("En la clave 10 esta: "+hash.get(10));
        System.out.println("En la clave 11 esta: "+hash.get(11));*/

        System.out.println(hash.toString());

    }
}


