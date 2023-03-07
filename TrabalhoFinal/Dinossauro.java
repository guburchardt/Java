public class Dinossauro {

    private int idDinossauro;
    // corresponde ao ID do dinossauro. Cada dinossauro possui um ID único.
    private String nomeRaca;
    // corresponde ao nome da raça do dinossauro
    private int tipo;
    // corresponde ao tipo do dinossauro. 1 para carnívoros, 2 para herbívoros.
    private int categoria;
    /*
     * corresponde a categoria do dinossauro. 1 para Pequeno Porte, 2 para Médio
     * Porte, 3 para grande porte.
     */
    private double peso;
    // corresponde ao peso do dinossauro

    // Construtor
    public Dinossauro(int idDinossauro, String nomeRaca, int tipo, int categoria,
            double peso) {
        this.idDinossauro = idDinossauro;
        this.nomeRaca = nomeRaca;
        this.tipo = tipo;
        this.categoria = categoria;
        this.peso = peso;
    }

    // ID Dinossauro
    public int getIdDinossauro() {
        return idDinossauro;
    }

    public void setIdDinossauro(int idDinossauro) {
        this.idDinossauro = idDinossauro;
    }

    // NomeRaça
    public String getNomeRaca() {
        return nomeRaca;
    }

    public void setNomeRaca(String nomeRaca) {
        this.nomeRaca = nomeRaca;
    }

    // Categoria
    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    // Peso
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // Tipo
    public int getTipo() 
    {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

}