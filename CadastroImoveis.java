import java.util.ArrayList;

public class CadastroImoveis {
    private ArrayList<Imovel> listaImoveis;

    public CadastroImoveis() {
        listaImoveis = new ArrayList<>();
    }

    
    public void cadastrarImovel(String nome, double precoCompra, double precoAluguel) {
        Imovel imovel = new Imovel(nome, precoCompra, precoAluguel);
        listaImoveis.add(imovel);
        System.out.println("Imóvel " + nome + " cadastrado com sucesso!");
    }

    public void listarImoveis() {
        if (listaImoveis.isEmpty()) {
            System.out.println("Não há imóveis cadastrados.");
        } else {
            for (Imovel imovel : listaImoveis) {
                System.out.println(imovel);
            }
        }
    }

    public void atualizarImovel(String nome, double novoPrecoCompra, double novoPrecoAluguel) {
        for (Imovel imovel : listaImoveis) {
            if (imovel.getNome().equals(nome)) {
                imovel.setPrecoCompra(novoPrecoCompra);
                imovel.setPrecoAluguel(novoPrecoAluguel);
                System.out.println("Imóvel " + nome + " atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Imóvel não encontrado!");
    }

    public void removerImovel(String nome) {
        for (Imovel imovel : listaImoveis) {
            if (imovel.getNome().equals(nome)) {
                listaImoveis.remove(imovel);
                System.out.println("Imóvel " + nome + " removido com sucesso!");
                return;
            }
        }
        System.out.println("Imóvel não encontrado!");
    }

    public boolean validarQuantidadeImoveis() {
        if (listaImoveis.size() < 10) {
            System.out.println("Erro: É necessário cadastrar pelo menos 10 imóveis.");
            return false;
        }
        return true;
    }

    public ArrayList<Imovel> getListaImoveis() {
        return listaImoveis;
    }
}
