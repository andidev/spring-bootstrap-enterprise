package org.andidev.applicationname.config.springsecurity;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import static org.andidev.applicationname.util.ApplicationUtils.getRequest;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.IpAddressMatcher;

@Slf4j
public class WebAndMethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    /* Code from WebSecurityExpressionRoot */

    //private FilterInvocation filterInvocation;
    /** Allows direct access to the request object */
    public final HttpServletRequest request;

    public WebAndMethodSecurityExpressionRoot(Authentication a, FilterInvocation fi) {
        super(a);
        //this.filterInvocation = fi;
        this.request = fi.getRequest();
    }

    /**
     * Takes a specific IP address or a range using the IP/Netmask (e.g. 192.168.1.0/24 or 202.24.0.0/14).
     *
     * @param ipAddress the address or range of addresses from which the request must come.
     * @return true if the IP address of the current request is in the required range.
     */
    public boolean hasIpAddress(String ipAddress) {
        return (new IpAddressMatcher(ipAddress).matches(request));
    }

    
    
    /* Code from WebSecurityExpressionRoot */
    
    private Object filterObject;
    private Object returnObject;
    private Object target;

    WebAndMethodSecurityExpressionRoot(Authentication a) {
        super(a);
        this.request = getRequest();
    }

    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    @Override
    public Object getFilterObject() {
        return filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public Object getReturnObject() {
        return returnObject;
    }

    /**
     * Sets the "this" property for use in expressions. Typically this will be the "this" property of
     * the {@code JoinPoint} representing the method invocation which is being protected.
     *
     * @param target the target object on which the method in is being invoked.
     */
    void setThis(Object target) {
        this.target = target;
    }

    @Override
    public Object getThis() {
        return target;
    }
}
