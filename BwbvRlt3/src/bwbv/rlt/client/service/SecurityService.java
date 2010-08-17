/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bwbv.rlt.client.service;

import bwbv.rlt.client.domain.Authentication;
import bwbv.rlt.client.domain.AuthenticationException;

/**
 * 
 * Manages all security aspects of the application.
 * Borrowed from Beginning Google Web Toolkit Book
 *
 * @author Uri Boness
 */
public interface SecurityService /*extends RemoteService*/ {

	public static class Holder {
		private static SecurityService service;

		public static SecurityService get() {
			if (service == null) {
//				service = new SecurityServiceInMemoryImpl();
				service = new SecurityServiceInMemoryImpl();
			}
			return service;
		}
	}

	/**
	 * 
	 * @param userName
	 * @throws AuthenticationException if userName is 'badguy'
	 */
    void login(String userName, String pwd) throws AuthenticationException;

    /**
     * Logs out the currently authenticated user.
     */
    void logout();

    /**
     * Indicates whether there is a logged in user.
     *
     * @return Whether there is a logged in user.
     */
    Boolean isLoggedIn();

    /**
     * Returns the currently logged in authentication.
     *
     * @return The currently logged in authentication.
     */
    Authentication getCurrentAuthentication();

}
