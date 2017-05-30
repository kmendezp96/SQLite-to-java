package translate; 
 import java.util.LinkedList; 
 import java.util.List; 
 public class beta { 
final boolean aUnique = false; 
final boolean aNotNull = false; 
int a; 
final boolean bUnique = false; 
final boolean bNotNull = false; 
String b; 
final boolean cUnique = false; 
final boolean cNotNull = false; 
float c; 
LinkedList<beta> table = new LinkedList<beta>(); 
public beta(int a, String b, float c){ 
this.a = a; 
this.b = b; 
this.c = c; 
 }
 public void result(String a){ 
System.out.print("\t\t|"); 
if(a.equals( "a" ))System.out.print(a); 
if(a.equals( "b" ))System.out.print(b); 
if(a.equals( "c" )) System.out.print(c); 
 } 

 public beta() { 
this.a = 0; 
this.b = ""; 
this.c = 0; 
 } 
 }