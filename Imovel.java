public class Imovel {
    private String nome;
    private double precoCompra;
    private double precoAluguel;
    private Jogador dono;  // Propriedade do imóvel

    // Construtor
    public Imovel(String nome, double precoCompra, double precoAluguel) {
        this.nome = nome;
        this.precoCompra = precoCompra;
        this.precoAluguel = precoAluguel;
        this.dono = null;  // Imóvel não tem dono inicialmente
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(double precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public Jogador getDono() {
        return dono;
    }

    public void setDono(Jogador dono) {
        this.dono = dono;
    }

    public boolean isComprado() {
        return dono != null;
    }

    @Override
    public String toString() {
        return "Imóvel: " + nome + ", Preço de Compra: " + precoCompra + ", Preço de Aluguel: " + precoAluguel;
    }
}


