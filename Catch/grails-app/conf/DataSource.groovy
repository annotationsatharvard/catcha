hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            pooled = true
            //dbCreate = "create-drop"
            driverClassName = "com.mysql.jdbc.Driver"
            dialect = org.hibernate.dialect.MySQL5InnoDBDialect
            url = "jdbc:mysql://localhost:3306/catch?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
            username = "catch"
            password = "catch"
            /*
            properties {
                maxActive = 50
                maxIdle = 25
                minIdle = 15
                initialSize = 10
                numTestsPerEvictionRun = 3
                maxWait = 10000
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "select now()"
                minEvictableIdleTimeMillis = 1000 * 60 * 5
                timeBetweenEvictionRunsMillis = 1000 * 60 * 5
            }*/


//            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
//            url = "jdbc:h2:mem:devDb;MVCC=TRUE"
        }
    }
    test {
        dataSource {
            /*
            pooled = true
            driverClassName = "org.h2.Driver"
            username = "sa"
            password = ""
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE"
            */
            pooled = true
            //dbCreate = "create-drop"
            driverClassName = "com.mysql.jdbc.Driver"
            dialect = org.hibernate.dialect.MySQL5InnoDBDialect
            url = "jdbc:mysql://localhost:3306/catch?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
            username = "catch"
            password = "catch"

        }
    }
    production {
        dataSource {
            //dbCreate = "create-drop"
            pooled = true
            driverClassName = "com.mysql.jdbc.Driver"
            dialect = org.hibernate.dialect.MySQL5InnoDBDialect
            url = "jdbc:mysql://localhost:3306/catch?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
            username = "catch"
            password = "catch"
            /*
            properties {
                maxActive = 50
                maxIdle = 25
                minIdle = 15
                initialSize = 10
                numTestsPerEvictionRun = 3
                maxWait = 10000
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "select now()"
                minEvictableIdleTimeMillis = 1000 * 60 * 5
                timeBetweenEvictionRunsMillis = 1000 * 60 * 5
            }
            */
        }
    }
}
