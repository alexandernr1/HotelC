
package Datos;

import java.sql.Date;

public class Dpago { 
    private int idpago;
    private int idreserva;
    private String tipocomprobante;
    private String numcomprobante;
    private Double igv;
    private Double totalpago;
    private Date fechaemision;
    private Date fechapago;
    private String formapago;

    public Dpago() {
    }

    public Dpago(int idpago, int idreserva, String tipocomprobante, String numcomprobante, Double igv, Double totalpago, Date fechaemision, Date fechapago, String formapago) {
        this.idpago = idpago;
        this.idreserva = idreserva;
        this.tipocomprobante = tipocomprobante;
        this.numcomprobante = numcomprobante;
        this.igv = igv;
        this.totalpago = totalpago;
        this.fechaemision = fechaemision;
        this.fechapago = fechapago;
        this.formapago = formapago;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getTipocomprobante() {
        return tipocomprobante;
    }

    public void setTipocomprobante(String tipocomprobante) {
        this.tipocomprobante = tipocomprobante;
    }

    public String getNumcomprobante() {
        return numcomprobante;
    }

    public void setNumcomprobante(String numcomprobante) {
        this.numcomprobante = numcomprobante;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotalpago() {
        return totalpago;
    }

    public void setTotalpago(Double totalpago) {
        this.totalpago = totalpago;
    }

    public Date getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(Date fechaemision) {
        this.fechaemision = fechaemision;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }
    

   
}
