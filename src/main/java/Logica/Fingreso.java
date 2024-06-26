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

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Idingreso", "Idhabitacion", "Numero", "Idcliente", "Cliente", "clientete",
            "Fecha_hora_ingreso", "Num_personas", "tipo_cliente", "Costoalojamiento", "Motivo_viaje", "Estado"};

        String[] registro = new String[12];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select i.idingreso,i.idhabitacion,h.numero,i.idcliente,"
                + "(select nombres from persona where idpersona=i.idcliente)as clienten,"
                + "(select apellidos from persona where idpersona=i.idcliente)as clienteap,"
                + "(select telefono from persona where idpersona= i.idcliente)as clientete,"
                + "i.fecha_hora_ingreso,i.num_personas,i.tipo_cliente,i.motivo_viaje,i.estado,"
                + "i.costoalojamiento from ingreso i inner join habitacion h on i.idhabitacion=h.idhabitacion where i.fecha_hora_ingreso like '%" + buscar + "%' order by idingreso desc";

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
                registro[6] = rs.getString("fecha_hora_ingreso");
                registro[7] = rs.getString("num_personas");
                registro[8] = rs.getString("tipo_cliente");
                registro[9] = rs.getString("costoalojamiento");
                registro[10] = rs.getString("motivo_viaje");
                registro[11] = rs.getString("estado");

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
        sSQL = "INSERT INTO ingreso (idhabitacion, idcliente, fecha_hora_ingreso, num_personas, tipo_cliente, costoalojamiento, motivo_viaje,estado)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?,?)";
        try ( PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, dts.getIdhabitacion());
            pst.setInt(2, dts.getIdcliente());
            pst.setDate(3, dts.getFecha_hora_ingreso());
            pst.setInt(4, dts.getNum_personas());
            pst.setString(5, dts.getTipo_cliente());
            pst.setDouble(6, dts.getCostoalojamiento());
            pst.setString(7, dts.getMotivo_viaje());
             pst.setString(8, dts.getEstado());

            int n = pst.executeUpdate();
            // JOptionPane.showMessageDialog(null, "DATOS ALMACENADOS CORRECTAMENTE");
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(Dingreso dts) {
        sSQL = "delete from ingreso where idingreso=?";

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
        sSQL = "update ingreso set idhabitacion=?,idcliente=?,fecha_hora_ingreso=?,num_personas=?,tipo_cliente=?,costoalojamiento=?,motivo_viaje=?,estado=?"
                + " where idingreso=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdhabitacion());
            pst.setInt(2, dts.getIdcliente());
            pst.setDate(3, dts.getFecha_hora_ingreso());
            pst.setInt(4, dts.getNum_personas());
            pst.setString(5, dts.getTipo_cliente());
            pst.setDouble(6, dts.getCostoalojamiento());
            pst.setString(7, dts.getMotivo_viaje());
             pst.setString(8, dts.getEstado());

            pst.setInt(9, dts.getIdingreso());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
   public boolean pagar (Dingreso dts){
      sSQL = "update ingreso set estado = 'pagada'"+"where idingreso=?";

  
    try {
         PreparedStatement pst =cn.prepareStatement(sSQL);
         pst.setInt(1, dts.getIdingreso());  
         
          int n = pst.executeUpdate();

            return n != 0;
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
        return false;
   
     }
}