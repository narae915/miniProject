package com.hair.salon.vo;

import lombok.Data;

@Data
public class ReviewVO {
	
	private String userId; // 사용자 아이디
	private int desNum; // 디자이너 사원번호
	private int score; // 평점
	private String review; // 후기
	private String revIndate; // 후기 작성 날짜

}
