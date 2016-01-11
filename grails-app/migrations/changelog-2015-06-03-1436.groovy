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

    changeSet(author: "jmiranda (generated)", id: "1433356780261-3") {
        validCheckSum '3:4480a9efb9e64b70af3604da4486a6cb'
        createIndex(indexName: "annotation_source_idx", tableName: "annotation") {
            column(name: "source(255)")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1433356780261-4") {
        validCheckSum '3:244fe5c7e0bff85f8b214d43566a40bb'
        createIndex(indexName: "annotation_uri_idx", tableName: "annotation") {
            column(name: "uri(255)")
        }
    }


    changeSet(author: "jmiranda (generated)", id: "1433356780261-5") {
		createIndex(indexName: "annotation_user_idx", tableName: "annotation") {
			column(name: "userid")
			column(name: "username")
		}
	}

    changeSet(author: "jmiranda (generated)", id: "1433356780261-6") {
        createIndex(indexName: "annotation_media_idx", tableName: "annotation") {
            column(name: "media")
        }
    }

    changeSet(author: "jmiranda (generated)", id: "1433356780261-7") {
        createIndex(indexName: "annotation_context_idx", tableName: "annotation") {
            column(name: "collection_id")
            column(name: "context_id")
        }
    }
}
