package gui;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class VtnCrearDocumento extends JDialog {
    private JPanel contentPane;
    
    public VtnCrearDocumento() {
        initComponents();
        addListeners();
    }

    private void addListeners() {
        
    }
    
    private void initComponents() {
        contentPane = new JPanel(new GridLayout());
        setContentPane(contentPane);
        setModal(true);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    
}