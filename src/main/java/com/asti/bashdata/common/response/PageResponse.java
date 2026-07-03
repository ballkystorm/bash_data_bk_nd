package com.asti.bashdata.common.response;


import lombok.Builder;

import java.util.List;

/**
 * Represents a paginated API response.
 *
 * @param <T> the type of items contained in the page
 */
@Builder
public record PageResponse<T>(

        List<T> content,

        int page,

        int size,

        long totalElements,

        int totalPages,

        boolean first,

        boolean last

) {
}