package csms.util;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class RoundedButton extends JButton {
	private static final long serialVersionUID = 4502324685868501934L;

	public RoundedButton() {
		super();
		setBackground(new Color(25, 25, 112));
		decorate();
	}

	public RoundedButton(String text) {
		super(text);
		decorate();
	}

	public RoundedButton(Action action) {
		super(action);
		decorate();
	}

	public RoundedButton(Icon icon) {
		super(icon);
		decorate();
	}

	public RoundedButton(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}

	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();

		Graphics2D graphics = (Graphics2D) g;

		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (getModel().isArmed()) { // 버튼에 마우스가 올려진 상태
			graphics.setColor(getBackground().brighter()); // 배경을 더 어둡게
		} else if (getModel().isRollover()) { // 버튼을 누른 상태
			graphics.setColor(getBackground().darker()); // 배경을 더 밝게
		} else {
			graphics.setColor(getBackground()); // 기본색
		}

		graphics.fillRoundRect(0, 0, width, height, 12, 12); // 버튼 채우는 걸 둥글게 채우자

		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

		graphics.setColor(getForeground());
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose(); // dispose 해야 덜 조잡하다고 함

		super.paintComponent(g);
	}
}
