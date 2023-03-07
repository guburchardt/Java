    import java.util.Scanner;
    public class App2 {        
        public static void main(String[] args){
            CadastroDinossauro cd = new CadastroDinossauro();
            //Definindo Scanner
            Scanner entrada = new Scanner (System.in);

            //Variáveis
            int opcao1 = 0;
            String decisao = " ";
            boolean variavel;
            int ferramentaInt;
            int tipo;
            int categoria;
            double distanciaDinoBunker;
            double distanciaPessoaBunker;
            double VelocidadeMediaDino;
            int [][] VetTerreno = new int [150][150];
            String [] nomes = new String [150];
            do
            {
                opcao1 = menu();
                switch (opcao1)
                {
                    case 1:
                        do
                        {
                            cd.adicionarDinossauro(adicionarDino());
                            System.out.println("Deseja adicionar um novo Dinossauro? Digite S OU N");
                            decisao = entrada.nextLine();
                            if(decisao.toLowerCase().equals("s"))
                            {
                                variavel = true;
                            }
                            else
                            {
                                variavel = false;;
                            }
                        } while(variavel==true);
                        break;
                    case 2:
                        System.out.println("Digite o ID do dinossauro que deseja pesquisar");
                        ferramentaInt = entrada.nextInt();
                        pesquisarDino(cd, ferramentaInt);
                        break;
                    case 3:
                        System.out.println("Digite o ID do dinossauro que deseja remover");
                        ferramentaInt = entrada.nextInt();
                        if (removerDino(cd, ferramentaInt) == true)
                            System.out.print("Sim! \n");
                        else
                            System.out.print("Não \n ");
                        break;
                    case 4:
                        cd.qntCatTipo();
                        System.out.printf(cd.qntAnimais());
                        break;
                    case 5:
                        do
                        {
                            System.out.println("Digite o tipo que deseja pesquisar:");
                            tipo = entrada.nextInt();
                        } while (tipo <=0 && tipo>=2);
                        do
                        {
                            System.out.println("Digite a categoria que deseja pesquisar");
                            categoria = entrada.nextInt();
                        } while (categoria <= 0 && categoria >=4);
                        maisPesado(cd, categoria, tipo);
                        break;
                    case 6:
                        System.out.printf("A quantidade de carne é: %.2f kg \n",cd.qntCarne());
                        break;
                    case 7:
                        System.out.println("Digite a distância entre o dinossauro e o bunker (km)");
                        distanciaDinoBunker = entrada.nextDouble();
                        System.out.println("Digite a distância entre a pessoa e o bunker (km)");
                        distanciaPessoaBunker = entrada.nextDouble();
                        System.out.println("Digite a velocidade média do dinossauro (km/h)");
                        VelocidadeMediaDino = entrada.nextDouble();
                        if (tempoFuga(cd, distanciaDinoBunker, distanciaPessoaBunker, VelocidadeMediaDino) == true)
                            System.out.print("Sim! \n");
                        else
                            System.out.print("Não \n");
                        break;
                    case 8:
                        System.out.println("A zona do parque mais perigosa é a zona: "+cd.zonaPerigosa(VetTerreno));
                        break;
                    case 9:
                        nomes = cd.getNomes(nomes);
                        nomes = cd.sortAlfabetica(nomes);
                        for(int i=0; i < nomes.length ; i++)
                            System.out.println(nomes[i]);
                        break;
                    case 10:
                        nomes = cd.getNomes(nomes);
                        cd.sortVogais(nomes);
                        break;
                }
                    
            
            } while (opcao1!=0);    
            

        }
            


        public static int menu()
        {
            Scanner teclado = new Scanner (System.in);
            int option = 0;
            System.out.println("1 - Adicionar dinossauro");
            System.out.println("2 - Pesquisar dinossauro");
            System.out.println("3 - Remover dinossauro");
            System.out.println("4 - Quantidade de dinossauros");
            System.out.println("5 - Dinossauro mais pesado");
            System.out.println("6 - Quantidade de carne para o mês");
            System.out.println("7 - Tempo para fugir");
            System.out.println("8 - Mostrar zona mais perigosa");
            System.out.println("9 - Listar por ordem alfabética");
            System.out.println("10 - Mais vogais no nome");
            System.out.println("0 - Sair");
            option = teclado.nextInt();
            return option;
        }

        public static Dinossauro adicionarDino()
        {
            //Scanner
            Scanner entradaInt = new Scanner (System.in);
            Scanner entradaString = new Scanner (System.in);
            Scanner entradaDouble = new Scanner (System.in);

            //Variáveis para contruir o objeto dinossauro
            int id;
            String raca;
            int tipo;
            int categoria;
            double peso;

            //Requisitos do objeto
            System.out.println("Digite o ID do dinossauro");
            id = entradaInt.nextInt();
            System.out.println("Digite o nome da raça");
            raca = entradaString.nextLine();
            do
            {
                System.out.println("Digite o tipo ('1' carnívoro e '2' herbívoro):");
                tipo = entradaInt.nextInt();
            }while(tipo<=0 && tipo>=3);
            do
            {
                System.out.println("Digite a categoria ('1' pequeno porte, '2' medio porte e '3' greande porte):");
                categoria = entradaInt.nextInt();
            }while (categoria<=0 && categoria>=4);
            System.out.println("Digite o peso:");
            peso = entradaDouble.nextDouble();

            //Adiciona o objeto com os parâmetros passados
            return new Dinossauro(id, raca, tipo, categoria, peso);
            
        }

        public static void pesquisarDino(CadastroDinossauro cadastro, int identificador)
        {
            //ID
             System.out.println("O ID é: "+cadastro.pesquisarDinossauro(identificador).getIdDinossauro());
            //Nome
            System.out.println("O nome da raça é: "+cadastro.pesquisarDinossauro(identificador).getNomeRaca());
            //Tipo
            System.out.println( (cadastro.pesquisarDinossauro(identificador).getTipo() == 1) ? ("É carnívoro") : (cadastro.pesquisarDinossauro(identificador).getTipo()== 2) 
           ? ("É herbívoro") : ("Indefinido") );
           //Categoria
            System.out.println( (cadastro.pesquisarDinossauro(identificador).getCategoria() == 1) ? ("É de pequeno porte") : (cadastro.pesquisarDinossauro(identificador)
            .getCategoria() == 2) ? ("É carnívoro") : (cadastro.pesquisarDinossauro(identificador).getCategoria() == 3) ? ("É de grande porte") : ("Indefinido") );
          
        }

        public static boolean removerDino(CadastroDinossauro cadastro, int identificador)
        {
            System.out.print("O dinossauro de ID: "+cadastro.pesquisarDinossauro(identificador).getIdDinossauro()+" foi removido?");
            return cadastro.removerDinossauro(identificador);

        }

        public static void maisPesado(CadastroDinossauro cadastro, int categoria, int tipo)
        {
            System.out.println("O dinossauro mais pesado do tipo e categoria pesa: "+cadastro.pesoPesado(categoria, tipo).getPeso());
            System.out.println("Seu ID é: "+cadastro.pesoPesado(categoria, tipo).getIdDinossauro());
            System.out.println("Seu nome é: "+cadastro.pesoPesado(categoria, tipo).getNomeRaca());
            System.out.println("Seu tipo é: "+cadastro.pesoPesado(categoria, tipo).getTipo());
            System.out.println("Sua categoria é: "+cadastro.pesoPesado(categoria, tipo).getCategoria());
        }

        public static boolean tempoFuga(CadastroDinossauro cadastro, double dinoBunker, double pessoaBunker, double vmDino)
        {
            System.out.print("Pessoa consegue correr até o bunker em menor tempo que o dinossauro? ");
            return cadastro.tempoFugir(dinoBunker, pessoaBunker, vmDino);
        }


    }