public class Tabuleiro {

    private Casa casaInicial;
    private Casa casaAtual;

    public Tabuleiro() {
        // Criando as casas do tabuleiro
        Casa inicio = new Casa("Início");
        Casa imposto = new Casa("Imposto");
        Casa restituição = new Casa("Restituição");
        Casa casaImovel = new Casa("Imóvel", new Imovel("Casa do Bosque", 200000, 1100));

        // Criando a estrutura circular
        inicio.setProximaCasa(imposto);
        imposto.setProximaCasa(restituição);
        restituição.setProximaCasa(casaImovel);
        casaImovel.setProximaCasa(inicio); // Fecha a lista circular

        this.casaInicial = inicio;
        this.casaAtual = inicio; // Jogo começa na casa "Início"
    }

    public Casa getCasaAtual() {
        return casaAtual;
    }

    public void avançarCasa() {
        casaAtual = casaAtual.getProximaCasa();
    }

    public Casa getCasaInicial() {
        return casaInicial;
    }
}
