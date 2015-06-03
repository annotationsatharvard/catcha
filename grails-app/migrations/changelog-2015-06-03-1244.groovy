databaseChangeLog = {

	changeSet(author: "jmiranda (generated)", id: "1433349892335-1") {
		modifyDataType(columnName: "json", newDataType: "text", tableName: "annotation")
	}

	changeSet(author: "jmiranda (generated)", id: "1433349892335-2") {
		modifyDataType(columnName: "quote", newDataType: "text", tableName: "annotation")
	}

	changeSet(author: "jmiranda (generated)", id: "1433349892335-3") {
		modifyDataType(columnName: "text", newDataType: "text", tableName: "annotation")
	}


}
