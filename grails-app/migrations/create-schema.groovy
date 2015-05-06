databaseChangeLog = {

    changeSet(author: "jmiranda (generated)", id: "1388820216662-1") {
        createTable(tableName: "agroup") {
            column(name: "id", type: "varchar(36)") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "agroupPK")
            }

            column(name: "created_by_id", type: "varchar(36)") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "varchar(1024)") {
                constraints(nullable: "false")
            }

            column(name: "enabled", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "locked", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "privacy_id", type: "varchar(36)") {
                constraints(nullable: "false")
            }

            column(name: "short_name", type: "varchar(100)")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-2") {
        createTable(tableName: "annotation") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "annotationPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "archived", type: "bit")

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "deleted", type: "bit")

            column(name: "json", type: "text") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "media", type: "varchar(255)")

            column(name: "owner_id", type: "varchar(36)")

            column(name: "parent_id", type: "bigint")

            column(name: "quote", type: "text")

            column(name: "source", type: "varchar(255)")

            column(name: "text", type: "text")

            column(name: "uri", type: "text") {
                constraints(nullable: "false")
            }

            column(name: "userid", type: "varchar(255)")

            column(name: "username", type: "varchar(255)")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-3") {
        createTable(tableName: "annotation_range") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "annotation_raPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "annotation_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "end", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "end_offset", type: "integer") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "start", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "start_offset", type: "integer") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-4") {
        createTable(tableName: "circle") {
            column(name: "id", type: "varchar(36)") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "circlePK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "short_name", type: "varchar(100)")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-5") {
        createTable(tableName: "group_privacy") {
            column(name: "id", type: "varchar(36)") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "group_privacyPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "label", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "value", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-6") {
        createTable(tableName: "group_role") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "group_rolePK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "authority", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "label", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "ranking", type: "integer") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-7") {
        createTable(tableName: "group_status") {
            column(name: "id", type: "varchar(36)") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "group_statusPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "label", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "value", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-8") {
        createTable(tableName: "openid") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "openidPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "url", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "varchar(36)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-9") {
        createTable(tableName: "persistent_logins") {
            column(name: "series", type: "varchar(64)") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "persistent_loPK")
            }

            column(name: "last_used", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "token", type: "varchar(64)") {
                constraints(nullable: "false")
            }

            column(name: "username", type: "varchar(64)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-10") {
        createTable(tableName: "role") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "authority", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "label", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "ranking", type: "integer") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-11") {
        createTable(tableName: "system_api") {
            column(name: "id", type: "varchar(36)") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "system_apiPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "access_to_public_data", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "apikey", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "created_by_id", type: "varchar(36)") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "varchar(1024)") {
                constraints(nullable: "false")
            }

            column(name: "enabled", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "short_name", type: "varchar(100)")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-12") {
        createTable(tableName: "system_api_agroup") {
            column(name: "system_api_groups_id", type: "varchar(36)")

            column(name: "group_id", type: "varchar(36)")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-13") {
        createTable(tableName: "system_api_user") {
            column(name: "system_api_users_id", type: "varchar(36)")

            column(name: "user_id", type: "varchar(36)")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-14") {
        createTable(tableName: "tag") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tagPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "annotation_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-15") {
        createTable(tableName: "user") {
            column(name: "id", type: "varchar(36)") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "account_expired", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "account_locked", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "affiliation", type: "varchar(255)")

            column(name: "country", type: "varchar(255)")

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "display_name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "email", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "enabled", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "first_name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "last_name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "middle_name", type: "varchar(255)")

            column(name: "password", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "password_expired", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "title", type: "varchar(255)")

            column(name: "username", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-16") {
        createTable(tableName: "user_account_request") {
            column(name: "id", type: "varchar(255)") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "user_account_PK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "affiliation", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "approved", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "country", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "display_name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "email", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "first_name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "last_name", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "moderated", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "moderated_by_id", type: "varchar(36)")

            column(name: "password", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "varchar(255)")

            column(name: "username", type: "varchar(60)") {
                constraints(nullable: "false")
            }

            column(name: "validated", type: "bit") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-17") {
        createTable(tableName: "user_account_request_openid") {
            column(name: "user_account_request_open_ids_id", type: "varchar(255)")

            column(name: "openid_id", type: "bigint")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-18") {
        createTable(tableName: "user_circle") {
            column(name: "circle_id", type: "varchar(36)") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "varchar(36)") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-19") {
        createTable(tableName: "user_circle_agroup") {
            column(name: "user_circle_circle_id", type: "varchar(36)")

            column(name: "user_circle_user_id", type: "varchar(36)")

            column(name: "group_id", type: "varchar(36)")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-20") {
        createTable(tableName: "user_circle_user") {
            column(name: "user_circle_circle_id", type: "varchar(36)")

            column(name: "user_circle_user_id", type: "varchar(36)")

            column(name: "user_id", type: "varchar(36)")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-21") {
        createTable(tableName: "user_group") {
            column(name: "group_id", type: "varchar(36)") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "varchar(36)") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "status_id", type: "varchar(36)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-22") {
        createTable(tableName: "user_group_group_role") {
            column(name: "user_group_group_id", type: "varchar(36)")

            column(name: "user_group_user_id", type: "varchar(36)")

            column(name: "group_role_id", type: "bigint")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-23") {
        createTable(tableName: "user_role") {
            column(name: "role_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "varchar(36)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-24") {
        createTable(tableName: "user_status_in_group") {
            column(name: "id", type: "varchar(36)") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "user_status_iPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "label", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "value", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-25") {
        createTable(tableName: "user_system_api") {
            column(name: "system_id", type: "varchar(36)") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "varchar(36)") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-26") {
        addPrimaryKey(columnNames: "circle_id, user_id", constraintName: "user_circlePK", tableName: "user_circle")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-27") {
        addPrimaryKey(columnNames: "group_id, user_id", constraintName: "user_groupPK", tableName: "user_group")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-28") {
        addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-29") {
        addPrimaryKey(columnNames: "system_id, user_id", constraintName: "user_system_aPK", tableName: "user_system_api")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-60") {
        createIndex(indexName: "FKAB670ABE68912AF3", tableName: "agroup") {
            column(name: "created_by_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-61") {
        createIndex(indexName: "FKAB670ABE7A49E6FF", tableName: "agroup") {
            column(name: "privacy_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-62") {
        createIndex(indexName: "name_uniq_1388820216521", tableName: "agroup", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-63") {
        createIndex(indexName: "FKA34FEB2F575B432E", tableName: "annotation") {
            column(name: "owner_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-64") {
        createIndex(indexName: "FKA34FEB2FD2AF0846", tableName: "annotation") {
            column(name: "parent_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-65") {
        createIndex(indexName: "FK6349282D28835BA1", tableName: "annotation_range") {
            column(name: "annotation_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-66") {
        createIndex(indexName: "name_uniq_1388820216537", tableName: "circle", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-67") {
        createIndex(indexName: "value_uniq_1388820216538", tableName: "group_privacy", unique: "true") {
            column(name: "value")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-68") {
        createIndex(indexName: "authority_uniq_1388820216539", tableName: "group_role", unique: "true") {
            column(name: "authority")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-69") {
        createIndex(indexName: "FKC3C3C8E5EB749316", tableName: "openid") {
            column(name: "user_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-70") {
        createIndex(indexName: "url_uniq_1388820216541", tableName: "openid", unique: "true") {
            column(name: "url")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-71") {
        createIndex(indexName: "authority_uniq_1388820216543", tableName: "role", unique: "true") {
            column(name: "authority")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-72") {
        createIndex(indexName: "FK26566C0A68912AF3", tableName: "system_api") {
            column(name: "created_by_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-73") {
        createIndex(indexName: "apikey_uniq_1388820216544", tableName: "system_api", unique: "true") {
            column(name: "apikey")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-74") {
        createIndex(indexName: "FK877ADC9394AE5BBC", tableName: "system_api_agroup") {
            column(name: "system_api_groups_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-75") {
        createIndex(indexName: "FK877ADC93F71A4416", tableName: "system_api_agroup") {
            column(name: "group_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-76") {
        createIndex(indexName: "FKC14F2EE05D281992", tableName: "system_api_user") {
            column(name: "system_api_users_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-77") {
        createIndex(indexName: "FKC14F2EE0EB749316", tableName: "system_api_user") {
            column(name: "user_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-78") {
        createIndex(indexName: "FK1BF9A28835BA1", tableName: "tag") {
            column(name: "annotation_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-79") {
        createIndex(indexName: "name_uniq_1388820216552", tableName: "tag", unique: "true") {
            column(name: "name")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-80") {
        createIndex(indexName: "email_uniq_1388820216554", tableName: "user", unique: "true") {
            column(name: "email")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-81") {
        createIndex(indexName: "username_uniq_1388820216556", tableName: "user", unique: "true") {
            column(name: "username")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-82") {
        createIndex(indexName: "FK6764F209B442890C", tableName: "user_account_request") {
            column(name: "moderated_by_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-83") {
        createIndex(indexName: "email_uniq_1388820216559", tableName: "user_account_request", unique: "true") {
            column(name: "email")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-84") {
        createIndex(indexName: "username_uniq_1388820216560", tableName: "user_account_request", unique: "true") {
            column(name: "username")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-85") {
        createIndex(indexName: "FK28A527DBBEE131C4", tableName: "user_account_request_openid") {
            column(name: "user_account_request_open_ids_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-86") {
        createIndex(indexName: "FK28A527DBEB8673B0", tableName: "user_account_request_openid") {
            column(name: "openid_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-87") {
        createIndex(indexName: "FKDB2603C4C94CD07B", tableName: "user_circle") {
            column(name: "circle_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-88") {
        createIndex(indexName: "FKDB2603C4EB749316", tableName: "user_circle") {
            column(name: "user_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-89") {
        createIndex(indexName: "FKE6DDFF99870FC97F", tableName: "user_circle_agroup") {
            column(name: "user_circle_circle_id")

            column(name: "user_circle_user_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-90") {
        createIndex(indexName: "FKE6DDFF99F71A4416", tableName: "user_circle_agroup") {
            column(name: "group_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-91") {
        createIndex(indexName: "FK9F0B5B66870FC97F", tableName: "user_circle_user") {
            column(name: "user_circle_circle_id")

            column(name: "user_circle_user_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-92") {
        createIndex(indexName: "FK9F0B5B66EB749316", tableName: "user_circle_user") {
            column(name: "user_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-93") {
        createIndex(indexName: "FK72A9010B329CA341", tableName: "user_group") {
            column(name: "status_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-94") {
        createIndex(indexName: "FK72A9010BEB749316", tableName: "user_group") {
            column(name: "user_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-95") {
        createIndex(indexName: "FK72A9010BF71A4416", tableName: "user_group") {
            column(name: "group_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-96") {
        createIndex(indexName: "FKD4D49EA6B69D89A", tableName: "user_group_group_role") {
            column(name: "user_group_group_id")

            column(name: "user_group_user_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-97") {
        createIndex(indexName: "FKD4D49EACC2F015", tableName: "user_group_group_role") {
            column(name: "group_role_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-98") {
        createIndex(indexName: "FK143BF46A4649CF36", tableName: "user_role") {
            column(name: "role_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-99") {
        createIndex(indexName: "FK143BF46AEB749316", tableName: "user_role") {
            column(name: "user_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-100") {
        createIndex(indexName: "FK75EB18FE89E2BF76", tableName: "user_system_api") {
            column(name: "system_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-101") {
        createIndex(indexName: "FK75EB18FEEB749316", tableName: "user_system_api") {
            column(name: "user_id")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-30") {
        addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "agroup", constraintName: "FKAB670ABE68912AF3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-31") {
        addForeignKeyConstraint(baseColumnNames: "privacy_id", baseTableName: "agroup", constraintName: "FKAB670ABE7A49E6FF", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "group_privacy", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-32") {
        addForeignKeyConstraint(baseColumnNames: "owner_id", baseTableName: "annotation", constraintName: "FKA34FEB2F575B432E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-33") {
        addForeignKeyConstraint(baseColumnNames: "parent_id", baseTableName: "annotation", constraintName: "FKA34FEB2FD2AF0846", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "annotation", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-34") {
        addForeignKeyConstraint(baseColumnNames: "annotation_id", baseTableName: "annotation_range", constraintName: "FK6349282D28835BA1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "annotation", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-35") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "openid", constraintName: "FKC3C3C8E5EB749316", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-36") {
        addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "system_api", constraintName: "FK26566C0A68912AF3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-37") {
        addForeignKeyConstraint(baseColumnNames: "group_id", baseTableName: "system_api_agroup", constraintName: "FK877ADC93F71A4416", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "agroup", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-38") {
        addForeignKeyConstraint(baseColumnNames: "system_api_groups_id", baseTableName: "system_api_agroup", constraintName: "FK877ADC9394AE5BBC", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "system_api", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-39") {
        addForeignKeyConstraint(baseColumnNames: "system_api_users_id", baseTableName: "system_api_user", constraintName: "FKC14F2EE05D281992", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "system_api", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-40") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "system_api_user", constraintName: "FKC14F2EE0EB749316", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-41") {
        addForeignKeyConstraint(baseColumnNames: "annotation_id", baseTableName: "tag", constraintName: "FK1BF9A28835BA1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "annotation", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-42") {
        addForeignKeyConstraint(baseColumnNames: "moderated_by_id", baseTableName: "user_account_request", constraintName: "FK6764F209B442890C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-43") {
        addForeignKeyConstraint(baseColumnNames: "openid_id", baseTableName: "user_account_request_openid", constraintName: "FK28A527DBEB8673B0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "openid", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-44") {
        addForeignKeyConstraint(baseColumnNames: "user_account_request_open_ids_id", baseTableName: "user_account_request_openid", constraintName: "FK28A527DBBEE131C4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user_account_request", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-45") {
        addForeignKeyConstraint(baseColumnNames: "circle_id", baseTableName: "user_circle", constraintName: "FKDB2603C4C94CD07B", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "circle", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-46") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_circle", constraintName: "FKDB2603C4EB749316", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-47") {
        addForeignKeyConstraint(baseColumnNames: "group_id", baseTableName: "user_circle_agroup", constraintName: "FKE6DDFF99F71A4416", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "agroup", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-48") {
        addForeignKeyConstraint(baseColumnNames: "user_circle_circle_id, user_circle_user_id", baseTableName: "user_circle_agroup", constraintName: "FKE6DDFF99870FC97F", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "circle_id, user_id", referencedTableName: "user_circle", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-49") {
        addForeignKeyConstraint(baseColumnNames: "user_circle_circle_id, user_circle_user_id", baseTableName: "user_circle_user", constraintName: "FK9F0B5B66870FC97F", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "circle_id, user_id", referencedTableName: "user_circle", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-50") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_circle_user", constraintName: "FK9F0B5B66EB749316", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-51") {
        addForeignKeyConstraint(baseColumnNames: "group_id", baseTableName: "user_group", constraintName: "FK72A9010BF71A4416", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "agroup", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-52") {
        addForeignKeyConstraint(baseColumnNames: "status_id", baseTableName: "user_group", constraintName: "FK72A9010B329CA341", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user_status_in_group", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-53") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_group", constraintName: "FK72A9010BEB749316", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-54") {
        addForeignKeyConstraint(baseColumnNames: "group_role_id", baseTableName: "user_group_group_role", constraintName: "FKD4D49EACC2F015", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "group_role", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-55") {
        addForeignKeyConstraint(baseColumnNames: "user_group_group_id, user_group_user_id", baseTableName: "user_group_group_role", constraintName: "FKD4D49EA6B69D89A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "group_id, user_id", referencedTableName: "user_group", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-56") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46A4649CF36", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-57") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46AEB749316", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-58") {
        addForeignKeyConstraint(baseColumnNames: "system_id", baseTableName: "user_system_api", constraintName: "FK75EB18FE89E2BF76", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "system_api", referencesUniqueColumn: "false")
    }

    changeSet(author: "jmiranda (generated)", id: "1388820216662-59") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_system_api", constraintName: "FK75EB18FEEB749316", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }
}
