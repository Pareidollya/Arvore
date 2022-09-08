package arvoreGenerica;

import java.util.ArrayList;

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

    public boolean isRoot(GenericNode<T> no) {
        if (no == this.raiz) {
            return true;
        } else {
            return false;
        }
    }

    GenericNode<T> noResultado = null;

    public GenericNode<T> buscar(T valor, GenericNode<T> no) { // retornar um nó pelo seu valor
        if (no == null) {
            no = this.raiz;
        }
        if (this.raiz.getValor() == valor) {
            noResultado = this.raiz;
        }

        int maxCount = no.getFilhos().size();
        if (maxCount > 0) {
            for (int i = 0; i < maxCount; i++) {
                if (no.getFilhos().get(i).getValor() != valor) { // || no.getFilhos().get(i).getValor() == null
                    buscar(valor, no.getFilhos().get(i));
                } else {
                    noResultado = no.getFilhos().get(i);

                }
            }
        }
        try {
            if (noResultado.getValor() != valor) {
                noResultado = null;
            }
        } catch (Exception e) {
            throw new NullPointerException("Nó inválido (null).");
        } finally {
            // System.out.println(noResultado.getValor());
            return noResultado;
        }

    }

    public void inserirNode(T no, T novoValor) { // no que quer adicionar o filho / valor que quer adicionar
        GenericNode<T> noPai = buscar(no, this.raiz);

        if (type == 0 && noPai != null) {
            GenericNode<T> noFilho = new GenericNode<T>(novoValor, noPai);
            noPai.addFilho(noFilho);

            System.out.println("Novo filho " + novoValor + " adicionado ao nó " + no);

        } else if (type == 1 && noPai.getFilhos().size() < 2 && noPai != null) { // caso seja binaria não inserir mais
                                                                                 // de 2
            GenericNode<T> noFilho = new GenericNode<T>(novoValor, noPai);
            noPai.addFilho(noFilho);

            System.out.println("Novo filho adicionado ao nó " + no);

        } else {
            System.out.println("Não é possível inserir um novo filho em " + no);
        }
    }

    public void showTree(GenericNode<T> no) { // caso passar um no exibir a sub arvore (igual a busca)
        if (no == null) {
            no = this.raiz;
        }
        int maxCount = no.getFilhos().size();
        if (maxCount > 0) {
            for (int i = 0; i < maxCount; i++) {
                if (no.getFilhos().size() > 0) { // || no.getFilhos().get(i).getValor() == null
                    System.out.print("  ");
                    for (int j = 0; j < no.getProfundidade(); j++) {
                        System.out.print("  ");
                    }
                    System.out.println(no.getFilhos().get(i).getValor());
                    showTree(no.getFilhos().get(i));
                }
            }
        }
    }

    public int getProfundidade(ArvoreGenerica<T> Arvore, GenericNode<T> no) {
        if (Arvore.isRoot(no)) {
            return 0;
        } else {
            return 1 + getProfundidade(Arvore, no.getPai());
        }
    }
    
    ArrayList<GenericNode<T>> folhas = new ArrayList<>();

    public ArrayList<GenericNode<T>> getFolhas(GenericNode<T> no) {
        if (no == null) {
            no = this.raiz;
        }

        int maxCount = no.getFilhos().size();
        if (maxCount > 0) {
            for (int i = 0; i < maxCount; i++) {
                if (no.getFilhos().size() > 0) { // || no.getFilhos().get(i).getValor() == null
                    getFolhas(no.getFilhos().get(i));
                }
            }
        } else {
            folhas.add(no);
        }
        return folhas;
    }

    public int getAlturaThree() { // pegar altura atravez das folhas
        int altura_arvore = 0;
        ArrayList<GenericNode<T>> folhasList = getFolhas(null);

        for (int i = 0; i < folhasList.size(); i++) {
            if (folhasList.get(i).getProfundidade() > altura_arvore) {
                altura_arvore = folhasList.get(i).getProfundidade();
            }
        }
        this.clear();
        return altura_arvore;
    }

    public int getProfundidadeFromNode(GenericNode<T> noAlvo, GenericNode<T> no) { //retornar profundidade de um no folha ate o que eu quero.
        System.out.println("dsaokfjsdklf");
        if(no.isRoot()){
            return 0;
        }
        if (noAlvo.getValor() == no.getValor()) {
            return 0;
        } else {
            return 1 + getProfundidadeFromNode(noAlvo, no.getPai());
        }
    }

    int alturaAux;
    public int getAlturaNode(GenericNode<T> no) {
        int maxCount = no.getFilhos().size();
        
        
        return alturaAux;
        


        

    }
    

    public void clear() { // limpar variaveis auxiliares para evitar bugs (utilizar no metodo main)
        folhas.clear();
        noResultado = null;
        alturaAux = 0;
        // altura_arvore = 0;

    }
}
