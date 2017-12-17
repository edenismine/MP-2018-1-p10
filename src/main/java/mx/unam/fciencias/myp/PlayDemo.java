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
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle(panel.title);
        return frame;
    }

    public static void main(String[] args) {
        int lines = 30;
        LinkedList<Demo> demos = new LinkedList<>();
        demos.add(new DemoOne(lines));
        demos.add(new DemoTwo(lines));
        demos.add(new DemoThree());
        demos.add(new DemoFour());

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        Double normalize = (double) (screenSize.width / demos.size()) / (double) lines;
        int side = normalize.intValue() * lines;
        for (int i = 0; i < demos.size(); i++) {
            Demo demo = demos.get(i);
            JFrame frame = wrapDemo(demo, side, side);
            frame.setLocation(i * side, 0);
            if (demo instanceof DemoOne || demo instanceof DemoTwo)
                frame.setResizable(false);
        }


    }
}
