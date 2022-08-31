package arvore;
import java.util.ArrayList;

public class Node<T> {
    private int altura;
    private int valor;
    private Node<T> pai;
    private ArrayList<Node<T>> filhos;

    public Node(int valor) { //declarar raiz
        this.altura = 0;
        this.valor = valor;

        this.pai = null;
        this.filhos = new ArrayList<>();
    }
}
