package com.vladopard.recipes.response;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserSummaryResponse {
    private Long id;
    private String displayName;
}
