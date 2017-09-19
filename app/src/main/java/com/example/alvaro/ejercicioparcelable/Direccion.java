package com.example.alvaro.ejercicioparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alvaro on 19/09/2017.
 */

public class Direccion implements Parcelable{
    private String calle;
    private String numero;
    private Integer cp;

    public Direccion() {
    }

    public Direccion(String calle, String numero, Integer cp) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
    }

    protected Direccion(Parcel in) {
        calle = in.readString();
        numero = in.readString();
        cp = in.readInt();
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direccion direccion = (Direccion) o;

        if (!calle.equals(direccion.calle)) return false;
        if (!numero.equals(direccion.numero)) return false;
        return cp.equals(direccion.cp);

    }

    @Override
    public int hashCode() {
        int result = calle.hashCode();
        result = 31 * result + numero.hashCode();
        result = 31 * result + cp.hashCode();
        return result;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(calle);
        dest.writeString(numero);
        dest.writeInt(cp);
    }



    public static final Parcelable.Creator<Direccion> CREATOR = new Parcelable.Creator<Direccion>() {
        @Override
        public Direccion createFromParcel(Parcel in) {
            return new Direccion(in);
        }

        @Override
        public Direccion[] newArray(int size) {
            return new Direccion[size];
        }
    };
}