import java.awt.*;
import javax.swing.*;

public class Finestre extends JFrame {
    static JButton uno = new JButton("Uno");
    static JButton due = new JButton("Due");
    static JButton tre = new JButton("Tre");
    static JButton quattro = new JButton("Quattro");
    static JButton cinque = new JButton("Cinque");
    static JButton sei = new JButton("Sei");
    static JButton sette = new JButton("Sette");
    static JButton otto = new JButton("Otto");
    static JButton nove = new JButton("Nove");

    public Finestre(String nome, int x, int y, String say) {
        super(nome);
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(3, 3));
        c.add(uno);
        c.add(due);
        c.add(tre);
        c.add(quattro);
        c.add(cinque);
        c.add(sei);
        c.add(sette);
        c.add(otto);
        c.add(nove);
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        String say = "Con cosa vuoi giocare? 1 = x; -1 = o";
        Finestre finestra = new Finestre("Finestra", 10, 10, say);

        uno.addActionListener(e ->
        {
            int[] coordinate = {0, 0};
            System.out.println("Coordinate del tasto Uno: (" + coordinate[0] + ", " + coordinate[1] + ")");
        }
        );
        due.addActionListener(e ->
                {
                    int[] coordinate = {0, 1};
                    System.out.println("Coordinate del tasto Uno: (" + coordinate[0] + ", " + coordinate[1] + ")");
                }
        );
        tre.addActionListener(e ->
                {
                    int[] coordinate = {0, 2};
                    System.out.println("Coordinate del tasto Uno: (" + coordinate[0] + ", " + coordinate[1] + ")");
                }
        );
        quattro.addActionListener(e ->
                {
                    int[] coordinate = {1, 0};
                    System.out.println("Coordinate del tasto Uno: (" + coordinate[0] + ", " + coordinate[1] + ")");
                }
        );
        cinque.addActionListener(e ->
                {
                    int[] coordinate = {1, 1};
                    System.out.println("Coordinate del tasto Uno: (" + coordinate[0] + ", " + coordinate[1] + ")");
                }
        );
        sei.addActionListener(e ->
                {
                    int[] coordinate = {1, 2};
                    System.out.println("Coordinate del tasto Uno: (" + coordinate[0] + ", " + coordinate[1] + ")");
                }
        );
        sette.addActionListener(e ->
                {
                    int[] coordinate = {2, 0};
                    System.out.println("Coordinate del tasto Uno: (" + coordinate[0] + ", " + coordinate[1] + ")");
                }
        );
        otto.addActionListener(e ->
                {
                    int[] coordinate = {2, 1};
                    System.out.println("Coordinate del tasto Uno: (" + coordinate[0] + ", " + coordinate[1] + ")");
                }
        );
        nove.addActionListener(e ->
                {
                    int[] coordinate = {2, 2};
                    System.out.println("Coordinate del tasto Uno: (" + coordinate[0] + ", " + coordinate[1] + ")");
                }
        );


        // Aggiungi azioni per gli altri pulsanti della tabella
    }
}