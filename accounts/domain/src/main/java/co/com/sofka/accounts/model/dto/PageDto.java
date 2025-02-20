package co.com.sofka.accounts.model.dto;

import java.util.List;

public record PageDto<T>(List<T> content, int pageNumber, int pageSize, long totalElements, int totalPages) {
}
