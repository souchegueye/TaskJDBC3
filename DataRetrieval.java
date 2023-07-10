package taskjdbc3;

import java.sql.SQLException;

interface DataRetrieval {
    void retrieveAllRecords() throws SQLException;
    void retrieveOneRecord() throws SQLException;
}