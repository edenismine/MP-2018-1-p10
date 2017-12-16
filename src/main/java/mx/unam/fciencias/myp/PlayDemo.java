package mx.unam.fciencias.myp;

import javax.swing.*;
import java.awt.*;


class PlayDemo {
    private static void wrapPanel(JPanel panel, int width, int height){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        panel.setSize(width,height);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        JPanel demoOne = new DemoOne(30);
        wrapPanel(demoOne,600, 600);

        JPanel demoTwo = new DemoTwo(30);
        wrapPanel(demoTwo, 600, 600);
    }
}
