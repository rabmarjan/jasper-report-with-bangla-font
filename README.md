# spring-jasper-report
How to generate dynamic Bangla reports using Spring Boot and Jasper. 
Blog link
https://medium.com/p/a926b436f1df

*Download JasperSoft Studio tool*
Link : https://community.jaspersoft.com/project/jaspersoft-studio/releases

Jasper Studio version 6.19.1

mvn install:install-file -Dfile=/home/marjan/fonts-extention.jar -DgroupId=com.marjan.fonts -DartifactId=bangla-font -Dversion=1.0 -Dpackaging=jar -DgeneratePom=true

Then add to the pom file

		<dependency>
			<groupId>net.sf.jasperreports</groupId>
			<artifactId>jasperreports</artifactId>
			<version>6.19.1</version>
		</dependency>
		<!-- mvn install:install-file -Dfile=/home/marjan/fonts-extention.jar -DgroupId=com.marjan.fonts -DartifactId=bangla-font -Dversion=1.0 -Dpackaging=jar -DgeneratePom=true -->
		<dependency>
			<groupId>com.marjan.fonts</groupId>
		        <artifactId>bangla-font</artifactId>
			<version>1.0</version>
		</dependency>
		<dependency>
			<groupId>net.sf.jasperreports</groupId>
			<artifactId>jasperreports-fonts</artifactId>
			<version>6.19.1</version>
		</dependency>
