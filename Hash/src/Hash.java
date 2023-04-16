public class Hash<Valor> { //Creacion de la clase Hash
    //Atributos de la clase Hash
    Celda<Valor>[] contenedor;
    int numElementos;
    float alfaMaximo ;
    //Constructores de la clase Hash
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
        for(int i = 0;  i<capacidad; i++){
            contenedor[i] = new Celda<Valor>();
        }
        this.alfaMaximo = 0.8f;
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
    public void insertar(int clave, Valor v) { //Funcion que inserta un elemento en el Hash
        int colision = 0;
        int indice = funcionHash(clave, colision);
        if (factorCarga() >= alfaMaximo) { //Si el factor de carga es mayor o igual al alfa maximo, se redimensiona el Hash
            redimensionar();
        }
        int cont=0;
        int equal=0;

        while (contenedor[indice].getEstado() == 1) { //Si la posicion del Hash esta ocupada, se realiza una colision
            colision++;
            indice = funcionHash(clave, colision);
        }

        do {
            if(contenedor[cont].getValor()==v){ //Si el elemento ya existe, no se inserta
                //System.out.println("El elemento ya existe");
                equal=1;

            }else {
                cont++;
            }
        }while(cont < contenedor.length && equal != 1); //Se recorre el Hash para comprobar si el elemento ya existe

        if (equal==0) { //Si el elemento no existe, se inserta
            contenedor[indice] = new Celda<Valor>(clave, v); //Se crea una nueva celda con el elemento
            contenedor[indice].setEstado(1); //Se cambia el estado de la celda a ocupada
        }
    }

    public  boolean borrar(int clave) { //Funcion que borra un elemento del Hash
        boolean borrado = false;
        for (int i = 0; i < contenedor.length; i++) { //Se recorre el Hash
            if (contenedor[i].getClave() == clave) { //si la clave del elemento es igual a la clave del elemento a borrar, se borra
                contenedor[i].setEstado(-1); //Se cambia el estado de la celda a borrada

                borrado = true;
            }
        }return borrado;
    }

    public Valor get(int clave) { //Funcion que devuelve el elemento del Hash
        int colision = 0;
        int indice = funcionHash(clave, colision);
        Valor Aux = null;
        while (contenedor[indice] != null && colision < contenedor.length) { //Se recorre el Hash
            if (contenedor[indice].getEstado() == 1 && contenedor[indice].getClave() == clave) { //Si la celda esta ocupada y la clave del elemento es igual a la clave del elemento a buscar, se devuelve el elemento
                Aux=  contenedor[indice].getValor(); //Se devuelve el elemento
            }
            colision++;
            indice = funcionHash(clave, colision);
        }
        return Aux;
    }

    public  boolean esVacia() { //Funcion que comprueba si el Hash esta vacio
        boolean vacia = true;
        for (int i = 0; i < contenedor.length; i++) { //Se recorre el Hash
            if (contenedor[i].getEstado() == 1) { //Si la celda esta ocupada, el Hash no esta vacio
                vacia = false;
            }

        }return vacia;
    }
    public  float getAlfa(){
        return alfaMaximo;
    } //Funcion que devuelve el alfa maximo

    public  void setAlfa(float nuevoAlfa){
        alfaMaximo = nuevoAlfa;
    } //Funcion que cambia el alfa maximo

    public  int getNumElementos(){ //Funcion que devuelve el numero de elementos del Hash
        int contador = 0;
        for (int i=0; i<contenedor.length; i++){ //Se recorre el Hash
            if (contenedor[i].getEstado() == 1){ //Si la celda esta ocupada, se suma 1 al contador
                contador++;
            }
        }return contador;
    }

    public  float factorCarga(){ //Funcion que devuelve el factor de carga
        float nfloat = contenedor.length; //Se convierte el numero de elementos del Hash a float
        return getNumElementos()/nfloat; //Se devuelve el factor de carga
    }

    //FUNCIONES PRIVADAS
    private  boolean hayColision(int indice){ //Funcion que comprueba si hay colision
        boolean colosion = false;
        for (int i=0; i<contenedor.length; i++){ //Se recorre el Hash
            if (contenedor[i].getEstado() == 1) { //Si la celda esta ocupada, hay
                colosion = true;

            }
        }return colosion;

    }

    private  int funcionHash(int clave, int colision){ //Funcion que devuelve el indice del Hash
        int h1 = hash1(clave); //Se calcula el primer hash
        int h2 = hash2(clave, colision); //Se calcula el segundo hash
        return (h1+h2)%(contenedor.length); //Se devuelve el indice del Hash
    }
    private  int hash1(int clave){ //Funcion que calcula el primer hash
        int h1 = clave % contenedor.length;
        return h1;
    }
    private  int hash2(int clave, int colision){ //Funcion que calcula el segundo hash
        int h2 = colision*(7-(clave % 7));
        return h2;
    }

    public  void redimensionar(){ //Funcion que redimensiona el Hash

        int nuevoTamano = siguientePrimo(contenedor.length); //Se calcula el nuevo tamaño del Hash
        Celda<Valor>[] nuevoContenedor = new Celda[nuevoTamano]; //Se crea un nuevo Hash con el nuevo tamaño

        for(int j = 0; j<nuevoTamano; j++){ //Se inicializa el nuevo Hash
            nuevoContenedor[j] = new Celda<Valor>(); //Se crea una nueva celda
            nuevoContenedor[j].setEstado(0); //Se cambia el estado de la celda a vacia
        }
        for (int i=0; i<contenedor.length; i++){ //Se recorre el Hash
            if (contenedor[i].getEstado() == 1){ //Si la celda esta ocupada, se inserta en el nuevo Hash
                int colision = 0; //Se inicializa la variable colision
                int indice = funcionHash(contenedor[i].getClave(), colision); //Se calcula el indice del nuevo Hash
                if (nuevoContenedor[indice].getEstado() == 0) { //Si la celda esta vacia, se inserta el elemento
                    nuevoContenedor[indice] = new Celda<>(contenedor[i].getClave(), contenedor[i].getValor()); //Se crea una nueva celda
                    nuevoContenedor[indice].setEstado(1); //Se cambia el estado de la celda a ocupada
                } else { //Si la celda esta ocupada, se resuelve la colision
                    while (nuevoContenedor[indice].getEstado() ==1 ) {
                        colision++;
                        indice = funcionHash(contenedor[i].getClave(), colision); //Se calcula el indice del nuevo Hash

                    }
                    nuevoContenedor[indice] = new Celda<>(contenedor[i].getClave(), contenedor[i].getValor()); //Se crea una nueva celda
                    nuevoContenedor[indice].setEstado(1); //Se cambia el estado de la celda a ocupada
                }
            }
        }
        contenedor = nuevoContenedor;
        numElementos = nuevoTamano;
    }

    public static boolean esPrimo(int numero) { //Funcion que comprueba si un numero es primo
        boolean primo = true;
        if (numero <= 1) { //Se comprueba si el numero es menor o igual que 1
           primo= false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) { //Se comprueba si el numero es divisible entre algun numero menor que su raiz cuadrada
            if (numero % i == 0) {
                primo = false;
            }
        }
        return true;
    }

    public static int siguientePrimo(int numero) { //Funcion que calcula el siguiente primo
        int doble = numero * 2; //Se multiplica el numero por 2
        int siguientePrimo = doble + 1; //Se suma 1 al doble del numero

        while (!esPrimo(siguientePrimo)) { //Se comprueba si el siguiente primo es primo
            siguientePrimo++;
        }

        return siguientePrimo;
    }
    public String toString() { //Funcion que devuelve el Hash en forma de String
        StringBuilder tablaFormat = new StringBuilder(); //Se crea un StringBuilder
        tablaFormat.append(String.format("TABLA HASH RESULTANTE (N = %d) (TAM = %d) (α = %f) (αmax = %f)\n", contenedor.length, numElementos, factorCarga(), alfaMaximo)); //Se añade la cabecera
        tablaFormat.append("|| INDEX || ESTADO | CLAVE |   VALOR   ||\n");
        int pos = 0;
        for (Celda<Valor> c: contenedor) { //Se recorre el Hash
            tablaFormat.append(String.format("||%s ||%s |%s |%s ||\n",
                            String.format("%1$"+6+"d", pos),
                            String.format("%1$"+7+"d", c.getEstado()),
                            String.format("%1$"+6+"d", c.getClave()),
                            String.format("%1$"+10+"s", String.valueOf(c.getValor()))));
            pos++;
        }
        return tablaFormat.toString();
    }
}