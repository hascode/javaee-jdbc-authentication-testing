# Java EE Configuration: Form-Based-Authentication with JDBC, embedded GlassFish and Arquillian

The sample web application consists of the following elements:

* A RESTful webservice that allows a user to logout and to retrieve user information. We’ll be applying restrictions to the user information API programmatically.
* A simple secured website. Restrictions are applied using XML declaration.
* Login and login-error pages for the form-based authentication so that a user is able to login.
* A dummy bootstrap class that adds a sample user with user-groups to the database

The goal behind the complex setup described in the following chapters is to finally have a mavenized project that allows us to..

* Initialize and startup a full configured Java EE application container with everything we need already set up e.g. security configuration, JDBC connection pool, an embedded H2 database running, user and group-mappings already configured, persistence working etc..
* Run full integration tests with Arquillian by automatically configure and startup an embedded GlassFish container matching the same criteria as above.

Please feel free to have a look at my blog at [www.hascode.com] for the full tutorial.

---

**2014 Micha Kops / hasCode.com**

   [www.hascode.com]:http://www.hascode.com

