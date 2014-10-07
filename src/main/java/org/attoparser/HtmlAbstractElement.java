/*
 * =============================================================================
 * 
 *   Copyright (c) 2012-2014, The ATTOPARSER team (http://www.attoparser.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.attoparser;


/*
 * Base abstract class for all implementations of IHtmlElement.
 * 
 * @author Daniel Fernandez
 * @since 2.0.0
 */
abstract class HtmlAbstractElement implements IHtmlElement {

    
    private final String name;


    
    protected HtmlAbstractElement(final String name) {
        
        super();
        
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        
        this.name = name.toLowerCase();

    }

    
    
    public final String getName() {
        return this.name;
    }

    
    
    public final boolean matches(final String elementName) {
        return TextUtil.equals(false, this.name, elementName);
    }

    
    public final boolean matches(final char[] elementName) {
        return TextUtil.equals(false, this.name, elementName);
    }

    
    public final boolean matches(final char[] elementNameBuffer, final int offset, final int len) {
        return TextUtil.equals(false, this.name, 0, this.name.length(), elementNameBuffer, offset, len);
    }



    
    

    @Override
    public String toString() {
        final StringBuilder strBuilder = new StringBuilder();
        strBuilder.append('<');
        strBuilder.append(this.name);
        strBuilder.append('>');
        return strBuilder.toString();
    }
    
    
    
    
    
}