package gui.hashmap.panel.image.text;

import java.awt.*;
import java.awt.font.TextLayout;

public class TextDrawerImpl implements TextDrawer {
    private final int fontSize;
    private final int height;
    private final int width;
    private Color color;

    public TextDrawerImpl(int fontSize, int height, int width) {
        this.fontSize = fontSize;
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw(Graphics graphics, int x, int y, int number) {
        String text = Integer.toString(number);
        if (text.length() > 7) {
            text = text.substring(0, 7);
            text = text.concat("...");
        }
        graphics.setColor(this.color);
        Font font = new Font("Arial", Font.BOLD, fontSize);
        graphics.setFont(font);
        drawTextInCenter(text, graphics, x, y);
    }

    private void drawTextInCenter(String text, Graphics graphics, int x, int y) {
        TextLayout textLayout = new TextLayout(text, graphics.getFont(), graphics.getFontMetrics().getFontRenderContext());
        double textHeight = textLayout.getBounds().getHeight();
        double textWidth = textLayout.getBounds().getWidth();
        int textX = width / 2 - (int) textWidth / 2;
        int textY = height / 2 + (int) textHeight / 2;
        graphics.drawString(text, textX + x, textY + y);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
