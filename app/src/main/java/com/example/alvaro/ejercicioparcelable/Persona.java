package com.example.alvaro.ejercicioparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alvaro on 19/09/2017.
 */

public class Persona implements Parcelable{
    private String nombre;
    private String  apellido;
    private Integer edad;
    private Direccion direccion;

    public Persona() {
    }

    public Persona(String nombre, String apellido, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona(String nombre, String apellido, Integer edad, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
    }

    protected Persona(Parcel in) {
        nombre = in.readString();
        apellido = in.readString();
        edad = in.readInt();
        direccion = in.readParcelable(Direccion.class.getClassLoader());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        if (!nombre.equals(persona.nombre)) return false;
        if (!apellido.equals(persona.apellido)) return false;
        if (!edad.equals(persona.edad)) return false;
        return direccion != null ? direccion.equals(persona.direccion) : persona.direccion == null;

    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + apellido.hashCode();
        result = 31 * result + edad.hashCode();
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        return result;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellido);
        dest.writeInt(edad);
        dest.writeParcelable(direccion, 0);
    }

    public static final Parcelable.Creator<Persona> CREATOR = new Parcelable.Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };
}