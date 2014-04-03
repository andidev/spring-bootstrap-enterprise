//package org.andidev.applicationname.config.springsecurity;
//
//import java.util.Collection;
//import org.springframework.security.access.AccessDecisionVoter;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//
//public class ServiceVoter implements AccessDecisionVoter<Object> {
//    //~ Instance fields ================================================================================================
//
//    private String servicePrefix = "SERVICE_";
//
//    //~ Methods ========================================================================================================
//    public String getServicePrefix() {
//        return servicePrefix;
//    }
//
//    /**
//     * Allows the default service prefix of <code>SERVICE_</code> to be overridden.
//     * May be set to an empty value, although this is usually not desirable.
//     *
//     * @param servicePrefix the new prefix
//     */
//    public void setServicePrefix(String servicePrefix) {
//        this.servicePrefix = servicePrefix;
//    }
//
//    @Override
//    public boolean supports(ConfigAttribute attribute) {
//        if ((attribute.getAttribute() != null) && attribute.getAttribute().startsWith(getServicePrefix())) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    /**
//     * This implementation supports any type of class, because it does not query
//     * the presented secure object.
//     *
//     * @param clazz the secure object
//     *
//     * @return always <code>true</code>
//     */
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return true;
//    }
//
//    @Override
//    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
//        int result = ACCESS_ABSTAIN;
//        Collection<? extends GrantedAuthority> authorities = extractAuthorities(authentication);
//
//        for (ConfigAttribute attribute : attributes) {
//            if (this.supports(attribute)) {
//                result = ACCESS_DENIED;
//
//                // Attempt to find a matching granted authority
//                for (GrantedAuthority authority : authorities) {
//                    if (attribute.getAttribute().equals(authority.getAuthority())) {
//                        return ACCESS_GRANTED;
//                    }
//                }
//            }
//        }
//
//        return result;
//    }
//
//    Collection<? extends GrantedAuthority> extractAuthorities(Authentication authentication) {
//        return authentication.getAuthorities();
//    }
//}
