package translate; 
 import java.util.LinkedList; 
 import java.util.List; 
 public class Administrador { 
double a; 
int b; 
boolean c; 
LinkedList<Administrador> table = new LinkedList<Administrador>(); 
public Administrador(double a, int b, boolean c){ 
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

 public Administrador() { 
this.a = 0; 
this.b = 0; 
this.c = false; 
 } 
 }