
public class Pruebas {



    public static void main(String[] args) {
      //Ejemplo de uso de la clase Hash

        Hash<String> hash = new Hash<>(7, 0.8f);
        hash.insertar(1, "Hola");
        hash.insertar(2, "Mundo");
        hash.insertar(3, "Cruel");
        hash.insertar(4, "!");
        hash.insertar(5, "!");
        hash.insertar(6, "!");
       hash.borrar(3);


        System.out.println(hash.get(1));
        System.out.println(hash.get(2));
        System.out.println(hash.get(3));
        System.out.println(hash.get(4));
    }
}


