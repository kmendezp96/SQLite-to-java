package translate; 
 public class Main { 
public static void main(String []args) throws IllegalArgumentException, IllegalAccessException{
Usuario holderUsuario = new Usuario(); 
Usuario temp0Usuario = new Usuario(); 
temp0Usuario.a = 1; 
 temp0Usuario.b = "text1"; 
 temp0Usuario.c = 1; 
 holderUsuario.table.push(temp0Usuario); 
 Usuario temp1Usuario = new Usuario(); 
temp1Usuario.a = 2; 
 temp1Usuario.b = "text2"; 
 temp1Usuario.c = 2; 
 holderUsuario.table.push(temp1Usuario); 
 Usuario temp2Usuario = new Usuario(); 
temp2Usuario.a = 3; 
 temp2Usuario.b = "text3"; 
 temp2Usuario.c = 3; 
 holderUsuario.table.push(temp2Usuario); 
 Usuario temp3Usuario = new Usuario(); 
temp3Usuario.a = 4; 
 temp3Usuario.b = "text4"; 
 temp3Usuario.c = 4; 
 holderUsuario.table.push(temp3Usuario); 
 for (int j=0;j<holderUsuario.table.size(); j++) { 
if (holderUsuario.table.get(j).b.matches(".*ext4")) { 
holderUsuario.table.get(j).a = 30; 
 } 
 } 
Usuario holder = new Usuario();
holder = holderUsuario;

int espaciado;
String espacio;

String a = "a";
espaciado = 20-a.length();
espacio="";
for (int j=0;j<espaciado;j++){
	espacio+=" ";
}
System.out.print(a+espacio);

String c = "c";
espaciado = 20-c.length();
espacio="";
for (int j=0;j<espaciado;j++){
	espacio+=" ";
}
System.out.print(c+espacio);

System.out.println();

String con_b;
con_b = "'%ext4'";
for(int i=0;i<holder.table.size();i++){


con_b = con_b.replace("\'", "");
con_b = con_b.replace("%",".*");
if ((String.valueOf(holder.table.get(i).b).matches(con_b))){

	a = String.valueOf(holder.table.get(i).a);
	espaciado =20-a.length();
	espacio="";
	for (int j=0;j<espaciado;j++){
		espacio+=" ";
	}
	System.out.print(a+espacio);

	c = String.valueOf(holder.table.get(i).c);
	espaciado =20-c.length();
	espacio="";
	for (int j=0;j<espaciado;j++){
		espacio+=" ";
	}
	System.out.print(c+espacio);

	System.out.println();

	}
}
}
}
