public class Casa {
    private String tipo;
    private Imovel imovel;
    private Casa proximaCasa;

    // Construtores
    public Casa(String tipo) {
        this.tipo = tipo;
        this.imovel = null;
        this.proximaCasa = null;
    }

    public Casa(String tipo, Imovel imovel) {
        this.tipo = tipo;
        this.imovel = imovel;
        this.proximaCasa = null;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Casa getProximaCasa() {
        return proximaCasa;
    }

    public void setProximaCasa(Casa proximaCasa) {
        this.proximaCasa = proximaCasa;
    }
}

