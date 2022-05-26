import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

/******** 

Aplicacion cliente RMI 

Cliente envie un mensaje al servidor y este le conteste con uno propio

******/

public class ClienteImpresion {

  public static void main( String args[] ){

	try{
		// puerto por omision: 1099
		ChatInterface ref = (ChatInterface)Naming.lookup("rmi://localhost:1099/ServidorImpresion");
		
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			
			System.out.print("Ingrese \'i\' para imprimir o \'e\' para consultar el estado de un trabajo de impresion: ");
			BufferedReader respuesta = new BufferedReader(new InputStreamReader(System.in));
			
			String respuestas = respuesta.readLine();
			
			switch(respuestas){
			
			 case "i": 
				System.out.print("Ingrese nroPaginas: ");
				BufferedReader nroPagina = new BufferedReader(new InputStreamReader(System.in));
				String nroPaginas = nroPagina.readLine();
				//int nro=Integer.parseInt(nroPaginas);
				String l= ref.paginas(Integer.parseInt(nroPaginas));
				System.out.println("trabajo enviado al servidor----" + l);
				
				 break;
			 case "e": 
				
				System.out.print("Ingrese id del trabajo: ");
				BufferedReader id1 = new BufferedReader(new InputStreamReader(System.in));
				String idTrab = id1.readLine();
				
				boolean m= ref.impresionAtendida(Integer.parseInt(idTrab));
				boolean s= ref.trabajoImpreso(Integer.parseInt(idTrab));

				if (m==true && s==false) {
					System.out.println("El trabajo ha sido atendido y se esta imprimiendo\n");
				}
				else if (m==false || s==true) {
					if (s==true) {
						System.out.println("El trabajo ya esta impreso, puede ir a retirarlo a la impresora\n");
					}else if (m==false) {
						System.out.println("El trabajo aun no es atendido\n");
					}
				}

				break;
			 default:
			
			 	break;
			}
			
		}
		
	}
	catch (RemoteException e) {
		System.err.println("Error de comunicacion: " + e.toString());
	}
	catch ( Exception e ){
		System.out.println(e);
	}
  }
}
