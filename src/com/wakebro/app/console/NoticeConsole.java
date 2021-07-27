package com.wakebro.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.wakebro.app.entity.Notice;
import com.wakebro.app.service.NoticeService;

// Program에서 실행되는 기능 구현
public class NoticeConsole {
	// 기능 구현에 필요한 데이터를 불러와 사용
	private NoticeService service;

	public NoticeConsole() {
		service = new NoticeService();
	}

	public void printNoticeList() throws ClassNotFoundException, SQLException {
		// List 객체에 만든 Notice 객체를 넣어 NoticeService의 getList()를 이용해 정보 추출
		List<Notice> list = service.getList(1);

		System.out.println("——————————————————————————————————");
		System.out.printf("<공지사항> 총 %d게시글\n", 12);
		System.out.println("——————————————————————————————————");

		for (Notice n : list) {
			System.out.printf("%d. %s / %s / %s\n", n.getNo(), n.getTitle(), n.getId(), n.getDate().toString());
		}

		System.out.println("——————————————————————————————————");
		System.out.printf("        %d/%d\n", 1, 2);
	}

	public int inputNoticeMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("1.상세조회/ 2.이전/ 3.다음/ 4.글쓰기 /5.종료>");
		String menu_ = sc.nextLine();
		int menu = Integer.parseInt(menu_);
		sc.close();
		return menu;
	}

}
