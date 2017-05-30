package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.Color;
 

public class MainWindow extends JFrame 
    implements ActionListener{
	public MainWindow() {
		
		JButton btnNewButton = new JButton("Cargar archivo");
		btnNewButton.setSize(900, 400);
		btnNewButton.setBounds(10, 51, 131, 25);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnNewButton, BorderLayout.WEST);
		
	}
 
    JTextArea textArea;
    JButton buttonOpenFile;
     
    public static void main(String[] args) {
         
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
 
    private static void createAndShowGUI() {
    	MainWindow myFrame = new MainWindow();
 
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        myFrame.prepareUI();
 
        myFrame.pack();
        myFrame.setVisible(true);
    }
     
    private void prepareUI(){
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane panel = new JScrollPane(textArea);
        panel.setPreferredSize(new Dimension(800, 600));
         
        buttonOpenFile = new JButton("Open File");
        buttonOpenFile.setSize(700, 400);
        buttonOpenFile.setBounds(10, 51, 131, 25);
        buttonOpenFile.addActionListener(this);
         
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonOpenFile, BorderLayout.AFTER_LAST_LINE);

    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
         
        if(e.getSource() == buttonOpenFile){
            final JFileChooser jFileChooser = new JFileChooser();
            int returnVal = jFileChooser.showOpenDialog(MainWindow.this);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                File file = jFileChooser.getSelectedFile();
                textArea.setText("Selected file: " + file.getName());
            }else if(returnVal == JFileChooser.CANCEL_OPTION){
                textArea.setText("Cancelled");
            }else if(returnVal == JFileChooser.ERROR_OPTION){
                textArea.setText("Error!");
            }else{
                textArea.setText("unknown...");
            }
        }
    }
}
