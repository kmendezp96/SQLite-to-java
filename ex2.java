package translate; 
 import java.util.LinkedList; 
 import java.util.List; 
 class ex2 { 
String a; 
final boolean bNotNull = true; 
String b; 
String c; 
final boolean dNotNull = true; 
int d; 
final boolean eUnique = true; 
float e; 
boolean f; 
String g; 
String j; 
String k; 
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