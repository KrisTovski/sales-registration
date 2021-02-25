package com.kristovski.sales.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceProvider {

    private static DataSource dataSource;

    public DataSourceProvider() {
    }

    public static DataSource getDataSource() throws NamingException{
        if(dataSource==null){
            Context initialContext = new InitialContext();
            Context envContext = (Context) initialContext.lookup("java:comp/env/");
            dataSource = (DataSource) envContext.lookup("jdbc/sales_records");
        }
        return dataSource;
    }
}
