package mx.unam.fciencias.myp;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;


class PlayDemo {
    /**
     * This method takes a Demo and wraps it within a JFrame, which is set to
     * the specified dimensions and returned. The returned frame is visible,
     * always on top and exits on close by default.
     *
     * @param demo   The demo to be wrapped.
     * @param width  The width of the panel.
     * @param height The height of the panel.
     * @return A visible frame that contains the provided demo.
     */
    private static JFrame wrapDemo(Demo demo, int width, int height) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle(demo.title);
        frame.setVisible(true);
        demo.setSize(width, height);
        frame.add(demo, BorderLayout.CENTER);
        frame.pack();
        frame.setAlwaysOnTop(true);
        return frame;
    }

    /**
     * Displays the four included demos.
     *
     * @param args commandline arguments.
     */
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
            wrapDemo(demos.get(i), side, side).setLocation(i * side, 0);
        }


    }
}
