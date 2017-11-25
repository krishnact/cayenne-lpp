/** Copyright (2016) Krishna C Tripathi. All rights reserved.
 * 
 * You are not allowed to read/copy/distribute following code without explicit written authorization from Krishna C Tripathi
 * Event after authorization this software is provided "as is" with no explicit or implicit warranties whatsoever 
 */

package org.himalay.lpp;

import org.himalay.msgs.runtime.Created;

@Created(date = "Wed Oct 25 20:23:57 EST 2017")

public class Pressure extends Pressure_ { // Concrete type is Pressure
	public double getValue() {
		return (this._value*0.1d);
	}
	
	public void setValue(double temp) {
		this._value = (short)(temp*10);
	}
}

// End of code