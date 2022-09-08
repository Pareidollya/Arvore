package arvoreGenerica;
import java.util.ArrayList;

public class GenericNode<T> {
    private int profundidade;
    private T valor;
    private GenericNode<T> pai;
    private ArrayList<GenericNode<T>> filhos;


    //declarar raiz
    public GenericNode(T valor) { 
        this.valor = valor;
        this.pai = null;
        this.profundidade = 0;

        this.filhos = new ArrayList<>();
        
    }

    //declarar um filho
    public GenericNode(T valor, GenericNode<T> pai) { 
        this.profundidade = pai.getProfundidade() + 1;
        this.valor = valor;
        this.pai = pai;

        this.filhos = new ArrayList<>();
    } 

    //declarar sub árvore
    public GenericNode(int profundidade, T valor, GenericNode<T> pai, ArrayList<GenericNode<T>> filhos) { 
        this.profundidade = profundidade;
        this.valor = valor;
        
        this.pai = pai;
        this.filhos = filhos;
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

    //adicionar um novo filho ao nó
    public void addFilho(GenericNode<T> novoFilho) {
        this.filhos.add(novoFilho);
    }
    
}
