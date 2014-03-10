package org.andidev.applicationname.mbean;


import org.jgroups.annotations.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component("mBeanExample")
@ManagedResource(objectName="org.andidev.applicationname.mbean:name=MyMBean", description="An example of a MBean")
public class MBeanExample {

    private int age;

    @ManagedAttribute(description="The age attribute", currencyTimeLimit=15)
    public int getAge() {
        return age;
    }

    @ManagedOperation(description = "Check permissions for the given activity")
    @ManagedOperationParameters( {
        @ManagedOperationParameter(name = "activity", description = "The activity to check")
    })
    public boolean isAllowedTo(final String activity) {
        return false;
    }
}