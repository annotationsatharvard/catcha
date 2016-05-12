databaseChangeLog = {

	changeSet(author: "jmiranda (generated)", id: "1457917690694-1") {
		validCheckSum "3:39c19021bd3b9bac7fa720cb69bc39e4"
		addNotNullConstraint(columnDataType: "text", columnName: "json", tableName: "annotation")
	}

}
