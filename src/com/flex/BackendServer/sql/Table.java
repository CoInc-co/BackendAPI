package com.flex.BackendServer.sql;

import com.flex.BackendServer.sql.insertion.Databasable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enumerators in this class file MUST be named the same as
 * the table names inside of the database.
 *
 * The {@link Class} parameter for each parameter must implement {@link Databasable}
 * and must have a static method called "createInstance" with a ResultSet as a parameter.
 */
@Getter
@AllArgsConstructor
public enum Table {
    RANDOM_TABLE(null);

    private Class constructorClass;
}
