import java.util.*;

class Status {

    public void render(Vector<String> v) {
        System.out.println("\n=== Estado de V ===");
        System.out.println("nº de elementos " + v.size());
        System.out.println("dimensión " + v.capacity());

        System.out.println("=== Con For Clasico ==");
        for (int i=0; i < v.size(); i++) {
            System.out.println(" > " + v.elementAt(i));
        }
        System.out.println("===\n");

        System.out.println("=== Con For Item ==");
        for (String item : v) {
            System.out.println(" > " + item);
        }
        System.out.println("===\n");

        System.out.println("=== Con While e iterador ==");
        Iterator<String> i = v.iterator();
        while (i.hasNext()) {
            String item = i.next();
            System.out.println(" > " + item);
        }
        System.out.println("===\n");
    }

    public void render(LinkedList<String> q) {
        System.out.println("\n=== Estado de Q ===");
        System.out.println("nº de elementos " + q.size());

        System.out.println("=== Con For Clasico ==");
        for (int i = 0; i < q.size(); i++) {
            System.out.println(" > " + q.get(i));
        }
        System.out.println("===\n");

        System.out.println("=== Con For Item ==");
        for (String item : q) {
            System.out.println(" > " + item);
        }
        System.out.println("===\n");

        System.out.println("=== Con While e iterador ==");
        Iterator<String> i = q.iterator();
        while (i.hasNext()) {
            String item = i.next();
            System.out.println(" > " + item);
        }
        System.out.println("===\n");
    }
}

class VectorSample {

    public void run() {
        System.out.println("Mostramos como trabajar con un vector");

        Vector<String> v = new Vector<String>();

        Status view = new Status();

        view.render(v);

        //Agregando Elementos
        v.addElement("Uno");
        v.addElement("Dos");
        v.addElement("Tres");
        v.addElement("Cinco");
        v.addElement("Seis");

        view.render(v);

        //Agregar en Posicion Especifica
        v.insertElementAt("Cuatro", 3);

        view.render(v);

        //Quitando Elementos
        v.removeElement("Cinco"); //Borra el elemento === "Cinco"
        v.removeElementAt(3); //Borra Elemento en posición 3

        view.render(v);

        v.removeAllElements();

        view.render(v);
    }
}

class QueueSample {

    public void run() {
        LinkedList<String> q = new LinkedList<String>();
        Status s = new Status();

        q.add("Uno");
        q.add("Dos");
        q.add("Tres");
        q.add("Cuatro");
        q.add("Cinco");
        q.add("Seis");

        s.render(q);

        q.poll(); //Saca Uno, primero de la lista
        q.pollLast(); //Saca Seis, último de la lista

        s.render(q);
    }
}

public class Main {

    public static void main(String[] args) {
        new VectorSample().run();
        new QueueSample().run();
    }
}