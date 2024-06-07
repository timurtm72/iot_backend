package com.example.iot_backend.validation;

import java.util.List;

public record ValidationErrorResponse(List<Violation> violations) {
}
