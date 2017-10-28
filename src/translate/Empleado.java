package translate; 
 import java.util.LinkedList; 
 import java.util.List; 
 public class Empleado { 
int Emp_documento; 
String Emp_nombre; 
int Emp_edad; 
int Emp_telefono; 
String Emp_correo; 
String Emp_sexo; 
int Emp_sueldo; 
String Emp_horario; 
int Emp_Suc_id; 
LinkedList<Empleado> table = new LinkedList<Empleado>(); 
public Empleado(int Emp_documento, String Emp_nombre, int Emp_edad, int Emp_telefono, String Emp_correo, String Emp_sexo, int Emp_sueldo, String Emp_horario, int Emp_Suc_id){ 
this.Emp_documento = Emp_documento; 
this.Emp_nombre = Emp_nombre; 
this.Emp_edad = Emp_edad; 
this.Emp_telefono = Emp_telefono; 
this.Emp_correo = Emp_correo; 
this.Emp_sexo = Emp_sexo; 
this.Emp_sueldo = Emp_sueldo; 
this.Emp_horario = Emp_horario; 
this.Emp_Suc_id = Emp_Suc_id; 
 }
 public void result(String a){ 
System.out.print("\t\t|"); 
if(a.equals( "Emp_documento" ))System.out.print(this.Emp_documento); 
if(a.equals( "Emp_nombre" ))System.out.print(this.Emp_nombre); 
if(a.equals( "Emp_edad" ))System.out.print(this.Emp_edad); 
if(a.equals( "Emp_telefono" ))System.out.print(this.Emp_telefono); 
if(a.equals( "Emp_correo" ))System.out.print(this.Emp_correo); 
if(a.equals( "Emp_sexo" ))System.out.print(this.Emp_sexo); 
if(a.equals( "Emp_sueldo" ))System.out.print(this.Emp_sueldo); 
if(a.equals( "Emp_horario" ))System.out.print(this.Emp_horario); 
if(a.equals( "Emp_Suc_id" )) System.out.print(this.Emp_Suc_id); 
 } 

 public Empleado() { 
this.Emp_documento = 0; 
this.Emp_nombre = ""; 
this.Emp_edad = 0; 
this.Emp_telefono = 0; 
this.Emp_correo = ""; 
this.Emp_sexo = ""; 
this.Emp_sueldo = 0; 
this.Emp_horario = ""; 
this.Emp_Suc_id = 0; 
 } 
 }