package translate; 
 class Main { 
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
 Usuario holder = new Usuario();
holder = holderUsuario;
Usuario nuevo = new Usuario();
for (java.lang.reflect.Field field : nuevo.getClass().getDeclaredFields()) {
	field.setAccessible(true);
	String name = field.getName();
	if(name!="table"){
	int espaciado =20-name.length();
	String espacio="";
	for (int i=0;i<espaciado;i++){
		espacio+=" ";
	}
	System.out.print(name+espacio);
	for(int i=0;i<holder.table.size();i++){
if (holder.table.get(i).c>1.0)

		holder.table.get(i).result(name);
	}
	System.out.println();
	}
}
}
}
