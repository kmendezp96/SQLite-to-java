package translate; 
 class Main { 
public static void main(String []args) throws IllegalArgumentException, IllegalAccessException{
ex2 holderex2 = new ex2(); 
ex2 temp0ex2 = new ex2(); 
temp0ex2.a = 1; 
 temp0ex2.b = "text1"; 
 temp0ex2.c = 1.0; 
 holderex2.table.push(temp0ex2); 
 ex2 temp1ex2 = new ex2(); 
temp1ex2.a = 1; 
 temp1ex2.b = "text1"; 
 temp1ex2.c = 1.0; 
 holderex2.table.push(temp1ex2); 
 beta holder = new beta();
holder = holderbeta;

int espaciado;
String espacio;

String a = "a";
espaciado = 20-a.length();
espacio="";
for (int j=0;j<espaciado;j++){
	espacio+=" ";
}
System.out.print(a+espacio);

String b = "b";
espaciado = 20-b.length();
espacio="";
for (int j=0;j<espaciado;j++){
	espacio+=" ";
}
System.out.print(b+espacio);

String c = "c";
espaciado = 20-c.length();
espacio="";
for (int j=0;j<espaciado;j++){
	espacio+=" ";
}
System.out.print(c+espacio);

System.out.println();
for(int i=0;i<holder.table.size();i++){

	a = String.valueOf(holder.table.get(i).a);
	espaciado =20-a.length();
	espacio="";
	for (int j=0;j<espaciado;j++){
		espacio+=" ";
	}
	System.out.print(a+espacio);

	b = String.valueOf(holder.table.get(i).b);
	espaciado =20-b.length();
	espacio="";
	for (int j=0;j<espaciado;j++){
		espacio+=" ";
	}
	System.out.print(b+espacio);

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
