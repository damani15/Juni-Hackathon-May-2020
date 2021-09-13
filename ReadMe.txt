# The Covid Tracker

This is our submisssion to the Juni May 2020 Hackathon.
If the project is not compiling make sure you have the following dependencies added in Intelij. 

com.github.cliftonlabs:json-simple:3.1.1
net.sf.dozer:dozer:5.5.1
org.jfree:jfreechart:1.5.0
org.xerial:sqlite-jdbc:3.30.1

How to add dependencies
Go to File -> Project Structure -> Global Libraries -> Add(+) -> From Maven 
and copy paste a link above into the text field.
Then press ok.
Once all the links have been added click apply and ok.

How to open the project
First download the project off of github and then go into Intelij and open the file May-Hackathon from your file directory.

General Information
The error "Failed to load class "org.slf4j.impl.StaticLoggerBinder"" is normal.
The reason the program is stuck on this error is because the program is creating a database for the first time.
This process should take at most 30 seconds.
The map will load up automatically after this time.

If you run into the error "No suitable driver for database" remove and add the org.xerial:sqlite-jdbc:3.30.1 dependency again.
Inorder to do this click on File -> Project Structure -> Global Libraries -> org.xerial:sqlite-jdbc:3.30.1 -> Minus.
Then add the dependency as explained above.
