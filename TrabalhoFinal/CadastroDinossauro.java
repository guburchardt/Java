import java.util.Arrays;

public class CadastroDinossauro {
    private Dinossauro[] cadastroDinossauros;
    private int proximaPosicao;
    private int ppCarnivoros = 0;
    private int mpCarnivoros = 0;
    private int gpCarnivoros = 0;
    private int ppHerbivoros = 0;
    private int mpHerbivoros = 0;
    private int gpHerbivoros = 0;
    private int nuloSave = 0;

    public CadastroDinossauro() {
        // Trocar para 150, pois erro java.lang.ArrayIndexOutOfBoundsException: Index 50
        // out of bounds for lenght 50
        cadastroDinossauros = new Dinossauro[150];
        for (int i = 0; i < cadastroDinossauros.length; i++)
            cadastroDinossauros[i] = new Dinossauro(0, " ", 0, 0, 0);
        proximaPosicao = -1; // evitar “out of range” nos metodos
    }

    public boolean adicionarDinossauro(Dinossauro dino) {
        if (proximaPosicao + 1 < cadastroDinossauros.length) { // pq comeca com -1
            proximaPosicao++;
            cadastroDinossauros[proximaPosicao] = dino;

            return true;
        } else {
            return false;
        }
    }

    public Dinossauro pesquisarDinossauro(int id) {
        for (int i = 0; i < proximaPosicao; i++) {
            if (cadastroDinossauros[i].getIdDinossauro() == id) {
                return cadastroDinossauros[i];
            }
        }
        return null;
    }

    public boolean removerDinossauro(int id) {
        for (int i = 0; i < proximaPosicao; i++) {
            if (cadastroDinossauros[i].getIdDinossauro() == id) {
                cadastroDinossauros[i] = null;
                for (int j = i; j < proximaPosicao; j++) {
                    cadastroDinossauros[j] = cadastroDinossauros[j + 1];
                }
                cadastroDinossauros[proximaPosicao] = null;
                proximaPosicao--;
                return true;
            }

        }
        return false;
    }
    //Obtem os tipos e categorias para usar no metodo qntAnimais
    public void qntCatTipo() {
        for (int i = 0; i < cadastroDinossauros.length; i++) 
        {
            if (cadastroDinossauros[i].getCategoria() == 1 && cadastroDinossauros[i].getTipo() == 1)
                ppCarnivoros++;
            else if (cadastroDinossauros[i].getCategoria() == 2 && cadastroDinossauros[i].getTipo() == 1)
                mpCarnivoros++;
            else if (cadastroDinossauros[i].getCategoria() == 3 && cadastroDinossauros[i].getTipo() == 1)
                gpCarnivoros++;
            else if (cadastroDinossauros[i].getCategoria() == 1 && cadastroDinossauros[i].getTipo() == 2)
                ppHerbivoros++;
            else if (cadastroDinossauros[i].getCategoria() == 2 && cadastroDinossauros[i].getTipo() == 2)
                mpHerbivoros++;
            else if (cadastroDinossauros[i].getCategoria() == 3 && cadastroDinossauros[i].getTipo() == 2)
                gpHerbivoros++;
            else if (cadastroDinossauros[i].getCategoria () == 0 && cadastroDinossauros[i].getTipo() == 0)
                nuloSave++;
            else
                nuloSave++;
            
            
        }
    }
    //Relatorio StringFormat
    public String qntAnimais() {
        return String.format("Carnívoros: PP: %d, MP: %d, GP: %d.\nHerbívoros: PP: %d, MP: %d, GP: %d \n", ppCarnivoros, 
        mpCarnivoros, gpCarnivoros, ppHerbivoros, mpHerbivoros, gpHerbivoros);
    }

    // Mostra qual o dinossauro mais pesado de acordo com a categoria e tipo
    public Dinossauro pesoPesado(int categoria, int tipo) {
        double maior = 0;
        for (int i = 0; i < cadastroDinossauros.length; i++) {
            if ((cadastroDinossauros[i].getCategoria() == categoria) && (cadastroDinossauros[i].getTipo() == tipo)) {
                if (maior < cadastroDinossauros[i].getPeso()) {
                    maior = cadastroDinossauros[i].getPeso();
                }

                if (cadastroDinossauros[i].getPeso() == maior) {
                    return cadastroDinossauros[i];
                }

            }

        }
        return null;
    }

    // Calcula a quantidade de que se deve comprar no mês
    public double qntCarne() {
        double carne = 0;
        for (int i = 0; i < proximaPosicao; i++) {
            if (cadastroDinossauros[i].getCategoria() == 1 && cadastroDinossauros[i].getTipo() == 1) {
                carne += cadastroDinossauros[i].getPeso() * 0.10;
            } else if (cadastroDinossauros[i].getCategoria() == 2 && cadastroDinossauros[i].getTipo() == 1) {
                carne += cadastroDinossauros[i].getPeso() * 0.15;
            } else if (cadastroDinossauros[i].getCategoria() == 3 && cadastroDinossauros[i].getTipo() == 1) {
                carne += cadastroDinossauros[i].getPeso() * 0.20;
            }
        }
        return carne * 30;
    }

    // Calcula o tempo de fuga se é seguro ou não
    public boolean tempoFugir(double dinossauroBunker, double pessoaBunker, double velocidadeMedia) {
        double tempoPessoa = pessoaBunker / 20;
        double tempoDino = dinossauroBunker / velocidadeMedia;

        if (tempoPessoa > tempoDino)
            return true;
        else
            return false;
    }

    // Retorna a Zona Perigosa do parque de acordo com o tipo
    public String zonaPerigosa(int[][] terreno) {
        String N = "Norte";
        String S = "Sul";

        int Sul = 0;
        int Norte = 0;

        for (int l = 0; l < terreno.length; l++)
            for (int c = 0; c < terreno[l].length; c++)
                if (cadastroDinossauros[l].getTipo() == 0)
                    terreno[l][c] = 0;
                else
                    terreno[l][c] = cadastroDinossauros[l].getTipo();

        for (int l = 0; l < terreno.length; l++)
            for (int c = 0; c < terreno[l].length; c++) {
                if (terreno[l][c] == 1 && l > terreno.length / 2)
                    Sul++;
                else if (terreno[l][c] == 1 && l < terreno.length / 2)
                    Norte++;
            }

        if (Norte > Sul)
            return N;
        else
            return S;

    }

    // Puxa os nomes
    public String[] getNomes(String[] secundaria) {
        for (int l = 0; l < cadastroDinossauros.length; l++)
            secundaria[l] = cadastroDinossauros[l].getNomeRaca().toLowerCase();

        return secundaria;
    }

    // Ordena em ordem alfabética
    public String[] sortAlfabetica(String[] nome) {
        Arrays.sort(nome);
        return nome;
    }

    // Conta as vogais de uma String
    public int contadorVogais(String nome) {
        int contarVogais = 0;
        for (int j = 0; j < nome.length(); j++) {
            char c = nome.charAt(j);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                contarVogais++;
            }

        }
        return contarVogais;
    }

    // Ordenação por vogais (relatorio 6)
    // Créditos desse método aos colegas Maurício e Marcelo
    public void sortVogais(String[] nome) {
        int numMax = 0;
        int contador = 0;
        int contador2 = 0;

        for (int i = 0; i < nome.length; i++) {
            if (contadorVogais(nome[i]) > numMax) {
                numMax = contadorVogais(nome[i]);
            }
            contador++;
        }
        String[] aux = new String[contador];
        for (int j = 0; j < nome.length; j++) {
            if (contadorVogais(nome[j]) == numMax) {
                aux[contador2] = nome[j];
                contador2++;
            }
        }
        if (contador2 > 1) {
            Arrays.sort(aux);
        }
        for (int z = 0; z < contador2; z++) {
            System.out.println(aux[z]);
        }

    }

}