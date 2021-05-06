package com.zfliu.gson.model;

import lombok.*;

/**
 * Created by zfliu on 2021/5/6 9:18
 * Desc:
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class PersonJson
{
	private String name;
	private Integer age;
	private String hobby;
}
