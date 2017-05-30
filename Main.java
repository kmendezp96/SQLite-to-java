package translate; 
 import java.util.LinkedList; 
 class Main { 
ex2 holderex2 = new ex2(); 
ex2 temp0ex2 = new ex2(); 
temp0ex2.a = "aa"; 
 temp0ex2.b = "aa"; 
 temp0ex2.c = "aa"; 
 temp0ex2.d = 3; 
 temp0ex2.e = 3; 
 temp0ex2.f = true; 
 temp0ex2.g = "aaa"; 
 temp0ex2.j = "aaa"; 
 temp0ex2.k = "aaa"; 
 temp0ex2.l = "aaa"; 
 holderex2.table.push(temp0ex2); 
 ex2 temp1ex2 = new ex2(); 
temp1ex2.a = "bb"; 
 temp1ex2.b = "bb"; 
 temp1ex2.c = "b"; 
 temp1ex2.d = 2; 
 temp1ex2.e = 2; 
 temp1ex2.f = true; 
 temp1ex2.g = "aaa"; 
 temp1ex2.j = "bbb"; 
 temp1ex2.k = "aaa"; 
 temp1ex2.l = "aaa"; 
 holderex2.table.push(temp1ex2); 
 Afiliado temp2Afiliado = new Afiliado(); 
temp2Afiliado.Afi_idTarjeta = 1021; 
 temp2Afiliado.Afi_documento = 1011722543; 
 temp2Afiliado.Afi_nombre = 'Carlos Rodriguez Perez'; 
 temp2Afiliado.Afi_edad = 32; 
 temp2Afiliado.Afi_telefono = 5487321; 
 temp2Afiliado.Afi_correo = 'Rodriguez_carlos@gmail.com'; 
 temp2Afiliado.Afi_sexo = 'M'; 
 temp2Afiliado.Afi_saldo = 43300; 
 temp2Afiliado.Afi_puntos = 754; 
 holderAfiliado.table.push(temp2Afiliado); 
 Afiliado temp3Afiliado = new Afiliado(); 
temp3Afiliado.Afi_idTarjeta = 1022; 
 temp3Afiliado.Afi_documento = 1011722543; 
 temp3Afiliado.Afi_nombre = 'Carlos daniel Perez'; 
 temp3Afiliado.Afi_edad = 22; 
 temp3Afiliado.Afi_telefono = 5487321; 
 temp3Afiliado.Afi_correo = 'Rodriguez_carlos@gmail.com'; 
 temp3Afiliado.Afi_sexo = 'M'; 
 temp3Afiliado.Afi_saldo = 43300; 
 temp3Afiliado.Afi_puntos = 754; 
 holderAfiliado.table.push(temp3Afiliado); 
 for (int d=0;d<holderAfiliado.table.size();d++) { 
 if (holderAfiliado.table.get(d).Afi_edad>30) { 
holderAfiliado.table.remove(d); 
 } 
 } 
for (int d=0;d<holderAfiliado.table.size();d++) { 
 if (holderAfiliado.table.get(d).Afi_nombre.matches("daniel.*")) { 
holderAfiliado.table.remove(d); 
 } 
 } 
