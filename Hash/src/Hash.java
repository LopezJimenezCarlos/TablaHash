public class Hash<Valor> {


    Celda<Valor>[] contenedor;
    int capacidad;
    float alfaMaximo;

    public static int n = 7;

    public Hash (){
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
    public void insertar(int clave, Valor v){

    }
    public static void borrar(int clave){

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
    public static boolean esVacia(){
        return true;
    }
    public static float getAlfa(){
        return 0;
    }

    public static void setAlfa(float puta){

    }
    public static float getAlfa(int clave){
        return 0;
    }
    public static int getNumElementos(){
        return 0;
    }
    public static float factorCarga(){
        return 0;
    }


    //FUNCIONES PRIVADAS

    private static boolean hayColision(int indice){

        return true;
    }
    private static int funcionHash(int clave, int colision){
        int h1 = has1(clave);
        int h2 = has2(clave, colision);
        return h1+h2;
    }
    private static int has1(int clave){
        int h1 = clave % n;
        return h1;
    }
    private static int has2(int clave, int colision){
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
