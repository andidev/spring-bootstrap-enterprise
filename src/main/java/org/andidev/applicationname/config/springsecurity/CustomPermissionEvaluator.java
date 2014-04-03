///*
// * Copyright 2013 Organization Name.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package org.andidev.applicationname.config.springsecurity;
//
//import java.io.Serializable;
//import java.util.HashMap;
//import org.andidev.applicationname.entity.User;
//import org.andidev.applicationname.util.ApplicationUtils;
//import org.springframework.security.access.PermissionEvaluator;
//import org.springframework.security.core.Authentication;
//
///**
// *
// * @author anders
// */
//public class CustomPermissionEvaluator implements PermissionEvaluator {
//
//    @Override
//    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
//        boolean hasPermission = false;
//        if (authentication != null && permission instanceof String) {
//
//            //implement the permission checking of your application here   
//            //you can just check if the input permission is within your permission list
//            //In my example, the user object contains a HashMap which stored the permission of the user.
//            //The HashMap<String, PrivilegeResult> is populated during using login by filter. This will not be shown in this example 
//            User user = ApplicationUtils.getUser();
//            HashMap<String, PrivilegeResult> pMap = user.getPrivilegeMap();
//            PrivilegeResult privResult = pMap.get(permission);
//            hasPermission = privResult.isAllowAccess();
//
//        } else {
//            hasPermission = false;
//        }
//        return hasPermission;
//    }
//
//    @Override
//    public boolean hasPermission(Authentication authentication,
//            Serializable targetId, String targetType, Object permission) {
//        throw new RuntimeException("Id and Class permissions are not supperted by this application");
//    }
//}
