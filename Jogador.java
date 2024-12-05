import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private String nome;
    private double saldo;
    private List<Imovel> propriedades;
    private int rodadasNaPrisao;
    private boolean emPrisão;
    private int posicao;

    public Jogador(String nome, double saldoInicial) {
        this.nome = nome;
        this.saldo = saldoInicial;
        this.propriedades = new ArrayList<>();
        this.rodadasNaPrisao = 0;
        this.emPrisão = false;
    }

    public void adicionarSaldo(double valor) {
        saldo += valor;
    }

    public void diminuirSaldo(double valor) {
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarPropriedade(Imovel imovel) {
        propriedades.add(imovel);
    }

    public List<Imovel> getPropriedades() {
        return propriedades;
    }

    public String getNome() {
        return nome;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    public void setEmPrisão(boolean emPrisão) {
        this.emPrisão = emPrisão;
    }

    public boolean isEmPrisão() {
        return emPrisão;
    }

    public void adicionarRodadaNaPrisão() {
        if (rodadasNaPrisao > 0) {
            rodadasNaPrisao--;
        }
    }
}

