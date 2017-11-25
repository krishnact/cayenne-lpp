/** Copyright (2016) Krishna C Tripathi. All rights reserved.
 * 
 * You are not allowed to read/copy/distribute following code without explicit written authorization from Krishna C Tripathi
 * Event after authorization this software is provided "as is" with no explicit or implicit warranties whatsoever 
 */

package org.himalay.lpp;

import org.himalay.msgs.runtime.Created;

@Created(date = "Wed Oct 25 20:23:57 EST 2017")

public class Gyration extends Gyration_ { // Concrete type is Gyration

	/**
	 * Get X acceleration in G
	 * @return
	 */
	public double getX() {
		return (0.01d* this._x);
	}
	
	/**
	 * Get Y acceleration in G
	 * @return
	 */
	public double getY() {
		return (0.01d* this._y);
	}
	
	/**
	 * Get Z acceleration in G
	 * @return
	 */
	public double getZ() {
		return (0.01d* this._z);
	}
	
	/**
	 * Set X acceleration in G
	 * @return
	 */
	public void setX(double val) {
		this._x = (short)(100*val); 
	}

	/**
	 * Set Y acceleration in G
	 * @return
	 */
	public void setY(double val) {
		this._y = (short)(100*val); 
	}
	/**
	 * Set Z acceleration in G
	 * @return
	 */
	public void setZ(double val) {
		this._z = (short)(100*val); 
	}
	

}

// End of code