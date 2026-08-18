package com.khae.librarydeployment.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BookRequest(
        @NotBlank @Size(max = 200) String title,
        @NotBlank @Size(max = 160) String author,
        @NotBlank @Size(max = 32) String isbn,
        @NotNull @Min(0) Integer availableCopies
) {
}
