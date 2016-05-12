databaseChangeLog = {

	changeSet(author: "jmiranda (generated)", id: "1457937795254-1") {
		dropNotNullConstraint(columnDataType: "varchar(255)", columnName: "email", tableName: "annotation_user")
	}

	changeSet(author: "jmiranda (generated)", id: "1457937795254-2") {
		dropNotNullConstraint(columnDataType: "varchar(255)", columnName: "user_id", tableName: "annotation_user")
	}

	changeSet(author: "jmiranda (generated)", id: "1457937795254-3") {
		dropNotNullConstraint(columnDataType: "varchar(255)", columnName: "username", tableName: "annotation_user")
	}
}
