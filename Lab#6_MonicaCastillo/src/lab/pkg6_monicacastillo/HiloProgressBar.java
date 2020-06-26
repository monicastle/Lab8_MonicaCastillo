/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg6_monicacastillo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JProgressBar;

/**
 *
 * @author Monica
 */
public class HiloProgressBar extends Thread {

    private JProgressBar barra;

    public HiloProgressBar(JProgressBar barra) {
        this.barra = barra;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    @Override
    public void run() {
        while (true) {
            Date h = new Date();
            DateFormat f = new SimpleDateFormat("hh:mm:ss");
            barra.setString(f.format(h));
            for (int i = 0; i < 1000; i++) {
                barra.setValue(i);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {

            }
        }
    }
}
