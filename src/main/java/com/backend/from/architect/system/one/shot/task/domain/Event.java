package com.backend.from.architect.system.one.shot.task.domain;

import lombok.*;

@ToString
@Getter
public class Event {
    String message;
    boolean failure;
}