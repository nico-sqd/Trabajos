import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

public class ServidorImpresion extends UnicastRemoteObject
  implements ChatInterface
{

 static int id[][]=new int[100][100];
 static int i=0;
 static int c=0;

  public ServidorImpresion() throws RemoteException
  {
    super();
  }

  public String paginas(int nroPaginas) throws RemoteException
  { 
    int aleatorio=(int)(Math.random()*8000+3000); //en milisegundos...
    c=(int)(nroPaginas*aleatorio);
    id[0][i]=i+1;

    i++;
    return ("El numero de id de su trabajadoe es: "+(id[0][i-1])+"\n");
  }
  
  public boolean impresionAtendida(int idTrab)
  {
    int condicion= id[1][idTrab-1];
    boolean salida= false;
  
    if(condicion==0) salida=false;
    else if(condicion==1) salida=true;
    return salida;
  }
  
  public boolean trabajoImpreso(int idTrab)
  {
    int condicion= id[1][idTrab-1];
    boolean salida= false;
    
    if(condicion==1) salida=false;
    else if(condicion==2) salida=true;
    return salida;
  }
  
  public void imprimir()
  {
   int a=0;
   
   while(true){
     if(id[0][a]!=0){
       System.out.println("Tardara "+(c/1000)+" segundos en imprimir la/s pagina/s");
     try{
       id[1][a]=1;
       
       Thread.sleep(c);
       System.out.println("Impresion id "+ id[0][a] + " terminada\n");
       id[1][a]=2;
       
       a++;
     }catch (Exception e){
     System.out.println(e);
     }
   }
   else if(id[0][i]==0){
   System.out.print("---Cargando Impresora---\r");
   }
  }
 }

    public static void main( String args[] )
  {
    try
    {
      ServidorImpresion ds = new ServidorImpresion();
      Naming.rebind( "ServidorImpresion", ds );
      System.out.println( "ServidorImpresion esperando consultas ..." );
      int rows= id.length;
      int columns=id[0].length;
      for(int i=0;i<rows;i++){
        for(int j=0;j<columns;j++){
          id[i][j]=0;
        }
      }
      i=0;
      ds.imprimir();
    }
    catch ( Exception e ) { System.out.println(e); }
  }
}
