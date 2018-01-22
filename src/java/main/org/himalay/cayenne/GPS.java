/** Copyright (2016) Krishna C Tripathi. All rights reserved.
 * 
 * You are not allowed to read/copy/distribute following code without explicit written authorization from Krishna C Tripathi
 * Event after authorization this software is provided "as is" with no explicit or implicit warranties whatsoever 
 */

package org.himalay.cayenne;

import org.himalay.cayenne.GPS_;
import org.himalay.msgs.runtime.Created;

@Created(date = "Wed Oct 25 18:27:18 EST 2017")

public class GPS extends GPS_ { // Concrete type is GPS

	/**
	 * Get longitude in degrees
	 * @return
	 */
	public double getLon() {
		return (0.0001d* this._longitude);
	}
	
	/**
	 * Get latitude in degrees
	 * @return
	 */
	public double getLat() {
		return (0.0001d* this._latitude);
	}
	
	/**
	 * Get elevation acceleration in Meters
	 * @return
	 */
	public double getElevation() {
		return (0.01d* this._elevation);
	}
	
	/**
	 * Set longitude in degrees
	 * @return
	 */
	public void setLon(double value) {
		this._longitude = (int)(value* 10000.0d) ;
	}
	
	/**
	 * Set latitude in degrees
	 * @return
	 */
	public void setLat(double value) {
		this._latitude=(int)(value* 10000.0d) ;
	}
	
	/**
	 * Set elevation in Meters
	 * @return
	 */
	public void setElevation(double value) {
		this._elevation = (int)(0.01d*value);
	}
	

}

// End of code