databaseChangeLog = {

	changeSet(author: "jmiranda (generated)", id: "1424455190494-1") {
		addColumn(tableName: "system_api") {
			column(name: "secret_key", type: "varchar(255)")
		}
    }

	changeSet(author: "jmiranda (generated)", id: "1424455190494-2") {
        grailsChange {
            change {
                sql.execute("UPDATE system_api SET secret_key = apikey WHERE secret_key IS NULL")
                confirm "Successfully set secret key for existing API systems."
            }
        }

	}


}
