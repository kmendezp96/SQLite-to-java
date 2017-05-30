package translate; 
 import java.util.LinkedList; 
 import java.util.List; 
 public class ex2 { 
final boolean aUnique = false; 
final boolean aNotNull = false; 
String a; 
final boolean bUnique = false; 
final boolean bNotNull = true; 
String b; 
final boolean cUnique = false; 
final boolean cNotNull = false; 
String c; 
final boolean dUnique = false; 
final boolean dNotNull = true; 
int d; 
final boolean eUnique = true; 
final boolean eNotNull = false; 
float e; 
final boolean fUnique = false; 
final boolean fNotNull = false; 
boolean f; 
final boolean gUnique = false; 
final boolean gNotNull = false; 
String g; 
final boolean jUnique = false; 
final boolean jNotNull = false; 
String j; 
final boolean kUnique = false; 
final boolean kNotNull = false; 
String k; 
final boolean lUnique = false; 
final boolean lNotNull = false; 
String l; 
final int primaryKey= d; 
LinkedList<ex2> table = new LinkedList<ex2>(); 
public ex2(String a, String b, String c, int d, float e, boolean f, String g, String j, String k, String l){ 
this.a = a; 
this.b = b; 
this.c = c; 
this.d = d; 
this.e = e; 
this.f = f; 
this.g = g; 
this.j = j; 
this.k = k; 
this.l = l; 
 }
 public void result(String a){ 
System.out.print("\t\t|"); 
if(a == a)System.out.print(a); 
if(a == b)System.out.print(b); 
if(a == c)System.out.print(c); 
if(a == d)System.out.print(d); 
if(a == e)System.out.print(e); 
if(a == f)System.out.print(f); 
if(a == g)System.out.print(g); 
if(a == j)System.out.print(j); 
if(a == k)System.out.print(k); 
if(a == l) System.out.print(l); 
 } 

 public ex2() { 
this.a = ""; 
this.b = ""; 
this.c = ""; 
this.d = 0; 
this.e = 0.0; 
this.f = false; 
this.g = ""; 
this.j = ""; 
this.k = ""; 
this.l = ""; 
 } 
 }