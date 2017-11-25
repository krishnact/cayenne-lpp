/** Copyright (2016) Krishna C Tripathi. All rights reserved.
 * 
 * You are not allowed to read/copy/distribute following code without explicit written authorization from Krishna C Tripathi
 * Event after authorization this software is provided "as is" with no explicit or implicit warranties whatsoever 
 */

package org.himalay.lpp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.Exception;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import org.himalay.msgs.runtime.Created;

import org.himalay.msgs.runtime.*;

@Created(date = "Wed Oct 25 20:31:12 EST 2017")

public class Acceleration_ extends LPPDataFactory.LPPData { // Concrete type is Acceleration

	// members variables
	// header
	public LPPHeader header;
	// _x
	public short _x;
	// _y
	public short _y;
	// _z
	public short _z;

	public Acceleration_() // throws Exception
	{
		init();
	}

	private void init() {
		// Initialize header
		header = new LPPHeader();
		// Initialize _x

		// Initialize _y

		// Initialize _z

	}

	public int readNoHeader(DataInputStream istream) throws IOException {

		preRead();
		int retVal = 0;
		// read _x
		{
			_x = istream.readShort();
			retVal += 2;
		}
		// read _y
		{
			_y = istream.readShort();
			retVal += 2;
		}
		// read _z
		{
			_z = istream.readShort();
			retVal += 2;
		}

		postRead();
		return retVal;
	}

	public int read(DataInputStream istream) throws IOException {
		preRead();
		int retVal = 0;

		// read header
		retVal += header.read(istream);
		// read _x
		{
			_x = istream.readShort();
			retVal += 2;
		}
		// read _y
		{
			_y = istream.readShort();
			retVal += 2;
		}
		// read _z
		{
			_z = istream.readShort();
			retVal += 2;
		}

		postRead();
		return retVal;
	}

	public int write(DataOutputStream ostream) throws IOException {
		preWrite();
		int retVal = 0;

		{
			/** fix dependent sizes for header **/
		}

		// write header
		if (header != null)
			retVal += header.write(ostream);
		// write _x
		ostream.writeShort(_x);
		retVal += 2;
		// write _y
		ostream.writeShort(_y);
		retVal += 2;
		// write _z
		ostream.writeShort(_z);
		retVal += 2;
		postWrite();
		return retVal;
	}

	public int dump(DumpContext dc) throws IOException {
		dc.indent();
		dc.getPs().print("Acceleration_\n");
		dc.increaseIndent();
		int retVal = 0;
		// write header
		if (header != null) {
			dc.indent();
			dc.getPs().println("header");
			retVal += header.dump(dc);
		}
		// write _x
		dc.indent();
		dc.getPs().println("_x=" + _x + "(0x" + Integer.toHexString(_x) + ")");
		// write _y
		dc.indent();
		dc.getPs().println("_y=" + _y + "(0x" + Integer.toHexString(_y) + ")");
		// write _z
		dc.indent();
		dc.getPs().println("_z=" + _z + "(0x" + Integer.toHexString(_z) + ")");
		dc.decreaseIndent();
		return retVal;
	}

	// Getter for header
	// public LPPHeader getHeader()
	// {
	// return header ;
	// }

	// Setter for header
	// public void setHeader(LPPHeader val)
	// {
	// this.header= val;
	// }
	// Getter for _x
	// public short get_x()
	// {
	// return _x ;
	// }

	// Setter for _x
	// public void set_x(short val)
	// {
	// this._x= val;
	// }
	// Getter for _y
	// public short get_y()
	// {
	// return _y ;
	// }

	// Setter for _y
	// public void set_y(short val)
	// {
	// this._y= val;
	// }
	// Getter for _z
	// public short get_z()
	// {
	// return _z ;
	// }

	// Setter for _z
	// public void set_z(short val)
	// {
	// this._z= val;
	// }

	public int getSize() throws IOException {
		DataOutputStream dos = new DataOutputStream(new NullStream());
		return this.write(dos);
	}

	public void setHeader(LPPHeader header) {
		this.header = header;
		this.header.setMessageType(0x71);
	}

	public LPPHeader getHeader() {
		return this.header;
	}

}

// End of code