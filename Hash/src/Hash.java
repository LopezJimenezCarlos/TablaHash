public class Hash<Valor> {


    Celda<Valor>[] contenedor;
    int capacidad;
    float alfaMaximo;


    public static int n = 7;

    public Hash() {
        this.contenedor = new Celda[7];
        this.capacidad = 0;
        this.alfaMaximo = 0.75f;
    }

    public Hash(int capacidad) {
        this.capacidad = capacidad;

    }

    public Hash(int capacidad, float alfaMaximo) {

        this.capacidad = capacidad;
        this.alfaMaximo = alfaMaximo;
    }

    //FUNCIONES PÚBLICAS
    public void insertar(int clave, Valor v) {
        int colision = 0;
        int indice = funcionHash(clave, colision);
        if (contenedor[indice] == null) {
            contenedor[indice] = new Celda<>(clave, v);
            contenedor[indice].setEstado(1);
        } else {
            while (contenedor[indice] != null) {
                colision++;
                indice = funcionHash(clave, colision);
            }
            contenedor[indice] = new Celda<>(clave, v);
            contenedor[indice].setEstado(1);
        }
    }


    public  boolean borrar(int clave) {
        boolean borrado = false;
        for (int i = 0; i < contenedor.length; i++) {
            if (contenedor[i].getClave() == clave) {
                contenedor[i].setEstado(0);
                borrado = true;
            }
        }return borrado;
    }

    public Valor get(int clave){
        Valor value = null;
        for (int i=0; i<contenedor.length; i++){
            if (contenedor[i].getClave() == clave){
                value =contenedor[i].getValor();
                break;
            }else {
                return (Valor) Integer.valueOf(1);
            }
        }
        return value ;
    }
    public  boolean esVacia() {
        boolean vacia = true;
        for (int i = 0; i < contenedor.length; i++) {
            if (contenedor[i].getEstado() == 1) {
                vacia = false;
            }

        }return vacia;
    }
    public static float getAlfa(){
        return 0;
    }

    public static void setAlfa(float puta){

    }
    public static float getAlfa(int clave){
        return 0;
    }
    public  int getNumElementos(){
        int contador = 0;
        for (int i=0; i<contenedor.length; i++){
            if (contenedor[i].getEstado() == 1){
                contador++;
            }
        }return contador;
    }
    public static float factorCarga(){
        return 0;
    }


    //FUNCIONES PRIVADAS

    private  boolean hayColision(int indice){
        boolean colosion = false;
        for (int i=0; i<contenedor.length; i++){
            if (contenedor[i].getEstado() == 1) {
                colosion = true;
                break;
            }
        }return colosion;

    }
    private static int funcionHash(int clave, int colision){
        int h1 = hash1(clave);
        int h2 = hash2(clave, colision);
        return h1+h2;
    }
    private static int hash1(int clave){
        int h1 = clave % n;
        return h1;
    }
    private static int hash2(int clave, int colision){
        int h2 = colision*(7-(clave % 7));
        return h2;
    }

    public static void redimensionar(){

    }
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int siguientePrimo(int numero) {
        int doble = numero * 2;
        int siguientePrimo = doble + 1;

        while (!esPrimo(siguientePrimo)) {
            siguientePrimo++;
        }

        return siguientePrimo;
    }

}
