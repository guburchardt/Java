public class Loja
{
    //deve conter o estoque
    //conter informacoes sobre a movimentacao financeira
    //nao pode conter mecasnismo de entrada(e.g. Scanner).
    private int nProdutos;
    private Produto [] listaPC = new Produto[100];
    private int qtdVendas;
    private int qtdProdutosVendidos;
    private double valorTotalVendas;
    
    public boolean criarProduto(String name, double price, int quantity)
    {
        if(nProdutos<100){
            listaPC[nProdutos] = new Produto(name, price, quantity);
            nProdutos++;
            return true;
        }
        else
            return false;
    }
    
    public void listarProdutosDisponiveis()
    {
        for(int pos= 0; pos<nProdutos; pos++)
        {
            if(listaPC[pos].getQuantidade()>0)
            System.out.printf("[%d]Produto_%02d (%s): R$ %.2f\n",listaPC[pos].getQuantidade(),pos,listaPC[pos].getnomeProduto(), listaPC[pos].getPreco());
        }
    }
    
    public void listarProdutos()
    {
        if(nProdutos==0)
            System.out.println("Nao ha contas cadastradas");
        else
        {
            System.out.println("Ha "+nProdutos+" produtos cadastrados");
            for(int pos=0; pos<nProdutos;  pos++)
                System.out.printf("[%d]Produto_%02d (%s): R$ %.2f\n",listaPC[pos].getQuantidade(),pos,listaPC[pos].getnomeProduto(), listaPC[pos].getPreco());
        }
    }
    
    public void adicionarProduto(String name1, int quantity1){
        for(int pos= 0; pos<nProdutos; pos++){
            if(name1.equals(listaPC[pos].getnomeProduto())){
               int qtdExistente= listaPC[pos].getQuantidade();
               qtdExistente =  qtdExistente + quantity1;
               listaPC[pos].setQuantidade(qtdExistente);
            }
        }
    }
    
    public void listagemProdutos(int opcao3)
    {
        switch(opcao3)
                        {
                            case 1:
                                listarProdutos();
                                break;
                            case 2:
                                for(int pos= 0; pos<nProdutos; pos++)
                                {
                                    if(listaPC[pos].getQuantidade()>0)
                                        System.out.printf("[%d]Produto_%02d (%s): R$ %.2f\n",listaPC[pos].getQuantidade(),pos,listaPC[pos].getnomeProduto(), listaPC[pos].getPreco());
                                }
                                break;
                            case 3:
                                for(int pos= 0; pos<nProdutos; pos++)
                                {
                                    if(listaPC[pos].getQuantidade()==0)
                                        System.out.printf("[%d]Produto_%02d (%s): R$ %.2f\n",listaPC[pos].getQuantidade(),pos,listaPC[pos].getnomeProduto(), listaPC[pos].getPreco());
                                }
                                break;
                            }
    }
    //compra o produto, com loop para verificar todos 
    public void compraProduto(String name2, int quantity2){
        for(int pos= 0; pos<nProdutos; pos++){
            if(name2.equals(listaPC[pos].getnomeProduto())){
               
               int qtdExistente= listaPC[pos].getQuantidade();
               if(quantity2 <= qtdExistente)
               {
                   qtdExistente =  qtdExistente - quantity2;
                   listaPC[pos].setQuantidade(qtdExistente);
                   valorTotalVendas= listaPC[pos].getPreco() * quantity2 + valorTotalVendas;
                   qtdProdutosVendidos= qtdProdutosVendidos + quantity2;
                   qtdVendas++;
                   System.out.println("Compra confirmada");
                }
                else{
                    System.out.println("Estoque insuficiente para sua compra");
                }
            }
        }
    }
    // consultar quanttidade de produtos vendidos
    public int getProdutosVendidos(){
        return qtdProdutosVendidos;
    }
    //consultar qtd vendas
    public int getVendas(){
        return qtdVendas;
    }
    //consultar valor total das vendas
    public double getValorVendas(){
        return valorTotalVendas;
    }
    
    
}
