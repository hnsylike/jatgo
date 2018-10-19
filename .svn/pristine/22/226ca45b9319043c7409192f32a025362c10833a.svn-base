
## flyway maven的使用

> 在pom.xml中配置了许多profile来应对不同环境的数据库升级，我们通过引用这些配置来进行数据库操作
> 本地数据库配置默认生效

**例如以下这段配置：**
> profile
```$xslt
<profile>
    <id>flyway_test</id>
     <properties>
         <flyway.db.dirver>com.mysql.jdbc.Driver</flyway.db.dirver>
         <flyway.db.user>flyway</flyway.db.user>
         <flyway.db.password>flyway_123456</flyway.db.password>
         <flyway.db.url>jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=UTF-8&amp;useSSL=false</flyway.db.url>
         <!--<flyway.location>classpath:db/migration/</flyway.location>-->
     </properties>
 </profile>
```
> flyway maven-plugin配置
```$xslt
            <plugin>
                <groupId>org.flywaydb</groupId>
                <artifactId>flyway-maven-plugin</artifactId>
                <version>4.0.3</version>
                <configuration>
                    <driver>${flyway.db.dirver}</driver>
                    <url>${flyway.db.url}</url>
                    <user>${flyway.db.user}</user>
                    <password>${flyway.db.password}</password>
                </configuration>
            </plugin>
```
在flyway插件中我们引用了我们的配置，这样可以做到指定环境的数据库升级
>关于flyway-maven命令操作
-P 指定具体的profile Id ， -X输出debug信息，用于跟踪异常问题
```$xslt
mvn flyway:migrate -Pflyway_test -X  

mvn flyway:clean -Pflyway_test -X

mvn flyway:validate -Pflyway_test -X
```