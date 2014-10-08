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

        }
    }
    test {
        dataSource {
            pooled = true
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
        }
    }
}
