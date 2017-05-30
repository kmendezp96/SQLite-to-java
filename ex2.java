package translate; 
 import java.util.LinkedList; 
 import java.util.List; 
 public class ex2 { 
String a; 
String b; 
String c; 
int d; 
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
 public void result(String a){ 
System.out.print("\t\t|"); 
if(a.equals( "a" ))System.out.print(this.a); 
if(a.equals( "b" ))System.out.print(this.b); 
if(a.equals( "c" ))System.out.print(this.c); 
if(a.equals( "d" ))System.out.print(this.d); 
if(a.equals( "e" ))System.out.print(this.e); 
if(a.equals( "f" ))System.out.print(this.f); 
if(a.equals( "g" ))System.out.print(this.g); 
if(a.equals( "j" ))System.out.print(this.j); 
if(a.equals( "k" ))System.out.print(this.k); 
if(a.equals( "l" )) System.out.print(this.l); 
 } 

 public ex2() { 
this.a = ""; 
this.b = ""; 
this.c = ""; 
this.d = 0; 
this.e = 0; 
this.f = false; 
this.g = ""; 
this.j = ""; 
this.k = ""; 
this.l = ""; 
 } 
 }