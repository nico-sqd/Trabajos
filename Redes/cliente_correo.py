
from socket import *
import sys

serverName = 'localhost' 
serverPort = 12000
clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect((serverName,serverPort))



if __name__ == '__main__':
    correo = sys.argv[1]
    clientSocket.send(correo.encode())
    respuesta = clientSocket.recv(1024)
    print ('Desde Servidor:', respuesta.decode())
    clientSocket.close()
