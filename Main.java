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

System.out.println("\u001B[41m"+ " 10 "+ "\u001B[0m");
ArvoreRedBlack<Integer> RB = new ArvoreRedBlack();
RB.insertNode(41);
RB.insertNode(38);
RB.insertNode(31);
RB.insertNode(12);
RB.insertNode(19);
RB.insertNode(8);

// RB.insertNode(40);
// RB.insertNode(30);
// RB.insertNode(50);
// RB.insertNode(45);
// RB.insertNode(55);
// RB.insertNode(52);

RB.showRBTree(null);

System.out.println();
// System.out.println(RB.searchNode(2).getRight().getValor());





    //INICIO MAIN
    Scanner s = new Scanner(System.in);
    int value;

    System.out.print("Insira o valor da raiz: ");
    value = s.nextInt();
    ArvoreGenerica<Integer> a = new ArvoreGenerica<Integer>(value);
    System.out.println(value);
    System.out.println("Gravar nós na árvore (inserir -1 pra parar)");
    int v1;
    int v2;
    while (true) {
      System.out.println("Árvore");
      System.out.println(a.getRaiz().getValor());
      a.showTree(null);
      System.out.println("");

      System.out.print("Nó que deseja inserir o filho (-1 para concluir): ");
      v1 = s.nextInt();
      if (v1 == -1) {
        break;
      }

      System.out.print("Valor do novo nó (-1 para concluir): ");
      v2 = s.nextInt();
      if (v2 == -1) {
        break;
      }
      System.out.println("");
      a.inserirNode(v1, v2);
      System.out.println("");
      System.out.println(a.getRaiz().getValor());
      a.showTree(null);
      System.out.println("");
    }
    int option;
    while (true) {
      v1 = 0;
      v2 = 0;

      System.out.println("OPÇÕES:\n --Funções de árvore-- \n");
      System.out.println("-1 = parar");
      System.out.println("0 = Imprimir arvore ");
      System.out.println("1 = Inserir nó");
      System.out.println("2 = Nós folhas");
      System.out.println("3 = Nós internos");
      System.out.println("4 = Maior Grau da arvore");
      System.out.println("5 = Altura");
      System.out.println("6 = Profundidade");
      System.out.println("7 = Exibir informações de um nó");
      System.out.println("8 = Exibir altura dos nós");
      System.out.println("9 = Exibir profundidade dos nós");
      System.out.println("10 = Exibir sub-árvores");
      System.out.println("11 = Excluir um nó");
      System.out.println("12 = Converter árvore para BINÁRIA");

      System.out.println("13 = Exibir altura dos nós");

      System.out.print("Insira a opção: ");
      option = s.nextInt();

      // System.out.println("Valor da raiz "+ a.getRaiz().getValor() );
      System.out.println("");
      switch (option) {
        case 0:

          System.out.print("Insira o nó: ");
          v1 = s.nextInt();

          System.out.println(a.buscar(v1, a.getRaiz()).getValor());
          a.showTree(a.buscar(v1, a.getRaiz()));
          System.out.println("");

          break;

        case 1:
          if (a.getType() != 1) {
            System.out.print("Nó que deseja inserir o filho: ");
            v1 = s.nextInt();

            System.out.print("Valor do novo nó: ");
            v2 = s.nextInt();

            a.inserirNode(v1, v2);

            System.out.println("");
          } else {
            System.out.print("Insira o nó (-1 cancelar): ");
            v1 = s.nextInt();
            System.out.print("Valor do nó esquerdo (-1 cancelar): ");
            v2 = s.nextInt();
            if (v1 != -1) {
              a.addLeft(v1, v2);
            }
            System.out.print("Valor do nó direito (-1 cancelar): ");
            v2 = s.nextInt();
            if (v2 != -1) {
              a.addRight(v1, v2);
            }
          }
          break;

        case 2:
          System.out.print("Insira o nó: ");
          v1 = s.nextInt();
          a.showFolhas(a.buscar(v1, a.getRaiz()));
          System.out.println("");
          break;

        case 3:
          System.out.print("Insira o nó: ");
          v1 = s.nextInt();
          a.showInternos(a.buscar(v1, a.getRaiz()));

          System.out.println("");
          break;

        case 4:
          System.out.print("Insira o nó: ");
          v1 = s.nextInt();

          System.out.println("Maior grau de (sub)arvore " + a.buscar(v1, a.getRaiz()).getValor() + ": "
              + a.getMaxNodeGrau(a.buscar(v1, a.getRaiz())));
          System.out.println("");
          break;

        case 5:
          System.out.print("Insira o nó: ");
          v1 = s.nextInt();

          System.out.println(
              "Altura de " + a.buscar(v1, a.getRaiz()).getValor() + ": " + a.getAlturaNode(a.buscar(v1, a.getRaiz())));
          System.out.println("");
          break;

        case 6:
          System.out.print("Insira o nó: ");
          v1 = s.nextInt();
          System.out.println("Profundidade de " + a.buscar(v1, a.getRaiz()).getValor() + ": "
              + a.getAlturaNode(a.buscar(v1, a.getRaiz())));
          System.out.println("");
          break;

        case 7:
          System.out.print("Insira o nó: ");
          v1 = s.nextInt();
          a.showNodeInfo(v1);
          System.out.println("");

          break;

        case 8:
          System.out.print("Insira o nó: ");
          v1 = s.nextInt();
          System.out.println("Altura dos nós:");
          System.out.println(a.getAlturaNode(a.buscar(v1, a.getRaiz())));
          a.showAlturas(a.buscar(v1, a.getRaiz()));

          System.out.println("");
          break;

        case 9:
          System.out.print("Insira o nó: ");
          v1 = s.nextInt();
          System.out.println("Profundidade dos nós:");
          System.out.println(a.getProfundidadeFromNode(a.getRaiz(), a.buscar(v1, a.getRaiz())));
          a.showProfundidades(a.buscar(v1, a.getRaiz()));

          System.out.println("");

          break;

        case 10:
          System.out.print("Insira o nó: ");
          v1 = s.nextInt();
          a.showSubarvores(a.buscar(v1, a.getRaiz()));
          break;

        case 11:
            System.out.print("Insira o nó que deseja remover: ");
            v1 = s.nextInt();
            a.removeNode(v1);
          
          break;

        case 12:
          System.out.print("Insira a (sub)árvore que deseja converter: ");
          v1 = s.nextInt();
          a.convertToBinary(a.buscar(v1, a.getRaiz()));
          a.setType(1);
          break;

          case 13:
          System.out.print("Insira o nó: ");
          v1 = s.nextInt();
          System.out.println("Grau dos nós:");
          System.out.println(a.buscar(v1, a.getRaiz()).getGrau());
          a.showGraus(a.buscar(v1, a.getRaiz()));

          System.out.println("");
          break;

      }
    }

  }

}