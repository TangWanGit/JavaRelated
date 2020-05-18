package com.tangwan.steam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tangwan
 * @Description : SortBean
 * @date 2020-05-12 10:28
 * @since JDK 1.8
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SortBean {

    private Long id;

    private Long limit;
}
