/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package org.apache.poi.ss.formula;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaParser.FormulaParseException;
/**
 * Avoids making {@link FormulaParser#FormulaParseException} public
 * 
 * @author Josh Micich
 */
public class FormulaParserTestHelper {
	public static void confirmParseException(RuntimeException e, String expectedMessage) {
		checkType(e);
		Assert.assertEquals(expectedMessage, e.getMessage());
	}
	public static void confirmParseException(RuntimeException e) {
		checkType(e);
		Assert.assertNotNull(e.getMessage());
	}
	private static void checkType(RuntimeException e) throws AssertionFailedError {
		if (!(e instanceof FormulaParseException)) {
    		String failMsg = "Expected FormulaParseException, but got (" 
    			+ e.getClass().getName() + "):";
    		System.err.println(failMsg);
    		e.printStackTrace();
    		throw new AssertionFailedError(failMsg);
		}
	}
}