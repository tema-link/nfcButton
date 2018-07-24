/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hal.tokyo.rd4c.nfc;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;

/**
 *
 * @author pi
 */
public class Sample {
    
    public static void main(String[] args) throws InterruptedException {
//        NFCReader nfc = new NFCReader();
//        System.out.println(nfc.readBGMNum());
        final GpioController gpio = GpioFactory.getInstance();

        GpioPinDigitalInput button = gpio.provisionDigitalInputPin(RaspiPin.GPIO_29, PinPullResistance.PULL_UP);
        button.addListener(new ButtonListener());

        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }
        
    }
}
