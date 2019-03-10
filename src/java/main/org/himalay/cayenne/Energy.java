/** Copyright (2016) Krishna C Tripathi. All rights reserved.
 * 
 * You are not allowed to read/copy/distribute following code without explicit written authorization from Krishna C Tripathi.
 * Even after authorization this software is provided "as is" with no explicit or implicit warranties whatsoever 
 */

package org.himalay.cayenne;

import org.himalay.cayenne.Energy_;
import org.himalay.msgs.runtime.Created;

@Created(date = "Wed Mar 09 18:27:18 EST 2019")
public class Energy extends Energy_ { // Concrete type is Energy

	/**
	 * Get longitude in degrees
	 * 
	 * @return
	 */
	public long getWattHour() {
		return _value;
	}

	/**
	 * Set longitude in degrees
	 * 
	 * @return
	 */
	public void setWattHour(long value) {
		this._value = value;
	}
}

// End of code