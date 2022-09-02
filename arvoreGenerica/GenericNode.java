package arvoreGenerica;
import java.util.ArrayList;

public class GenericNode<T> {
    private int altura;
    private T valor;
    private GenericNode<T> pai;
    private ArrayList<GenericNode<T>> filhos;


    //declarar raiz
    public GenericNode(T valor) { 
        this.altura = 0;
        this.valor = valor;
        this.pai = null;

        this.filhos = new ArrayList<>();
        
    }

    //declarar um filho
    public GenericNode(int altura, T valor, GenericNode<T> pai) { 
        this.altura = altura;
        this.valor = valor;
        this.pai = pai;

        this.filhos = new ArrayList<>();
    } 

    //declarar com filhos (passar com uma lista de nós ja encadeados)
    public GenericNode(int altura, T valor, GenericNode<T> pai, ArrayList<GenericNode<T>> filhos) { 
        this.altura = altura;
        this.valor = valor;
        
        this.pai = pai;
        this.filhos = filhos;
    } 

    // getter/setter
    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
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

    
    //retornar grau do nó
    public int getGrau() { 
        return filhos.size();
    }

    //adicionar um novo filho ao nó
    public void addFilho(GenericNode<T> novoFilho) {
        this.filhos.add(novoFilho);
    }
}
