package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;

import classes.SQLiteBaseVisitor;
import classes.SQLiteLexer;
import classes.SQLiteParser;

import org.eclipse.swt.widgets.Button;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.events.TouchEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Label;
import javax.swing.JTextField;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Composite;
import java.awt.Frame;
import org.eclipse.swt.awt.SWT_AWT;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JRootPane;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;

public class MWindow {

	static File archivo=new File("input.txt");
	
	protected Shell shlSqliteToJava;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtArchivo;
	private Text output;

	/**
	 * Launch the application.
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		try {
			MWindow window = new MWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlSqliteToJava.open();
		shlSqliteToJava.layout();
		while (!shlSqliteToJava.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSqliteToJava = new Shell();
		shlSqliteToJava.setImage(SWTResourceManager.getImage(MWindow.class, "/img/sqlitelogo-200x200sm.png"));
		shlSqliteToJava.setSize(800, 448);
		shlSqliteToJava.setText("SQLite to java");
		
		Button btnAlgo = formToolkit.createButton(shlSqliteToJava, "Seleccionar archivo", SWT.NONE);
		btnAlgo.setFont(SWTResourceManager.getFont("Segoe UI Black", 9, SWT.NORMAL));
		
		btnAlgo.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseDown(MouseEvent e) {
		            JFileChooser jf = new JFileChooser();
		            jf.showOpenDialog(null);
		            archivo = jf.getSelectedFile();
		            if (archivo!=null){
		            	
		            	txtArchivo.setText("Selected file: " + archivo.getAbsolutePath());
		            	
		            	try {
							System.setIn(new FileInputStream(archivo));
							ANTLRInputStream input = new ANTLRInputStream(System.in);
			        		SQLiteLexer lexer = new SQLiteLexer(input);
			        		CommonTokenStream tokens = new CommonTokenStream(lexer);
			        		SQLiteParser parser = new SQLiteParser(tokens);
			        		ParseTree tree = parser.parse();
			        		SQLiteBaseVisitor<Object> loader = new SQLiteBaseVisitor<Object>();
			        		loader.visit(tree);
			        		System.out.println(loader.out);
			        		output.setText(loader.out);
			        		
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        		
		            }
		          
		        
			}

		});
		btnAlgo.setBounds(497, 267, 131, 25);
		
		txtArchivo = formToolkit.createText(shlSqliteToJava, "New Text", SWT.NONE);
		txtArchivo.setText("");
		txtArchivo.setBounds(37, 272, 439, 20);
		
		Label label = formToolkit.createLabel(shlSqliteToJava, "", SWT.NONE);
		label.setImage(SWTResourceManager.getImage(MWindow.class, "/img/SQLite-Java.jpg"));
		label.setBounds(89, 35, 456, 211);
		
		output = formToolkit.createText(shlSqliteToJava, "New Text", SWT.NONE);
		output.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		output.setText("");
		output.setBounds(40, 338, 713, 43);
		
		Label lblSalida = formToolkit.createLabel(shlSqliteToJava, "Salida:", SWT.NONE);
		lblSalida.setFont(SWTResourceManager.getFont("Segoe UI Semilight", 12, SWT.BOLD));
		lblSalida.setBounds(37, 307, 58, 25);
		
		

		

	}
}
