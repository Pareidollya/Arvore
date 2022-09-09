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

    public void setType(int type) {
        this.type = type;
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
                if (no.getFilhos().get(i) != null) {
                    if (no.getFilhos().get(i).getValor() != valor) { // || no.getFilhos().get(i).getValor() == null
                        buscar(valor, no.getFilhos().get(i));
                    } else {
                        noResultado = no.getFilhos().get(i);
                    }
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

        } else if (type == 1 && noPai.getFilhos().size() == 2 && noPai != null) { // caso seja binaria não inserir mais
                                                                                  // de 2
            System.out.println(hasLeft(noPai));
            if (hasLeft(noPai) == false) {
                GenericNode<T> noFilho = new GenericNode<T>(novoValor, noPai);
                noPai.getFilhos().add(0, noFilho);
                System.out.println("Novo filho " + novoValor + " adicionado a esquerda do nó " + no);
            } else if (hasRight(noPai) == false) {
                GenericNode<T> noFilho = new GenericNode<T>(novoValor, noPai);
                noPai.getFilhos().add(1, noFilho);
                System.out.println("Novo filho " + novoValor + " adicionado a direita do nó " + no);
            }
            // noPai.addFilho(noFilho);
            // verificar e dar prioridade pra

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
                if (no.getFilhos().size() > 0 && no.getFilhos().get(i) != null) { // || no.getFilhos().get(i).getValor()
                                                                                  // == null
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
                if (no.getFilhos().get(i) != null) {

                    if (no.getFilhos().size() > 0) { // || no.getFilhos().get(i).getValor() == null
                        getFolhas(no.getFilhos().get(i));
                    }
                }
                if (no.getFilhos().size() >= 2 && hasLeft(no) == false && hasRight(no) == false
                        && folhas.contains(no) == false) {
                    folhas.add(no);
                }
            }
        } else {
            folhas.add(no);
        }
        return folhas;
    }

    ArrayList<GenericNode<T>> internosList = new ArrayList<>();

    public ArrayList<GenericNode<T>> getInternosList(GenericNode<T> no) {
        if (no == null) {
            no = this.raiz;
        }
        int maxCount = no.getFilhos().size();
        if (maxCount > 0) {
            if (no.isRoot() == false) {
                internosList.add(no);
            }
            for (int i = 0; i < maxCount; i++) {
                getInternosList(no.getFilhos().get(i));
            }
        }
        return internosList;
    }

    public int getAlturaThree() { // pegar altura atravez das folhas
        int altura_arvore = 0;
        ArrayList<GenericNode<T>> folhasList = getFolhas(null);

        for (int i = 0; i < folhasList.size(); i++) {
            if (folhasList.get(i).getProfundidade() > altura_arvore) {
                altura_arvore = folhasList.get(i).getProfundidade();
            }
        }
        clear();
        return altura_arvore;
    }

    // caso usar a raiz, irá retornar altura da arvore
    public int getProfundidadeFromNode(GenericNode<T> noAlvo, GenericNode<T> noFilho) { // retornar profundidade de
                                                                                        // umno}
        if (noFilho.isRoot()) {
            return 0;
        }
        if (noAlvo.getValor() == noFilho.getValor()) {
            return 0;
        } else {
            return 1 + getProfundidadeFromNode(noAlvo, noFilho.getPai());
        }
    }

    public int getAlturaNode(GenericNode<T> no) { // atravez das folhas de sua sub árvore retornar a altura do nó
                                                  // especificado.
        ArrayList<GenericNode<T>> folhasList = this.getFolhas(no);
        int maxCount = folhasList.size();

        int aux = 0;
        int altura = 0;
        if (maxCount > 0) {
            for (int i = 0; i < maxCount; i++) {
                if (getProfundidadeFromNode(no, folhasList.get(i)) > altura) {
                    altura = getProfundidadeFromNode(no, folhasList.get(i));
                }
            }
        }

        clear();
        return altura;
    }

    public int getMaxNodeGrau(GenericNode<T> no) {
        if (no == null) {
            no = this.raiz;
        }
        int maxCount = no.getFilhos().size();
        int maxGrau = no.getGrau(); // maior grau será definido a partir do primeiro nó instanciado
        if (maxCount > 0) {
            for (int i = 0; i < maxCount; i++) { // percorrer todos os nós em busca do maior grau dentree eles
                if (no.getFilhos().get(i) != null) {
                    if (no.getFilhos().get(i).getGrau() > maxGrau) {
                        maxGrau = no.getFilhos().get(i).getGrau();
                    }
                }

            }
        }
        return maxGrau;
    }

    public void showInternos(GenericNode<T> no) { // imprimir nós internos de uma (sub)arvore
        if (no == null) {
            no = this.raiz;
        }
        internosList = getInternosList(no);
        if (internosList.size() > 0) {
            System.out.print("\nNós Internos de " + no.getValor() + "(" + internosList.size() + "): ");
            for (int i = 0; i < internosList.size(); i++) {
                System.out.print(internosList.get(i).getValor() + " ");
            }
        } else {
            System.out.println("\nEsta (sub)arvore não possui nós internos.");
        }

        clear();
    }

    public void showFolhas(GenericNode<T> no) { // imprimir lista de folhas de uma (sub)arvore
        if (no == null) {
            no = this.raiz;
        }
        folhas = getFolhas(no);
        if (folhas.size() > 0) {
            System.out.print("\nNós Folhas de " + no.getValor() + "(" + folhas.size() + "): ");
            for (int i = 0; i < folhas.size(); i++) {
                System.out.print(folhas.get(i).getValor() + " ");
            }
        } else {
            System.out.println("\nEsta (sub)arvore não possui nós folhas.");
        }

        clear();
    }

    public void showNodeInfo(T valor) { // imprimir informações de um nó de valor x
        GenericNode<T> node = buscar(valor, null);

    }

    // funçoes para binaria
    public boolean hasLeft(GenericNode<T> no) {
        if (no == null) {
            no = this.raiz;
        }
        if (no.getFilhos().get(0) == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasRight(GenericNode<T> no) {
        if (no == null) {
            no = this.raiz;
        }
        if (no.getFilhos().get(1) == null) {
            return false;
        } else {
            return true;
        }
    }

    public GenericNode<T> getLeft(GenericNode<T> no) {
        if (no == null) {
            no = this.raiz;
        }
        return no.getFilhos().get(0);
    }

    public GenericNode<T> getRight(GenericNode<T> no) {
        if (no == null) {
            no = this.raiz;
        }
        return no.getFilhos().get(no.getFilhos().size() - 1);
    }

    public GenericNode<T> addLeft(T no, T novoValor) {
        GenericNode<T> noPai = buscar(no, this.raiz);
        if (no == null) {
            noPai = this.raiz;
        }

        if (hasLeft(noPai) != true) {
            GenericNode<T> noFilho = new GenericNode<T>(novoValor, noPai);
            noPai.getFilhos().remove(0);
            noPai.getFilhos().add(0, noFilho);
        }
        return noPai.getFilhos().get(0);
    }

    public GenericNode<T> addRight(T no, T novoValor) {
        GenericNode<T> noPai = buscar(no, this.raiz);
        if (no == null) {
            noPai = this.raiz;
        }
        if (hasRight(noPai) != true) {
            System.out.println("a");
            GenericNode<T> noFilho = new GenericNode<T>(novoValor, noPai);
            noPai.getFilhos().remove(1);
            noPai.getFilhos().add(1, noFilho);
            System.out.println("cu");
        }
        return noPai.getFilhos().get(1);
        // return no.getFilhos().get(no.getFilhos().size() - 1);
    }

    public void convertToBinary(GenericNode<T> no){
        if (no == null) {
            no = this.raiz;
        }
        int maxCount = no.getFilhos().size();

        if (maxCount > 0) {
            for (int i = 0; i < maxCount; i++) {
                if (no.getFilhos().size() > 2 && no.getFilhos().get(i) != null) { 
                    for (int j = 2; j < no.getFilhos().size(); j++) {
                       no.getFilhos().remove(j); 
                }
                convertToBinary(no.getFilhos().get(i));
            }
        }
    }
}

    // if(maxCount == 0){
    // no.getFilhos().add(null);
    // no.getFilhos().add(null);
    // }
    // if(maxCount == 1){
    // no.getFilhos().add(null);
    // convertToBinary(no.getFilhos().get(0));
    // }
    // if (maxCount > 2) {
    // for (int i = 0; i < maxCount; i++) {
    // if (no.getFilhos().get(i) != null) {
    // // System.out.print(" ");
    // for (int j = 2; j < no.getFilhos().size(); j++) {
    // no.getFilhos().remove(j);
    // System.out.println("cusasds");
    // }
    // // System.out.println(no.getFilhos().get(i).getValor());
    // convertToBinary(no.getFilhos().get(i));
    // }
    // }
    // }

    public void clear() { // limpar variaveis auxiliares para evitar bugs (utilizar no metodo main)
        folhas.clear();
        internosList.clear();
        noResultado = null;
        // altura_arvore = 0;

    }
}
