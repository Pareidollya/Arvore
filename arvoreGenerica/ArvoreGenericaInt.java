package arvoreGenerica;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ArvoreGenericaInt{
    private int option; //
    private int altura;
    private int elementos;
    private GenericNode<Integer> raiz;
    private GenericNode<Integer> atual;
    private ArrayList<GenericNode<Integer>> folhas;

    // instanciar uma arvore
    public ArvoreGenericaInt() {
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

    public GenericNode<Integer> getRaiz() {
        return raiz;
    }

    public void setRaiz(GenericNode<Integer> raiz) {
        this.raiz = raiz;
    }

    public GenericNode<Integer> getAtual() {
        return atual;
    }

    public void setAtual(GenericNode<Integer> atual) {
        this.atual = atual;
    }

    public ArrayList<GenericNode<Integer>> getFolhas() {
        return folhas;
    }

    public void setFolhas(ArrayList<GenericNode<Integer>> folhas) {
        this.folhas = folhas;
    }

    //funções de visualização
    public String showFilhosList() { // vizualizar lista de filhos com index.
        int numFilhos = this.atual.getFilhos().size();
        String filhosList = "";
        if (numFilhos == 0) {
            filhosList = "Este nó não possui filho...";
        } else {
            filhosList = Integer.toString(numFilhos) + " ";
            for (int i = 0; i < numFilhos; i++) {
                filhosList = filhosList + "  (" + i + ") " + this.atual.getFilhos().get(i) + ";";
                // System.out.print("("+i+") "+lista.get(i) + "; ");
            }
        }

        return filhosList;
    }

    public String getActualStatus() { // vizuzalizar informações do nó atual
        String valor = this.atual.getValor().toString();
        String pai = this.atual.getPai().getValor().toString();

        return "\nNó atual: " + valor 
                + "\nPai: " + pai
                + "\n" + showFilhosList();
    }

    //funções de inserção
    public void inserirNode(String value) { // inserir um nó raiz ou adicionar um filho.
        String valorStr;
        int valorInt;

        if (this.raiz == null) {
            valorStr = JOptionPane.showInputDialog("Insira o valor do nó Raiz.");
            valorInt = Integer.parseInt(valorStr);

            this.raiz =  new GenericNode<Integer>(valorInt);
            this.atual = this.raiz;

            this.elementos++;

            System.out.println("Raiz adicionada \n");

        } else { //inserir um nó filho ao nó atual.
            valorStr = JOptionPane.showInputDialog("Insira o valor do novo filho.");
            valorInt = Integer.parseInt(valorStr);

            GenericNode<Integer> novoFilho = new GenericNode<Integer>(valorInt);
            this.atual.addFilho(novoFilho);

            this.elementos++;

            System.out.println("Novo filho adicionado ao nó " + this.atual.getValor().toString());
        }
    }

    //funções de navegação
    public void goToFilho(String index){ //ir para o filho
        
    }

    public void goToPai(){ //ir para o nó pai

    }

    public void goToRoot(){ //ir opara raiz

    }



    //função para interação com usuário na árvore.
    public void run() {
        switch (this.option) {
            case 0: // caso ainda não possua raiz
                System.out.println("Instanciar raiz");

        }
    }

}
