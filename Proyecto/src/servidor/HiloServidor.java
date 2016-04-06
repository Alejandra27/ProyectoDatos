package servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import DAO.PasajeroDAO;

public class HiloServidor
{

    private Socket socketPasajero;
    private PrintWriter out;
    private BufferedReader in;

    private PasajeroDAO pasajeroDAO;

    public HiloServidor() throws Exception
    {
        pasajeroDAO = new PasajeroDAO(this);
        socketPasajero = new Socket("localhost", Servidor.PUERTO);
        out = new PrintWriter(socketPasajero.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socketPasajero.getInputStream()));
    }

    public void enviarInstruccion(String sql)
    {
        out.println(sql);
    }

    public String darRespuestaServer() throws Exception
    {
        return in.readLine();
    }

    public String insertarCliente(String parametros[])
    {
        if (pasajeroDAO.insertar(parametros))
        {
            return "Se inserto correctamente";
        }
        else
            return "No se inserto correctamente";
    }

    public String eliminarCliente(int llave)
    {
        if (pasajeroDAO.eliminar(llave))
        {
            return "Se elimino correctamente";
        }
        else
            return "No se elimino correctamente";
    }
}
