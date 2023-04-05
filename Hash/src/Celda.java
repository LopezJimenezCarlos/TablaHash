public class Celda<Valor>{

   private Valor valor;
    private int clave;
    private int estado;

    public Celda() {
        this.valor = null;
        this.clave = 0;
        this.estado = 0;
    }

    public Celda( int clave,Valor valor) {
        this.valor = valor;
        this.clave = clave;

    }
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
