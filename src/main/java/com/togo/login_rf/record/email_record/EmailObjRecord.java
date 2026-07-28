package com.togo.login_rf.record.email_record;

import java.io.Serializable;

public record EmailObjRecord(
        String recipient,
        String subject,
        String body
) implements Serializable {
}
