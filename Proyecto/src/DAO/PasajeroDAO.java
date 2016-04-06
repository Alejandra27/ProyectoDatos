package DAO;

import java.awt.List;

import clases.Pasajero;
import interfaces.AerolineaDAO;
import servidor.HiloServidor;

public class PasajeroDAO implements AerolineaDAO
{

    private HiloServidor socket;

    public List pasajeros;

    public PasajeroDAO(HiloServidor socket)
    {
        this.socket = socket;
    }

    @Override
    public boolean insertar(String parametros[])
    {
        try
        {
            Pasajero c = new Pasajero(Integer.parseInt(parametros[0]),
                    parametros[1], parametros[2], parametros[3],
                    Integer.parseInt(parametros[4]));
            String sql = c.insertar();
            socket.enviarInstruccion(sql);
            String res = socket.darRespuestaServer();
            if (res.equalsIgnoreCase("true"))
            {
                return true;
            }
            else
                return false;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean eliminar(int PrimayKey)
    {
        try
        {
            Pasajero c = new Pasajero(PrimayKey);
            String sql = c.eliminar();
            socket.enviarInstruccion(sql);
            String res = socket.darRespuestaServer();
            if (res != null)
            {
                if (res.equalsIgnoreCase("true"))
                {
                    return true;
                }
                else if (res.equals("null"))
                {
                    System.out.println("Respuesta nula ");
                    return false;
                }
                else
                    return false;
            }
            else
            {
                System.out.println("Error el valor no puede ser nulo");
                return false;
            }

        }
        catch (Exception e)
        {
            System.out.println("Error de " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean consultar()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean consultarPorID()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean consultartodos()
    {
        // TODO Auto-generated method stub
        return false;
    }

}
