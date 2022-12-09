import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import arvoreGenerica.ArvoreGenerica;
import arvoreGenerica.GenericNode;
import arvoreGenerica.ArvoreRedBlack;

class Main {
  public static void main(String[] args) {
    // teste a = new teste("aasd");
    // a.setName("kkkk");

    String[] array = new String[10];
    System.out.println(array.length);
    System.out.println(array[0]);

    ArrayList<Integer> lista = new ArrayList<>();
    lista.add(1);
    lista.add(2);
    lista.add(3);


    System.out.println("\nArvore Genérica\n===");

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

    System.out.println("saida " + arvore.buscar(1, arvore.getRaiz()));

    System.out.println("\n" + arvore.buscar(2, arvore.getRaiz()).getValor());

    arvore.showTree(arvore.buscar(2, arvore.getRaiz()));

    arvore.buscar(2, arvore.getRaiz());
    System.out.println(arvore.isRoot(arvore.buscar(7, arvore.getRaiz())));
    System.out.println("folhas aq: " + arvore.getFolhas(null)); // retornar folhas da arvore ou do nó inserido
    System.out.println("altura da arvore: " + arvore.getAlturaThree()); // altura da arvore
    System.out.println("folhas aq: " + arvore.getFolhas(arvore.buscar(2, arvore.getRaiz())));
    System.out.println("profundidade de nó: " + arvore.getProfundidade(null, arvore.buscar(2, arvore.getRaiz())));
    System.out.println("altura de 5 (forced): "
        + arvore.getProfundidadeFromNode(arvore.buscar(5, arvore.getRaiz()), arvore.buscar(4, arvore.getRaiz())));
    System.out.println("folha do nó 5: " + arvore.getFolhas(arvore.buscar(5, arvore.getRaiz())).get(0).getValor());
    System.out.println("altura de nó: " + arvore.getAlturaNode(arvore.buscar(2, arvore.getRaiz())));
    System.out.println("maior grau de raiz: " + arvore.getMaxNodeGrau(arvore.buscar(2, arvore.getRaiz())));
    arvore.showFolhas(null);
    arvore.showInternos(null);
    arvore.showSubarvores(null);

    // TESTES COM NÓS BINARIOS
    arvore.inserirNode(4, 100);
    arvore.buscar(100, null).getFilhos().add(null);
    arvore.inserirNode(100, 101);
    // arvore.addRight(100, 101);

    System.out.println(arvore.buscar(100, null).getFilhos());
    arvore.inserirNode(101, 102);
    arvore.inserirNode(101, 103);
    arvore.buscar(103, null).getFilhos().add(null);
    arvore.buscar(103, null).getFilhos().add(null);
    arvore.inserirNode(101, 104);
    arvore.showTree(arvore.buscar(2, arvore.getRaiz()));
    System.out.println("folhas aq: " + arvore.getFolhas(arvore.buscar(5, arvore.getRaiz())));

    // System.out.println("profundidade de nó: " + arvore.getProfundidade(arvore, arvore.buscar(103, arvore.getRaiz())));
    System.out.println("altura de x ate y: "
        + arvore.getProfundidadeFromNode(arvore.buscar(2, arvore.getRaiz()), arvore.buscar(103, arvore.getRaiz())));
    System.out.println("maior grau de raiz: " + arvore.getMaxNodeGrau(arvore.buscar(2, arvore.getRaiz())));
    // arvore.convertToBinary(arvore.buscar(2, null));
    arvore.convertTrueBinary(null);
    System.out.println(arvore.getType());
    arvore.showTree(arvore.buscar(2, null));
    arvore.showTree(arvore.buscar(2, arvore.getRaiz()));
    System.out.println("folhas aq: " + arvore.getFolhas(arvore.buscar(5, arvore.getRaiz())));
    // System.out.println("profundidade de nó: " + arvore.getProfundidade(null, arvore.buscar(103, arvore.getRaiz())));
    // System.out.println("altura de x ate y: "
    //     + arvore.getProfundidadeFromNode(arvore.buscar(2, arvore.getRaiz()), arvore.buscar(103, arvore.getRaiz())));
    System.out.println("maior grau de raiz: " + arvore.getMaxNodeGrau(arvore.buscar(2, arvore.getRaiz())));
    arvore.showNodeInfo(101);
    // arvore.removeNode(103);
    arvore.showTree(arvore.buscar(2, arvore.getRaiz()));
    arvore.showNodeInfo(2);
    arvore.showAlturas(null);
    arvore.showProfundidades(null);
    arvore.showGraus(null);
    // arvore.showSubarvores(null);
    


    //TESTES BINARIA TRUE

      System.out.println("TESTES BINARIA TRUE\n");

      ArvoreGenerica<Integer> arvoreBinaria2 = new ArvoreGenerica<Integer>(0);
      arvoreBinaria2.setType(2);
      arvoreBinaria2.addLeft(0, 1);
      arvoreBinaria2.addRight(0, 2);
      arvoreBinaria2.addLeft(1, 5);
      arvoreBinaria2.addRight(1, 3);
      arvoreBinaria2.addLeft(2, 4);
      arvoreBinaria2.addRight(4, 6);
      arvoreBinaria2.addLeft(4, 8);
      // System.out.println("busasd " +  arvoreBinaria2.buscar(2, null));
      // System.out.println("algo aki " + arvoreBinaria2.getRaiz().getRight());

      //showArvore
      System.out.println("show arvore\n" + arvoreBinaria2.getRaiz().getValor());
      arvoreBinaria2.showTree(arvoreBinaria2.getRaiz());

      //getInternos
      System.out.println("internos: " + arvoreBinaria2.getInternosList(null));
      System.out.println("subarvores");
      // arvoreBinaria2.showSubarvores(null);

      //getFolhas
      System.out.println("folhas: " + arvoreBinaria2.getFolhas(null));
      //profundidade / altura
      System.out.println("altura: " + arvoreBinaria2.getAlturaNode(arvoreBinaria2.buscar(0, null)));
      
      System.out.println("profundidade " + arvoreBinaria2.getProfundidadeFromNode(arvoreBinaria2.getRaiz(), arvoreBinaria2.buscar(1, null)));
      System.out.println("grau " + arvoreBinaria2.buscar(2, null).getGrauBinary());
      System.out.println("altura da arvore " + arvoreBinaria2.getAlturaThree());
      arvoreBinaria2.showInternos(arvoreBinaria2.buscar(1, null));
      arvoreBinaria2.showFolhas(null);
      System.out.println("profundidades");
      arvoreBinaria2.showProfundidades(null);
      System.out.println("alturas");
      arvoreBinaria2.showAlturas(null);
      System.out.println("arvore graus");
      arvoreBinaria2.showGraus(null);

      arvoreBinaria2.showNodeInfo(2);
      System.out.println(arvoreBinaria2.getNodesList(null));
      // arvoreBinaria2.inserirBB();

      // arvoreBinaria2.showTree(arvoreBinaria2.getRaiz());

      //teste de remoção
      // System.out.println("show arvore\n" + arvoreBinaria2.getRaiz().getValor());
      // arvoreBinaria2.showTree(arvoreBinaria2.getRaiz());
      
      // arvoreBinaria2.removeBinary(3);

      // System.out.println("show arvore\n" + arvoreBinaria2.getRaiz().getValor());
      // arvoreBinaria2.showTree(arvoreBinaria2.getRaiz());
      System.out.println("\nFIM TESTE BINARIA\n");
//TESTE ARVORE BINARIA DE BUSCA 
System.out.println("show arvore\n" + arvoreBinaria2.getRaiz().getValor());
System.out.println("\nBINARIA DE BUSCA\n");
arvoreBinaria2.showTree(null);
arvoreBinaria2.convertToSearchBinary(null);
arvoreBinaria2.inserirBB(9);
// arvoreBinaria2.inserirBB(7);
arvoreBinaria2.removeBinary(8);

// arvoreBinaria2.removeBinary(6);
// arvoreBinaria2.clearTree(null);

// arvoreBinaria2.getRaiz().setValor(40);
// arvoreBinaria2.inserirBB(30);
// arvoreBinaria2.inserirBB(65);
// arvoreBinaria2.inserirBB(25);
// arvoreBinaria2.inserirBB(35);
// arvoreBinaria2.inserirBB(75);
// arvoreBinaria2.inserirBB(28);
// arvoreBinaria2.inserirBB(38);
// arvoreBinaria2.inserirBB(26);

// arvoreBinaria2.removeBinary(30);

// arvoreBinaria2.buscar(2, null)


System.out.println("show arvore\n" + arvoreBinaria2.getRaiz().getValor());
arvoreBinaria2.showTree(null);

ArvoreGenerica<Integer> arvore3 = new ArvoreGenerica<Integer>(40);

//iniciar como generica
System.out.println("APRESENTAÇÃO MAIN");
arvore3.inserirNode(null, 30);
arvore3.inserirNode(null, 55);//new
arvore3.inserirNode(null, 65);

arvore3.inserirNode(30, 25);
arvore3.inserirNode(30, 29); //new
arvore3.inserirNode(30, 35);

arvore3.inserirNode(25, 28);
arvore3.inserirNode(28, 26);

arvore3.inserirNode(35, 38);

arvore3.inserirNode(65, 75);

System.out.println("show arvore\n" + arvore3.getRaiz().getValor());
arvore3.showTree(null);

arvore3.convertTrueBinary(null);

System.out.println("show arvore\n" + arvore3.getRaiz().getValor());
arvore3.showTree(null);

arvore3.convertToSearchBinary(null);

// arvore3.showNodeInfo(30);

// System.out.println("show arvore\n" + arvore3.getRaiz().getProfundidade());
// arvore3.showProfundidades(null);

// arvore3.showSubarvores(null);

arvore3.removeBinary(30);

arvore3.clearTree(null);

arvore3.inserirBB(30);
arvore3.inserirBB(65);
arvore3.inserirBB(25);
arvore3.inserirBB(35);
arvore3.inserirBB(75);
arvore3.inserirBB(28);
arvore3.inserirBB(38);
arvore3.inserirBB(26);
System.out.println("show arvore\n" + arvore3.getRaiz().getValor());
arvore3.showTree(null);

// System.out.println("\u001B[41m"+ " 10 "+ "\u001B[0m");
System.out.println("\n\n\nÁrvore RED BLACK\n");
// RB.insertNode(40);
// RB.insertNode(30);
// RB.insertNode(50);
// RB.insertNode(45);
// RB.insertNode(55);
// RB.insertNode(52);
ArvoreRedBlack<Integer> RB = new ArvoreRedBlack();

// RB.insertNode(41);
// RB.insertNode(38);

//rotação simples direita
// RB.insertNode(31);

// RB.insertNode(12);

//rotação dupla esquerda
// RB.insertNode(19);

// RB.insertNode(8);

//rotação direita
// RB.insertNode(6);

//rotação direita na raiz
// RB.insertNode(5);


//remoções
// RB.deleteNode(8); //1 time

// RB.deleteNode(5);
// RB.deleteNode(6);



System.out.println("Red Black");
RB.showRBTree(null);


//funções antigas
  // System.out.println("\nFunções antigas");
  // RB.showTree(RB.getRoot());
  // RB.showInternos(RB.getRoot());
  // RB.showFolhas(RB.getRoot());
  // System.out.println("Altura da árvore: " + RB.getAlturaThree(RB.getRoot()));
  
  // //alturas
  // RB.showAlturas(RB.getRoot());
  // RB.showGraus(RB.getRoot());

  // //internos e folhas
  // RB.showSubarvores(RB.getRoot());

  // RB.showNodeInfo(RB.getRoot());

  
  }
}