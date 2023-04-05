
public class Pruebas {



    public static void main(String[] args) {
        // Crear una tabla hash
        Hash<Integer> hash = new Hash<>(4, 0.75f);

        Celda<Integer> celda = new Celda<>(1, 69);
        // Agregar un valor a la tabla hash
        hash.insertar(1, 69);

        // Obtener un valor de la tabla hash
        int valor = hash.get(0);
        System.out.println(valor);  // Imprime "Hola"
    }
}


