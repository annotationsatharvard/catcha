databaseChangeLog = {

	changeSet(author: "jmiranda (generated)", id: "1457918899928-1") {
		createTable(tableName: "annotation_permission") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "annotation_pePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "annotation_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "permission", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint")
		}
	}

	changeSet(author: "jmiranda (generated)", id: "1457918899928-2") {
		createTable(tableName: "annotation_user") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "annotation_usPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "jmiranda (generated)", id: "1457918899928-3") {
		createIndex(indexName: "FK23C0ACDF28835BA1", tableName: "annotation_permission") {
			column(name: "annotation_id")
		}
	}

	changeSet(author: "jmiranda (generated)", id: "1457918899928-4") {
		createIndex(indexName: "FK23C0ACDF3B26FA70", tableName: "annotation_permission") {
			column(name: "user_id")
		}
	}

	changeSet(author: "jmiranda (generated)", id: "1457918899928-6") {
		addForeignKeyConstraint(baseColumnNames: "annotation_id", baseTableName: "annotation_permission", constraintName: "FK23C0ACDF28835BA1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "annotation", referencesUniqueColumn: "false")
	}

	changeSet(author: "jmiranda (generated)", id: "1457918899928-7") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "annotation_permission", constraintName: "FK23C0ACDF3B26FA70", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "annotation_user", referencesUniqueColumn: "false")
	}
}
