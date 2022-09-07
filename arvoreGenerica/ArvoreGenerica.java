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

    public GenericNode<T> buscar(T valor, GenericNode<T> no) { // retornar um nó pelo seu valor
        GenericNode<T> noResultado = null;
        if (no == null) {
            no = this.raiz;
        }

        int maxCount = no.getFilhos().size();
        if (maxCount > 0 && noResultado.getValor() != valor) {
            for (int i = 0; i < maxCount; i++) {
                if(no.getFilhos().get(i) != null){
                    if(no.getFilhos().get(i).getValor() != valor) {
                        buscar(valor, no.getFilhos().get(i));
                    }else{
                        noResultado = no.getFilhos().get(i);
                    }
                }
            }
        }
        return noResultado;
    }

    public void inserirNode(T no, T novoValor){ //no que quer adicionar o filho / valor que quer adicionar
        GenericNode<T> noPai = buscar(no, this.raiz);
        
        if(type == 0){
            GenericNode<T> noFilho = new GenericNode<T>(novoValor, noPai);
            System.out.println("Novo filho adicionado ao nó " + no);

        }else if (type == 1 && noPai.getFilhos().size() < 2){
            GenericNode<T> noFilho = new GenericNode<T>(novoValor, noPai);
            System.out.println("Novo filho adicionado ao nó " + no);
        }else{
            System.out.println("Não é possível inserir um novo filho em " + no);
        }
    }

}
