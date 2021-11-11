package com.project.nyvia380server.util;


import com.project.nyvia380server.common.user.Member;
import com.project.nyvia380server.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

@Component
public class Utils {

    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .format(localDateTime);
    }

    Supplier<UUID> uuidSupplier = UUID::randomUUID;



}
