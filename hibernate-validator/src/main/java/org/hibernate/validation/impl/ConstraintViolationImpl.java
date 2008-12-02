// $Id$
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
package org.hibernate.validation.impl;

import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintDescriptor;

/**
 * @author Emmanuel Bernard
 * @author Hardy Ferentschik
 */
public class ConstraintViolationImpl<T> implements ConstraintViolation<T> {
	private String interpolatedMessage;
	private T rootBean;
	private Class<T> beanClass;
	private Object value;
	private String propertyPath;
	private HashSet<String> groups;
	private Object leafBeanInstance;
	private final ConstraintDescriptor constraintDescriptor;
	private String rawMessage;


	public ConstraintViolationImpl(String rawMessage, String interpolatedMessage, T rootBean, Class<T> beanClass,
								   Object leafBeanInstance, Object value,
								   String propertyPath, String group, ConstraintDescriptor constraintDescriptor) {
		this.rawMessage = rawMessage;
		this.interpolatedMessage = interpolatedMessage;
		this.rootBean = rootBean;
		this.beanClass = beanClass;
		this.value = value;
		this.propertyPath = propertyPath;
		groups = new HashSet<String>();
		groups.add( group );
		this.leafBeanInstance = leafBeanInstance;
		this.constraintDescriptor = constraintDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getInterpolatedMessage() {
		return interpolatedMessage;
	}

	public String getRawMessage() {
		return rawMessage;
	}

	/**
	 * {@inheritDoc}
	 */
	public T getRootBean() {
		return rootBean;
	}

	public Object getLeafBean() {
		return leafBeanInstance;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getInvalidValue() {
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPropertyPath() {
		return propertyPath;
	}

	/**
	 * {@inheritDoc}
	 */
	public Set<String> getGroups() {
		return groups;
	}

	public ConstraintDescriptor getConstraintDescriptor() {
		return this.constraintDescriptor;
	}

	public void addGroups(Set<String> groupSet) {
		groups.addAll( groupSet );
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( !( o instanceof ConstraintViolationImpl ) ) {
			return false;
		}

		ConstraintViolationImpl that = ( ConstraintViolationImpl ) o;

		if ( beanClass != null ? !beanClass.equals( that.beanClass ) : that.beanClass != null ) {
			return false;
		}
		if ( interpolatedMessage != null ? !interpolatedMessage.equals( that.interpolatedMessage ) : that.interpolatedMessage != null ) {
			return false;
		}
		if ( propertyPath != null ? !propertyPath.equals( that.propertyPath ) : that.propertyPath != null ) {
			return false;
		}
		if ( rootBean != null ? !rootBean.equals( that.rootBean ) : that.rootBean != null ) {
			return false;
		}
		if ( value != null ? !value.equals( that.value ) : that.value != null ) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = interpolatedMessage != null ? interpolatedMessage.hashCode() : 0;
		result = 31 * result + ( rootBean != null ? rootBean.hashCode() : 0 );
		result = 31 * result + ( beanClass != null ? beanClass.hashCode() : 0 );
		result = 31 * result + ( value != null ? value.hashCode() : 0 );
		result = 31 * result + ( propertyPath != null ? propertyPath.hashCode() : 0 );
		return result;
	}
}