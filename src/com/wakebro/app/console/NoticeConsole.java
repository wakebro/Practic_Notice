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
	private int page;

	public NoticeConsole() {
		service = new NoticeService();
		page = 1;
	}

	public void printNoticeList() throws ClassNotFoundException, SQLException {
		// List 객체에 만든 Notice 객체를 넣어 NoticeService의 getList()를 이용해 정보 추출
		List<Notice> list = service.getList(page);
		// Notice의 개수
		int count = service.getCount();
		int lastpage = count % 10 > 0 ? (count / 10) + 1 : count / 10;

		System.out.println("——————————————————————————————————");
		System.out.printf("<공지사항> 총 %d게시글\n", count);
		System.out.println("——————————————————————————————————");

		for (Notice n : list) {
			System.out.printf("%d. %s / %s / %s\n", n.getNo(), n.getTitle(), n.getId(), n.getDate().toString());
		}

		System.out.println("——————————————————————————————————");
		System.out.printf("        %d/%d\n", page, lastpage);
	}

	public int inputNoticeMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("1.상세조회/ 2.이전/ 3.다음/ 4.글쓰기 /5.종료>");
		String menu_ = sc.nextLine();
		int menu = Integer.parseInt(menu_);
		return menu;
	}

	public void movePrevList() {
		if (page == 1) {
			System.out.println("이전 페이지가 없습니다.");
			return;
		}
		page -= 1;
	}

	public void moveNextList() {
		// 마지막 페이지를 구하는 로직을 작성 전까지는 사용 불가
		/*
		 * if (page == ?) { System.out.println("이전 페이지가 없습니다."); return; }
		 */
		page += 1;
	}

}
