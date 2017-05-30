package translate; 
 import java.util.LinkedList; 
 import java.util.List; 
 public class Usuario { 
int a; 
String b; 
float c; 
LinkedList<Usuario> table = new LinkedList<Usuario>(); 
public Usuario(int a, String b, float c){ 
this.a = a; 
this.b = b; 
this.c = c; 
 }
 public void result(String a){ 
System.out.print("\t\t|"); 
if(a.equals( "a" ))System.out.print(this.a); 
if(a.equals( "b" ))System.out.print(this.b); 
if(a.equals( "c" )) System.out.print(this.c); 
 } 

 public Usuario() { 
this.a = 0; 
this.b = ""; 
this.c = 0; 
 } 
 }