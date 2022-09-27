import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import arvoreGenerica.ArvoreGenerica;
import arvoreGenerica.GenericNode;

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
    arvore.convertToBinary(arvore.buscar(2, null));
    arvore.showTree(arvore.buscar(2, null));
    arvore.showTree(arvore.buscar(2, arvore.getRaiz()));
    System.out.println("folhas aq: " + arvore.getFolhas(arvore.buscar(5, arvore.getRaiz())));
    System.out.println("profundidade de nó: " + arvore.getProfundidade(null, arvore.buscar(103, arvore.getRaiz())));
    System.out.println("altura de x ate y: "
        + arvore.getProfundidadeFromNode(arvore.buscar(2, arvore.getRaiz()), arvore.buscar(103, arvore.getRaiz())));
    System.out.println("maior grau de raiz: " + arvore.getMaxNodeGrau(arvore.buscar(2, arvore.getRaiz())));
    arvore.showNodeInfo(103);
    arvore.removeNode(103);
    arvore.showTree(arvore.buscar(2, arvore.getRaiz()));
    arvore.showNodeInfo(2);
    arvore.showAlturas(null);
    arvore.showProfundidades(null);
    arvore.showSubarvores(null);

    //TESTES BINARIA TRUE

    System.out.println("TESTES BINARIA TRUE\n");

    ArvoreGenerica<Integer> arvoreBinaria2 = new ArvoreGenerica<Integer>(0);
    arvoreBinaria2.setType(2);
    arvoreBinaria2.addLeft(0, 1);
    arvoreBinaria2.addRight(0, 2);
    arvoreBinaria2.addLeft(1, 3);
    // System.out.println("algo aki " + arvoreBinaria2.getRaiz().getRight());

    //showArvore
    System.out.println("show arvore\n" + arvoreBinaria2.getRaiz().getValor());
    arvoreBinaria2.showTree(arvoreBinaria2.getRaiz());

    System.out.println("\nFIM TESTE BINARIA\n");

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