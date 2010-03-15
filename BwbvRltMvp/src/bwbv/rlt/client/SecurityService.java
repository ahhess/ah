package bwbv.rlt.client;

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
    void login(String userName) throws AuthenticationException;

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
