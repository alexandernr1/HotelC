
package Logica;

import Datos.Dpago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fpago {

    private final Cconexion mysql = new Cconexion();
    private final Connection cn = mysql.establecerConexion();
    private String sSQL = "";
    private final String sSQL2 = "";
    // private String  sSQL3 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Idreserva", "Comprobante", "Número", "Igv", "Total", "Fecha Emisión", "Fecha Pago", "formapago"};

        String[] registro = new String[9];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from pago where idreserva=" + buscar + " order by idpago desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpago");
                registro[1] = rs.getString("idreserva");
                registro[2] = rs.getString("tipocomprobante");
                registro[3] = rs.getString("numcomprobante");
                registro[4] = rs.getString("igv");
                registro[5] = rs.getString("totalpago");
                registro[6] = rs.getString("fechaemision");
                registro[7] = rs.getString("fechapago");
                registro[8] = rs.getString("formapago");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(Dpago dts) {
        sSQL = "insert into pago (idreserva,tipocomprobante,numcomprobante,igv,totalpago,fechaemision,fechapago,formapago)"
                + "values (?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setString(2, dts.getTipocomprobante());
            pst.setString(3, dts.getNumcomprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotalpago());
            pst.setDate(6, dts.getFechaemision());
            pst.setDate(7, dts.getFechapago());
            pst.setString(8, dts.getFormapago());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(Dpago dts) {
        sSQL = "update pago set idreserva=?,tipocomprobante=?,numcomprobante=?,igv=?,totalpago=?,fechaemision=?,fechapago=?,formapago=0"
                + " where idpago=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setString(2, dts.getTipocomprobante());
            pst.setString(3, dts.getNumcomprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotalpago());
            pst.setDate(6, dts.getFechaemision());
            pst.setDate(7, dts.getFechapago());
            pst.setString(8, dts.getFormapago());

            pst.setInt(9, dts.getIdpago());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(Dpago dts) {
        sSQL = "delete from pago where idpago=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdpago());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
