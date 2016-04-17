RESTORE PROJECT WITH FULL DB
1 - download repository Blog
2 - create new empty DB in SQL
3 - restore bak file from folder DB/latestBak in the new DB
4 - open project in Eclipse
5 - edit class connection manager
6 - run project
7 - log in the application with username prova@prova.com pword: letmein

RESTORE PROJECT WITH SCRIPTS
1 - download repository Blog
2 - create new empty DB in SQL
3.1 - execute scripts from DB/scripts/schema 
3.2 - execute scripts from DB/scripts/data 
4 - open project in Eclipse
5 - edit class connection manager
6 - run project
7 - log in the application with username prova@prova.com pword: letmein








- crea static class connection  con attributi url, user, password

	private String url = "jdbc:sqlserver://localhost;databaseName=BLOG";
	private String user = "alerossi82";
	private String password = "telecono";
	
- crea static method getDBConnection che restituisce un oggetto Connection

public static Connection getDBConnection (){
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
			}