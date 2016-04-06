package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import servidor.HiloServidor;
import servidor.Servidor;

public class Vista implements ActionListener
{

    private Servidor servidor;
    public Vista() throws Exception
    {
        // TODO Auto-generated constructor stub
        HiloServidor socket = new HiloServidor();
        int nuevo = 1521;
        System.out.println(socket.eliminarCliente(nuevo));
        //servidor = new Servidor();
    }

  /*  public static void main(String[] args)
    {
        try
        {
            Vista p = new Vista();
            System.out.println("Hola");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("No se puede conectar !!!!");
        }
    }*/

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        // TODO Auto-generated method stub

    }
}
