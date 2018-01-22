/** Copyright (2016) Krishna C Tripathi. All rights reserved.
 * 
 * You are not allowed to read/copy/distribute following code without explicit written authorization from Krishna C Tripathi
 * Event after authorization this software is provided "as is" with no explicit or implicit warranties whatsoever 
 */

package org.himalay.cayenne;

import org.himalay.cayenne.AnalogOutput_;
import org.himalay.msgs.runtime.Created;

@Created(date = "Wed Oct 25 18:27:18 EST 2017")

public class AnalogOutput extends AnalogOutput_ { // Concrete type is AnalogOutput
	public double getValue() {
		return (this._value*0.01d);
	}
	
	public void setValue(double temp) {
		this._value = (short)(temp*100);
	}
}

// End of code