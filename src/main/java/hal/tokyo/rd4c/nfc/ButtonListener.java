/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hal.tokyo.rd4c.nfc;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**
 *
 * @author pi
 */
public class ButtonListener implements GpioPinListenerDigital {

    private NFCReader nfc;
    private RaspRC522 rsp;

    public ButtonListener() {
        /* RC522_Initを複数呼び出すと危険なため */
        rsp = new RaspRC522();
        rsp.RC522_Init();
    }

    @Override
    public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent gpdsce) {
        nfc = new NFCReader();
        if (gpdsce.getState() == PinState.LOW) {
            try {
                System.out.println(gpdsce.getState().toString());
                System.out.println(nfc.readBGMNum());
            } catch (InterruptedException e) {
            }
        }
    }
}
