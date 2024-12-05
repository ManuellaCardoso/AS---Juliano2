import java.util.ArrayList;
import java.util.Random;

public class JogoTabuleiro {
    private ArrayList<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private Random random;
    private int numeroDeRodadas;

    public JogoTabuleiro(int numeroDeRodadas) {
        this.jogadores = new ArrayList<>();
        this.tabuleiro = new Tabuleiro();
        this.random = new Random();
        this.numeroDeRodadas = numeroDeRodadas;
    }

    public void adicionarJogador(Jogador jogador) {
        if (jogadores.size() < 6) {
            jogadores.add(jogador);
        } else {
            System.out.println("Não é possível adicionar mais jogadores.");
        }
    }

    public void iniciarJogo() {
        if (jogadores.size() < 2) {
            System.out.println("É necessário pelo menos 2 jogadores.");
            return;
        }

        for (int i = 0; i < numeroDeRodadas; i++) {
            for (Jogador jogador : jogadores) {
                jogar(jogador);
            }
        }

        Jogador vencedor = jogadores.get(0);
        for (Jogador jogador : jogadores) {
            if (jogador.getSaldo() > vencedor.getSaldo()) {
                vencedor = jogador;
            }
        }

        System.out.println("Vencedor: " + vencedor.getNome() + " com R$" + vencedor.getSaldo());
    }

    private void jogar(Jogador jogador) {

        int dado = random.nextInt(6) + 1;
        jogador.setPosicao((jogador.getPosicao() + dado) % 4);

        Casa casa = tabuleiro.getCasaAtual();
        System.out.println(jogador.getNome() + " caiu na casa: " + casa.getTipo());

        if (casa.getTipo().equals("Início")) {
            jogador.adicionarSaldo(1000);
        } else if (casa.getTipo().equals("Imposto")) {
            jogador.diminuirSaldo(jogador.getSaldo() * 0.05);
        } else if (casa.getTipo().equals("Restituição")) {
            jogador.adicionarSaldo(jogador.getSaldo() * 0.10);
        } else if (casa.getTipo().equals("Imóvel") && !casa.getImovel().isComprado()) {

            if (jogador.getSaldo() >= casa.getImovel().getPrecoCompra()) {
                jogador.diminuirSaldo(casa.getImovel().getPrecoCompra());
                jogador.adicionarPropriedade(casa.getImovel());
                casa.getImovel().setDono(jogador);
                System.out.println("Parabéns pela compra do imóvel: " + casa.getImovel().getNome());
            } else {
                System.out.println("Saldo insuficiente para comprar o imóvel.");
            }
        } else if (casa.getTipo().equals("Imóvel") && casa.getImovel().isComprado()) {

            if (casa.getImovel().getDono() != jogador) {
                jogador.diminuirSaldo(casa.getImovel().getPrecoAluguel());
                casa.getImovel().getDono().adicionarSaldo(casa.getImovel().getPrecoAluguel());
                System.out.println("Você pagou R$" + casa.getImovel().getPrecoAluguel() + " de aluguel.");
            }
        }

        tabuleiro.avançarCasa();
    }
       // Método main para iniciar o jogo
    public static void main(String[] args) {
        // Criar o jogo com um número de rodadas
        JogoTabuleiro jogo = new JogoTabuleiro(10);

        // Iniciar o jogo
        jogo.iniciarJogo();
    }
}
