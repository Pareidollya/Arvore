import java.util.ArrayList;

import javax.swing.JOptionPane;

import arvoreGenerica.ArvoreGenerica;
import arvoreGenerica.GenericNode;

class Main {
  public static void main(String[] args) {
    teste a = new teste("aasd");
    a.setName("kkkk");

    String[] array = new String[10];
    System.out.println(array.length);
    System.out.println(array[0]);

    ArrayList<Integer> lista = new ArrayList<>();
    lista.add(1);
    lista.add(2);
    lista.add(3);

    // for (int i = 0; i < lista.size(); i++)  { metodo para remover as outras posições
    //   if(i > 1){
    //     lista.remove(i);
    //   }
    // }
    ArrayList<teste> listaTeste = new ArrayList<>();
    listaTeste.add(a);
    listaTeste.remove(0);

    
    // lista.set(0, null);

    // System.out.println(lista.size());

    // System.out.println(a.getName());
    
    // System.out.println(listaTeste);
    System.out.println("\nArvore Genérica\n===");
      String A = "";
    // System.out.print("Filhos:");
    for (int i = 0; i < lista.size(); i++) {
      A = A + "  ("+i+") "+lista.get(i) + ";";
      // System.out.print("("+i+") "+lista.get(i) + ";  ");
    }
    // System.out.println(A);

    // String testeInput = JOptionPane.showInputDialog("insira um valor");
    // int testeInputInt = Integer.parseInt(testeInput);
    // System.out.println(testeInputInt);

    //implementação da arvore generica
    int option;
    
    // int valorRaiz = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor da raiz!"));
    ArvoreGenerica<Integer> arvore = new ArvoreGenerica<Integer>(2);

    arvore.inserirNode(2, 7);
    arvore.inserirNode(7, 3);
    arvore.inserirNode(7, 6);
    arvore.inserirNode(7, 11);

    arvore.inserirNode(2, 5);
    arvore.inserirNode(5, 9);
    arvore.inserirNode(9, 4);

    System.out.println("raiz " + arvore.getRaiz());

    
    System.out.println("saida " + arvore.buscar(3, arvore.getRaiz()).getProfundidade());
    
    // for (int i = 0; i < 5; i++) {
    //   System.out.print("5");
    // }
    System.out.println("saida " + arvore.buscar(1, arvore.getRaiz()));

    // System.out.println(arvore.buscar(1, arvore.getRaiz()));
    A = "";
    System.out.print("Filhos de 0: ");
    for (int i = 0; i < arvore.getRaiz().getFilhos().size(); i++) {
      A = A + "  ("+i+") "+ arvore.getRaiz().getFilhos().get(i) + ";";
      System.out.print("("+i+") "+arvore.getRaiz().getFilhos().get(i).getValor() + ";  ");
    }

    // System.out.println(arvore.buscar(1, arvore.getRaiz()).getValor());
    // System.out.println(arvore.buscar(1, arvore.getRaiz()).getValor());
    System.out.println("\n" + arvore.buscar(2, arvore.getRaiz()).getValor());

    arvore.showTree(arvore.buscar(2, arvore.getRaiz()));
    
    arvore.buscar(2, arvore.getRaiz());

    System.out.println(arvore.isRoot(arvore.buscar(7, arvore.getRaiz())));

    
    // System.out.println(arvore.buscar(3, arvore.getRaiz()).getProfundidade());
    // arvore.inserirNode(4, 20);

    System.out.println("folhas aq: " +arvore.getFolhas(null)); //retornar folhas da arvore ou do nó inserido
  
    System.out.println("altura da arvore: " + arvore.getAlturaThree()); //altura da arvore
    
    arvore.clear();
    System.out.println("folhas aq: " +arvore.getFolhas(arvore.buscar(2, arvore.getRaiz())));
    arvore.clear();
    System.out.println("profundidade de nó: " + arvore.getProfundidade(arvore, arvore.buscar(2, arvore.getRaiz())));
    System.out.println("altura de 5 (forced): " + arvore.getProfundidadeFromNode( arvore.buscar(5, arvore.getRaiz()), arvore.buscar(4, arvore.getRaiz()) ));
    System.out.println("folha do nó 5: " + arvore.getFolhas(arvore.buscar(5, arvore.getRaiz())).get(0).getValor());

    arvore.clear();
    System.out.println("altura de nó: " + arvore.getAlturaNode(arvore.buscar(2, arvore.getRaiz())));
    arvore.clear();

    System.out.println("maior grau de raiz: " + arvore.getMaxNodeGrau(arvore.buscar(2, arvore.getRaiz())));

    arvore.showFolhas(null);
    arvore.showInternos(null);


    //TESTES COM NÓS BINARIOS
    arvore.inserirNode(4, 100);
    arvore.buscar(100, null).getFilhos().add(null);
    arvore.buscar(100, null).getFilhos().add(null);
    // arvore.setType(1);
    // arvore.inserirNode(100, 101);
    arvore.addRight(100, 101);
    
    System.out.println(arvore.buscar(100, null).getFilhos());

    
    arvore.inserirNode(101, 102);
    arvore.inserirNode(101, 103);

    arvore.buscar(103, null).getFilhos().add(null);
    arvore.buscar(103, null).getFilhos().add(null);
    arvore.inserirNode(101, 104);

    arvore.showTree(arvore.buscar(2, arvore.getRaiz()));
    System.out.println("folhas aq: " +arvore.getFolhas(arvore.buscar(5, arvore.getRaiz())));
    arvore.clear();
    System.out.println("profundidade de nó: " + arvore.getProfundidade(arvore, arvore.buscar(103, arvore.getRaiz())));
    arvore.clear();
    System.out.println("altura de x ate y: " + arvore.getProfundidadeFromNode( arvore.buscar(2, arvore.getRaiz()), arvore.buscar(103, arvore.getRaiz())));
    arvore.clear();
    System.out.println("maior grau de raiz: " + arvore.getMaxNodeGrau(arvore.buscar(2, arvore.getRaiz())));
    arvore.clear();

    arvore.convertToBinary(arvore.buscar(2, null));
    arvore.showTree(arvore.buscar(2, null));

    arvore.showTree(arvore.buscar(2, arvore.getRaiz()));
    System.out.println("folhas aq: " +arvore.getFolhas(arvore.buscar(5, arvore.getRaiz())));
    arvore.clear();
    System.out.println("profundidade de nó: " + arvore.getProfundidade(arvore, arvore.buscar(103, arvore.getRaiz())));
    arvore.clear();
    System.out.println("altura de x ate y: " + arvore.getProfundidadeFromNode( arvore.buscar(2, arvore.getRaiz()), arvore.buscar(103, arvore.getRaiz())));
    arvore.clear();
    System.out.println("maior grau de raiz: " + arvore.getMaxNodeGrau(arvore.buscar(2, arvore.getRaiz())));
    arvore.clear();


  }
}