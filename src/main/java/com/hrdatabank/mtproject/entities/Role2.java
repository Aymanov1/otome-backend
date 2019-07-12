package com.hrdatabank.mtproject.entities;

// TODO: Auto-generated Javadoc
/**
 * Enumerated {@link User} roles.
 * 
 * @author vladimir.stankovic
 *
 * Aug 16, 2019
 */
public enum Role2 {
    
    /** The admin. */
    ADMIN, 
 /** The premium member. */
 PREMIUM_MEMBER, 
 /** The member. */
 MEMBER;
    
    /**
     * Copyright (c) 2018 by HRDatabank. All rights reserved.
     *
     * @author Hanios
     * 
     * Using JRE: 1.8
     * 
     * Project Name: Module-core-hr
     * 
     * Class Name: Role2.java
     * 
     * Authority.
     * @return the string
     */
    public String authority() {
        return "ROLE_" + this.name();
    }
}
