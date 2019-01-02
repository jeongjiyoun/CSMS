package csms.util;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;

public class ScreenSize {

	public static Point getCenterPosition(Window window) {
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize(); // 전체 화면 크기를 구한다.
		Dimension frameDimen = window.getSize();// 프레임창의 크기를 구한다.

		// 위치 계산은 프레임을 기준으로 좌측 위 꼭지점으로 한다.
		// 따라서 화면의 크기에서 반을 나눈 화면의 중심에서,
		// 프레임의 크기를 반으로 나눈 값을 빼주어야지
		// 프레임이 화면의 가운데에 위치하게 된다.

		int xPoint = (dimen.width / 2) - (frameDimen.width / 2);
		int yPoint = (dimen.height / 2) - (frameDimen.height / 2);

		return new Point(xPoint, yPoint);
	}
}
