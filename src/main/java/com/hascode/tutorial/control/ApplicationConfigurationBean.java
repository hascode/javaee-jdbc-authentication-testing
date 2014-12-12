package com.hascode.tutorial.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;

@Singleton
@Startup
public class ApplicationConfigurationBean {
	private final Logger log = Logger.getLogger(ApplicationConfigurationBean.class.getName());

	@Resource(lookup = "jdbc/hascode_test_db")
	private DataSource ds;

	@PostConstruct
	protected void onStartup() throws SQLException {
		log.info("initializing users and roles..");
		// use a migration framework here - this is just for the purpose of
		// demonstration, works only once ;)
		String createUserTable = "CREATE TABLE `users` (`userid` varchar(255) NOT NULL, `password` varchar(255) NOT NULL, PRIMARY KEY (`userid`))";
		String createGroupTable = "CREATE TABLE `users_groups` ( `groupid` varchar(20) NOT NULL, `userid` varchar(255) NOT NULL)";
		String addAdminUser = "INSERT INTO `users` VALUES('admin', 'test')";
		String addUserToAdminGroup = "INSERT INTO users_groups VALUES('administrators','admin')";

		Connection con = ds.getConnection();

		con.prepareCall(createUserTable).execute();
		con.prepareCall(createGroupTable).execute();
		con.prepareCall(addAdminUser).execute();
		con.prepareCall(addUserToAdminGroup).execute();
		log.info("user and roles setup completed");
	}
}