databaseChangeLog = {

	changeSet(author: "jmiranda (generated)", id: "1391669329771-1") {
		createTable(tableName: "annotation_tags") {
			column(name: "annotation_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "tag_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "jmiranda (generated)", id: "1391669329771-2") {
		modifyDataType(columnName: "json", newDataType: "text", tableName: "annotation")
	}

	changeSet(author: "jmiranda (generated)", id: "1391669329771-3") {
		modifyDataType(columnName: "quote", newDataType: "text", tableName: "annotation")
	}

	changeSet(author: "jmiranda (generated)", id: "1391669329771-4") {
		modifyDataType(columnName: "text", newDataType: "text", tableName: "annotation")
	}

	changeSet(author: "jmiranda (generated)", id: "1391669329771-5") {
		modifyDataType(columnName: "uri", newDataType: "text", tableName: "annotation")
	}

	changeSet(author: "jmiranda (generated)", id: "1391669329771-6") {
		addPrimaryKey(columnNames: "annotation_id, tag_id", tableName: "annotation_tags")
	}

	changeSet(author: "jmiranda (generated)", id: "1391669329771-7") {
		dropForeignKeyConstraint(baseTableName: "tag", baseTableSchemaName: "catch", constraintName: "FK1BF9A28835BA1")
	}

	changeSet(author: "jmiranda (generated)", id: "1391669329771-10") {
		createIndex(indexName: "FK6E8FA72928835BA1", tableName: "annotation_tags") {
			column(name: "annotation_id")
		}
	}

	changeSet(author: "jmiranda (generated)", id: "1391669329771-11") {
		createIndex(indexName: "FK6E8FA729C33ED913", tableName: "annotation_tags") {
			column(name: "tag_id")
		}
	}

	changeSet(author: "jmiranda (generated)", id: "1391669329771-12") {
		dropColumn(columnName: "annotation_id", tableName: "tag")
	}

	changeSet(author: "jmiranda (generated)", id: "1391669329771-8") {
		addForeignKeyConstraint(baseColumnNames: "annotation_id", baseTableName: "annotation_tags", constraintName: "FK6E8FA72928835BA1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "annotation", referencesUniqueColumn: "false")
	}

	changeSet(author: "jmiranda (generated)", id: "1391669329771-9") {
		addForeignKeyConstraint(baseColumnNames: "tag_id", baseTableName: "annotation_tags", constraintName: "FK6E8FA729C33ED913", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "tag", referencesUniqueColumn: "false")
	}
}
