databaseChangeLog = {

	changeSet(author: "jmiranda (generated)", id: "1424455190494-1") {
		addColumn(tableName: "system_api") {
			column(name: "secret_key", type: "varchar(255)")
		}
	}

}
