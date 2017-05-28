package translate; 
 import java.util.LinkedList; 
 import java.util.List; 
 class Afiliado { 
int Afi_idTarjeta; 
int Afi_documento; 
String Afi_nombre; 
int Afi_edad; 
int Afi_telefono; 
String Afi_correo; 
char Afi_sexo; 
int Afi_saldo; 
int Afi_puntos; 
LinkedList<Afiliado> table = new LinkedList<Afiliado>(); 
public Afiliado(int Afi_idTarjeta, int Afi_documento, String Afi_nombre, int Afi_edad, int Afi_telefono, String Afi_correo, int Afi_saldo, int Afi_puntos){ 
this.Afi_idTarjeta = Afi_idTarjeta; 
this.Afi_documento = Afi_documento; 
this.Afi_nombre = Afi_nombre; 
this.Afi_edad = Afi_edad; 
this.Afi_telefono = Afi_telefono; 
this.Afi_correo = Afi_correo; 
this.Afi_saldo = Afi_saldo; 
this.Afi_puntos = Afi_puntos; 
 }
 public Afiliado() { 
this.Afi_idTarjeta = 0; 
this.Afi_documento = 0; 
this.Afi_nombre = ""; 
this.Afi_edad = 0; 
this.Afi_telefono = 0; 
this.Afi_correo = ""; 
this.Afi_saldo = 0; 
this.Afi_puntos = 0; 
 } 
 }