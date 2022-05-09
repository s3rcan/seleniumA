import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiDeneme extends JFrame {
    private JTextField input;
    private JButton OKButton;
    private JTextArea textArea;
    private JPanel mainPanel;
    private JButton BButton;

    public GuiDeneme(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = input.getText();
                textArea.setText("hehe : " + a);

            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new GuiDeneme("Test 0.1");
        frame.setVisible(true);
    }
}
