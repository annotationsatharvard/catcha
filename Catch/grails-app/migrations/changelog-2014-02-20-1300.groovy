databaseChangeLog = {

	changeSet(author: "jmiranda (generated)", id: "1424455279294-2") {
		modifyDataType(columnName: "json", newDataType: "text", tableName: "annotation")
	}

	changeSet(author: "jmiranda (generated)", id: "1424455279294-3") {
		addNotNullConstraint(columnDataType: "text", columnName: "json", tableName: "annotation")
	}

	changeSet(author: "jmiranda (generated)", id: "1424455279294-4") {
		modifyDataType(columnName: "quote", newDataType: "text", tableName: "annotation")
	}

	changeSet(author: "jmiranda (generated)", id: "1424455279294-5") {
		modifyDataType(columnName: "text", newDataType: "text", tableName: "annotation")
	}

	changeSet(author: "jmiranda (generated)", id: "1424455279294-6") {
		modifyDataType(columnName: "uri", newDataType: "varchar(2048)", tableName: "annotation")
	}

	changeSet(author: "jmiranda (generated)", id: "1424455279294-7") {
		addNotNullConstraint(columnDataType: "varchar(2048)", columnName: "uri", tableName: "annotation")
	}
}
