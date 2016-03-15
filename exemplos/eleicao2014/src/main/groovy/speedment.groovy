import com.speedment.config.parameters.*

name = "twitter";
packageLocation = "src/main/java";
packageName = "com.company.speedment.test";
enabled = true;
expanded = true;
dbms {
    ipAddress = "127.0.0.1";
    name = "db0";
    port = 3306;
    typeName = "MySQL";
    username = "root";
    enabled = true;
    expanded = true;
    schema {
        columnCompressionType = ColumnCompressionType.NONE;
        fieldStorageType = FieldStorageType.WRAPPER;
        name = "twitter";
        schemaName = "twitter";
        storageEngineType = StorageEngineType.ON_HEAP;
        defaultSchema = false;
        enabled = true;
        expanded = true;
        table {
            columnCompressionType = ColumnCompressionType.INHERIT;
            fieldStorageType = FieldStorageType.INHERIT;
            name = "tweets";
            storageEngineType = StorageEngineType.INHERIT;
            tableName = "tweets";
            enabled = true;
            expanded = true;
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "id";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = true;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "user";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.sql.Timestamp.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "createdAt";
                typeMapper = com.speedment.internal.core.config.mapper.identity.TimestampIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "text";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "source";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "isTruncated";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "inReplyToStatusId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.Integer.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "inReplyToUserId";
                typeMapper = com.speedment.internal.core.config.mapper.identity.IntegerIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = true;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "isFavorited";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            column {
                columnCompressionType = ColumnCompressionType.INHERIT;
                databaseType = java.lang.String.class;
                fieldStorageType = FieldStorageType.INHERIT;
                name = "inReplyToScreenName";
                typeMapper = com.speedment.internal.core.config.mapper.identity.StringIdentityMapper.class;
                autoincrement = false;
                enabled = true;
                expanded = true;
                nullable = false;
            }
            primaryKeyColumn {
                name = "id";
                enabled = true;
                expanded = true;
            }
            index {
                name = "PRIMARY";
                enabled = true;
                expanded = true;
                unique = true;
                indexColumn {
                    name = "id";
                    orderType = OrderType.ASC;
                    enabled = true;
                    expanded = true;
                }
            }
        }
    }
}