// Generated from SQLite.g4 by ANTLR 4.6
package classes;
import java.io.BufferedWriter;
import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link SQLiteVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class SQLiteBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements SQLiteVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	private String fileName = "";	
	private int countInserts=0;
	private String classBuf = "";
	String contentMain = "package translate; \n "+
			"class Main { \n"+
			"public static void main(String []args) throws IllegalArgumentException, IllegalAccessException{\n";
	BufferedWriter bw = null;
	FileWriter fw = null;
	@Override public T visitParse(SQLiteParser.ParseContext ctx) { 
		//System.out.println(ctx.getText());
		return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitError(SQLiteParser.ErrorContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSql_stmt_list(SQLiteParser.Sql_stmt_listContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSql_stmt(SQLiteParser.Sql_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAlter_table_stmt(SQLiteParser.Alter_table_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAnalyze_stmt(SQLiteParser.Analyze_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAttach_stmt(SQLiteParser.Attach_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBegin_stmt(SQLiteParser.Begin_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCommit_stmt(SQLiteParser.Commit_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCompound_select_stmt(SQLiteParser.Compound_select_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCreate_index_stmt(SQLiteParser.Create_index_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCreate_table_stmt(SQLiteParser.Create_table_stmtContext ctx) { 
		try {

			String content = "package translate; \n import java.util.LinkedList; \n import java.util.List; \n ";
			if(ctx.K_CREATE() != null){
				content = content + "public class ";
			}
			if(ctx.table_name() != null){
				content = content + ctx.table_name().getText()+" { \n";
				fileName=ctx.table_name().getText();
			}
			
			if(ctx.column_def() != null){
				String contentTemp="";
				String constructorHead="public "+fileName+"(";
				String constructorEmptyHead="\n public "+fileName+"() { \n";
				String constructorBody="";
				String constructorEmptyBody="";
				String contentMet="\n public void result(String a){ \n"+
				"System.out.print(\"\\t\\t|\"); \n";

				for (int i=0;i<ctx.column_def().size();i++){
					String type=ctx.column_def().get(i).type_name().getText();
					String id=ctx.column_def().get(i).column_name().getText();
					//System.out.println(ctx.column_def().get(i).getText());
					if (ctx.column_def().get(i).getText().startsWith("foreignkey")){
						int idI=ctx.column_def().get(i).getText().indexOf("foreignkey")+10;
						int idF=ctx.column_def().get(i).getText().indexOf("references");
						type="int";
						//System.out.println(ctx.column_def().get(i).getText());
						id= ctx.column_def().get(i).getText().substring(idI, idF); 
						
					}
					if (i==ctx.column_def().size()-1){
						contentMet=contentMet+"if(a.equals( \""+id+"\" ))"+" System.out.print("+id+"); \n } \n";
					} else {
						contentMet=contentMet+"if(a.equals( \""+id+"\" ))"+"System.out.print("+id+"); \n";
					}
						/*switch (type) {
		            case "int":  type = "int";
		                     break;
		            case "integer":  type = "int";
		                     break;
		            case "tynyint":  type = "byte";
		                     break;
		            case "smallint":  type = "small";
		                     break;
		            case "mediumint":  type = "int";
		                     break;
		            case "bigint":  type = "long";
		                     break;
		            case "unisigned big int":  type = "long";
		                     break;
		            case "int2":  type = "small";
		                     break;
		            case "int8":  type = "long";
		                     break;

		            case "nchar": type = "String";
		                    break;
		            case "native character": type = "String";
		                    break;
		            case "nvarchar": type = "String";
		                    break;
		            case "text": type = "String";
		                    break;
		            case ".*clob.*": type = "String";
		                    break;
		            case ".*real.*": type = "float";
		                    break;
		            case ".*double.*": type = "double";
		                    break;
		            case "float": type = "float";
		                    break;
		            case ".*numeric.*": type = "String";
		                    break;
		            case ".*decimal.*": type = "float";
		                    break;
		            case ".*boolean.*": type = "boolean";
		                    break;
		            case ".*date.*": type = "String";
		                    break;
		            case ".*datetime.*": type = "String";
                    		break;
				    default: type = "";
		                     break;
		        }*/
					//System.out.println(type+" "+ type.contains("notnull"));
					/*if (type.contains("unique")){
						
						content = content + "final boolean "+id+"Unique = true; \n";
					}
					else{
						
						content = content + "final boolean "+id+"Unique = false; \n";
					}
					if (type.contains("notnull") || type.contains("primarykey")){
						content = content + "final boolean "+id+"NotNull = true; \n";
					}else {
						
						content = content + "final boolean "+id+"NotNull = false; \n";
					}*/
					
					if (type.contains("primarykey")){
						contentTemp = contentTemp + "final int primaryKey= "+id+"; \n";
					}
					if (type.startsWith("varchar")){
						type="String";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"String "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n } \n }";
							
						}
						else {
							constructorHead=constructorHead+"String "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n";
						}
					}
					if (type.startsWith("text")){
						type="String";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"String "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"String "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n";
						}
					}
					if (type.startsWith("nchar")){
						type="String";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"String "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"String "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n";
						}
					}
					if (type.startsWith("nativecharacter")){
						type="String";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"String "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"String "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n";
						}
					}
					if (type.startsWith("nvarchar")){
						type="String";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"String "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"String "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n";
						}
					}
					if (type.startsWith("varyingcharacter")){
						type="String";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"String "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"String "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n";
						}
					}
					if (type.startsWith("clob")){
						type="String";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"String "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"String "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n";
						}
					}
					if (type.startsWith("datetime")){
						type="String";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"String "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"String "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n";
						}
					}
					if (type.startsWith("date")){
						type="String";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"String "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"String "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n";
						}
					}
					
					if (type.startsWith("numeric")){
						type="String";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"String "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"String "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"\"\""+"; \n";
						}
					}
					if (type.startsWith("int")){
						type="int";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"int "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"int "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n";
						}
					}
					if (type.startsWith("integer")){
						type="int";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"int "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"int "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n";
						}
					}
					if (type.startsWith("tynyint")){
						type="byte";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"byte "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"byte "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n";
						}
					}
					if (type.startsWith("smallint")){
						type="short";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"short "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"short "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n";
						}
					}
					if (type.startsWith("mediumint")){
						type="int";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"int "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"int "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n";
						}
					}
					if (type.startsWith("bigint")){
						type="long";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"long "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"long "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n";
						}
					}
					if (type.startsWith("unisignedbigint")){
						type="long";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"long "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"long "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n";
						}
					}
					if (type.startsWith("int2")){
						type="short";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"short "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"short "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n";
						}
					}
					if (type.startsWith("int8")){
						type="long";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"long "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"long "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n";
						}
					}
					if (type.startsWith("real")){
						type="float";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"float "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"float "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n";
						}
					}
					if (type.startsWith("float")){
						type="float";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"float "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"float "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n";
						}
					}
					if (type.startsWith("double")){
						type="double";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"double "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"double "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0"+"; \n";
						}
					}
					if (type.startsWith("decimal")){
						type="double";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"double "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0.0"+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"double "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"0.0"+"; \n";
						}
					}
					if (type.startsWith("boolean")){
						type="boolean";
						if (i==ctx.column_def().size()-1) {
							constructorHead=constructorHead+"boolean "+id+"){ \n";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n }";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"false"+"; \n } \n }";
						}
						else {
							constructorHead=constructorHead+"boolean "+id+", ";
							constructorBody=constructorBody+"this."+id+" = "+id+"; \n";
							constructorEmptyBody=constructorEmptyBody+"this."+id+" = "+"false"+"; \n";
						}
					}

					



					content = content + type + " " + id +"; \n";	
					
				
				}
				content = content + contentTemp;
				content = content + "LinkedList<"+fileName+"> table = new LinkedList<"+fileName+">(); \n";  
				content = content+constructorHead;
				content = content+constructorBody;
				content = content+contentMet;
				content = content+constructorEmptyHead;
				content = content+constructorEmptyBody;
			}
			fw = new FileWriter(fileName+ ".java");
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		
		
		return visitChildren(ctx); 
		}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCreate_trigger_stmt(SQLiteParser.Create_trigger_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCreate_view_stmt(SQLiteParser.Create_view_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCreate_virtual_table_stmt(SQLiteParser.Create_virtual_table_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDelete_stmt(SQLiteParser.Delete_stmtContext ctx) { 
		fileName = "Main";
		try{
			
			String className=ctx.qualified_table_name().getText();
			String column=ctx.expr().expr(0).column_name().getText();
			String val=ctx.expr().expr(1).literal_value().getText();		
			String expresion="";
			String op = ctx.expr().getText().substring(ctx.expr().getText().indexOf(column)+column.length(),ctx.expr().getText().indexOf(val));
			val=val.replace("\'", "\"");
			if (op.matches(".*=.*")){
			    op="==";
			    }
			if (op.matches(".*like.*")){
				val=val.replace("%", ".*");
			    expresion=column+".matches("+val+")";
			    expresion=expresion.replace("\'", "\"");
			    //System.out.println(expresion);
			    }
			else{
				expresion=column+op+val;
			}
			contentMain=contentMain+ "for (int d=0;d<holder"+className+".table.size();d++) { \n "+
			//className+"del = "holder"+className+".table.get(i); \n"+
			"if (holder"+className+".table.get(d)."+expresion+") { \n"+	
			"holder"+className+".table.remove(d); \n } \n } \n";
			
			fw = new FileWriter(fileName+ ".java");
			bw = new BufferedWriter(fw);
			bw.write(contentMain);

			System.out.println("delete done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDelete_stmt_limited(SQLiteParser.Delete_stmt_limitedContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDetach_stmt(SQLiteParser.Detach_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDrop_index_stmt(SQLiteParser.Drop_index_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDrop_table_stmt(SQLiteParser.Drop_table_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDrop_trigger_stmt(SQLiteParser.Drop_trigger_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDrop_view_stmt(SQLiteParser.Drop_view_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFactored_select_stmt(SQLiteParser.Factored_select_stmtContext ctx) {
		String from = "";
		String tabla;
		
		if(ctx.select_core(0).K_ALL()!=null){
			tabla = ctx.select_core(0).result_column(0).column_alias().getText();
			from = tabla+" holder = new "+tabla+"();\n";
			from += "holder = holder"+tabla+";\n";
		}
		else{
			tabla = ctx.select_core(0).table_or_subquery(0).table_name().any_name().getText();			
			from = tabla+" holder = new "+tabla+"();\n";
			from += "holder = holder"+tabla+";\n";
		}
		
		String select = from;
		
		if(ctx.select_core(0).K_ALL()!=null){
			select += ctx.select_core(0).result_column(0).column_alias().getText()+" nuevo = new "+ctx.select_core(0).result_column(0).column_alias().getText()+"();\n";
			select = select + "for (java.lang.reflect.Field field : nuevo.getClass().getDeclaredFields()) {";
			select += "\n	field.setAccessible(true);";
			select += "\n	String name = field.getName();";
			select += "\n	if(name!=\"table\"){";
			select += "\n	int espaciado =20-name.length();";
			select += "\n	String espacio=\"\";";
			select += "\n	for (int i=0;i<espaciado;i++){";
			select += "\n		espacio+=\" \";";
			select += "\n	}";
			select += "\n	System.out.print(name+espacio);";
			select += "\n	for(int i=0;i<holder.table.size();i++){";	
			
			if(ctx.select_core(0).K_WHERE()!=null){
				select += "\n";
				String con_a =ctx.select_core(0).expr(0).expr(0).getText();
				String con_b =ctx.select_core(0).expr(0).expr(1).getText();
				String operador = ctx.select_core(0).expr(0).getChild(1).getText();
				if(operador.equals("<>") || operador.equals("!=")){
					select+="if (!(String.valueOf(holder.table.get(i)."+con_a+").equals(\""+con_b+"\")))\n";	
				}
				else if(operador.equals("==")||operador.equals("=")){
					select+="if ((String.valueOf(holder.table.get(i)."+con_a+").equals(\""+con_b+"\")))\n";
				}
				else{
					select+="if (holder.table.get(i)."+con_a+operador+con_b+")\n";
				}
				
			}	
			
			
			
			
			select += "\n		holder.table.get(i).result(name);";
			select += "\n	}";
			select += "\n	System.out.println();";
			select += "\n	}";
			select += "\n}\n";
		}	
		
		
		
		else{
			String tex;
			int nparametros = ctx.select_core(0).result_column().size();
			select += "\nint espaciado;";
			select += "\nString espacio;\n\n";			
			for(int i = 0; i < nparametros;i++){
				tex = ctx.select_core(0).result_column(i).expr().column_name().any_name().getText();
				select += "String "+tex+" = "+"\""+tex+"\";\n";
				select += "espaciado = 20-"+tex+".length();\n";
				select += "espacio=\"\";\n";
				select += "for (int j=0;j<espaciado;j++){\n";
				select += "\tespacio+=\" \";\n";
				select += "}\n";
				select += "System.out.print("+tex+"+espacio);\n";				
				select += "\n";
			}
			select += "System.out.println();\n";
			
			if(ctx.select_core(0).K_WHERE()!=null){
				select += "\n";
				String con_b =ctx.select_core(0).expr(0).expr(1).getText();
				String operador = ctx.select_core(0).expr(0).getChild(1).getText();
				if(operador.equals("<>") || operador.equals("!=")||operador.equals("==")||operador.equals("=")){
					select += "String con_b;\n";			
					select += "con_b = \""+con_b+"\";\n";
				}
				else{
					select += "double con_b;\n";			
					select += "con_b = "+con_b+";\n";
				}				
			}		
			
			
			select += "for(int i=0;i<holder.table.size();i++){\n";
			
			if(ctx.select_core(0).K_WHERE()!=null){
				select += "\n";
				String con_a =ctx.select_core(0).expr(0).expr(0).getText();
				String operador = ctx.select_core(0).expr(0).getChild(1).getText();
				if(operador.equals("<>") || operador.equals("!=")){
					select+="if (!(String.valueOf(holder.table.get(i)."+con_a+").equals(con_b))){\n";	
				}
				else if(operador.equals("==")||operador.equals("=")){
					select+="if ((String.valueOf(holder.table.get(i)."+con_a+").equals(con_b))){\n";	
				}
				else{
					select+="if (holder.table.get(i)."+con_a+operador+"con_b){\n";	
				}
				
			}	
			
			for(int i = 0; i < nparametros;i++){
				select += "\n";
				tex = ctx.select_core(0).result_column(i).expr().column_name().any_name().getText();
				select += "\t"+tex+" = String.valueOf(holder.table.get(i)."+tex+");\n";
				select += "\tespaciado =20-"+tex+".length();\n";
				select += "\tespacio=\"\";\n";
				select += "\tfor (int j=0;j<espaciado;j++){\n";
				select += "\t\tespacio+=\" \";\n";
				select += "\t}\n";
				select += "\tSystem.out.print("+tex+"+espacio);\n";								
			}
			select += "\n\tSystem.out.println();\n";
			if(ctx.select_core(0).K_WHERE()!=null){
				select += "\n\t}\n";
			}
			select += "}\n";
		}
		select += "}\n";
		select += "}\n";
		contentMain += select;
		
		fileName = "Main";
		try{
			fw = new FileWriter(fileName+ ".java");
			bw = new BufferedWriter(fw);
			bw.write(contentMain);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		
		
		
		
		
		return visitChildren(ctx);
		
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitInsert_stmt(SQLiteParser.Insert_stmtContext ctx) { 
		String className = ctx.table_name().getText();
		LinkedList <String> columns= new LinkedList<String>();
		if(!(className.equals(classBuf))){
			
		contentMain = contentMain+
		className+" holder"+className+" = new "+className+"(); \n";
		classBuf=className;
		}

		contentMain = contentMain+className+" temp"+countInserts+className+" = new "+className+"(); \n";
		fileName = "Main";
		try{
			/*if(ctx.K_INSERT() != null){
				content = content + "holder.push(new "+className+"(";
			}
			
			if(ctx.K_REPLACE() != null){
				content = content + ctx.table_name().getText()+" { \n";
				fileName=ctx.table_name().getText();
			}*/
			if(ctx.column_name () != null){
				for (int i=0;i<ctx.column_name().size();i++){
					columns.add(i,ctx.column_name().get(i).getText());
				}
			
			}
			if (ctx.expr() != null){
				for (int i=0;i<ctx.expr().size();i++){
				//	content = content+"if ("+columns.get(i)+"NotNull == true && "+ctx.expr().get(i).getText()+" == null ) { \n"+
				//"System.out.println( \"The field doesn't accept null values. \" ); \n } else{";
					contentMain =contentMain+"temp"+countInserts+className+"."+columns.get(i) +" = "+ctx.expr().get(i).getText()+"; \n ";
				}
				contentMain = contentMain + "holder"+className+".table.push(temp"+countInserts+className+"); \n ";
			}
			fw = new FileWriter(fileName+ ".java");
			bw = new BufferedWriter(fw);
			bw.write(contentMain);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		countInserts++;
		return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPragma_stmt(SQLiteParser.Pragma_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitReindex_stmt(SQLiteParser.Reindex_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRelease_stmt(SQLiteParser.Release_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRollback_stmt(SQLiteParser.Rollback_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSavepoint_stmt(SQLiteParser.Savepoint_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSimple_select_stmt(SQLiteParser.Simple_select_stmtContext ctx) { 
		System.out.println(ctx.getText());
		return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSelect_stmt(SQLiteParser.Select_stmtContext ctx) { 
		System.out.println(ctx.getText());
		return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSelect_or_values(SQLiteParser.Select_or_valuesContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitUpdate_stmt(SQLiteParser.Update_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitUpdate_stmt_limited(SQLiteParser.Update_stmt_limitedContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitVacuum_stmt(SQLiteParser.Vacuum_stmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitColumn_def(SQLiteParser.Column_defContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitType_name(SQLiteParser.Type_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitColumn_constraint(SQLiteParser.Column_constraintContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitConflict_clause(SQLiteParser.Conflict_clauseContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpr(SQLiteParser.ExprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitForeign_key_clause(SQLiteParser.Foreign_key_clauseContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRaise_function(SQLiteParser.Raise_functionContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIndexed_column(SQLiteParser.Indexed_columnContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTable_constraint(SQLiteParser.Table_constraintContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitWith_clause(SQLiteParser.With_clauseContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitQualified_table_name(SQLiteParser.Qualified_table_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOrdering_term(SQLiteParser.Ordering_termContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPragma_value(SQLiteParser.Pragma_valueContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCommon_table_expression(SQLiteParser.Common_table_expressionContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitResult_column(SQLiteParser.Result_columnContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTable_or_subquery(SQLiteParser.Table_or_subqueryContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitJoin_clause(SQLiteParser.Join_clauseContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitJoin_operator(SQLiteParser.Join_operatorContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitJoin_constraint(SQLiteParser.Join_constraintContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSelect_core(SQLiteParser.Select_coreContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCompound_operator(SQLiteParser.Compound_operatorContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCte_table_name(SQLiteParser.Cte_table_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSigned_number(SQLiteParser.Signed_numberContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitLiteral_value(SQLiteParser.Literal_valueContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitUnary_operator(SQLiteParser.Unary_operatorContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitError_message(SQLiteParser.Error_messageContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitModule_argument(SQLiteParser.Module_argumentContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitColumn_alias(SQLiteParser.Column_aliasContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitKeyword(SQLiteParser.KeywordContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitName(SQLiteParser.NameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFunction_name(SQLiteParser.Function_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDatabase_name(SQLiteParser.Database_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTable_name(SQLiteParser.Table_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTable_or_index_name(SQLiteParser.Table_or_index_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitNew_table_name(SQLiteParser.New_table_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitColumn_name(SQLiteParser.Column_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitCollation_name(SQLiteParser.Collation_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitForeign_table(SQLiteParser.Foreign_tableContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIndex_name(SQLiteParser.Index_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTrigger_name(SQLiteParser.Trigger_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitView_name(SQLiteParser.View_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitModule_name(SQLiteParser.Module_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPragma_name(SQLiteParser.Pragma_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSavepoint_name(SQLiteParser.Savepoint_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTable_alias(SQLiteParser.Table_aliasContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTransaction_name(SQLiteParser.Transaction_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAny_name(SQLiteParser.Any_nameContext ctx) { return visitChildren(ctx); }
}