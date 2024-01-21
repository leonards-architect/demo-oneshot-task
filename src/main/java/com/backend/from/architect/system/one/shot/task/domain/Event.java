package com.backend.from.architect.system.one.shot.task.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    String message;
    boolean failure;

    public boolean failure() {
        return failure;
    }
}