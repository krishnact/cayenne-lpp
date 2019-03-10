/** Copyright (2016) Krishna C Tripathi. All rights reserved.
 * 
 * You are not allowed to read/copy/distribute following code without explicit written authorization from Krishna C Tripathi
 * Even after authorization this software is provided "as is" with no explicit or implicit warranties whatsoever 
 */

package org.himalay.cayenne;

import org.himalay.cayenne.GPS_;
import org.himalay.msgs.runtime.Created;

@Created(date = "Wed Mar 09 18:27:18 EST 2019")
public class Concentration extends Concentration_ { // Concrete type is GPS

	/**
	 * Get longitude in degrees
	 * 
	 * @return
	 */
	public int getValuePPM() {
		return _value;
	}

	/**
	 * Set longitude in degrees
	 * 
	 * @return
	 */
	public void setValuePPM(int value) {
		this._value = value;
	}
}

// End of code