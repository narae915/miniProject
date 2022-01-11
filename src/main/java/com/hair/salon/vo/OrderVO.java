package com.hair.salon.vo;

import lombok.Data;

@Data
public class OrderVO {
	
	private String userId; // 사용자 ID
	private int desNum; // 디자이너 사원번호
	private String resIndate; // 예약 날짜
	private String hairType; // 시술
	private int price; // 가격
	private String resStatus; // 예약 상태 

}
