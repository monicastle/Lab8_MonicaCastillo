/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg6_monicacastillo;

/**
 *
 * @author Monica
 */
public class SerVivo {

    private String nombre;
    private int poder;
    private int años;
    private String planeta;
    private String raza;

    public SerVivo() {
    }

    public SerVivo(String nombre, int poder, int años, String planeta, String raza) {
        this.nombre = nombre;
        this.poder = poder;
        this.años = años;
        this.planeta = planeta;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        if (poder >= 1 && poder <= 10) {
            this.poder = poder;
        }
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
