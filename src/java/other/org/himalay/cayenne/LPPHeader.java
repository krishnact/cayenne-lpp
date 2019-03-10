/** Copyright (2016) Krishna C Tripathi. All rights reserved.
 * 
 * You are not allowed to read/copy/distribute following code without explicit written authorization from Krishna C Tripathi
 * Even after authorization this software is provided "as is" with no explicit or implicit warranties whatsoever 
 */

package org.himalay.cayenne;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.Exception;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import org.himalay.msgs.runtime.Created;

import org.himalay.msgs.runtime.*;

@Created(date = "Wed Oct 25 20:31:11 EST 2017")
public class LPPHeader extends BinStruct implements PublicBinMsg {

	// members variables
	// dataChannel
	public short dataChannel;
	// messageType
	public short messageType;

	public LPPHeader() // throws Exception
	{
		init();
	}

	private void init() {
		// Initialize dataChannel

		// Initialize messageType

	}

	public int readNoHeader(DataInputStream istream) throws IOException {

		return read(istream);
	}

	public int read(DataInputStream istream) throws IOException {
		preRead();
		int retVal = 0;

		// read dataChannel
		{
			dataChannel = (short) (istream.readUnsignedByte());
			retVal += 1;
		}
		// read messageType
		{
			messageType = (short) (istream.readUnsignedByte());
			retVal += 1;
		}

		postRead();
		return retVal;
	}

	public int write(DataOutputStream ostream) throws IOException {
		preWrite();
		int retVal = 0;

		// write dataChannel
		ostream.writeByte(dataChannel);
		retVal += 1;
		// write messageType
		ostream.writeByte(messageType);
		retVal += 1;
		postWrite();
		return retVal;
	}

	public int dump(DumpContext dc) throws IOException {
		dc.indent();
		dc.getPs().print("LPPHeader\n");
		dc.increaseIndent();
		int retVal = 0;
		// write dataChannel
		dc.indent();
		dc.getPs().println(
				"dataChannel=" + dataChannel + "(0x"
						+ Integer.toHexString(dataChannel) + ")");
		// write messageType
		dc.indent();
		dc.getPs().println(
				"messageType=" + messageType + "(0x"
						+ Integer.toHexString(messageType) + ")");
		dc.decreaseIndent();
		return retVal;
	}

	// Getter for dataChannel
	// public short getDataChannel()
	// {
	// return dataChannel ;
	// }

	// Setter for dataChannel
	// public void setDataChannel(short val)
	// {
	// this.dataChannel= val;
	// }
	// Getter for messageType
	public short getMessageType() {
		return messageType;
	}

	// Setter for messageType
	public void setMessageType(short val) {
		this.messageType = val;
	}

	// Setter for messageType
	public void setMessageType(int val) {
		this.messageType = (short) val;
	}

	public int getSize() throws IOException {
		DataOutputStream dos = new DataOutputStream(new NullStream());
		return this.write(dos);
	}

}

// End of code