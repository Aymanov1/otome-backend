package com.hrdatabank.mtproject.entities;

/**
 * Enumerated {@link User} roles.
 * 
 * @author vladimir.stankovic
 *
 * Aug 16, 2016
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
     * @author yassine amira
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
