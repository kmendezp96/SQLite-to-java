package classes;

import java.io.File;
import java.io.FileInputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import classes.SQLiteBaseVisitor;
import classes.SQLiteLexer;
import classes.SQLiteParser;

public class prueba {
	public static void main(String [] args) throws Exception{
		System.setIn(new FileInputStream(new File("input.txt")));
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		SQLiteLexer lexer = new SQLiteLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SQLiteParser parser = new SQLiteParser(tokens);
		ParseTree tree = parser.parse();
		

		SQLiteBaseVisitor<Object> loader = new SQLiteBaseVisitor<Object>();
		loader.visit(tree);
	}

}
