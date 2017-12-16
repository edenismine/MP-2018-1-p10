package mx.unam.fciencias.myp;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;


class PlayDemo {
    private static JFrame wrapDemo(Demo panel, int width, int height) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        panel.setSize(width,height);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle(panel.title);
        return frame;
    }

    public static void main(String[] args) {
        int lines = 30;
        LinkedList<Demo> demos = new LinkedList<>();
        demos.add(new DemoOne(lines));
        demos.add(new DemoTwo(lines));
        demos.add(new DemoThree());

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        Double normalize = (double) (screenSize.width / demos.size()) / (double) lines;
        int side = normalize.intValue() * lines - 10;
        for (int i = 0; i < demos.size(); i++) {
            wrapDemo(demos.get(i), side, side).setLocation(i * side, 0);
        }


    }
}
