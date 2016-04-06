package DAO;

import java.awt.List;

import clases.Pasajero;
import interfaces.AerolineaDAO;
import servidor.Controlador;



public class PasajeroDAO implements AerolineaDAO{
	
	private Controlador socket;

	public List pasajeros;

	public PasajeroDAO(Controlador socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
	
	@Override
	public boolean insertar(String parametros[]) {
		try {
			Pasajero c = new Pasajero(Integer.parseInt(parametros[0]), parametros[1], parametros[2], parametros[3], Integer.parseInt(parametros[4]));
			String sql = c.insertar();
			socket.enviarInstruccion(sql);
			String res = socket.darRespuestaServer();
			if(res.equalsIgnoreCase("true"))
			{
				return true;
			}else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean eliminar(int PrimayKey) {
		try {
			Pasajero c = new Pasajero(PrimayKey);
			String sql = c.eliminar();
			socket.enviarInstruccion(sql);
			String res = socket.darRespuestaServer();
			if(res.equalsIgnoreCase("true"))
			{
				return true;
			}else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean actualizar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean consultar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean consultarPorID() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean consultartodos() {
		// TODO Auto-generated method stub
		return false;
	}
	

}