package arvoreGenerica;
import java.util.ArrayList;

public class ArvoreGenerica<T> {
    private int option; // 
    private int altura;
    private int elementos;
    private GenericNode<T> raiz;
    private GenericNode<T> atual;
    private  ArrayList<GenericNode<T>> folhas;

    //instanciar uma arvore
    public ArvoreGenerica(){
        this.option = 0;
        this.altura = 0;
        this.elementos = 0;

        this.raiz = null;
        this.atual = null;
        this.folhas = null;
        System.out.println("\n===\nArvore Genérica\n");
    }
    
    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public GenericNode<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(GenericNode<T> raiz) {
        this.raiz = raiz;
    }

    public GenericNode<T> getAtual() {
        return atual;
    }

    public void setAtual(GenericNode<T> atual) {
        this.atual = atual;
    }

    public ArrayList<GenericNode<T>> getFolhas() {
        return folhas;
    }

    public void setFolhas(ArrayList<GenericNode<T>> folhas) {
        this.folhas = folhas;
    }

    public void inserirNode() {
        if(this.raiz == null) {
            
        }
    }
    public void run(){
        switch(this.option){
            case 0: //caso ainda não possua raiz
                System.out.println("Instanciar raiz");

        }
    }

}
