public class Celda<Valor>{ //Creacion de la clase Celda
    //Atributos de la clase Celda
    private Valor valor;
    private int clave;
    private int estado;
    //Constructor de la clase Celda
    public Celda() {
        this.valor = null;
        this.clave = 0;
        this.estado = 0;
    }
    //Constructor de la clase Celda
    public Celda( int clave,Valor valor) {
        this.valor = valor;
        this.clave = clave;

    }
    //Metodos de la clase Celda: Getters y Setters
    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean equals(Object obj) {
        return  super.equals(obj);
    }
}
