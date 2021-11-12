package pj_gui;

import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends Frame {
    private Button b1;
    private Label l1, caption;
    private Panel p1;
    private CheckboxGroup znacka;
    private Checkbox isWhite, sb, k, p;


    public Window() {
        try {
            super.setTitle("PJ CV06 part 1");

        } catch (Exception e) {
            e.printStackTrace();
        }


        this.setLayout(null);
        caption = new Label("Vyberte si pivo");
        caption.setFont(new Font("Calibri", Font.PLAIN, 24));
        caption.setBounds(250, 30, 300, 30);
        this.add(caption);

        p1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        //p1.se
        p1.setBounds(30, 70, 100, 90);
        znacka = new CheckboxGroup();
        sb = new Checkbox("Starobrno", znacka, true);
        k = new Checkbox("Krusovice", znacka, false);
        p = new Checkbox("Plzen", znacka, false);
        p1.add(sb);
        p1.add(k);
        p1.add(p);
        //p1.add(new Checkbox("Starobrno", znacka, true));
        //p1.add(new Checkbox("Krusovice", znacka, false));
        //p1.add(new Checkbox("Plzen", znacka,false));
        this.add(p1);
        isWhite = new Checkbox("Psenicne");
        isWhite.setBounds(30, 180, 100, 20);

        this.add(isWhite);
        isWhite.addItemListener(this::itemStateChanged);

        b1 = new Button("Test");
        b1.setBounds(20,30,100,30);
        //this.add(b1);
        l1 = new Label("This is a label");
        l1.setBounds(320, 400, 200, 60);
        this.add(l1);
        this.setSize(640, 480);

        addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                dispose();
            }
        });

    }
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == isWhite) {
            if (e.getStateChange() == 1) {
                l1.setText("Krusovice psenicne");
                znacka.setSelectedCheckbox(k);
                k.setEnabled(false);
                p.setEnabled(false);
                sb.setEnabled(false);
            } else {
                k.setEnabled(true);
                p.setEnabled(true);
                sb.setEnabled(true);
                l1.setText("Krusovice");
            }
        }


    }

}
