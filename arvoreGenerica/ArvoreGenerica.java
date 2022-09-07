package arvoreGenerica;

public class ArvoreGenerica<T> {
    private GenericNode<T> raiz;
    private int type; // 0 para generica, 1 para binaria

    public ArvoreGenerica() {
        this.type = 0;
        this.raiz = null;
    }

    public ArvoreGenerica(T valor) { // instanciar com uma raiz de valor X
        this.type = 0;
        this.raiz = new GenericNode<T>(valor);
    }

    public GenericNode<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(GenericNode<T> raiz) {
        this.raiz = raiz;
    }

    GenericNode<T> noResultado = null;
    public GenericNode<T> buscar(T valor, GenericNode<T> no) { // retornar um nó pelo seu valor
        
        if (no == null) {
            no = this.raiz;
        }
        if(this.raiz.getValor() == valor){
            noResultado = this.raiz;
        }
        
        int maxCount = no.getFilhos().size();
        // System.out.println(maxCount);
        if (maxCount > 0) {
            for (int i = 0; i < maxCount; i++) {
                
                if(no.getFilhos().get(i).getValor() != valor) {
                    buscar(valor, no.getFilhos().get(i));
                    // System.out.println(" n achei aki'");
                }else{
                    // System.out.println("'achei aki'");
                    noResultado = no.getFilhos().get(i);
                
                }
            
            }

        }
        return noResultado;
    }

    public void inserirNode(T no, T novoValor){ //no que quer adicionar o filho / valor que quer adicionar
        GenericNode<T> noPai = buscar(no, this.raiz);
        if(type == 0){
            GenericNode<T> noFilho = new GenericNode<T>(novoValor, noPai);
            noPai.addFilho(noFilho);
            System.out.println("Novo filho " + novoValor + " adicionado ao nó " + no);

        }else if (type == 1 && noPai.getFilhos().size() < 2){
            GenericNode<T> noFilho = new GenericNode<T>(novoValor, noPai);
            noPai.addFilho(noFilho);
            System.out.println("Novo filho adicionado ao nó " + no);
        }else{
            System.out.println("Não é possível inserir um novo filho em " + no);
        }
    }

}
