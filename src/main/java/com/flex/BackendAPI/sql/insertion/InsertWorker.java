package com.flex.BackendAPI.sql.insertion;

import com.flex.BackendAPI.sql.SQLHelper;
import com.flex.BackendAPI.sql.Table;
import com.flex.BackendAPI.sql.Worker;
import com.flex.BackendAPI.utility.Utils;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InsertWorker extends Worker {
    private String objectStringForm;

    public InsertWorker(Table table, Databasable databasableObject) {
        super(table);
        setObjectStringForm(SQLHelper.databasableToInsertionForm(databasableObject));
    }

    @Override
    public void run() {
        if (getStatement() == null)
            return;

        doInsertion();
        closeStatement();
    }

    private void doInsertion() {
        String sqlArg = "INSERT INTO " + getTable().name() + " VALUES " + getObjectStringForm();
        try {
            getStatement().execute(sqlArg);
        } catch (Exception e) {
            Utils.log("Failed to do insertion on table: " + getTable().name());
        }
    }
}
