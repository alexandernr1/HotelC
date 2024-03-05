package Logica;

import Datos.Dingreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Alexander Nieves
 */
public class Fingreso {

    private Cconexion mysql = new Cconexion();
    private Connection cn = mysql.establecerConexion();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Idhabitacion", "Numero", "idcliente", "Cliente", "Idempleado"
            + "Empleado", "costoalojamiento", "fechaingreso", "tipo", "motivo_viaje", "Personas"};

        String[] registro = new String[12];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select i.idingreso,i.idhabitacion,h.numero,i.idcliente,"
                + "(select nombres from persona where idpersona=i.idcliente)as clienten,"
                + "(select apellidos from persona where idpersona=i.idcliente)as clienteap,"
                + "(select numdocumento form persona where idpersona = i.cliente) as clientenu"
                + "(select telefono form persona where idpersona= i.idcliente)as clientete,"
                + "i.idempleado,(select nombres from persona where idpersona = i.idempleado)as empleadon,"
                + "(select apellidos from persona where idpersona = i.idempleado)as empleadoap,"
                + "i.fechaingreso,i.personas,i.costoalojamiento,i.tipo,i.motivo_viaje,"
                + "i.costoalojamiento from ingreso i inner join habitacion h on i.idhabitacion=h.idhabitacion where r.fechaingreso like '%" + buscar + "%' order by idreserva desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idingreso");
                registro[1] = rs.getString("idhabitacion");
                registro[2] = rs.getString("numero");
                registro[3] = rs.getString("idcliente");
                registro[4] = rs.getString("clienten") + " " + rs.getString("clienteap");
                registro[5] = rs.getString("clientete");
                registro[6] = rs.getString("idempleado");
                registro[7] = rs.getString("empleadon") + " " + rs.getString("empleadop");
                registro[8] = rs.getString("fechaingreso");
                registro[9] = rs.getString("costoalojamiento");
                registro[10] = rs.getString("tipo");
                registro[11] = rs.getString("personas");
                registro[12] = rs.getString("motivo_viaje");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(Dingreso dts) {
        sSQL = "INSERT INTO reserva (idhabitacion, idcliente, idempleado, tipo, fechaingreso, costoalojamiento, motivo_viaje, personas)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, dts.getIdhabitacion());
            pst.setInt(2, dts.getIdcliente());
            pst.setInt(3, dts.getIdempleado());
            pst.setDouble(4, dts.getCostoalojamiento());
            pst.setDate(5, dts.getFechaingreso());
            pst.setString(6, dts.getTipo());
            pst.setString(7, dts.getPersonas());
            pst.setString(8, dts.getMotivo_viaje());

            int n = pst.executeUpdate();

            return n != 0;
        } catch (SQLException e) {

            return false;
        }
    }

    public boolean eliminar(Dingreso dts) {
        sSQL = "delete from reserva where idreserva=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdingreso());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(Dingreso dts) {
        sSQL = "update reserva set idhabitacion=?,idcliente=?,idempleado=?,tipo=?,fechaingreso=?,costoalojamiento=?,motivo_viaje=?, personas=?"
                + " where idreserva=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdhabitacion());
            pst.setInt(2, dts.getIdcliente());
            pst.setInt(3, dts.getIdempleado());
            pst.setString(4, dts.getTipo());
            pst.setDate(5, dts.getFechaingreso());
            pst.setDouble(6, dts.getCostoalojamiento());
            pst.setString(7, dts.getMotivo_viaje());
            pst.setString(8, dts.getPersonas());

            pst.setInt(9, dts.getIdingreso());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

}
