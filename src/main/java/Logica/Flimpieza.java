package Logica;

import Datos.Dlimpieza;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Flimpieza {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";

   
    public boolean insertar(Dlimpieza dts) {
        sSQL = "insert into limpieza(idempleado, numero,  tipo_habitacion, fecha, estado, turno)" + "values (?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdempleado());
            pst.setInt(2, dts.getNumero());
            pst.setString(3, dts.getTipo_habitacion());
            pst.setDate(4, dts.getFecha());
            pst.setString(5, dts.getEstado());
            pst.setString(6, dts.getTurno());

            int n = pst.executeUpdate();
           // JOptionPane.showMessageDialog(null, "DATOS ALMACENADOS CORRECTAMENTE");
            return n != 0;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    /* public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Idlimpieza", "Idempleado", "Numero", "fecha", "tipo_habitacion", "estado", "turno"};
        String[] registro = new String[7];

        //  totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select l.idlimpieza,l.numero,"
                + "l.idempleado,(select nombres from persona where idpersona = l.idempleado)as empleadon,"
                + "(select apellidos from persona where idpersona = l.idempleado)as empleadoap,"
                + "l.fecha,l.estado,l.tipo_habitacion,l.turno from limpieza l inner join limpieza l on l.idlimpieza=l.idlimpieza where l.numero like '%" + buscar + "%' order by idlimpieza desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idlimpieza");
                registro[1] = rs.getString("idempleado");
                registro[2] = rs.getString("empleadon") + " " + rs.getString("empleadoap");
                registro[3] = rs.getString("numero");
                registro[4] = rs.getString("fecha");
                registro[5] = rs.getString("tipo_habitacion");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("turno");

//                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "NO SE PUEDE MOSTRAR LOS DATOS");
            return null;
        }

    }*/


 /* public boolean eliminar(Dlimpieza dts) {
        sSQL = "delete from reserva where idreserva=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdreserva());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(Dlimpieza dts) {
        sSQL = "update reserva set idhabitacion=?,idcliente=?,idempleado=?,tiporeserva=?,fechareserva=?,fechaingreso=?,fechasalida=?,costoalojamiento=?, numnoches=?, numpersonas=?, estado=?"
                + " where idreserva=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdhabitacion());
            pst.setInt(2, dts.getIdcliente());
            pst.setInt(3, dts.getIdempleado());
            pst.setString(4, dts.getTiporeserva());
            pst.setDate(5, dts.getFechareserva());
            pst.setDate(6, dts.getFechaingreso());
            pst.setDate(7, dts.getFechasalida());
            pst.setDouble(8, dts.getCostoalojamiento());
            pst.setInt(9, dts.getNumnoches());
            pst.setInt(10, dts.getNumpersonas());
            pst.setString(11, dts.getEstado());

            pst.setInt(12, dts.getIdreserva());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }*/
}
