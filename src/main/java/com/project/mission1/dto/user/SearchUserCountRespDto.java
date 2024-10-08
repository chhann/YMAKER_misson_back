package com.project.mission1.dto.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SearchUserCountRespDto {
    private int totalCount;
    private int maxPageNumber;
}
