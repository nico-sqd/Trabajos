from socket import *
import smtplib, ssl


serverPort = 12000
serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(('', serverPort))
serverSocket.listen(1)
print('Servidor esperando clientes')
while True:
    connectionSocket, addr = serverSocket.accept()

    receiver_email = connectionSocket.recv(1024).decode()
    port = 465  
    smtp_server = "smtp.gmail.com"
    mensaje ="""\
    Subject: Prueba envio de correo con python.
    Mensaje de prueba para taller n3 de Redes."""

    context = ssl.create_default_context()
    with smtplib.SMTP_SSL(smtp_server, port, context=context) as server:
        server.login("nicolassebastian.quintraman@alumnos.ulagos.cl","nikoseba9902") #Correo y contraseña desde que se envia mensage
        server.sendmail(from_addr='nicolassebastian.quintraman@alumnos.ulagos.cl', to_addrs=receiver_email, msg= mensaje)
    connectionSocket.send("Correo enviedo exitosamente!".encode())
    connectionSocket.close()
