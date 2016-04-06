package servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class Servidor {

	public static final int puerto = 1517;

	Connection conexion;
	Statement st;

	public boolean insertar(String x) {
		try {
			st = conexion.createStatement();
			st.execute(x);
			st.close();
			st = null;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

		public boolean eliminar(String x) {
			try {
				st = conexion.createStatement();
				st.execute(x);
				st.close();
				st = null;
				return true;
			} catch (Exception e) {
				return false;
			}
	}

	public Servidor() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conexion = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "AEROLINEA", "qwerty");
			System.out.println("Conexion exitosa a la base de datos!");
			
			ServerSocket servidor = new ServerSocket(puerto);
			System.out.println("El puerto se ha abierto");
			System.out.println("esperando conexion con el cliente...");
			Socket cliente = servidor.accept();
			System.out.println("nueva conexion con el cliente"
					+ cliente.getInetAddress().getHostAddress());
			BufferedReader in = new BufferedReader(new InputStreamReader(
					cliente.getInputStream()));
			PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);

			

			String sql = in.readLine();

			while (!sql.equalsIgnoreCase("c")) {
				if (sql.startsWith("insert into")) {
					System.out.println("Aca");
					if (insertar(sql)) {
						out.println("true");
					} else {
						out.println("false");
					}
				}else if(sql.startsWith("delete")) {
					if (eliminar(sql)) {
						out.println("true");
					} else {
						out.println("false");
					}
				}
				sql = in.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		Servidor s = new Servidor();
	}

}
