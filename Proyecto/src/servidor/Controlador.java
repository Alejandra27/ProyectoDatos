package servidor;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import DAO.PasajeroDAO;


public class Controlador {

	private Socket pasajero;
	private PrintWriter out;
	private BufferedReader in;
	
	private PasajeroDAO pasajeroDAO;
	
	public Controlador() throws Exception{
		pasajeroDAO = new PasajeroDAO(this);
		pasajero = new Socket("localhost", Servidor.puerto);
		out = new PrintWriter(pasajero.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(pasajero.getInputStream()));
	}
	
	public void enviarInstruccion(String sql)
	{
		out.println(sql);
	}
	
	public String darRespuestaServer() throws Exception
	{
		return in.readLine();
	}

	public String insertarCliente(String parametros[]){
		if (pasajeroDAO.insertar(parametros)) {
			return "Se inserto ,,,, correctamente";
		}else
			return "No se inserto";
	}
	
	public String eliminarCliente(int llave){
		if (pasajeroDAO.eliminar(llave)) {
			return "Se elimino ,,,, correctamente";
		}else
			return "No se elimino";
	}
}