package arvoreGenerica;
import java.util.ArrayList;

public class GenericNode<T> {
    private int profundidade;
    private T valor;
    private GenericNode<T> pai;
    private GenericNode<T> left;
    private GenericNode<T> right;


    private ArrayList<GenericNode<T>> filhos;


    //declarar raiz
    public GenericNode(T valor) { 
        this.valor = valor;
        this.pai = null;
        this.left = null;
        this.right = null;
        this.profundidade = 0;
        
        this.filhos = new ArrayList<>();
        
    }

    //declarar um filho generic
    public GenericNode(T valor, GenericNode<T> pai) { 
        this.profundidade = pai.getProfundidade() + 1;
        this.valor = valor;
        this.pai = pai;
        this.left = null;
        this.right = null;
        this.filhos = new ArrayList<>();
    }

    //declarar sub árvore geric
    public GenericNode(int profundidade, T valor, GenericNode<T> pai, ArrayList<GenericNode<T>> filhos) { 
        this.profundidade = profundidade;
        this.valor = valor;
        
        this.pai = pai;
        this.filhos = filhos;
    } 

    //declarar com filho esquerdo ou direito
    public GenericNode(int profundidade, T valor, GenericNode<T> pai, GenericNode<T> left,GenericNode<T> right) { 
        this.profundidade = profundidade;
        this.valor = valor;
        this.left = left;
        this.right = right;
        this.pai = pai;
        this.filhos = null;
    } 

    // getter/setter
    public int getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public GenericNode<T> getPai() {
        return pai;
    }

    public void setPai(GenericNode<T> pai) {
        this.pai = pai;
    }

    public ArrayList<GenericNode<T>> getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList<GenericNode<T>> filhos) {
        this.filhos = filhos;
    }

    //BINARIOS
    public GenericNode<T> getLeft() {
        return left;
    }

    public void setLeft(GenericNode<T> left) {
        this.left = left;
    }

    public GenericNode<T> getRight() {
        return right;
    }

    public void setRight(GenericNode<T> right) {
        this.right = right;
    }

    //retornar se possui filhos
    public boolean hasFilhos() {
        return !filhos.isEmpty();
    }
    public boolean isLeaf() { 
        return filhos.isEmpty();
    }
    public boolean isRoot(){
        if(this.pai == null){
            return true;
        }else{
            return false;
        }
    }

    //binarios
    public boolean hasLeft() {
        if(this.left != null) return true;
        else return false;
    }
    public boolean hasRight() {
        if(this.right != null) return true;
        else return false;
    }

    
    //retornar grau do nó
    public int getGrau() { 
        if(filhos.size() == 2 && filhos.get(0) == null && filhos.get(1) == null){ //para caso de 
            return 0;
        }else if(filhos.size() == 2 && filhos.get(0) != null && filhos.get(1) == null){
            return 1;
        }else if(filhos.size() == 2 && filhos.get(0) == null && filhos.get(1) != null){
            return 1;
        }else if(filhos.size() == 2 && filhos.get(0) != null &&  filhos.get(1) != null){
            return 2;
        }else{
            return filhos.size();
        }

    
        // 
    }
    //binario
    public int getGrauBinary() { 
        if(this.left == null && this.right == null){ //para caso de 
            return 0;
        }else if(this.left != null && this.right == null){
            return 1;
        }else if(this.left == null && this.right != null){
            return 1;
        }else if(this.left!= null &&  this.right != null){
            return 2;
        }else return 0;

    
        // 
    }

    //adicionar um novo filho ao nó
    public void addFilho(GenericNode<T> novoFilho) {
        this.filhos.add(novoFilho);
    }
    
}
