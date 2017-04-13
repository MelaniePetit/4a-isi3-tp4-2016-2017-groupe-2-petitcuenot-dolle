package modele;

import java.awt.*;

/**
 * Created by Mel on 12/04/2017.
 */
public class Segment {
    private Point ptStart, ptEnd;

    private Color color;

    public Segment() {
        ptStart = new Point(0,0);
        ptEnd = new Point(0,0);
    }

    public Point getPtStart() {
        return ptStart;
    }

    public Point getPtEnd() {
        return ptEnd;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
