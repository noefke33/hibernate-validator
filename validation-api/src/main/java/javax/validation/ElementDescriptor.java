// $Id: ElementDescriptor.java 114 2008-10-01 13:44:26Z hardy.ferentschik $
/*
* JBoss, Home of Professional Open Source
* Copyright 2008, Red Hat Middleware LLC, and individual contributors
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package javax.validation;

import java.lang.annotation.ElementType;
import java.util.List;

/**
 * Describes a validated element (class, field or property).
 *
 * @author Emmanuel Bernard
 * @author Hardy Ferentschik
 */
public interface ElementDescriptor {
	/**
	 * @return The element type.
	 */
	ElementType getElementType();

	/**
	 * @return Statically defined returned type.
	 *
	 * @todo should it be Type or even completly removed
	 */
	Class getReturnType();

	/**
	 * @return Returns <code>true</code> if the association is cascaded, <code>false</code> otherwise.
	 */
	boolean isCascaded();

	/**
	 * @return All the constraint descriptors for this element.
	 */
	List<ConstraintDescriptor> getConstraintDescriptors();

	/**
	 * @return Property path from the root entity validated.
	 *
	 * @todo there is a problem in describing cyclic dependencies
	 */
	String getPropertyPath();

}