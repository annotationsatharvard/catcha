databaseChangeLog = {

	changeSet(author: "jmiranda (generated)", id: "1457924249816-1") {
		dropForeignKeyConstraint(baseTableName: "annotation", constraintName: "FKA34FEB2F575B432E")
	}

	changeSet(author: "jmiranda (generated)", id: "1457924249816-2") {
		modifyDataType(columnName: "owner_id", newDataType: "bigint", tableName: "annotation")
	}

	changeSet(author: "jmiranda (generated)", id: "1457924249816-3") {
		addForeignKeyConstraint(baseColumnNames: "owner_id", baseTableName: "annotation", constraintName: "FKA34FEB2FA70DAA88", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "annotation_user", referencesUniqueColumn: "false")
	}
}
