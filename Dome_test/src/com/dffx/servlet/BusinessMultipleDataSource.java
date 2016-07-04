package com.dffx.servlet;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by rabbit on 2015-07-07
 */
public class BusinessMultipleDataSource extends AbstractRoutingDataSource {
	
    @Override  
    protected Object determineCurrentLookupKey() {  
        return DataSourceInstances.Business;  
    }  
    

}