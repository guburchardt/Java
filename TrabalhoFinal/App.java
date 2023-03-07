    public class App {
        
        public static void main(String[] args){
            Dinossauro d1 = new Dinossauro(1,"Mike",1,1,500.0);
            Dinossauro d2 = new Dinossauro(2,"Josh",1,1,100.0);
            Dinossauro d3 = new Dinossauro(3,"Sebastian",1,1,1000.0);

            CadastroDinossauro cd = new CadastroDinossauro();

            cd.adicionarDinossauro(d1);
            cd.adicionarDinossauro(d2);
            cd.adicionarDinossauro(d3);

            System.out.println(cd.pesoPesado(1,1));

        }
    }