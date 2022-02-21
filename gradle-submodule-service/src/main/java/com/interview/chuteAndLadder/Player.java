package com.interview.chuteAndLadder;


import lombok.Builder;
import lombok.Data;

/**
 * @author Bing ZHANG
 * @created 19/01/2022
 */
@Data
@Builder
public class Player {

    private String nickName;
    private int position;
}
