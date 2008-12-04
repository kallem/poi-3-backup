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

package org.apache.poi.ss.usermodel;

/**
 * Represents a defined name for a range of cells.
 * <p>
 * A name is a meaningful shorthand that makes it easier to understand the purpose of a
 * cell reference, constant or a formula.
 * </p>
 * Examples:
 * <pre><blockquote>
 *  Sheet sheet = workbook.createSheet("Loan Calculator");
 *  Name name;
 *
 *  name = workbook.createName();
 *  name.setNameName("Interest_Rate");
 *  name.setRefersToFormula("'Loan Calculator'!$E$5");
 *
 *  name = wb.createName();
 *  name.setNameName("Loan_Amount");
 *  name.setRefersToFormula("'Loan Calculator'!$E$4");
 *
 *  name = wb.createName();
 *  name.setNameName("Number_of_Payments");
 *  name.setRefersToFormula("'Loan Calculator'!$E$10");
 *
 *  name = wb.createName();
 *  name.setNameName("Monthly_Payment");
 *  name.setRefersToFormula("-PMT(Interest_Rate/12,Number_of_Payments,Loan_Amount)");
 *
 *  name = wb.createName();
 *  name.setNameName("Values_Entered");
 *  name.setRefersToFormula("IF(Loan_Amount*Interest_Rate>0,1,0)");
 *
 * </blockquote></pre>
 */
public interface Name {

    /**
     * Get the sheets name which this named range is referenced to
     *
     * @return sheet name, which this named range refered to
     */
    String getSheetName();

    /** 
     * Gets the name of the named range
     *
     * @return named range name
     */
    String getNameName();

    /** 
     * Sets the name of the named range
     *
     * <p>The following is a list of syntax rules that you need to be aware of when you create and edit names.</p>
     * <ul>
     *   <li><strong>Valid characters</strong>
     *   The first character of a name must be a letter, an underscore character (_), or a backslash (\).
     *   Remaining characters in the name can be letters, numbers, periods, and underscore characters.
     *   </li>
     *   <li><strong>Cell references disallowed</strong>
     *   Names cannot be the same as a cell reference, such as Z$100 or R1C1.</li>
     *   <li><strong>Spaces are not valid</strong>
     *   Spaces are not allowed as part of a name. Use the underscore character (_) and period (.) as word separators, such as, Sales_Tax or First.Quarter.
     *   </li>
     *   <li><strong>Name length</strong>
     *    A name can contain up to 255 characters.
     *   </li>
     *   <li><strong>Case sensitivity</strong>
     *   Names can contain uppercase and lowercase letters.
     *   </li>
     * </ul>
     * @param name named range name to set
     * @throws IllegalArgumentException if the name is invalid or the workbook already contains this name (case-insensitive)
     */
    void setNameName(String name);

    /**
     * Returns the formula that the name is defined to refer to. The following are representative examples:
     *
     * @return the reference for this name
     * @see #setRefersToFormula(String)
     */
    String getRefersToFormula();

    /**
     * Sets the formula that the name is defined to refer to. The following are representative examples:
     *
     * <ul>
     *  <li><code>'My Sheet'!$A$3</code></li>
     *  <li><code>8.3</code></li>
     *  <li><code>HR!$A$1:$Z$345</code></li>
     *  <li><code>SUM(Sheet1!A1,Sheet2!B2)</li>
     *  <li><code>-PMT(Interest_Rate/12,Number_of_Payments,Loan_Amount)</li>
     * </ul>
     *
     * @param ref the reference for this name
     * @throws IllegalArgumentException if the specified reference is unparsable
    */
   void setRefersToFormula(String ref);

    /**
     * Checks if this name is a function name
     *
     * @return true if this name is a function name
     */
	boolean isFunctionName();

    /**
     * Checks if this name points to a cell that no longer exists
     *
     * @return true if the name refers to a deleted cell, false otherwise
     */
    boolean isDeleted();
}