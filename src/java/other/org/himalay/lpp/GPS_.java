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

public class GPS_ extends LPPDataFactory.LPPData { // Concrete type is GPS

	// members variables
	// header
	public LPPHeader header;
	// _latitude
	public int _latitude;
	// _longitude
	public int _longitude;
	// _elevation
	public int _elevation;

	public GPS_() // throws Exception
	{
		init();
	}

	private void init() {
		// Initialize header
		header = new LPPHeader();
		// Initialize _latitude

		// Initialize _longitude

		// Initialize _elevation

	}

	public int readNoHeader(DataInputStream istream) throws IOException {

		preRead();
		int retVal = 0;
		// read _latitude
		{
			_latitude = BinPrimitive.readI24(istream);
			retVal += 3;
		}
		// read _longitude
		{
			_longitude = BinPrimitive.readI24(istream);
			retVal += 3;
		}
		// read _elevation
		{
			_elevation = BinPrimitive.readI24(istream);
			retVal += 3;
		}

		postRead();
		return retVal;
	}

	public int read(DataInputStream istream) throws IOException {
		preRead();
		int retVal = 0;

		// read header
		retVal += header.read(istream);
		// read _latitude
		{
			_latitude = BinPrimitive.readI24(istream);
			retVal += 3;
		}
		// read _longitude
		{
			_longitude = BinPrimitive.readI24(istream);
			retVal += 3;
		}
		// read _elevation
		{
			_elevation = BinPrimitive.readI24(istream);
			retVal += 3;
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
		// write _latitude
		{
			ostream.writeByte((_latitude & 0x00FF0000) >> 16);
			ostream.writeShort((_latitude & 0x0000FFFF));
			retVal += 3;
		}
		// write _longitude
		{
			ostream.writeByte((_longitude & 0x00FF0000) >> 16);
			ostream.writeShort((_longitude & 0x0000FFFF));
			retVal += 3;
		}
		// write _elevation
		{
			ostream.writeByte((_elevation & 0x00FF0000) >> 16);
			ostream.writeShort((_elevation & 0x0000FFFF));
			retVal += 3;
		}
		postWrite();
		return retVal;
	}

	public int dump(DumpContext dc) throws IOException {
		dc.indent();
		dc.getPs().print("GPS_\n");
		dc.increaseIndent();
		int retVal = 0;
		// write header
		if (header != null) {
			dc.indent();
			dc.getPs().println("header");
			retVal += header.dump(dc);
		}
		// write _latitude
		dc.indent();
		dc.getPs().println("_latitude=" + _latitude + "(0x" + Integer.toHexString(_latitude) + ")");
		// write _longitude
		dc.indent();
		dc.getPs().println("_longitude=" + _longitude + "(0x" + Integer.toHexString(_longitude) + ")");
		// write _elevation
		dc.indent();
		dc.getPs().println("_elevation=" + _elevation + "(0x" + Integer.toHexString(_elevation) + ")");
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
	// Getter for _latitude
	// public int get_latitude()
	// {
	// return _latitude ;
	// }

	// Setter for _latitude
	// public void set_latitude(int val)
	// {
	// this._latitude= val;
	// }
	// Getter for _longitude
	// public int get_longitude()
	// {
	// return _longitude ;
	// }

	// Setter for _longitude
	// public void set_longitude(int val)
	// {
	// this._longitude= val;
	// }
	// Getter for _elevation
	// public int get_elevation()
	// {
	// return _elevation ;
	// }

	// Setter for _elevation
	// public void set_elevation(int val)
	// {
	// this._elevation= val;
	// }

	public int getSize() throws IOException {
		DataOutputStream dos = new DataOutputStream(new NullStream());
		return this.write(dos);
	}

	public void setHeader(LPPHeader header) {
		this.header = header;
		this.header.setMessageType(0x88);
	}

	public LPPHeader getHeader() {
		return this.header;
	}

}

// End of code