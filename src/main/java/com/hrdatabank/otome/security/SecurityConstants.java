package com.hrdatabank.otome.security;

/**
 * The Class SecurityConstants.
 */
public class SecurityConstants {

	/** The Constant SECRET. */
	public static final String SECRET = "SecretKeyToGenJWTs";
	
	/** The Constant EXPIRATION_TIME. */
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	
	/** The Constant TOKEN_PREFIX. */
	public static final String TOKEN_PREFIX = "Bearer ";
	
	/** The Constant HEADER_STRING. */
	public static final String HEADER_STRING = "Authorization";
	
	/** The Constant SIGN_UP_URL. */
	public static final String SIGN_UP_URL = "/users/sign-up";
	
	/** The Constant SWAGGER. */
	public static final String SWAGGER = "/swagger-ui.html";
	
	/** The Constant WEBJARS. */
	public static final String WEBJARS = "/webjars/**";
	
	/** The Constant API_DOC. */
	public static final String API_DOC ="/v2/api-docs";
	
	/** The Constant SWAGGER_RESOURCES. */
	public static final String SWAGGER_RESOURCES = "/swagger-resources/**";
	
	/** The Constant SWAGGER_JSON. */
	public static final String SWAGGER_JSON ="/swagger.json";
}
