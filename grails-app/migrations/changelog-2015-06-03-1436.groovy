databaseChangeLog = {

	changeSet(author: "jmiranda (generated)", id: "1433356780261-1") {
		addColumn(tableName: "annotation") {
			column(name: "collection_id", type: "varchar(255)")
		}
	}

	changeSet(author: "jmiranda (generated)", id: "1433356780261-2") {
		addColumn(tableName: "annotation") {
			column(name: "context_id", type: "varchar(255)")
		}
	}

	changeSet(author: "jmiranda (generated)", id: "1433356780261-6") {
		dropIndex(indexName: "annotation_idx", tableName: "annotation")
		createIndex(indexName: "annotation_idx", tableName: "annotation") {
			column(name: "collection_id")

			column(name: "context_id")

			column(name: "media")

			column(name: "source")

			column(name: "uri")

			column(name: "userid")

			column(name: "username")
		}
	}
}
