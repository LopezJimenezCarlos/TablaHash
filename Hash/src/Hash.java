public class Hash<Valor> {


    Celda<Valor>[] contenedor;
    int numElementos;
    float alfaMaximo ;




    public Hash() {
        contenedor = new Celda[7];
        for(int i = 0; i<7; i++){
            contenedor[i] = new Celda<Valor>();
        }
        this.numElementos = 7;
        this.alfaMaximo = 0.8f;

    }

    public Hash(int capacidad) {
        numElementos = capacidad;
        this.contenedor = new Celda[capacidad];
        for(int i = 0; i<capacidad; i++){
            contenedor[i] = new Celda<Valor>();
        }

    }

    public Hash(int capacidad, float alfaMaximo) {

        numElementos = capacidad;
        this.alfaMaximo = alfaMaximo;
        this.contenedor = new Celda[capacidad];
        for(int i = 0; i<capacidad; i++){
            contenedor[i] = new Celda<Valor>();
        }

    }

    //FUNCIONES PÚBLICAS
    public void insertar(int clave, Valor v) {
        int colision = 0;
        int indice = funcionHash(clave, colision);
        if (factorCarga() >= alfaMaximo) {
            redimensionar();
        }
        while (contenedor[indice].getEstado() == 1) {
            colision++;
            indice = funcionHash(clave, colision);
        }
        contenedor[indice] = new Celda<>(clave, v);
        contenedor[indice].setEstado(1);
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

    public Valor get(int clave) {
        int colision = 0;
        int indice = funcionHash(clave, colision);
        while (contenedor[indice] != null && colision < contenedor.length) {
            if (contenedor[indice].getEstado() == 1 && contenedor[indice].getClave() == clave) {
                return contenedor[indice].getValor();
            }
            colision++;
            indice = funcionHash(clave, colision);
        }
        return null;
    }

    public  boolean esVacia() {
        boolean vacia = true;
        for (int i = 0; i < contenedor.length; i++) {
            if (contenedor[i].getEstado() == 1) {
                vacia = false;
            }

        }return vacia;
    }
    public  float getAlfa(){
        return alfaMaximo;
    }

    public  void setAlfa(float nuevoAlfa){
        alfaMaximo = nuevoAlfa;
    }


    public  int getNumElementos(){
        int contador = 0;
        for (int i=0; i<contenedor.length; i++){
            if (contenedor[i].getEstado() == 1){
                contador++;
            }
        }return contador;
    }
    public  float factorCarga(){
       float nfloat=getNumElementos();
        return nfloat/numElementos;
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
    private  int funcionHash(int clave, int colision){
        int h1 = hash1(clave);
        int h2 = hash2(clave, colision);
        return (h1+h2)%contenedor.length;
    }
    private  int hash1(int clave){
        int h1 = clave % contenedor.length;
        return h1;
    }
    private static int hash2(int clave, int colision){
        int h2 = colision*(7-(clave % 7));
        return h2;
    }

    public  void redimensionar(){
        int nuevoTamano = siguientePrimo(getNumElementos());
        Celda[] nuevoContenedor = new Celda[nuevoTamano];
        for (int i=0; i<contenedor.length; i++){
            if (contenedor[i].getEstado() == 1){
                int colision = 0;
                int indice = funcionHash(contenedor[i].getClave(), colision);
                if (nuevoContenedor[indice] == null) {
                    nuevoContenedor[indice] = new Celda<>(contenedor[i].getClave(), contenedor[i].getValor());
                    nuevoContenedor[indice].setEstado(1);
                } else {
                    while (nuevoContenedor[indice] != null) {
                        colision++;
                        indice = funcionHash(contenedor[i].getClave(), colision);
                    }
                    nuevoContenedor[indice] = new Celda<>(contenedor[i].getClave(), contenedor[i].getValor());
                    nuevoContenedor[indice].setEstado(1);
                }
            }
        }
        contenedor = nuevoContenedor;
        int nuevoNumElementos = getNumElementos();
        nuevoNumElementos = nuevoTamano;
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
