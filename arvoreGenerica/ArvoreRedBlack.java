package arvoreGenerica;

public class ArvoreRedBlack<T extends Comparable<T>> extends ArvoreGenerica{

    protected GenericNode<T> root;

    static final boolean RED = false;
    static final boolean BLACK = true;

    public ArvoreRedBlack(){
      super();
      this.setType(3);
    }

    public GenericNode<T> getRoot() {
        return root;
      }

    public void showRBTree(GenericNode<T> no) { // caso passar um no exibir a sub arvore (igual a busca)
            if(no == null){
              no = root;
          }
          if( no == root){
            System.out.println("\u001B[30m"+" " + no.getValor() + "\u001B[0m");
          }
          if (no.hasLeft()) {
              System.out.print("  ");
              for (int j = 0; j < getProfundidade(null, no); j++) {
                  System.out.print("  ");
              }
              System.out.println(no.getLeft().color == BLACK ? "\u001B[30m"+ no.getLeft().getValor() + "\u001B[0m" : "\u001B[31m"+ no.getLeft().getValor() + "\u001B[0m");
              showRBTree(no.getLeft());
          }

          if (no.hasRight()) {
              System.out.print("  ");
              for (int j = 0; j < getProfundidade(null, no); j++) {
                  System.out.print("  ");
              }
              System.out.println(no.getRight().color == BLACK ? "\u001B[30m"+ no.getRight().getValor() + "\u001B[0m" : "\u001B[31m"+ no.getRight().getValor() + "\u001B[0m");
              showRBTree(no.getRight());
          }
  }

    public GenericNode<T> searchNode(Comparable<T> key) {
      GenericNode<T> node = root;
      while (node != null) {
        if (key == node.valor) {
          return node;
        } else if ( (int) key < (int) node.valor) {
          node = node.left;
        } else {
          node = node.right;
        }
      }
  
      return null;
    }
  
    public void insertNode(T key) {
      GenericNode<T>  node = root;
      GenericNode<T>  parent = null;
  

      while (node != null) {
        parent = node;
        if ((int) key < (int) node.valor) {
          node = node.left;
        } else if ((int) key > (int) node.valor) {
          node = node.right;
        } else {
          throw new IllegalArgumentException("Nó "+ key +" ja existe" + key);
        }
      }

      GenericNode<T> newNode = new GenericNode<T>(key);
      newNode.color = RED;
      if (parent == null) {
        root = newNode;
      } else if ((int) key < (int) parent.valor) {
        parent.left = newNode;
      } else {
        parent.right = newNode;
      }
      newNode.pai = parent;
  
      fixRedBlackPropertiesAfterInsert(newNode);
    }
  
    private void fixRedBlackPropertiesAfterInsert(GenericNode<T> node) {
      GenericNode<T> parent = node.pai;

      if (parent == null) {
        return;
      }
      if (parent.color == BLACK) {
        return;
      }

      GenericNode<T> grandparent = parent.pai;
      if (grandparent == null) {
        parent.color = BLACK;
        return;
      }
      GenericNode<T> uncle = getUncle(parent);

      if (uncle != null && uncle.color == RED) {
        parent.color = BLACK;
        grandparent.color = RED;
        uncle.color = BLACK;
        fixRedBlackPropertiesAfterInsert(grandparent);
      }
      else if (parent == grandparent.left) {
        if (node == parent.right) {
          rotateLeft(parent);
          parent = node;
        }
        rotateRight(grandparent);
        parent.color = BLACK;
        grandparent.color = RED;
      }
  
      else {
        if (node == parent.left) {
          rotateRight(parent);
          parent = node;
        }
        rotateLeft(grandparent);
        parent.color = BLACK;
        grandparent.color = RED;
      }
    }
  
    private GenericNode<T> getUncle(GenericNode<T> parent) {
      GenericNode<T> grandparent = parent.pai;
      if (grandparent.left == parent) {
        return grandparent.right;
      } else if (grandparent.right == parent) {
        return grandparent.left;
      } else {
        throw new IllegalStateException("erro parentesco");
      }
    }
  
  
    public void deleteNode(T key) {
      GenericNode<T> node = root;
  
      while (node != null && node.valor != key) {
        if ((int) key < (int) node.valor) {
          node = node.left;
        } else {
          node = node.right;
        }
      }
      if (node == null) {
        return;
      }

      GenericNode<T> movedUpNode;
      boolean deletedNodeColor;
  
      if (node.left == null || node.right == null) {
        movedUpNode = deleteNodeWithZeroOrOneChild(node);
        deletedNodeColor = node.color;
      }
  
      else {
        GenericNode<T> inOrderSuccessor = findMinimum(node.right);
        node.valor = inOrderSuccessor.valor;
        movedUpNode = deleteNodeWithZeroOrOneChild(inOrderSuccessor);
        deletedNodeColor = inOrderSuccessor.color;
      }
  
      if (deletedNodeColor == BLACK) {
        fixRedBlackPropertiesAfterDelete(movedUpNode);

        if (movedUpNode.getClass() == NilNode.class) {
          replaceParentsChild(movedUpNode.pai, movedUpNode, null);
        }
      }
    }
  
    private GenericNode<T> deleteNodeWithZeroOrOneChild(GenericNode<T> node) {
      if (node.left != null) {
        replaceParentsChild(node.pai, node, node.left);
        return node.left;
      }
  

      else if (node.right != null) {
        replaceParentsChild(node.pai, node, node.right);
        return node.right; 
      }

      else {
        GenericNode<T> newChild = node.color == BLACK ? (GenericNode<T>) new NilNode() : null;
        replaceParentsChild(node.pai, node, newChild);
        return newChild;
      }
    }
  
    private GenericNode<T> findMinimum(GenericNode<T> node) {
      while (node.left != null) {
        node = node.left;
      }
      return node;
    }
  
    private void fixRedBlackPropertiesAfterDelete(GenericNode<T> node) {

      if (node == root) {
        return;
      }
  
      GenericNode<T> sibling = getSibling(node);
      if (sibling.color == RED) {
        handleRedSibling(node, sibling);
        sibling = getSibling(node); 
      }
      if (isBlack(sibling.left) && isBlack(sibling.right)) {
        sibling.color = RED;
        
        if (node.pai.color == RED) {
          node.pai.color = BLACK;
        }
        else {
          fixRedBlackPropertiesAfterDelete(node.pai);
        }
      }
  
      else {
        handleBlackSiblingWithAtLeastOneRedChild(node, sibling);
      }
    }
  
    private void handleRedSibling(GenericNode<T> node, GenericNode<T> sibling) {
      sibling.color = BLACK;
      node.pai.color = RED;
  
      if (node == node.pai.left) {
        rotateLeft(node.pai);
      } else {
        rotateRight(node.pai);
      }
    }
  
    private void handleBlackSiblingWithAtLeastOneRedChild(GenericNode<T> node, GenericNode<T> sibling) {
      boolean nodeIsLeftChild = node == node.pai.left;

      if (nodeIsLeftChild && isBlack(sibling.right)) {
        sibling.left.color = BLACK;
        sibling.color = RED;
        rotateRight(sibling);
        sibling = node.pai.right;
      } else if (!nodeIsLeftChild && isBlack(sibling.left)) {
        sibling.right.color = BLACK;
        sibling.color = RED;
        rotateLeft(sibling);
        sibling = node.pai.left;
      }

      sibling.color = node.pai.color;
      node.pai.color = BLACK;
      if (nodeIsLeftChild) {
        sibling.right.color = BLACK;
        rotateLeft(node.pai);
      } else {
        sibling.left.color = BLACK;
        rotateRight(node.pai);
      }
    }
  
    private GenericNode<T> getSibling(GenericNode<T> node) {
      GenericNode<T> parent = node.pai;
      if (node == parent.left) {
        return parent.right;
      } else if (node == parent.right) {
        return parent.left;
      } else {
        throw new IllegalStateException("erro parentesco");
      }
    }
  
    private boolean isBlack(GenericNode<T> node) {
      return node == null || node.color == BLACK;
    }
  
    private static class NilNode extends GenericNode<Integer> {
      private NilNode() {
        super(0);
        this.color = BLACK;
      }
    }
  
    private void rotateRight(GenericNode<T> node) {
      GenericNode<T> parent = node.pai;
      GenericNode<T> leftChild = node.left;
  
      node.left = leftChild.right;
      if (leftChild.right != null) {
        leftChild.right.pai = node;
      }
  
      leftChild.right = node;
      node.pai = leftChild;
  
      replaceParentsChild(parent, node, leftChild);
    }
  
    private void rotateLeft(GenericNode<T> node) {
      GenericNode<T> parent = node.pai;
      GenericNode<T> rightChild = node.right;
  
      node.right = rightChild.left;
      if (rightChild.left != null) {
        rightChild.left.pai = node;
      }
  
      rightChild.left = node;
      node.pai = rightChild;
  
      replaceParentsChild(parent, node, rightChild);
    }
  
    private void replaceParentsChild(GenericNode<T> parent, GenericNode<T> oldChild, GenericNode<T> newChild) {
      if (parent == null) {
        root = newChild;
      } else if (parent.left == oldChild) {
        parent.left = newChild;
      } else if (parent.right == oldChild) {
        parent.right = newChild;
      } else {
        throw new IllegalStateException("Não é filho do parente inserido");
      }
  
      if (newChild != null) {
        newChild.pai = parent;
      }
    }
}
