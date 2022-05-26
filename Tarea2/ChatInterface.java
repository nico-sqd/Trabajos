import java.rmi.*;

public interface ChatInterface 
                   extends Remote {
					   
					   // sendMessage: String -> String
					   // envia un mensaje desde el cliente al servidor
					   // y este le contesta con uno propio
					   public String paginas(int nroPaginas) throws RemoteException;
					   public boolean impresionAtendida(int idTrab) throws RemoteException;
					   public boolean trabajoImpreso(int idTrab) throws RemoteException;
}
