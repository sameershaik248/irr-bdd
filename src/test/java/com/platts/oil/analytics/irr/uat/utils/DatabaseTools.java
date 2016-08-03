package com.platts.oil.analytics.irr.uat.utils;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.oracle.OracleDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by jonathan_cone on 7/29/2016.
 * Ensure that you close the DB connection after database tasks complete
 * (Ideally in your After Stories)
 */
public enum DatabaseTools {

    INSTANCE;
    private IDatabaseConnection connection;

    public void createSnapshotAndLoadTestData() throws Exception {
        if(this.connection != null) {
            // Try a database export of Market Analysis and Dependent Tables
            QueryDataSet dataSet = new QueryDataSet(connection);
            dataSet.addTable("MARKET_ANALYSIS");
            dataSet.addTable("MARKET_ANALYSIS_CONTENT");
            dataSet.addTable("MARKET_ANALYSIS_ATTACHMENT");
            FlatXmlDataSet.write(dataSet, new OutputStreamWriter(new FileOutputStream("snapshot.xml"), "UTF-8"));
            // Insert the test data
            FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
            builder.setColumnSensing(true);
            IDataSet depDataSet = builder.build(new File("test_data.xml"));
            DatabaseOperation.CLEAN_INSERT.execute(connection, depDataSet);
        } else {
            throw new Exception("Database connection not established.");
        }

    }

    public void restoreSnapshot() throws Exception {
        if(this.connection != null) {
            FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
            builder.setColumnSensing(true);
            IDataSet snapDataSet = builder.build(new File("snapshot.xml"));
            DatabaseOperation.CLEAN_INSERT.execute(connection, snapDataSet);
        } else {
            throw new Exception("Attempted to load data, but no database connection available");
        }
    }

    public void connectToDb() throws Exception {
        if(this.connection == null) {
            Class driverClass = Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection jdbcConnection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//nj09cpc0090scan.mhf.mhc/BIOILDEV", "IRR", "irr1rr");
            this.connection = new DatabaseConnection(jdbcConnection);
        }

        DatabaseConfig config = this.connection.getConfig();
        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
    }

    public void closeDbConnection() throws SQLException {
        if(this.connection != null) {
            this.connection.close();
        }
    }

}
