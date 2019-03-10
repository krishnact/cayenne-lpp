/** Copyright (2016) Krishna C Tripathi. All rights reserved.
 * 
 * You are not allowed to read/copy/distribute following code without explicit written authorization from Krishna C Tripathi
 * Even after authorization this software is provided "as is" with no explicit or implicit warranties whatsoever 
 */

package org.himalay.cayenne;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.himalay.cayenne.Acceleration;
import org.himalay.cayenne.AnalogInput;
import org.himalay.cayenne.AnalogOutput;
import org.himalay.cayenne.DigitalInput;
import org.himalay.cayenne.DigitalOutput;
import org.himalay.cayenne.GPS;
import org.himalay.cayenne.Gyration;
import org.himalay.cayenne.Humidity;
import org.himalay.cayenne.Illuminance;
import org.himalay.cayenne.Presence;
import org.himalay.cayenne.Pressure;
import org.himalay.cayenne.Temperature;
import org.himalay.msgs.runtime.*;

@Created(date = "Wed Oct 25 20:31:12 EST 2017")
public class LPPDataFactory implements Factory {
    public static final int DigitalInput = 0x00;
    public static final int DigitalOutput = 0x01;
    public static final int AnalogInput = 0x02;
    public static final int AnalogOutput = 0x03;
    public static final int Illuminance = 0x65;
    public static final int Presence = 0x66;
    public static final int Temperature = 0x67;
    public static final int Humidity = 0x68;
    public static final int Acceleration = 0x71;
    public static final int Pressure = 0x73;
    public static final int Gyration = 0x86;
    public static final int GPS = 0x88;
    public static final int Concentration = 0x7d;
    public static final int Energy = 0x83;
    public static boolean isDebug = true;
    public static LPPData lastParsedObject = null;

    public static LPPData createMsg(DataInputStream istream,
            AtomicInteger iHolder) throws IOException {
        IntegerHolder iHolder1 = new IntegerHolder();
        LPPData retVal = createMsg(istream, iHolder1);
        if (iHolder != null) {
            iHolder.set(iHolder1.getValue());
        }
        return retVal;
    }

    public static LPPData createMsg(DataInputStream istream,
            IntegerHolder iHolder1) throws IOException {
        int iRead = 0;
        LPPHeader header;
        {
            int retVal = 0;
            header = new LPPHeader();
            retVal += header.read(istream);
            iRead = retVal;
        }
        LPPData retVal = createMsg(header, istream, iHolder1);
        iHolder1.setValue(iHolder1.getValue() + iRead);
        return retVal;
    }

    public static LPPData createMsg(org.himalay.cayenne.LPPHeader temp,
            DataInputStream dis, IntegerHolder iHolder) throws IOException {
        int iRead = 0;
        LPPData retVal = null;
        try {
            switch (temp.getMessageType()) {
                case 0x00 : {
                    retVal = new DigitalInput();
                    retVal.setHeader(temp);
                    // has no spread
                    iRead += retVal.readNoHeader(dis);
                    break;
                }
                case 0x01 : {
                    retVal = new DigitalOutput();
                    retVal.setHeader(temp);
                    // has no spread
                    iRead += retVal.readNoHeader(dis);
                    break;
                }
                case 0x02 : {
                    retVal = new AnalogInput();
                    retVal.setHeader(temp);
                    // has no spread
                    iRead += retVal.readNoHeader(dis);
                    break;
                }
                case 0x03 : {
                    retVal = new AnalogOutput();
                    retVal.setHeader(temp);
                    // has no spread
                    iRead += retVal.readNoHeader(dis);
                    break;
                }
                case 0x65 : {
                    retVal = new Illuminance();
                    retVal.setHeader(temp);
                    // has no spread
                    iRead += retVal.readNoHeader(dis);
                    break;
                }
                case 0x66 : {
                    retVal = new Presence();
                    retVal.setHeader(temp);
                    // has no spread
                    iRead += retVal.readNoHeader(dis);
                    break;
                }
                case 0x67 : {
                    retVal = new Temperature();
                    retVal.setHeader(temp);
                    // has no spread
                    iRead += retVal.readNoHeader(dis);
                    break;
                }
                case 0x68 : {
                    retVal = new Humidity();
                    retVal.setHeader(temp);
                    // has no spread
                    iRead += retVal.readNoHeader(dis);
                    break;
                }
                case 0x71 : {
                    retVal = new Acceleration();
                    retVal.setHeader(temp);
                    // has no spread
                    iRead += retVal.readNoHeader(dis);
                    break;
                }
                case 0x73 : {
                    retVal = new Pressure();
                    retVal.setHeader(temp);
                    // has no spread
                    iRead += retVal.readNoHeader(dis);
                    break;
                }
                case 0x86 : {
                    retVal = new Gyration();
                    retVal.setHeader(temp);
                    // has no spread
                    iRead += retVal.readNoHeader(dis);
                    break;
                }
                case 0x88 : {
                    retVal = new GPS();
                    retVal.setHeader(temp);
                    // has no spread
                    iRead += retVal.readNoHeader(dis);
                    break;
                }
                case 0x7d :
                {
                    retVal= new Concentration ();
                    retVal.setHeader(temp);
                    // has no spread
                    iRead+=retVal.readNoHeader(dis);
                    break;
                }
                case 0x83 :
                {
                    retVal= new Energy ();
                    retVal.setHeader(temp);
                    // has no spread
                    iRead+=retVal.readNoHeader(dis);
                    break;
                }
            }
        } catch (IOException ioex) {
            if (isDebug) {
                lastParsedObject = retVal;
            }
            throw ioex;
        }
        iHolder.setValue(iRead);
        return retVal;
    }

    public static abstract class LPPData extends BinMessage
            implements
                FactoryProduct {
        public LPPData() {
            super();
            // TODO Auto-generated constructor stub
        }

        public abstract void setHeader(org.himalay.cayenne.LPPHeader header);

        public abstract org.himalay.cayenne.LPPHeader getHeader();

    }
}

// End of code