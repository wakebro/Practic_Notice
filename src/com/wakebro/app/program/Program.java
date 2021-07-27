package com.wakebro.app.program;

import java.sql.SQLException;

import com.wakebro.app.console.NoticeConsole;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 프로그램 실행 부문
		// NoticeConsole을 불러와 프로그램을 실행
		NoticeConsole console = new NoticeConsole();

		START: while (true) {
			console.printNoticeList(); // 콘솔 화면에 출력하는 메서드
			int menu = console.inputNoticeMenu(); // 콘솔 화면에 입력하여 다른 구문으로 넘어가는 메서드

			// 콘솔에 입력 후 다른 기능으로 넘어가는 구문
			switch (menu) {
			case 1: // 상세조회
				break;
			case 2: // 이전
				console.movePrevList();
				break;
			case 3: // 다음
				console.moveNextList();
				break;
			case 4: // 글쓰기
				break;
			case 5: // 종료
				System.out.println("bye~~");
				break START;
			default:
				System.out.println("<<사용방법>>1~4까지만 입력할 수 있습니다.");
				break;
			}
		}
	}

}
