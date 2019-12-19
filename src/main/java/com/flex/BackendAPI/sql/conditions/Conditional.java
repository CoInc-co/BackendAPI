package com.flex.BackendAPI.sql.conditions;

import com.flex.BackendAPI.sql.SQLHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Conditional {
    private String phrase;

    public Conditional(String field, Object value) {
        setPhrase(SQLHelper.makeConditionalPhrase(field, value));
    }

    @Override
    public String toString() {
        return getPhrase();
    }
}
