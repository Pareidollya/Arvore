package arvoreBinaria;

public class BinaryNode<T> {
    private T valor;
    private BinaryNode<T> pai;
    private BinaryNode<T> esquerda;
    private BinaryNode<T> direita;

    public BinaryNode(T valor){ //declarar uma raiz
        this.valor = valor;
        this.pai = null;
        this.esquerda = null;
        this.direita = null;
    }       

    //declarar um nó filho
    public BinaryNode(T valor, BinaryNode<T> pai){ 
        this.valor = valor;
        this.pai = pai;
        this.esquerda = null;
        this.direita = null;
    }

    //declarar uma sub árvore 
    public BinaryNode(T valor, BinaryNode<T> pai, BinaryNode<T> esquerda, BinaryNode<T> direita){ 
        this.valor = valor;
        this.pai = pai; 
        this.esquerda = esquerda;
        this.direita = direita;
    }

    //getters and setters
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public BinaryNode<T> getPai() {
        return pai;
    }

    public void setPai(BinaryNode<T> pai) {
        this.pai = pai;
    }

    public BinaryNode<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(BinaryNode<T> esquerda) {
        this.esquerda = esquerda;
    }

    public BinaryNode<T> getDireita() {
        return direita;
    }

    public void setDireita(BinaryNode<T> direita) {
        this.direita = direita;
    }

    //funções
    public boolean hasLeft(){ //verificar se há filhos
        return this.esquerda.getEsquerda() != null;
    }

    public boolean hasRight(){
        return this.direita.getEsquerda() != null;
    }

    public boolean isRoot(){ //verificar é raiz
        return this.pai == null;
    }

}
