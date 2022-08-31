import java.util.ArrayList;

class Main {
  // tes
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

    for (int i = 0; i < lista.size(); i++)  {
      if(i > 1){
        lista.remove(i);
      }
    }

    System.out.println(lista);

    System.out.println(a.getName());
  }
}