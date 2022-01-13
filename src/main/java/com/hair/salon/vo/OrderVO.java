package com.hair.salon.vo;

import lombok.Data;

@Data
public class OrderVO {
	
	private int resNum; //예약번호
	private String userNm; // 사용자 이름
	private int desNum; // 디자이너 사원번호
	private String desNm;//디자이너 이름
	private String resIndate; // 예약 날짜
	private String hairType; // 시술
	private int price; // 가격
	private String resStatus; // 예약 상태 

}
