package acgn.aber.view;

/**
 * Created by aber on 01/07/2017.
 * Holder for vertex information.
 */

class Vertex {
    int mColor;
    float mColorFactor;
    double mPenumbraX;
    double mPenumbraY;
    double mPosX;
    double mPosY;
    double mPosZ;
    double mTexX;
    double mTexY;

    Vertex() {
        mPosX = mPosY = mPosZ = mTexX = mTexY = 0;
        mColorFactor = 1.0f;
    }

    void rotateZ(double theta) {
        final double cos = Math.cos(theta);
        final double sin = Math.sin(theta);
        double x = mPosX * cos + mPosY * sin;
        double y = mPosX * -sin + mPosY * cos;
        mPosX = x;
        mPosY = y;
        double px = mPenumbraX * cos + mPenumbraY * sin;
        double py = mPenumbraX * -sin + mPenumbraY * cos;
        mPenumbraX = px;
        mPenumbraY = py;
    }

    void set(Vertex vertex) {
        mPosX = vertex.mPosX;
        mPosY = vertex.mPosY;
        mPosZ = vertex.mPosZ;
        mTexX = vertex.mTexX;
        mTexY = vertex.mTexY;
        mPenumbraX = vertex.mPenumbraX;
        mPenumbraY = vertex.mPenumbraY;
        mColorFactor = vertex.mColorFactor;
        mColor = vertex.mColor;
    }

    void translate(double dx, double dy) {
        mPosX += dx;
        mPosY += dy;
    }
}
